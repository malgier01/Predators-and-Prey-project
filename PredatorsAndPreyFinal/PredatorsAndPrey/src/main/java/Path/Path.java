/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Path;
//path is accumulation of places and has to start with hideout and end with source
//change of plans: path is a [0/1] array and prey moves on places with 1
import Place.Place;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;



/**
 *
 * @author Małgorzata
 */
public class Path {
    //path is a COLLECTION of places
    private String name;
    public static Map<Integer, Place> placesInPath = new HashMap();
    public static int[][] path = {
        {1,1,1,1,1,1,0,0},
        {1,0,0,0,1,1,1,1},
        {1,0,1,1,0,1,0,1},
        {1,0,1,0,0,1,0,1},
        {1,0,1,1,1,1,0,1},
        {1,0,0,1,0,1,0,1},
        {1,0,0,1,0,1,1,1},
        {1,1,1,1,0,0,0,0}
};
    
    
    
    public void Path(){
        
        
        //how to implement path though
        //linked list, xcor and ycor of place will be first, then arraylist of animals aka a place
        //path append place i takie tam
        //a może hashmap skoro i tak mam zhardcodowana mapę?
        // 2 sets of places, first is an array so the animals can move, second is hashmap with special places
        
    }

   



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    //should I hardcode paths in this file?
    
    
    
}
