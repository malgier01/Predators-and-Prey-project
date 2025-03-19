/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Map;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Małgorzata
 */
public class parkMap extends JFrame{
    JFrame parkMap;
    public static Map<Integer, JButton> parkMapFunctionalButton = new HashMap(); 
    //ImageIcon img = null;
    public parkMap(){
      JFrame parkMap = new JFrame();
      parkMap.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      parkMap.setSize(640,640);
      parkMap.setLayout(new GridLayout(8,8));
    JButton place11 = new JButton();
    place11.setBackground(Color.green);
    parkMap.add(place11);
    parkMapFunctionalButton.put(11, place11);
    
    JButton place12 = new JButton();
    place12.setBackground(Color.orange);
    parkMap.add(place12);
    parkMapFunctionalButton.put(12, place12);
    
    JButton place13 = new JButton();
    place13.setBackground(Color.lightGray);
    parkMap.add(place13);
    parkMapFunctionalButton.put(13, place13);
    
    JButton place14 = new JButton();
    place14.setBackground(Color.orange);
    parkMap.add(place14);
    parkMapFunctionalButton.put(14, place14);
    
    JButton place15 = new JButton();
    place15.setBackground(Color.green);
    parkMap.add(place15);
    parkMapFunctionalButton.put(15, place15);
    
    JButton place16 = new JButton();
    place16.setBackground(Color.orange);
    parkMap.add(place16);
    parkMapFunctionalButton.put(16, place16);
    
    JButton place17 = new JButton();
    place17.setBackground(Color.pink);
    parkMap.add(place17);
    parkMapFunctionalButton.put(17, place17);
    
    JButton place18 = new JButton();
    place18.setBackground(Color.pink);
    parkMap.add(place18);
    parkMapFunctionalButton.put(18, place18);
    
    JButton place21 = new JButton();
    place21.setBackground(Color.orange);
    parkMap.add(place21);
    parkMapFunctionalButton.put(21, place21);
    
    JButton place22 = new JButton();
    place22.setBackground(Color.pink);
    parkMap.add(place22);
    parkMapFunctionalButton.put(22, place22);
    
    JButton place23 = new JButton();
    place23.setBackground(Color.pink);
    parkMap.add(place23);
    parkMapFunctionalButton.put(23, place23);
    
    JButton place24 = new JButton();
    place24.setBackground(Color.pink);
    parkMap.add(place24);
    parkMapFunctionalButton.put(24, place24);
    
    JButton place25 = new JButton();
    place25.setBackground(Color.lightGray);
    parkMap.add(place25);
    parkMapFunctionalButton.put(25, place25);
    
    JButton place26 = new JButton();
    place26.setBackground(Color.orange);
    parkMap.add(place26);
    parkMapFunctionalButton.put(26, place26);
    
    JButton place27 = new JButton();
    place27.setBackground(Color.blue);
    parkMap.add(place27);
    parkMapFunctionalButton.put(27, place27);
    
    JButton place28 = new JButton();
    place28.setBackground(Color.orange);
    parkMap.add(place28);
    parkMapFunctionalButton.put(28, place28);
    
    JButton place31 = new JButton();
    place31.setBackground(Color.orange);
    parkMap.add(place31);
    parkMapFunctionalButton.put(31, place31);
    
    JButton place32 = new JButton();
    place32.setBackground(Color.pink);
    parkMap.add(place32);
    parkMapFunctionalButton.put(32, place32);
      

    JButton place33 = new JButton();
    place33.setBackground(Color.orange);
    parkMap.add(place33);
    parkMapFunctionalButton.put(33, place33);

    JButton place34 = new JButton();
    place34.setBackground(Color.green);
    parkMap.add(place34);
    parkMapFunctionalButton.put(34, place34);
    
    JButton place35 = new JButton();
    place35.setBackground(Color.pink);
    parkMap.add(place35);
    parkMapFunctionalButton.put(35, place35);

    JButton place36 = new JButton();
    place36.setBackground(Color.orange);
    parkMap.add(place36);
    parkMapFunctionalButton.put(36, place36);

    JButton place37 = new JButton();
    place37.setBackground(Color.pink);
    parkMap.add(place37);
    parkMapFunctionalButton.put(37, place37);

    JButton place38 = new JButton();
    place38.setBackground(Color.orange);
    parkMap.add(place38);
    parkMapFunctionalButton.put(38, place38);

    JButton place41 = new JButton();
    place41.setBackground(Color.blue);
    parkMap.add(place41);
    parkMapFunctionalButton.put(41, place41);

    JButton place42 = new JButton();
    place42.setBackground(Color.pink);
    parkMap.add(place42);
    parkMapFunctionalButton.put(42, place42);

    JButton place43 = new JButton();
    place43.setBackground(Color.orange);
    parkMap.add(place43);
    parkMapFunctionalButton.put(43, place43);

    JButton place44 = new JButton();
    place44.setBackground(Color.pink);
    parkMap.add(place44);
    parkMapFunctionalButton.put(44, place44);

    JButton place45 = new JButton();
    place45.setBackground(Color.pink);
    parkMap.add(place45);
    parkMapFunctionalButton.put(45, place45);

    JButton place46 = new JButton();
    place46.setBackground(Color.orange);
    parkMap.add(place46);
    parkMapFunctionalButton.put(46, place46);

    JButton place47 = new JButton();
    place47.setBackground(Color.pink);
    parkMap.add(place47);
    parkMapFunctionalButton.put(47, place47);

    JButton place48 = new JButton();
    place48.setBackground(Color.lightGray);
    parkMap.add(place48);
    parkMapFunctionalButton.put(48, place48);

    JButton place51 = new JButton();
    place51.setBackground(Color.green);
    parkMap.add(place51);
    parkMapFunctionalButton.put(51, place51);

    JButton place52 = new JButton();
    place52.setBackground(Color.pink);
    parkMap.add(place52);
    parkMapFunctionalButton.put(52, place52);

    JButton place53 = new JButton();
    place53.setBackground(Color.green);
    parkMap.add(place53);
    parkMapFunctionalButton.put(53, place53);

    JButton place54 = new JButton();
    place54.setBackground(Color.blue);
    parkMap.add(place54);
    parkMapFunctionalButton.put(54, place54);

    JButton place55 = new JButton();
    place55.setBackground(Color.orange);
    parkMap.add(place55);
    parkMapFunctionalButton.put(55, place55);

    JButton place56 = new JButton();
    place56.setBackground(Color.lightGray);
    parkMap.add(place56);
    parkMapFunctionalButton.put(56, place56);

    JButton place57 = new JButton();
    place57.setBackground(Color.pink);
    parkMap.add(place57);
    parkMapFunctionalButton.put(57, place57);

    JButton place58 = new JButton();
    place58.setBackground(Color.orange);
    parkMap.add(place58);
    parkMapFunctionalButton.put(58, place58);

    JButton place61 = new JButton();
    place61.setBackground(Color.orange);
    parkMap.add(place61);
    parkMapFunctionalButton.put(61, place61);

    JButton place62 = new JButton();
    place62.setBackground(Color.pink);
    parkMap.add(place62);
    parkMapFunctionalButton.put(62, place62);

    JButton place63 = new JButton();
    place63.setBackground(Color.pink);
    parkMap.add(place63);
    parkMapFunctionalButton.put(63, place63);

    JButton place64 = new JButton();
    place64.setBackground(Color.orange);
    parkMap.add(place64);
    parkMapFunctionalButton.put(64, place64);

    JButton place65 = new JButton();
    place65.setBackground(Color.pink);
    parkMap.add(place65);
    parkMapFunctionalButton.put(65, place65);

    JButton place66 = new JButton();
    place66.setBackground(Color.orange);
    parkMap.add(place66);
    parkMapFunctionalButton.put(66, place66);

    JButton place67 = new JButton();
    place67.setBackground(Color.pink);
    parkMap.add(place67);
    parkMapFunctionalButton.put(67, place67);

    JButton place68 = new JButton();
    place68.setBackground(Color.green);
    parkMap.add(place68);
    parkMapFunctionalButton.put(68, place68);

    JButton place71 = new JButton();
    place71.setBackground(Color.orange);
    parkMap.add(place71);
    parkMapFunctionalButton.put(71, place71);

    JButton place72 = new JButton();
    place72.setBackground(Color.pink);
    parkMap.add(place72);
    parkMapFunctionalButton.put(72, place72);

    JButton place73 = new JButton();
    place73.setBackground(Color.pink);
    parkMap.add(place73);
    parkMapFunctionalButton.put(73, place73);

    JButton place74 = new JButton();
    place74.setBackground(Color.orange);
    parkMap.add(place74);
    parkMapFunctionalButton.put(74, place74);

    JButton place75 = new JButton();
    place75.setBackground(Color.pink);
    parkMap.add(place75);
    parkMapFunctionalButton.put(75, place75);

    JButton place76 = new JButton();
    place76.setBackground(Color.blue);
    parkMap.add(place76);
    parkMapFunctionalButton.put(76, place76);

    JButton place77 = new JButton();
    place77.setBackground(Color.orange);
    parkMap.add(place77);
    parkMapFunctionalButton.put(77, place77);

    JButton place78 = new JButton();
    place78.setBackground(Color.orange);
    parkMap.add(place78);
    parkMapFunctionalButton.put(78, place78);

    JButton place81 = new JButton();
    place81.setBackground(Color.orange);
    parkMap.add(place81);
    parkMapFunctionalButton.put(81, place81);

    JButton place82 = new JButton();
    place82.setBackground(Color.blue);
    parkMap.add(place82);
    parkMapFunctionalButton.put(82, place82);

    JButton place83 = new JButton();
    place83.setBackground(Color.orange);
    parkMap.add(place83);
    parkMapFunctionalButton.put(83, place83);

    JButton place84 = new JButton();
    place84.setBackground(Color.lightGray);
    parkMap.add(place84);
    parkMapFunctionalButton.put(84, place84);

    JButton place85 = new JButton();
    place85.setBackground(Color.pink);
    parkMap.add(place85);
    parkMapFunctionalButton.put(85, place85);

    JButton place86 = new JButton();
    place86.setBackground(Color.pink);
    parkMap.add(place86);
    parkMapFunctionalButton.put(86, place86);

    JButton place87 = new JButton();
    place87.setBackground(Color.pink);
    parkMap.add(place87);
    parkMapFunctionalButton.put(87, place87);

    JButton place88 = new JButton();
    place88.setBackground(Color.pink);
    parkMap.add(place88);
    parkMapFunctionalButton.put(88, place88);


      parkMap.setVisible(true);
           
    }

 
    public static Map<Integer, JButton> getParkMapFunctionalButton() {
        return parkMapFunctionalButton;
    }

    
}
