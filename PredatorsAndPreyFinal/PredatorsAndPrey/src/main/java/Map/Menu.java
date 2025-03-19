/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Map;
//////CHANGE FLOW LAYOUT TO GRIDBAG LAYOUT


import Animals.Animals;
import Animals.AnimalsPredators;
import Animals.AnimalsPrey;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;



/**
 *
 * @author Małgorzata
 */
public class Menu extends JFrame{
    //second jframe to add the animals
    
    JButton addPredator;
    JTextField insertX;
    JTextField insertY;
    JButton addPrey;
    JTextField insertXPrey;
    JTextField insertYPrey;
    JList<Animals> allAnimals;
    JSplitPane splitPanel;
    JLabel label;
    JLabel labelNamePrey;
    JLabel labelNamePred;
    JPanel panel;
    DefaultListModel<Animals> model;
    
    //AnimalList aniList;
    List<Thread> listOfPredators = new ArrayList<>();
    List<Thread> listOfPreys = new ArrayList<>();
    List<AnimalsPrey> objPreys = new ArrayList<>();
    List<AnimalsPredators> objPreds = new ArrayList<>();
    AtomicBoolean flag = new AtomicBoolean(false);
    

    public List<Thread> getListOfPredators() {
        return listOfPredators;
    }

    public List<Thread> getListOfPreys() {
        return listOfPreys;
    }

    public List<AnimalsPrey> getObjPreys() {
        return objPreys;
    }
    
    
    
    
    public Menu(){
        
      //JList of Preys  
        
      JList<Animals> allAnimals = new JList<>();
      
      JSplitPane splitPanel = new JSplitPane();
      JPanel panel = new JPanel();
      DefaultListModel<Animals> model = new DefaultListModel<>();
      
      allAnimals.setModel(model);
      JLabel label = new JLabel();
      JLabel labelNamePrey = new JLabel("set name of Prey");
      JLabel labelNamePred = new JLabel("set name of Predator");
      
      allAnimals.getSelectionModel().addListSelectionListener(e -> {
            Animals animal = allAnimals.getSelectedValue();
            label.setText(" Name of species: " + animal.getSpeciesName() 
                    + "\n X coordinates: " + animal.getXcor() + "\n Y coordinates: " + animal.getYcor() +
                    " \n Status: " + animal.status());
        });
      
      splitPanel.setLeftComponent(new JScrollPane(allAnimals));
      panel.add(label);
      splitPanel.setRightComponent(panel);
      
      this.setLocationRelativeTo(null);
      this.setVisible(true);
      
      
      //JList of Predators
      JList<AnimalsPredators> predAnimals= new JList<>();
      JSplitPane splitPanel2 = new JSplitPane();
      JPanel panel2 = new JPanel();
      DefaultListModel<AnimalsPredators> model2 = new DefaultListModel<>();
      
      predAnimals.setModel(model2);
      JLabel label2 = new JLabel();
      
      predAnimals.getSelectionModel().addListSelectionListener(e -> {
            AnimalsPredators pd = predAnimals.getSelectedValue();
            label2.setText(" Name of species: " + pd.getSpeciesName() 
                    + " X coordinates: " + pd.getXcor() + " Y coordinates: " + pd.getYcor() +
                    " Status: " + pd.status());
        });
      
      splitPanel2.setLeftComponent(new JScrollPane(predAnimals));
      panel2.add(label2);
      splitPanel2.setRightComponent(panel2);
      this.setLocationRelativeTo(null);
      this.setVisible(true);
      
      
      //JButton to add predators
      
      JTextField insertName = new JTextField();
      insertName.setPreferredSize(new Dimension(100,40));
      
      JTextField insertX = new JTextField();
      insertX.setPreferredSize(new Dimension(100,40));
      
      JTextField insertY = new JTextField();
      insertY.setPreferredSize(new Dimension(100,40));  
        
      JButton addPredator = new JButton("create a predator");
      //zobacz jakie boundy będą najlepsze
      addPredator.setBounds(100,100,100,100);
      addPredator.addActionListener(e -> {
          Object source = e.getSource();
          if(source == addPredator){
              String xvaR = insertX.getText();
              String yvaR = insertY.getText();
              String nick = insertName.getText();
              int x = Integer.parseInt(xvaR);
              int y = Integer.parseInt(yvaR);
              AnimalsPredators pred = new AnimalsPredators(x, y, nick,  this);
              Thread t = new Thread(pred);
              t.start();
              objPreds.add(pred);
              model2.addElement(pred);
              int idx = this.objPreds.indexOf(pred);
              listOfPredators.add(t);
              listOfPredators.set(idx, t);
              //model.addElement();           
          }
      });
      
      //JButton to add prey
      
      JTextField insertNameOfPrey = new JTextField();
      insertNameOfPrey.setPreferredSize(new Dimension(100,40));
      
      JTextField insertXPrey = new JTextField();
      insertXPrey.setPreferredSize(new Dimension(100,40));
      
      JTextField insertYPrey = new JTextField();
      insertYPrey.setPreferredSize(new Dimension(100,40));  
        
      JButton addPrey = new JButton("create a prey");
      addPrey.setBounds(100,200,100,100);
      addPrey.addActionListener(e -> {
          Object source = e.getSource();
          if(source == addPrey){
              String xvar = insertXPrey.getText();
              String yvar = insertYPrey.getText();
              int x = Integer.parseInt(xvar);
              int y = Integer.parseInt(yvar);
              String name = insertNameOfPrey.getText();
              AnimalsPrey prey = new AnimalsPrey(x, y, name);
              Thread t = new Thread(prey);
              t.start();
              objPreys.add(prey);
              model.addElement(prey);
              int idx = objPreys.indexOf(prey);
              listOfPreys.add(t);
              listOfPreys.set(idx, t);
            
          }
      });
      
      //JButton to assign water source to a prey
      
      JButton getWater = new JButton("water");
      getWater.setBounds(100,100,70,70);
      getWater.addActionListener(e -> {
          Object source = e.getSource();
          if(source == getWater){
            LinkedList<Integer> waterSource = new LinkedList<Integer>();
            boolean water = Collections.addAll(waterSource, 27, 41, 54, 76, 82  );
            int idx = (int) ((Math.random() * waterSource.size()));
            int i = waterSource.get(idx);
            Animals prey = allAnimals.getSelectedValue();
            prey.setGoal(i);
          }
      });
      
      //JButton to assign food source to a prey
      
      JButton getFood = new JButton("food");
      getFood.setBounds(100,100,70,70);
      getFood.addActionListener(e -> {
          Object source = e.getSource();
          if(source == getFood){
            LinkedList<Integer> foodSource = new LinkedList<Integer>();
            boolean foo = Collections.addAll(foodSource, 11, 15, 34, 51, 53, 68 );
            int idx = (int) ((Math.random() * foodSource.size()));
            int i = foodSource.get(idx);
            Animals prey = allAnimals.getSelectedValue();
            prey.setGoal(i);
          }
      });
      
      //JButton to assign hideout to a prey
      
      JButton getHide = new JButton("hide");
      getHide.setBounds(100,100,70,70);
      getHide.addActionListener(e -> {
          Object source = e.getSource();
          if(source == getFood){
            LinkedList<Integer> hideout = new LinkedList<Integer>();
            boolean hid = Collections.addAll(hideout, 13, 25, 48, 56, 84 );
            int idx = (int) ((Math.random() * hideout.size()));
            int i = hideout.get(idx);
            Animals prey = allAnimals.getSelectedValue();
            prey.setGoal(i);
          }
      });
      
    
      //JButton to kill predators
      
      JButton killPredator = new JButton("kill a predator");
          killPredator.addActionListener(e -> {
          Object source = e.getSource();
          if(source == killPredator){
            System.out.println(listOfPredators);
            System.out.println(objPreds);
            AnimalsPredators pred = predAnimals.getSelectedValue();
            int x = this.objPreds.indexOf(pred);
            this.objPreds.remove(pred);
            this.listOfPredators.remove(x);
            pred.stop();
            System.out.println(listOfPredators);
            System.out.println(objPreds);
          }
          });
     
this.setSize(600, 600);
this.setLayout(new GridBagLayout());
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

GridBagConstraints gbc = new GridBagConstraints();

gbc.gridx = 0;
gbc.gridy = 0;
gbc.insets = new Insets(10, 10, 10, 10);
this.add(insertX, gbc);

gbc.gridx = 1;
this.add(insertY, gbc);

gbc.gridx = 2;
this.add(addPredator, gbc);

gbc.gridy = 0;
gbc.gridx = 3;
this.add(labelNamePred, gbc);

gbc.gridx = 4;
this.add(insertName, gbc);

gbc.gridy = 1;
gbc.gridx = 0;
this.add(insertXPrey, gbc);

gbc.gridx = 1;
this.add(insertYPrey, gbc);

gbc.gridx = 2;
this.add(addPrey, gbc);

gbc.gridy = 1;
gbc.gridx = 3;
this.add(labelNamePrey, gbc);

gbc.gridx = 4;
this.add(insertNameOfPrey, gbc);

gbc.gridy = 2;
gbc.gridx = 0;
this.add(getWater, gbc);

gbc.gridx = 1;
this.add(getFood, gbc);

gbc.gridx = 2;
this.add(getHide, gbc);

gbc.gridy = 3;
gbc.gridx = 0;
this.add(splitPanel, gbc);

gbc.gridy = 3;
gbc.gridx = 2;
this.add(splitPanel2, gbc);

gbc.gridy = 4;
gbc.gridx = 2;
this.add(killPredator, gbc);
       

this.pack();
this.setVisible(true);

    }
    
    public boolean notifyPredator(){
        //System.out.println(listOfPreys);
        if(!objPreys.isEmpty()){
            flag.set(true);
            return true;
        }
        flag.set(false);
        return false;
    }
    
    
    public void delPrey(AnimalsPrey prey){
        System.out.println("kill");
        //prey.stop();
        System.out.println("przed: "+this.objPreys.size());
        int x = this.objPreys.indexOf(prey);
        this.objPreys.remove(prey);
        //model.removeElement(prey);
        this.listOfPreys.remove(x);
        System.out.println("po: "+this.objPreys.size());
        
        
    }
    
   
       
}
