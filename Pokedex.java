import java.util.*;
/**
 * Pokedex class is a driver class.
 * @author Tianhui Zhou
 * @since 11/23/2018
 */
public class Pokedex {
 /**
   * Driver code.
   * 
   * @param args are not used
   */
   public static void main(String[] args) {
      PokeTree tree = new PokeTree();
      String inString1 = "";
      Scanner reader = new Scanner(System.in);
      boolean endLoop = true;
      while (endLoop) {
         
         System.out.println("Please enter the number of your choice:");
         System.out.println("1.Catch a Pokemon");
         System.out.println("2.Trade a pokemon");
         System.out.println("3.Print all pokemon");
         System.out.println("0.Exit the program");
         //read in from user as a String
         inString1 = reader.nextLine();
         //take off any space on the string
         inString1 = inString1.trim();
         
         switch(inString1) {
            case "0":
               endLoop = false;
               System.out.println("\nGoodbye!");
               break;
            case "1":// make a new pokemon
               tree.add(Pokedex.choosePokemon());
               break;
            case "2":// trade a pokemon
               Pokemon q = Pokedex.choosePokemon();
               try {
                  tree.remove(q); }
               catch (TreeException e) {
                  System.out.println("You have not added the pokemon." 
                      + "\nPlease try again");
               }
               
               break;
               
            case "3":// print out all the pokemon in the PokeTree
               tree.printPokeTree();
               break;
            default:// not a valid input from user
               System.out.println("\nInvalid menu choice.\nPlease try again");
               break;
         }
      }
   } // close main method 
   
   /** a method for make new pokemon.
   *  Asking information about the pokemon.
   *  @return a new pokemon
   */
   public static Pokemon choosePokemon() {
      /** call the Pokemon class, and initialize pokemon*/
      Pokemon p = new Bulbasaur();
     
      String name = "";
    
      boolean endLoop2 = true; // ask number from user
      
      Scanner reader = new Scanner(System.in);
      String sTemp = "";
      String inString = "";
      
      /** menu of pokemon.
        * user can enter the number for choosing their pokemon.    
        */
      while (endLoop2) {
         System.out.println("Please enter the number to choose a Pokemon");
         System.out.println("1. Add a Bulbasaur");
         System.out.println("2. Add a Ivysaur");
         System.out.println("3. Add a Venusaur");
         System.out.println("4. Add a Charmander");
         System.out.println("5. Add a Charmeleon");
         System.out.println("6. Add a Charizard");
         System.out.println("7. Add a Squirtle");
         System.out.println("8. Add a Wartortle");
         System.out.println("9. Add a Blastoise");
         System.out.println("10. Add a Eevee");
         System.out.println("11. Add a Vaporeon");
         System.out.println("12. Add a Jolteon");
         System.out.println("13. Add a Flareon");
         System.out.println("Pick a Pokeman ");
         inString = reader.nextLine();
         inString = inString.trim();
         switch(inString) { 
            case "1":
               p = new Bulbasaur();
               endLoop2 = false;
               break;
            case "2":
               p = new Ivysaur();
               endLoop2 = false;
               break;
            case "3":
               p = new Venusaur();
               endLoop2 = false;
               break;
            case "4":
               p = new Charmander();
               endLoop2 = false;
               break;
            case "5":
               p = new Charmeleon();
               endLoop2 = false;
               break;       
            case "6":
               p = new Charizard();
               endLoop2 = false;
               break;
            case "7":
               p = new Squirtle();
               endLoop2 = false;
               break;
            case "8":
               p = new Wartortle();
               endLoop2 = false;
               break;
            case "9":
               p = new Blastoise();
               endLoop2 = false;
               break;
            case "10":
               p = new Eevee();
               endLoop2 = false;
               break;
            case "11":
               p = new Vaporeon();
               endLoop2 = false;
               break;
            case "12":
               p = new Jolteon();
               endLoop2 = false;
               break;
            case "13":
               p = new Flareon();
               endLoop2 = false;
               break;
            default:
               System.out.println("\nInvalid menu choice.\nPlease try again");
               break;
         }
      }
      return p;      
   } //close makePokemon
   
} //ends of class