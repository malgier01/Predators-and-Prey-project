/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Place;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Małgorzata
 */
public class PlaceSourceWater extends PlaceSource {
    private static final int MAX_AVAILABLE = 3;
    public final Semaphore available = new Semaphore(MAX_AVAILABLE, true);
    private float waterLeft;

    public float getWaterLeft() {
        return waterLeft;
    }

    public void setWaterLeft(float waterLeft) {
        this.waterLeft = waterLeft;
    }

    @Override
    public int getReplenishingSpeed() {
        return super.getReplenishingSpeed(); 
    }

    @Override
    public void setSemaphore(Semaphore semaphore) {
        super.setSemaphore(semaphore); 
    }

    @Override
    public Semaphore getSemaphore() {
        return super.getSemaphore(); 
    }
    
    

    @Override
    public void setReplenishingSpeed(int replenishingSpeed) {
        super.setReplenishingSpeed(replenishingSpeed);
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
    public void setYcor(int ycor) {
        super.setYcor(ycor); 
    }

    @Override
    public void setXcor(int xcor) {
        super.setXcor(xcor); 
    }
    
    public PlaceSourceWater(){
        setSemaphore(available);
        getSemaphore();
    };
    
}
