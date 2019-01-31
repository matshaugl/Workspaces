
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author matsh
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<GameObject> objects = new ArrayList<GameObject>();
        objects.add(new Tree(4,2));
        objects.add(new Tree(1,1));
        objects.add(new Tree(5,3));
        objects.add(new Tree(122,22));
        objects.add(new Tree(1,34));
        objects.add(new Tree(22,324));
        
        objects.add(new Sheep(2,1222));
        objects.add(new Sheep(4,123));
        objects.add(new Sheep(6,22));
        objects.add(new Sheep(23,23));
        objects.add(new Sheep(65,5));
        objects.add(new Sheep(11,23));
        objects.add(new Sheep(53,1));
        
        Collections.sort(objects);
        
        for(int i=0; i<objects.size(); i++){
            System.out.println(objects.get(i));
        }
        
    }
    
}
