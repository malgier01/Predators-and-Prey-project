/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Place;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Małgorzata
 */
public abstract class Place implements Serializable {

    
    //the map will be a board, so each place will be a square on the board (x y)
    private String name;
    private int maxCapacity;
    private static int xcor;
    private static int ycor;
    public Semaphore semaphore;

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public void setSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }
    
    
    
    //private ArrayList place;
    //array of animals
    //each place is an array list of animals??
    //ArrayList<Animals.Animals> place = new ArrayList;
    //overall I did semaphores
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getXcor() {
        return xcor;
    }

    public void setXcor(int xcor) {
        this.xcor = xcor;
    }

    public int getYcor() {
        return ycor;
    }

    public void setYcor(int ycor) {
        this.ycor = ycor;
    }

    
}

