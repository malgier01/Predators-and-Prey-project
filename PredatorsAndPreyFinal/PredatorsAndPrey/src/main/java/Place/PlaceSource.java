/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Place;

/**
 *
 * @author Małgorzata
 */
public abstract class PlaceSource extends Place {
    private int replenishingSpeed;

    public int getReplenishingSpeed() {
        return replenishingSpeed;
    }

    public void setReplenishingSpeed(int replenishingSpeed) {
        this.replenishingSpeed = replenishingSpeed;
    }
    
}
