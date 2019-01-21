/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapgen;

import mapgen.noise.TileNoise;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author matsh
 */
public class MapChunk {

    Image mapImage;
    Image miniMapImage;
    SpriteSheet sheet;

    TileNoise fixedNoise;
    int size;
    TerrainType[][] terrainTypeArray;
    int chunkX;
    int chunkY;

    int tileSize = 32;
    double waterLevel = -0.05;
    double sandLevel = -0.03;
    double grassLevel = -0.02;

    public MapChunk(int x, int y, TileNoise f) {
        fixedNoise = f;
        size = 32;
        terrainTypeArray = new TerrainType[size + 2][size + 2];
        chunkX = x;
        chunkY = y;
        try {
            init();
        } catch (SlickException ex) {
            Logger.getLogger(MapChunk.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Image getMiniMapImage() {
        return miniMapImage;
    }

    public void init() throws SlickException {
        mapImage = new Image(size * tileSize, size * tileSize);
        sheet = new SpriteSheet("res/sandwaterbinary2.png", 32, 32);
        makeTerrainTypeArray();
        makeMiniMap();
        makeMapImage();

    }

    public void render(float shiftX, float shiftY) {
        mapImage.draw(shiftX, shiftY);

        Graphics g = null;
        try {
            g = mapImage.getGraphics();
        } catch (SlickException ex) {
            Logger.getLogger(MapChunk.class.getName()).log(Level.SEVERE, null, ex);
        }

        g.draw(new Rectangle(1, 1, 32 * 32 - 1, 32 * 32 - 1));
        g.flush();
    }

    public void update() {

    }

    public int getX() {
        return chunkX;
    }

    public int getY() {
        return chunkY;
    }

    public String getKey() {
        return "" + chunkX + "," + chunkY;
    }

    private void makeTerrainTypeArray() {
        double[][] noiseMap = makeNoiseMap();
        for (int i = 0; i < size + 2; i++) {
            for (int j = 0; j < size + 2; j++) {
                if (noiseMap[i][j] < waterLevel) {
                    terrainTypeArray[i][j] = TerrainType.WATER;
                } else if (noiseMap[i][j] < sandLevel) {
                    terrainTypeArray[i][j] = TerrainType.SAND;
                } else {
                    terrainTypeArray[i][j] = TerrainType.GRASS;
                }
            }
        }

    }

    private double[][] makeNoiseMap() {
        int x = (size * chunkX) - 1;
        int y;
        double[][] noiseMap = new double[size + 2][size + 2];
        for (int i = 0; i < size + 2; i++) {
            y = (size * chunkY) - 1;
            for (int j = 0; j < size + 2; j++) {
                noiseMap[i][j] = fixedNoise.getNoise(x + i, y + j);
            }
        }
        return noiseMap;
    }

    private void makeMapImage() throws SlickException {
        Graphics g = null;
        g = mapImage.getGraphics();

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                int tX = x + 1;
                int tY = y + 1;
                //System.out.print(terrainTypeArray[x][y] + "   ");
                if (terrainTypeArray[tX][tY] == TerrainType.WATER) {
                    g.drawImage(sheet.getSprite(0, 16), x * tileSize, y * tileSize);
                } else if (terrainTypeArray[tX][tY] == TerrainType.SAND) {
                    int spriteNumber = 0;
                    if (terrainTypeArray[tX][tY - 1] == TerrainType.SAND || terrainTypeArray[tX][tY - 1] == TerrainType.GRASS) {
                        spriteNumber = spriteNumber + 1;
                    }
                    if (terrainTypeArray[tX][tY + 1] == TerrainType.SAND || terrainTypeArray[tX][tY + 1] == TerrainType.GRASS) {
                        spriteNumber = spriteNumber + 2;
                    }
                    if (terrainTypeArray[tX - 1][tY] == TerrainType.SAND || terrainTypeArray[tX - 1][tY] == TerrainType.GRASS) {
                        spriteNumber = spriteNumber + 4;
                    }
                    if (terrainTypeArray[tX + 1][tY] == TerrainType.SAND || terrainTypeArray[tX + 1][tY] == TerrainType.GRASS) {
                        spriteNumber = spriteNumber + 8;
                    }
                    g.drawImage(sheet.getSprite(0, spriteNumber), x * tileSize, y * tileSize);
                    //g.setColor(Color.red);
                    //g.drawString("S", (x * tileSize) + 10, (y * tileSize) + 7);
                } else if (terrainTypeArray[tX][tY] == TerrainType.GRASS) {
                    int spriteNumber = 0;
                    if (terrainTypeArray[tX][tY - 1] == TerrainType.GRASS) {
                        spriteNumber = spriteNumber + 1;
                    }
                    if (terrainTypeArray[tX][tY + 1] == TerrainType.GRASS) {
                        spriteNumber = spriteNumber + 2;
                    }
                    if (terrainTypeArray[tX - 1][tY] == TerrainType.GRASS) {
                        spriteNumber = spriteNumber + 4;
                    }
                    if (terrainTypeArray[tX + 1][tY] == TerrainType.GRASS) {
                        spriteNumber = spriteNumber + 8;
                    }
                    if (spriteNumber != 15) {
                        g.drawImage(sheet.getSprite(0, 15), x * tileSize, y * tileSize);
                    }
                    g.drawImage(sheet.getSprite(1, spriteNumber), x * tileSize, y * tileSize);
                    //7g.setColor(Color.red);
                    //g.drawString("G", (x * tileSize) + 10, (y * tileSize) + 7);
                }

            }
            //System.out.println();
        }

        g.flush();
    }

    private void makeMiniMap() throws SlickException {
        Graphics g = null;
        miniMapImage = new Image(32, 32);
        g = miniMapImage.getGraphics();

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                int tX = x + 1;
                int tY = y + 1;
                //System.out.print(terrainTypeArray[x][y] + "   ");
                if (terrainTypeArray[tX][tY] == TerrainType.WATER) {
                    //156C99
                    g.setColor(new Color(21, 108, 153));
                    g.fillRect(x, y, 1, 1);
                }
                if (terrainTypeArray[tX][tY] == TerrainType.GRASS) {
                    //2F8136
                    g.setColor(new Color(47, 129, 54));
                    g.fillRect(x, y, 1, 1);
                }
                if (terrainTypeArray[tX][tY] == TerrainType.SAND) {
                    //EEEC69
                    g.setColor(new Color(238, 236, 105));
                    g.fillRect(x, y, 1, 1);
                }

            }
            //System.out.println();
        }

        g.flush();
    }

}
