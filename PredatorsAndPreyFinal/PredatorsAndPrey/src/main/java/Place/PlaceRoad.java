/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Place;

import Animals.AnimalsPrey;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Małgorzata
 */
public class PlaceRoad extends Place {
    
    private static final int MAX_AVAILABLE = 5;
    public final Semaphore available = new Semaphore(MAX_AVAILABLE, true);

    @Override
    public void setSemaphore(Semaphore semaphore) {
        super.setSemaphore(semaphore); 
    }

    @Override
    public Semaphore getSemaphore() {
        return super.getSemaphore(); 
    }
    
    
    
    @Override
    public void setMaxCapacity(int maxCapacity) {
        super.setMaxCapacity(maxCapacity); 
    }

    @Override
    public void setName(String name) {
        super.setName(name); 
    }
    
    @Override
    public void setXcor(int xcor){
        super.setXcor(xcor);
    }
    
    @Override
    public void setYcor(int ycor){
        super.setYcor(ycor);
    }
    
    public PlaceRoad(){
        setSemaphore(available);
        getSemaphore();
    };

}
