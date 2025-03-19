/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Animals;


import Map.Menu;
import Map.parkMap;
import Map.placeMap;
import Place.Place;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Małgorzata
 */
public final class AnimalsPredators extends Animals implements Runnable {
    private String currentMode;
    private int isHunting;
    private int isResting;
    private boolean eatPrey;
    private final AtomicBoolean isAlive = new AtomicBoolean(true);
    AtomicBoolean flagKill = new AtomicBoolean(false);
    ArrayList<String> killedDino = new ArrayList<>();
    Menu menu;
    //BufferedImage image;
     
    //File imagefile = new File("Screenshots/benis.bmp");
    private ImageIcon image = new ImageIcon("C:/Users/Małgorzata/Downloads/mat1.png");
    //
    //image = ImageIO.read(imagefile);



    //File image = new File("Screenshots/chuj.bmp");
     
    
    //current place place
    // move up
    // move down
    // move left
    // move right
    

      
     
    public void setIsHunting(int isHunting) {
        this.isHunting = isHunting;
    }

    public int getIsResting() {
        return isResting;
    }

    public void setIsResting(int isResting) {
        this.isResting = isResting;
    }

    /**
     *
     * @return
     */
    @Override
    public int getXcor() {
        return xcor;
    }

    @Override
    public int getYcor() {
        return ycor;
    }

    @Override
    public void setXcor(int Xcor) {
        this.xcor = Xcor;
    }

    @Override
    public void setYcor(int Ycor) {
        this.ycor = Ycor;
    }
    
    public void ChangeStateOfIsAlive(){
        this.isAlive.set(false);
    }
    
    public void move(){
        xcor = getXcor();
        ycor = getYcor();
        speed = getSpeed();
        
        String x1 = Integer.toString(xcor);
        String y1 = Integer.toString(ycor);
        String x1y1 = x1 + y1;
        Integer cords = Integer.valueOf(x1y1);
        Place curPlace = placeMap.parkMapFunctionalPlace.get(cords);
        if(curPlace.semaphore.tryAcquire()){
            /*
            if(curPlace.){
                System.out.println("dead");
                JButton var1 = parkMap.parkMapFunctionalButton.get(cords);
                var1.setIcon(null);
                stop();
            }
*/
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
        
        //if no image then set image
        
        
        //THIS SECTION DEPENDS ON SIZE OF THE MAP
        //GOSIA Z PRZYSZŁOŚCI WYBACZ JAK BĘDZIESZ TO DEBUGOWAĆ
        //HAHA JOKES ON U GOSIA Z PRZESZŁOŚCI, BO ZHARDCODOWALAM MAPE
        
        Random direction = new Random();
        int max_directions = 4;
        int oneDirection = direction.nextInt(max_directions);
        if(oneDirection == 0){
            int rightxcor = xcor + 1 * speed;
            if(checkIfInRange(rightxcor)){
                setXcor(rightxcor);
            }    
        }
        if(oneDirection == 1){
            int upycor = ycor + 1 * speed;
            if (checkIfInRange(upycor)){
                setYcor(upycor);
            }
            
        }
        if(oneDirection == 2){
            int leftxcor = xcor - 1 * speed;
            if(checkIfInRange(leftxcor)){
                setXcor(leftxcor); 
            }
              
        }
        if (oneDirection == 3){
            int downycor = ycor - 1 * speed;
            if(checkIfInRange(downycor)){
                setYcor(downycor);
            }
        }
        String x2 = Integer.toString(xcor);
        String y2 = Integer.toString(ycor);
        String x2y2 = x2 + y2;
        Integer cords2 = Integer.valueOf(x2y2);
        Place newPlace = placeMap.parkMapFunctionalPlace.get(cords2);
        if(newPlace.semaphore.tryAcquire()){
            curPlace.semaphore.release();
            JButton var1 = parkMap.parkMapFunctionalButton.get(cords);
            JButton var2 = parkMap.parkMapFunctionalButton.get(cords2);
            var2.setIcon(var1.getIcon());
            var1.setIcon(null);
        }
        if(newPlace.semaphore.tryAcquire() == false){
            try{
            sleep(5000);
            }catch(InterruptedException e) {
            }
        }
        
        
    };
    
    public int placePredator(){
        xcor = getXcor();
        ycor = getYcor();
        
        String x1 = Integer.toString(xcor);
        String y1 = Integer.toString(ycor);
        String x1y1 = x1 + y1;
        Integer cords = Integer.valueOf(x1y1);
        
        return cords;
    };
    
    public boolean checkIfInRange(int i){
        boolean var = true;
        if(i < 1 || i > 8){
            var = false;
        }
        return var;
    }
    
    
   //currentMode can be a monitor for isHunting and isResting
    //orrr i should make 2 monitors, one on ishunting and one on isresting
    
    

    public void bloodshed(){
        // eat Prey == false, ale jesli predator i prey maja takie same 
        // xy to się jedzą i speed predator zwalnia bo jest gruby
        // jak speed predatora spadnie do 0 to umiera z przejedzenia
    };
    
    public String getCurrentMode() {
        return currentMode;
    }

    public void setCurrentMode(String currentMode) {
        this.currentMode = currentMode;
    }

    @Override
    public void setStrength(int strength) {
        super.setStrength(strength); 
    }

    @Override
    public void setSpeed(int speed) {
        //speed should depend on size of map and be divided by 10
        super.setSpeed(speed); 
    }

    @Override
    public void setSpeciesName(String speciesName) {
        int min = 1;
        int max = 51;
        int n = (int)Math.floor(Math.random()*(max-min+1)+min);
        try (Stream<String> lines = Files.lines(Paths.get("C:/Users/Małgorzata/Downloads/JurassicPredators.txt"))) {
            speciesName = lines.skip(n).findFirst().get();
        }
        catch(IOException e){
            System.out.println(e);
        }
        super.setSpeciesName(speciesName); 
    }
    
    public void stop(){
        if(isAlive.get()){
            isAlive.set(false);
            Integer cords = placePredator();
            Place placeOfDeath = placeMap.parkMapFunctionalPlace.get(cords);
            placeOfDeath.semaphore.release();
            JButton dead = parkMap.parkMapFunctionalButton.get(cords);
            dead.setIcon(null);
        }
    };
    
    public boolean notifyPrey(double distance){
        if(distance == 0){
            flagKill.set(true);
            return true;
        }
        flagKill.set(false);
        return false;
    }
    // hunt - a* algorithm when there is a prey somewhere (like sync with prey?)
    //for animals in animalsprey
    //if cords of predator == cords of prey
    //AnimalsPrey.prey.stop()
    //objprey pop prey
    
    public void hunt(){
        boolean canHuntPrey = menu.notifyPredator();
        if(canHuntPrey){
            List<AnimalsPrey> mealPrep = menu.getObjPreys();
            int idx = (mealPrep.size() - 1);
            AnimalsPrey goal = mealPrep.get(idx);
            int goali = goal.getXcor();
            int goalj = goal.getYcor();
            int goalCords = (goal.mergeInt(goali, goalj));
            int i = getXcor();
            int j = getYcor();
            int cords = placePredator();
            int lenX = Math.abs(goali - i);
            int lenY = Math.abs(goalj - j);
            double distance = Math.hypot(lenX, lenY);
            while(distance > 2){
                System.out.println("Działa");
                Place curPlace = placeMap.parkMapFunctionalPlace.get(cords);
                if(curPlace.semaphore.tryAcquire() == false){
                    try{
                    sleep(5000);
                    }catch(InterruptedException e) {
                    }
                }
                ArrayList<Double> contest = new ArrayList();
                Map<Double,Integer> nextCord = new HashMap();
                int rightxcor = xcor + 1 * speed;
                if(checkIfInRange(rightxcor)){
                    int newlenR = Math.abs(goali - rightxcor);
                    double distanceR = Math.hypot(newlenR, lenY);
                    nextCord.put(distanceR, rightxcor);
                    contest.add(distanceR);
                }
                int leftxcor = xcor - 1 * speed;
                if(checkIfInRange(leftxcor)){
                    int newlenL = Math.abs(goali - leftxcor);
                    double distanceL = Math.hypot(newlenL, lenY);
                    nextCord.put(distanceL, leftxcor);
                    contest.add(distanceL);
                }
                int upycor = ycor + 1 * speed;
                if(checkIfInRange(upycor)){
                    int newlenU = Math.abs(goalj - upycor);
                    double distanceU = Math.hypot(lenX, newlenU);
                    nextCord.put(distanceU, upycor);
                    contest.add(distanceU);
                }
                int dycor = ycor - 1 * speed;
                if(checkIfInRange(dycor)){
                    int newlenD = Math.abs(goalj - dycor);
                    double distanceD = Math.hypot(lenX, newlenD);
                    nextCord.put(distanceD, dycor);
                    contest.add(distanceD);
                }
                Collections.sort(contest);
                double bestD = contest.remove(0);
                int newC = nextCord.get(bestD);
                if(newC == rightxcor){
                    System.out.println("r");
                   setXcor(newC);
                   setYcor(ycor);  
                }
                if(newC == leftxcor){
                    System.out.println("l");
                    setXcor(newC);
                    setYcor(ycor);
                }
                if(newC == upycor){
                    System.out.println("u");
                    setXcor(xcor);
                    setYcor(newC);
                }
                if(newC == dycor){
                    System.out.println("d");
                    setXcor(xcor);
                    setYcor(newC);
                }
                int cords2 = placePredator(); 
                Place newPlace = placeMap.parkMapFunctionalPlace.get(cords2);
                if(newPlace.semaphore.tryAcquire()){
                    curPlace.semaphore.release();
                    JButton var1 = parkMap.parkMapFunctionalButton.get(cords);
                    JButton var2 = parkMap.parkMapFunctionalButton.get(cords2);
                    var2.setIcon(image);
                    var1.setIcon(null);
                }
                if(newPlace.semaphore.tryAcquire() == false){
                    try{
                    sleep(5000);
                    curPlace.semaphore.release();
                    JButton var1 = parkMap.parkMapFunctionalButton.get(cords);
                    JButton var2 = parkMap.parkMapFunctionalButton.get(cords2);
                    var2.setIcon(image);
                    var1.setIcon(null);
                    }catch(InterruptedException e) {
                    }
                }
                goali = goal.getXcor();
                goalj = goal.getYcor();
                i = getXcor();
                j = getYcor();
                cords = placePredator();
                distance = bestD;
                System.out.println(i+ " " + j);

            }
            if(distance <= 2 ){
                int cords2 = placePredator(); 
                Place newPlace = placeMap.parkMapFunctionalPlace.get(cords2);
                if(newPlace.semaphore.tryAcquire()){
                    Place curPlace = placeMap.parkMapFunctionalPlace.get(cords);
                    curPlace.semaphore.release();
                    JButton var1 = parkMap.parkMapFunctionalButton.get(cords);
                    JButton var2 = parkMap.parkMapFunctionalButton.get(cords2);
                    var2.setIcon(image);
                    var1.setIcon(null);
                }
                if(newPlace.semaphore.tryAcquire() == false){
                    try{
                    sleep(5000);
                    Place curPlace = placeMap.parkMapFunctionalPlace.get(cords);
                    curPlace.semaphore.release();
                    JButton var1 = parkMap.parkMapFunctionalButton.get(cords);
                    JButton var2 = parkMap.parkMapFunctionalButton.get(cords2);
                    var2.setIcon(image);
                    var1.setIcon(null);
                    }catch(InterruptedException e) {
                    }
                
                System.out.println("mniam");
                killedDino.add(goal.getSpeciesName());
                menu.delPrey(goal); 
                goal.stop();
                
            }
        }    
    }
    }
        
    @Override
    

    public void run(){
        
        int numOfMoves = (int) ((Math.random() * 10) + 1);
        while(isAlive.get()) {
            boolean canHuntPrey = menu.notifyPredator();
                if(canHuntPrey){ hunt();}
        for(int i = 0; i < numOfMoves; i++){
            System.out.println(i);
            move();
            
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(AnimalsPredators.class.getName()).log(Level.SEVERE, null, ex);
                stop();
                break;
            }
            System.out.println(getSpeciesName() + getXcor());
            System.out.println(getYcor());
        }  
        try{
            sleep(100);
            } catch (InterruptedException e) {
            }
    }
    };

    @Override
    public boolean status() {
        if(isAlive.get()){
            
        } else {
            return false;
        }return true;
        
        
    }
    
   
    
    public AnimalsPredators(int Xvar, int Yvar, String nicknam, Menu newMenu){
        this.menu = newMenu;
        //Scanner sc = new Scanner(System.in);
        System.out.println("Set x and y coordinates");
        //int xvar = sc.nextInt();
        //int yvar = sc.nextInt();
        setName(nicknam);
        setSpeed(1);
        setXcor(Xvar);
        setYcor(Yvar);
        String typeOfDino = null;
        setSpeciesName(typeOfDino);
        System.out.println(getSpeciesName());
        //run(); 
    }


}
