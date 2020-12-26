
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.font.effects.ColorEffect;

import java.awt.Font;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.newdawn.slick.util.ResourceLoader;

public class Play extends BasicGameState {
	SlickSoundPlayer beepSound;
	SlickSoundPlayer singleBeepSound;
	SlickSoundPlayer music;
	SlickSoundPlayer airhorn;
	long start;
	long time;
	long countDown;
	long countUp;
	long displayTime;
	
	int countDown1Min = 0;
	int countDown1Sec = 30;
	
	int countDown2Min = 2;
	int countDown2Sec = 30;
	
	long countDownTime = countDown1Min * 60000 + countDown1Sec * 1000 + 1000; // 31000
	long countDownTime2 = countDown2Min * 60000 + countDown2Sec * 1000; // 150000
	
	TrueTypeFont font;
	UnicodeFont unicodeFont;
	UnicodeFont unicodeFontBig;
	
	boolean bigFont = false;
	
	boolean stop;
	
	int millisMode = 0;
	
	long milli;
	long sec;
	long min;
	long kvartSec;
	long halvSec;
	
	float beepVolume;
	float musicVolume;
	float airhornVolume;
	
	boolean countingDown;
	boolean countingUp;
	boolean blinkRed; 
	boolean playCountDown;
	boolean playCountDown2;
	boolean playMusic;
	boolean playAirhorn;

	
	public Play(int xSize, int ySize) {
		beepVolume = 1.0f;
		musicVolume = 0.7f;
		airhornVolume =  1.0f;
	}

	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		beepSound = new SlickSoundPlayer("res/beep.wav");
		singleBeepSound = new SlickSoundPlayer("res/singlebeep.wav");
		music = new SlickSoundPlayer("res/music.wav");
		airhorn = new SlickSoundPlayer("res/airhorn.wav");
		//loadFont();
		loadUnicodeFont();
		stop = false;
		start = System.currentTimeMillis();
		displayTime = 0;
		
		boolean loadFromFile = true;
		if(loadFromFile) {
			loadSettingsFromFile();
		}
		
		countingDown = false;
		countingUp = false;
		blinkRed = false;
		playCountDown = true;
		playCountDown2 = true;
		playMusic = true;
		playAirhorn = true;
	}
	
	public void loadSettingsFromFile() {
		Properties properties = new Properties();
		try {
		  properties.load(new FileInputStream("config.properties"));
		  
		  millisMode = Integer.parseInt(properties.getProperty("millisMode", "0"));
		  countDown1Min = Integer.parseInt(properties.getProperty("countDown1Min", "0"));
		  countDown1Sec = Integer.parseInt(properties.getProperty("countDown1Sec", "30"));
		  countDown2Min = Integer.parseInt(properties.getProperty("countDown2Min", "2"));
		  countDown2Sec = Integer.parseInt(properties.getProperty("countDown2Sec", "30"));
		  
		  countDownTime = countDown1Min * 60000 + countDown1Sec * 1000 + 1000;
		  countDownTime2 = countDown2Min * 60000 + countDown2Sec * 1000;
		} catch (IOException e) {
		  System.out.println(e);
		}
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		//g.scale(2.2f, 2.2f); // ditta va grunnen til blurry font
		//g.setFont(font);
		g.setFont(unicodeFont);
		
		String s = "";
		
		
		if(blinkRed){
			if(countingDown) {
				if((halvSec%2 == 1 && sec <= 5) || sec < 1){
					g.setFont(unicodeFontBig);
					bigFont = true;
				} else {
					g.setFont(unicodeFont);
					bigFont = false;
				}
			} else if(countingUp) {
				g.setFont(unicodeFontBig);
				bigFont = true;
			}
		}
		
		if(bigFont)
			g.setColor(Color.red);
		else
			g.setColor(Color.white);
		
		if(countingDown){
			if(sec<1){
				s = "START";
				renderString(gc, g, s);
				music.stop();
				bigFont = false;
			} else {
				s = "" + sec;
				if(sec < 10)
					renderString(gc, g, s);
				else
					renderString(gc, g, s);
			}
		} else if(countingUp){
			switch(millisMode) {
				case 1:
					s = String.format("%02d:%02d:%01d" , min, sec, milli);
					break;
				default:
					s = String.format("%02d:%02d:%03d" , min, sec, milli);
					break;
			}
			renderString(gc, g, s);
		} else {
			s = "LEGO LEAGUE";
			renderString(gc, g, s);
		}
	}
	
	public void renderString(GameContainer gc, Graphics g, String s) {
		if(bigFont)
			g.drawString(s, 
					gc.getWidth() / 2 - unicodeFontBig.getWidth(s) / 2, 
					gc.getHeight() / 2 - unicodeFontBig.getLineHeight() / 1.4f);
		else
		g.drawString(s, 
				gc.getWidth() / 2 - unicodeFont.getWidth(s) / 2, 
				gc.getHeight() / 2 - unicodeFont.getLineHeight() / 1.4f);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		
		if(countingDown){
			if(playMusic){
				music.loop(musicVolume);
				playMusic = false;
			}
			time = System.currentTimeMillis() - start;
			
			countDown = countDownTime-time;
			displayTime = countDown;
			if(countDown < 6000 && playCountDown){
				blinkRed = true;
				beepSound.play(beepVolume);
				playCountDown = false;
			}
			if(countDown < 0){
				countingDown = false;
				countingUp = true;
				start = System.currentTimeMillis();
			}

		}
		
		if(countingUp){
			blinkRed = false;
			time = System.currentTimeMillis() - start;
			countDown = countDownTime2-time;
			if(!(countDown<0)){
				displayTime = countDown;
			} else {
				displayTime = 0;
			}
			if(displayTime < 10000){
				blinkRed = true;
			}
			if(displayTime < 10000 && halvSec%2 == 1 && playCountDown2){
				if(!singleBeepSound.fx.playing())
					singleBeepSound.play(beepVolume);
			}
			if(displayTime < 1 && playAirhorn){
				airhorn.play(airhornVolume);
				playAirhorn = false;
			}
		}
		
		Input input = gc.getInput();
		

		if (input.isKeyPressed(Input.KEY_F1)) {
			music.stop();
			beepSound.stop();
			airhorn.stop();
			countingDown = true;
			countingUp = false;
			blinkRed = false;
			playCountDown = true;
			playMusic = true;
			playAirhorn = true;
			bigFont = false;
			
			start = System.currentTimeMillis();
        }
		if (input.isKeyPressed(Input.KEY_F2)) {
			music.stop();
			beepSound.stop();
			airhorn.stop();
			countingDown = false;
			countingUp = false;
			bigFont = false;
			
			
			displayTime = 0;
        }
		
		
		switch(millisMode) {
			case 1:
				milli = (displayTime/100)%10;
				break;
			default:
				milli = displayTime%1000;
				break;
		}
		sec = (displayTime/1000)%60;
		min = (displayTime/1000/60)%60;
		kvartSec = (displayTime/200);
		halvSec = (displayTime/500);
		
	}
	
	public void loadFont(){

		try {
			InputStream inputStream	= ResourceLoader.getResourceAsStream("res/DS-DIGI.ttf");
			//InputStream inputStream	= ResourceLoader.getResourceAsStream("res/disp-font.ttf");
			
			Font awtFont2 = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			awtFont2 = awtFont2.deriveFont(75f); // set font size
			font = new TrueTypeFont(awtFont2, true);
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void loadUnicodeFont(){
		try {
			InputStream inputStream	= ResourceLoader.getResourceAsStream("res/digital-7 (mono).ttf");			
			Font awtFont2 = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			unicodeFont = new UnicodeFont(awtFont2, 200, false, false);
			unicodeFontBig = new UnicodeFont(awtFont2, 250, false, false);
	        ColorEffect colorEffect = new ColorEffect(java.awt.Color.white);
	        unicodeFont.getEffects().add(colorEffect);
	        unicodeFont.addNeheGlyphs();
	        unicodeFont.loadGlyphs();
	        unicodeFontBig.getEffects().add(colorEffect);
	        unicodeFontBig.addNeheGlyphs();
	        unicodeFontBig.loadGlyphs();
	        inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getID() {
		return 0;
	}
}