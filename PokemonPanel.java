import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;



/**
 * PokemonPanel for Pokemon GUI.
 * 
 * @author Tianhui Zhou
 * @since 12/05/2018
 */
public class PokemonPanel extends JPanel {
   /** for counting index number of an array.*/
   int u = 0;
   /** initialize a pokemon.*/
   Pokemon p;
   /** a initialized pokeTree.*/
   PokeTree tree = new PokeTree();
    /** stack.*/
   Deque<Pokemon> pokeStack = new ArrayDeque<Pokemon>();
    /** a temp stack.*/
   Deque<Pokemon> tempStack = new ArrayDeque<Pokemon>();
        /** priorityQueue.*/
   PriorityQueue<Pokemon> pq = new PriorityQueue<Pokemon>();
     /** a temp priorityQueue.*/
   PriorityQueue<Pokemon> tempPq = new PriorityQueue<Pokemon>();
    /** an array to hold data for option Name, HP, CP.*/
   Pokemon pokemonA[] = new Pokemon[100];
   /** image for hunt button. */
   private ImageIcon picHunt = new ImageIcon("hunt.png");
   /** hunt button. */
   private JButton bHunt = new JButton("Hunt");
   /** image for catch button.*/
   private ImageIcon picCatch = new ImageIcon("catchball.png");
   /** catch button.*/
   private JButton bCatch = new JButton("Catch");
   /** image for pokedex button.*/
   private ImageIcon picPokedex = new ImageIcon("pokedex.png");
   /** pokedex button.*/
   private JButton bPokedex = new JButton("Pokedex");
   /** image for backpack button.*/
   private ImageIcon picBackpack = new ImageIcon("backpack.png");
   /** backpack button.*/
   private JButton bBackpack = new JButton("Backpack");
   
   /******** String for holding Pokemon for display. */ 
   private String sOut = new String("");
    /****** text are for displaying Pokemon.toString()s. */
   private JTextArea textArea1 = new JTextArea(15, 40); //for the top
    /****** text are for displaying Pokemon.toString()s. */
   private JTextArea textArea2 = new JTextArea(15, 40); //for the bottom
   /** Make TextArea scrollable. **********************/
   private JScrollPane scroll = new JScrollPane(textArea2, 
       JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
       JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
   
   /********* sub-panel. *********/
   //most work will be done with centerSubPanel
   private JPanel centerSubPanel = new JPanel();
   /********* sub-panel. *********/
   private JPanel allPanel = new JPanel();
                 
   /********* label. ************/
   private JLabel lTitle1 = new JLabel("Try to Catch a Pokemon");
   
   /********** Choice drop down menu for Number/Recent. **/
   private Choice chBackPack = new Choice();
   
   /** we can declare and initialize ActionListener obj. */
   private GUIListener listener = new GUIListener();
   
   /********* label. ************/   
   private JLabel photo = new JLabel("");
   /**
    * Constructor holds everything.
    */ 
   public PokemonPanel() {
     
      setPreferredSize(new Dimension(1000, 1000)); //set the size for Border
      centerSubPanel.setPreferredSize(new Dimension(1000, 100));
      allPanel.setPreferredSize(new Dimension(1000, 800));
      allPanel.setBackground(Color.white);
      
      textArea1.setText(sOut);
      textArea1.setEditable(false);
      allPanel.add(textArea1);   
      
      
      /** setting button Hunt.*/
      bHunt.setBounds(0, 0, 80, 80);
      Image temp = picHunt.getImage().getScaledInstance(bHunt.getWidth(), 
          bHunt.getHeight(), picHunt.getImage().SCALE_DEFAULT);
      picHunt = new ImageIcon(temp);
      bHunt.setIcon(picHunt); 
      centerSubPanel.add(bHunt);
      bHunt.addActionListener(listener);
      allPanel.add(photo);
      /** setting button Catch.*/
      bCatch.setBounds(0, 0, 80, 80);
      Image temp1 = picCatch.getImage().getScaledInstance(bCatch.getWidth(), 
          bCatch.getHeight(), picCatch.getImage().SCALE_DEFAULT);
      picCatch = new ImageIcon(temp1);
      bCatch.setIcon(picCatch);
      centerSubPanel.add(bCatch);
      bCatch.setEnabled(false);
      bCatch.addActionListener(listener);
      /** setting button Pokedex.*/
      bPokedex.setBounds(0, 0, 80, 80);
      Image temp2 = picPokedex.getImage().getScaledInstance(bPokedex.getWidth(),
          bPokedex.getHeight(), picPokedex.getImage().SCALE_DEFAULT);
      picPokedex = new ImageIcon(temp2);
      bPokedex.setIcon(picPokedex);
      centerSubPanel.add(bPokedex);
      bPokedex.addActionListener(listener);
      /** setting button Backpack.*/
      bBackpack.setBounds(0, 0, 80, 80);
      Image temp3 = picBackpack.getImage().getScaledInstance(bBackpack.getWidth(),
          bBackpack.getHeight(), picBackpack.getImage().SCALE_DEFAULT);
      picBackpack = new ImageIcon(temp3);
      bBackpack.setIcon(picBackpack);
      centerSubPanel.add(bBackpack);
      bBackpack.addActionListener(listener);
      chBackPack.add("Recent");
      chBackPack.add("Number");
      chBackPack.add("Name");
      chBackPack.add("HP");
      chBackPack.add("CP");
      centerSubPanel.add(chBackPack);
      allPanel.add(centerSubPanel);
   
      textArea2.setText(sOut);
      textArea2.setEditable(false);
      allPanel.add(scroll);
      
      add(allPanel);
      
   } // ends of Constructor
   
   /**
 * Private ActionListener class.
 */
   private class GUIListener implements ActionListener {
   
      /** bulbasaur image for making image button.*/
      ImageIcon bulbasaur = new ImageIcon("Bulbasaur.png");
      /** ivysaur image for making image button.*/
      ImageIcon ivysaur = new ImageIcon("Ivysaur.png");
      /** venusaur image for making image button.*/
      ImageIcon venusaur = new ImageIcon("Venusaur.png");
      /** squirtle image for making image button.*/
      ImageIcon squirtle = new ImageIcon("Squirtle.png");
      /** wartortle image for making image button.*/
      ImageIcon wartortle = new ImageIcon("Wartortle.jpg");
      /** blastoise image for making image button.*/
      ImageIcon blastoise = new ImageIcon("Blastoise.png");
      /** charmander image for making image button.*/
      ImageIcon charmander = new ImageIcon("Charmander.png");
      /** charmeleon image for making image button.*/
      ImageIcon charmeleon = new ImageIcon("Charmeleon.png");
      /** charizard image for making image button.*/
      ImageIcon charizard = new ImageIcon("Charizard.png");
      /** eevee image for making image button.*/
      ImageIcon eevee = new ImageIcon("Eevee.png");
      /** jolteon image for making image button.*/
      ImageIcon jolteon = new ImageIcon("Jolteon.png");
      /** vaporeon image for making image button.*/
      ImageIcon vaporeon = new ImageIcon("Vaporeon.png");
      /** flareon image for making image button.*/
      ImageIcon flareon = new ImageIcon("Flareon.jpg");
   /**
   * ActionPerformed method.
   * @param event what button is clicked.
   */ 
      public void actionPerformed(ActionEvent event) {
      /** define each buttom.*/
         
         if (event.getSource() == bHunt) {
            int pokedex = 0;
            Random ranNum = new Random();
            pokedex = (ranNum.nextInt(12)) + 1;
            switch(pokedex) { 
               case 1:
                  p = new Bulbasaur();
                  photo.setIcon(bulbasaur);
                  break;
               case 2:
                  p = new Ivysaur();
                  photo.setIcon(ivysaur);
                  break;
               case 3:
                  p = new Venusaur();
                  photo.setIcon(venusaur);
                  break;
               case 4:
                  p = new Charmander();
                  photo.setIcon(charmander);
                  break;
               case 5:
                  p = new Charmeleon();
                  photo.setIcon(charmeleon);
                  break;       
               case 6:
                  p = new Charizard();
                  photo.setIcon(charizard);
                  break;
               case 7:
                  p = new Squirtle();
                  photo.setIcon(squirtle);
                  break;
               case 8:
                  p = new Wartortle();
                  photo.setIcon(wartortle);
                  break;
               case 9:
                  p = new Blastoise();
                  photo.setIcon(blastoise);
                  break;
               case 10:
                  p = new Eevee();
                  photo.setIcon(eevee);
                  break;
               case 11:
                  p = new Vaporeon();
                  photo.setIcon(vaporeon);
                  break;
               case 12:
                  p = new Jolteon();
                  photo.setIcon(jolteon);
                  break;
               case 13:
                  p = new Flareon();
                  photo.setIcon(flareon);
                  break;
               default:
                  break;
            }
            sOut = "*****************";
            sOut = sOut + "A " + p.getSpecies() + " appeared!\n"
               + "*****************\n";
            sOut = sOut + p.toString();
            textArea1.setText(sOut);
            bCatch.setEnabled(true);
         } // close bHunt event
            /** Catch only can happen after Hunt.*/
         
         if (event.getSource() == bCatch) {
            int posibility = 0;
            Random a = new Random();
            posibility = a.nextInt(2);
            String q = "";
            
            if (posibility == 1) {
               q = "Caught!\n" + p.toString();
               textArea1.setText(q);
               tree.add(p);
               pokeStack.push(p);
               pq.add(p);
               
               pokemonA[u] = p;
               u++;
            } else {
               q =  p.getSpecies() + " escaped!";
               textArea1.setText(q);     
            }
            bCatch.setEnabled(false);
         } //close bCatch event
         
         if (event.getSource() == bPokedex) {
            textArea2.setText("");
            tree.printPokeTree();
            sOut = tree.getSpokedex();
            textArea2.setText(sOut);
         } //close bPokedex event
         
         if (event.getSource() == bBackpack) {
            //tempStack.addAll(pokeStack);
            if (chBackPack.getSelectedItem().equals("Recent")) {
               tempStack.addAll(pokeStack);
               String re = "*************Stack*************\n";
               while (tempStack.size() > 0) {
                  Pokemon currS = tempStack.pop();
                  re = re + currS.toString() + "\n" + "\n";
               }
               textArea2.setText(re);
            } else if (chBackPack.getSelectedItem().equals("Number")) {
               tempPq.addAll(pq);
               String nu = "*************Priority queue***********\n";
               while (tempPq.size() > 0) {
                  Pokemon currPq = tempPq.poll();
                  nu = nu + currPq.toString() + "\n" + "\n";
               }
               textArea2.setText(nu);
            } else if (chBackPack.getSelectedItem().equals("Name")) {
               Arrays.sort(pokemonA, new NameComparator());
               String sName = "";   
               for (int i = 0; i < pokemonA.length; i++) {
                  try {
                     sName = sName + pokemonA[i].toString() + "\n";
                  } catch (NullPointerException m) {
                  }
               }
               textArea2.setText(sName);
            } else if (chBackPack.getSelectedItem().equals("HP")) {
               Arrays.sort(pokemonA, new HpComparator());
               String sHp = "";
               for (int h = 0; h < pokemonA.length; h++) {
                  try {
                     sHp = sHp + pokemonA[h].toString() + "\n";
                  } catch (NullPointerException m) {
                  }
               }
               textArea2.setText(sHp);
            } else if (chBackPack.getSelectedItem().equals("CP")) {
               Arrays.sort(pokemonA, new CpComparator());
               String sCp = "";
               for (int c = 0; c < pokemonA.length; c++) {
                  try {
                     sCp = sCp + pokemonA[c].toString() + "\n";
                  } catch (NullPointerException m) {
                  }
               }
               textArea2.setText(sCp);
            }
         } //close bBackpack event
         
      }
   }
} //ends of class