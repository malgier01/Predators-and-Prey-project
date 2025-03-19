 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.predatorsandprey;

import Animals.AnimalsPredators;
import Animals.AnimalsPrey;

import Map.Menu;
import Map.parkMap;
import Map.placeMap;
import Place.Place;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;



/**
 *
 * @author Małgorzata
 */
public class PredatorsAndPrey {

    public static void main(String[] args) {
      parkMap JurassicPark = new parkMap();
      placeMap JurrasicPlace = new placeMap();
      
      //Map<Integer, > parkMapPlaces = new HashMap();
      
      //parkMap.getParkMapFunctionalButton();
      SwingUtilities.invokeLater(Menu::new);
      //AnimalList alist = new AnimalList();
      //Menu addAnimal = new Menu();
      
      
      //AnimalsPrey prey = new AnimalsPrey(); 
     
      
      
    }
    }

