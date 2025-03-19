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
public class PlaceSourceFood extends PlaceSource {
    private static final int MAX_AVAILABLE = 3;
    public final Semaphore available = new Semaphore(MAX_AVAILABLE, true);
    private float foodLeft;
    
    public float getFoodLeft() {
        return foodLeft;
    }

    public void setFoodLeft(float foodLeft) {
        //the more animals are in the source, more food is depleted
        
        this.foodLeft = foodLeft;
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
    
    public PlaceSourceFood(){
        setSemaphore(available);
        getSemaphore();
    };
    
    
}
