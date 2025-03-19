/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Map;

import Place.Place;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import Place.Place;
import Place.PlaceHideout;
import Place.PlaceRoad;
import Place.PlaceSourceFood;
import Place.PlaceSourceWater;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;

/**
 *
 * @author Małgorzata
 */
public class placeMap {
    public static Map<Integer, Place> parkMapFunctionalPlace = new HashMap();
    
    //ArrayList<Integer> hideouts = {13, 25, 48, 56, 84};
    LinkedList<Integer> hideout = new LinkedList<Integer>();
    boolean hid = Collections.addAll(hideout, 13, 25, 48, 56, 84 );
    //fillMapHideout(hideout);
    //for(int i = 0; i < 5; i++){}
    
    // waterSource = {27, 41, 54, 76, 82}
    LinkedList<Integer> waterSource = new LinkedList<Integer>();
    boolean water = Collections.addAll(waterSource, 27, 41, 54, 76, 82  );
    
    // foodSource = {11, 15, 34, 51, 53, 68}
    LinkedList<Integer> foodSource = new LinkedList<Integer>();
    boolean foo = Collections.addAll(foodSource, 11, 15, 34, 51, 53, 68 );
    // road = {12, 14, 16, 17, 18, 21, 22, 23, 24, 25, 27, 28, 31, 32, 33, 35, 36, 37, 38, 42, 43, 44, 45, 46, 47, 52, 55, 57, 58, 61, 62, 63, 64, 65, 66, 67, 71, 72, 73, 74, 75, 77, 78, 81, 83, 85, 86, 87, 88}
    LinkedList<Integer> road = new LinkedList<Integer>();
    boolean roo = Collections.addAll(road,12, 14, 16, 17, 18, 21, 22, 23, 24, 26, 27, 28, 31, 32, 33, 35, 36, 37, 38, 42, 43, 44, 45, 46, 47, 52, 55, 57, 58, 61, 62, 63, 64, 65, 66, 67, 71, 72, 73, 74, 75, 77, 78, 81, 83, 85, 86, 87, 88
     );
    
    public void fillMapHideout(LinkedList<Integer> list){
        for(int i = 0; i < 5; i++){
            int key = list.pollLast();
            PlaceHideout hid = new PlaceHideout();
            parkMapFunctionalPlace.put(key, hid);
        }
    };
    
    public void fillMapWaterSource(LinkedList<Integer> list){
        int x =  list.size();
         for(int i = 0; i < x; i++){
            int key = list.pollLast();
            PlaceSourceWater wat = new PlaceSourceWater();
            parkMapFunctionalPlace.put(key, wat);
        }
    }

    public void fillMapFoodSource(LinkedList<Integer> list){
        int x =  list.size();
         for(int i = 0; i < x; i++){
            int key = list.pollLast();
            PlaceSourceFood foo = new PlaceSourceFood();
            parkMapFunctionalPlace.put(key, foo);
        }
    }
    
    public void fillMapRoad(LinkedList<Integer> list){
        int x =  list.size();
         for(int i = 0; i < x; i++){
            int key = list.pollLast();
            PlaceRoad roo = new PlaceRoad();
            parkMapFunctionalPlace.put(key, roo);
        }
    }
    
    public placeMap(){
        fillMapHideout(hideout);
        fillMapWaterSource(waterSource);
        fillMapFoodSource(foodSource);
        fillMapRoad(road);
    }
    
    //if cords prey == getcords predator
    //kill prey (remove from threadlist)

/**
 *
 * @author Małgorzata
 */

}
