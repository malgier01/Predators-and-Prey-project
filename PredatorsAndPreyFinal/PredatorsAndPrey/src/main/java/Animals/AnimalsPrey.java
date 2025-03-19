 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Animals;

import Map.parkMap;
import Map.placeMap;
import static Map.placeMap.parkMapFunctionalPlace;
import Path.Path;
import Place.Place;
import Place.PlaceHideout;
import java.io.IOException;
import static java.lang.Math.abs;
import static java.lang.Thread.sleep;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Małgorzata
 */
public final class AnimalsPrey extends Animals implements Runnable{
    private int waterLvl;
    private int foodLvl;
    private int[][] trail;
    int goal = 0;
    private ImageIcon image = new ImageIcon("C:/Users/Małgorzata/Downloads/patmat1.png");
    private final AtomicBoolean isAlive = new AtomicBoolean(true);
    
    public void drinkWater(){};
    public void eatPlants(){};
    
    public boolean status(){
        if(isAlive.get()){
        } else {
            return false;
        }
        return true;
    }
    
    public void move(){
        //
        ArrayList <Integer> candidates = new ArrayList<Integer>();
        xcor = getXcor();
        ycor = getYcor();
        this.trail = Path.path;
        Integer cords = mergeInt(xcor, ycor);
        Place curPlace = placeMap.parkMapFunctionalPlace.get(cords);
        if(curPlace.semaphore.tryAcquire()){
            JButton var1 = parkMap.parkMapFunctionalButton.get(cords);
            if(var1.getIcon() == null){
                var1.setIcon(image);
            }
        }
        if(curPlace.semaphore.tryAcquire() == false){
            try{
            sleep(5000);
            }catch(InterruptedException e) {
            }
        
        }
                
                
                int candidateR = xcor + 1;
                if(checkIfInRange(candidateR)){
                if(trail[candidateR - 1][ycor - 1] == 1){
                    candidates.add(mergeInt(candidateR, ycor));
                }
                }
                
                int candidateL = xcor - 1;
                if(checkIfInRange(candidateL)){
                if(trail[candidateL - 1][ycor - 1] == 1){
                    candidates.add(mergeInt(candidateL, ycor));
                }
                }
                
                int candidateU = ycor + 1;
                if(checkIfInRange(candidateU)){
                if(trail[xcor - 1][candidateU - 1] == 1){
                    candidates.add(mergeInt(xcor, candidateU));
                }
                }
                
                int candidateD = ycor - 1;
                if(checkIfInRange(candidateD)){
                if(trail[xcor - 1][candidateD - 1] == 1){
                    candidates.add(mergeInt(xcor, candidateD));
                }
                }
                
        System.out.println(candidates); 
        int rando = (int) ((Math.random() * candidates.size()));
        int newCords = candidates.remove(rando);
                
        setXcor(returnX(newCords));
        setYcor(returnY(newCords));
        
        Place newPlace = placeMap.parkMapFunctionalPlace.get(newCords);
        if(newPlace.semaphore.tryAcquire()){
            curPlace.semaphore.release();
            JButton var1 = parkMap.parkMapFunctionalButton.get(cords);
            JButton var2 = parkMap.parkMapFunctionalButton.get(newCords);
            var2.setIcon(var1.getIcon());
            var1.setIcon(null);
        }
        if(newPlace.semaphore.tryAcquire() == false){
            try{
            sleep(5000);
            }catch(InterruptedException e) {
            }
        }
        
    }
             
    
    public boolean checkIfInRange(int i){
        boolean var = true;
        if(i < 1 || i > 8){
            var = false;
        }
        return var;
    }
    
    
    @Override
    public void setGoal( int i){
        this.goal = i;
    }

    public int getGoal() {
        return goal;
    }
    
    


    public int manhattanSearch(int[][] grid, int startX, int startY, int goalX, int goalY) {
    // create a priority queue to store points to visit
    PriorityQueue<int[]> queue = new PriorityQueue<>((p1, p2) -> (distance(startX, startY, p1[0], p1[1]) + distance(p1[0], p1[1], goalX, goalY))
                                                             - (distance(startX, startY, p2[0], p2[1]) + distance(p2[0], p2[1], goalX, goalY)));

    // create a hash set to keep track of visited points
    Set<String> visited = new HashSet<>();

    // add the start point to the queue
    queue.add(new int[]{startX, startY});

    // loop until the queue is empty
    while (!queue.isEmpty()) {
        // remove the first point from the queue
        int[] current = queue.poll();
        int xc = current[0];
        int yc = current[1];
        setXcor(xc);
        setYcor(yc);
        System.out.println(xc + " " + yc);
        int cords = mergeInt(xc, yc);
        
        Place curPlace = placeMap.parkMapFunctionalPlace.get(cords);
        if(curPlace.semaphore.tryAcquire()){
            JButton var1 = parkMap.parkMapFunctionalButton.get(cords);
            if(var1.getIcon() == null){
                var1.setIcon(image);
            }
        }
        if(curPlace.semaphore.tryAcquire() == false){
            try{
            sleep(5000);
            }catch(InterruptedException e) {
            }
        
        }
        
        // check if the current point is the goal
        if (current[0] == goalX && current[1] == goalY) {
            int water = 200;
            setWaterLvl(water);
            int food = 200;
            setFoodLvl(food);
            return distance(startX, startY, current[0], current[1]);
        }

        // mark the current point as visited
        visited.add(current[0] + "," + current[1]);

        // explore the neighboring points
        int[][] neighbors = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for (int[] neighbor : neighbors) {
            int x = current[0] + neighbor[0];
            int y = current[1] + neighbor[1];
            String nextKey = x + "," + y;

            // check if the neighbor is within the grid and not visited
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && !visited.contains(nextKey) && grid[x][y] == 1) {
                queue.add(new int[]{x, y});
                
                
            }
        }
            curPlace.semaphore.release();
            JButton var1 = parkMap.parkMapFunctionalButton.get(cords);
            var1.setIcon(null);
        }


    // no path found
    return -1;
}

// calculate the Manhattan distance between two points
public static int distance(int x1, int y1, int x2, int y2) {
    return Math.abs(x1 - x2) + Math.abs(y1 - y2);
}


    public void hide(){
        
        var hideoutIsFull = PlaceHideout.isHideoutIsFull();
        
        if(hideoutIsFull == true){
            try {
                sleep(5000);
            } catch (InterruptedException e) {
            }
        }
        
        if(hideoutIsFull == false){
            //boolean add = PlaceHideout.hideout.add(this);
            //boi this is a mess
        }
        //add animal to a hideout array if xycor == xycor of hideout
        //sleep for 5s
        //remove animal from hideout array
        
        //if hideout is full, wait outside
    }
    
    public int mergeInt(int x, int y){
        String x1 = Integer.toString(x);
        String y1 = Integer.toString(y);
        String x1y1 = x1 + y1;
        Integer cords = Integer.valueOf(x1y1);
        
        return cords;
    };
    
    public int returnX (int cords){
        int xF = Math.floorDiv(cords,10);
        return xF;
    }
    
    public int returnY (int cords){
        int yF = cords - (Math.floorDiv(cords, 10) * 10);
        return yF;
    }
    
    
    
    public int getWaterLvl() {
        return waterLvl;
    }

    public void setWaterLvl(int waterLvl) {
        
        this.waterLvl = waterLvl;
    }

    public int getFoodLvl() {
        return foodLvl;
    }

    public void setFoodLvl(int foodLvl) {

        this.foodLvl = foodLvl;
    }

    @Override
    public void setStrength(int strength) {
        super.setStrength(strength);
    }

    @Override
    public void setSpeed(int speed) {
        //move 1 place in path per tick or more
        int min = 1;
        int max = 10;
        speed = (int)Math.floor(Math.random()*(max-min+1)+min);
        super.setSpeed(speed); 
    }

    @Override
    public void setHealth(int health) {
        int min = 50;
        int max = 200;
        health = (int)Math.floor(Math.random()*(max-min+1)+min);
        super.setHealth(health);
    }

    @Override
    public void setSpeciesName(String speciesName) {
        int min = 1;
        int max = 17;
        int n = (int)Math.floor(Math.random()*(max-min+1)+min);
        try (Stream<String> lines = Files.lines(Paths.get("C:/Users/Małgorzata/Downloads/JurassicPrey.txt"))) {
            speciesName = lines.skip(n).findFirst().get();
        }
        catch(IOException e){
            System.out.println(e);
        }
        super.setSpeciesName(speciesName); 
    }
    
    @Override
    public void setName(String name){
        super.setName(name);
    }

    @Override
    public void setXcor(int xcor) {
        this.xcor = xcor;
    }

    @Override
    public void setYcor(int ycor) {
        this.ycor = ycor;
    }
    
    public void stop(){
        if(isAlive.get()){
            isAlive.set(false);
            Integer cords = mergeInt(xcor, ycor);
            Place placeOfDeath = placeMap.parkMapFunctionalPlace.get(cords);
            placeOfDeath.semaphore.release();
            JButton dead = parkMap.parkMapFunctionalButton.get(cords);
            dead.setIcon(null);
        }
    };
    
    
    @Override
    public void run(){
        
        int numOfMoves = (int) ((Math.random() * 10) + 1);
        while(isAlive.get()) {
        //mam visitedPlaces w run, ale chcę je przenieść do move    
        Set<Integer> visitedPlaces = new HashSet<Integer>();
        if(goal != 0){
            manhattanSearch(trail, getXcor(), getYcor(), returnX(goal), returnY(goal) );
            setGoal(0);
        }
        
        for(int i = 0; i < numOfMoves; i++){
            //give coords into the buffer queue
            System.out.println(i);
            if(visitedPlaces.contains(mergeInt(xcor,ycor)) == false || i >= 3){
                visitedPlaces.add(mergeInt(xcor,ycor));
                move();
            }
            //change cords from old to new in the queue
            //maybe changing data is too much and I should stick to notifying if array of prey is not null
            try {
                sleep(1000);
                int water = getWaterLvl() - 1;
                setWaterLvl(water);
                int food = getFoodLvl() - 1;
                setFoodLvl(food);
            } catch (InterruptedException ex) {
                Logger.getLogger(AnimalsPrey.class.getName()).log(Level.SEVERE, null, ex);
                stop();
                
            }
            System.out.println(getSpeciesName() + getXcor());
            System.out.println(getYcor());
            System.out.println(getWaterLvl());
            System.out.println(getFoodLvl());
        }  
        try{
            sleep(1000);
              
            } catch (InterruptedException e) {
            }
    }  
    }
    
    @Override
    public String toString(){
        return this.getName();
    }
    
    
    

    public AnimalsPrey(int X, int Y, String nickname) {
        getHealth();
        int min = 50;
        int max = 200;
        waterLvl = (int)Math.floor(Math.random()*(max-min+1)+min);
        foodLvl = (int)Math.floor(Math.random()*(max-min+1)+min);
        setWaterLvl(waterLvl);
        setFoodLvl(foodLvl);
        setXcor(X);
        setYcor(Y);
        String typeOfDino = null;
        setSpeciesName(typeOfDino);
        setName(nickname);
        System.out.println(getSpeciesName());
        //Scanner sc = new Scanner(System.in);
        //System.out.println("Give your beloved dino a name");
        //String name = sc.nextLine();
        //setName(name);
        //System.out.println(getName());
        //run();
    }
    

    

    
}
