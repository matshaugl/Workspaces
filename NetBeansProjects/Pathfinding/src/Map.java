
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.util.pathfinding.PathFindingContext;
import org.newdawn.slick.util.pathfinding.TileBasedMap;

public class Map implements TileBasedMap {
    
    Image mapPng;
    Image renderMap;
    Image tileSprite;
    SpriteSheet tiles;
    int width;
    int height;
    
    public void init(){
        Graphics g = null;
        try {
            mapPng = new Image ("res/map.png", false, Image.FILTER_NEAREST);
            width = mapPng.getWidth();
            height = mapPng.getHeight();
            tileSprite = new Image ("res/mapSheet.png", false, Image.FILTER_NEAREST);
            renderMap = new Image(width*32, height*32);
            g = renderMap.getGraphics();
        } catch (SlickException ex) {
            Logger.getLogger(Map.class.getName()).log(Level.SEVERE, null, ex);
        }
        tiles = new SpriteSheet(tileSprite,32,32);
        
        for(int x=0; x<width; x++){
            for(int y=0; y<height; y++){
                if(mapPng.getColor(x, y).equals(Color.black)){
                    g.drawImage(tiles.getSprite(0, 0), x * 32, y * 32);
                } else {
                    g.drawImage(tiles.getSprite(2, 0), x * 32, y * 32);
                }
            }
        }
        g.flush();
        
        
    }
    
    public void render(Graphics g){
        g.drawImage(renderMap, 0, 0);
    }
    
    public void update(){
        
    }

    @Override
    public int getWidthInTiles() {
        return width;
    }

    @Override
    public int getHeightInTiles() {
        return width;
    }

    @Override
    public void pathFinderVisited(int x, int y) {

    }

    @Override
    public boolean blocked(PathFindingContext context, int tx, int ty) {
        if(mapPng.getColor(tx, ty).equals(Color.black)){
            return true;
        } 
        return false;
    }

    @Override
    public float getCost(PathFindingContext context, int tx, int ty) {    
        return 1;
    }

    public boolean blocked(int tx, int ty) {
        if(mapPng.getColor(tx, ty).equals(Color.black)){
            return true;
        } 
        return false;
    }
    
}