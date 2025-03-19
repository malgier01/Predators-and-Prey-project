/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Place;
import Animals.AnimalsPrey;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Małgorzata
 */
public class PlaceHideout extends Place {
    
    private static final int MAX_AVAILABLE = 3;
    public final Semaphore available = new Semaphore(MAX_AVAILABLE, true);

    public Semaphore getAvailable() {
        return available;
    }
    
    

    @Override
    public void setSemaphore(Semaphore semaphore) {
        super.setSemaphore(semaphore); 
    }

    @Override
    public Semaphore getSemaphore() {
        return super.getSemaphore(); 
    }
    
    
    private static boolean hideoutIsFull = false;

    public static boolean isHideoutIsFull() {
        return hideoutIsFull;
    }

    public void setHideoutIsFull(boolean hideoutIsFull) {
        this.hideoutIsFull = hideoutIsFull;
    }
    
    
    
    ArrayList<Thread> hideout = new ArrayList(); 
    public void reproduce(){
        //try with 
        int PreyInHideout = hideout.size();
        if(PreyInHideout > 1 && MAX_AVAILABLE > PreyInHideout + 1){
           Thread baby = new Thread(new AnimalsPrey(getXcor(), getYcor(), getName())); 
           hideout.add(baby);
        }
    };
    
    
    //maybe hide function should be in animal?
    // moved it to prey, having boolean for hideout is better so animals can check if hideout is full
    public void hide(){
        //if prey is in hideout, I can give it sleep for some seconds and then move out from array
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
    
    public PlaceHideout(){
        setSemaphore(available);
        getSemaphore();
        reproduce();
        
    };
    
}
