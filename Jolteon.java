import java.util.Random;
/**
* Jolteon Pokemon object class.
* Tianhui Zhou
* since 09/20/2018
*/
public class Jolteon extends Eevee implements ElectricType {
   /** The minimum attack power for species. */
   static final int BASE_ATTACK_POWER = 232;
   /** The minimum defense power for species. */
   static final int BASE_DEFENSE_POWER = 201;
   /** The minimum stamina power for species. */
   static final int BASE_STAMINA_POWER = 130;
   
 
 /** Constructor with no name. */
   public Jolteon() {
      super("Jolteon", "Jolteon", 135, ELECTRIC_COLOR, 0.8, 24.5, ELECTRIC_TYPE,
         BASE_ATTACK_POWER, BASE_DEFENSE_POWER, BASE_STAMINA_POWER);
      chooseFastAttack();
      chooseSpecialAttack();
   }

 /** 
 * Constructor with name.
 * @param name The user-defined name.
 */ 
   public Jolteon(String name) {
      super("Jolteon", name, 135, ELECTRIC_COLOR, 0.8, 24.5, ELECTRIC_TYPE, 
         BASE_ATTACK_POWER, BASE_DEFENSE_POWER, BASE_STAMINA_POWER);
      chooseFastAttack();
      chooseSpecialAttack();
   }
  
  /**
  * Electric-type specific fast attack chooser.
  */
   protected void chooseFastAttack() {
      Random randGen = new Random();
      int index;
   
      index = randGen.nextInt(ELECTRIC_FAST_ATTACKS.length);
      fastAttack = ELECTRIC_FAST_ATTACKS[index];
      fastAttackPower = ELECTRIC_FAST_ATK_POWER[index];
   } //close chooseFastAttack
   
   /**
   * Electric-type specific special attack chooser.
   */
   protected void chooseSpecialAttack() {
      Random randGen = new Random();
      int index;
   
      index = randGen.nextInt(ELECTRIC_SPECIAL_ATTACKS.length);
      specialAttack = ELECTRIC_SPECIAL_ATTACKS[index];
      specialAttackPower = ELECTRIC_SPECIAL_ATK_POWER[index];
   } //close chooseSpecialAttack
  
   
   /**
   * Game-play fast attack simulation.
   * @param victim the Pokemon being attacked
      * @return String explaining attack and effectiveness
   */
   public String performFastAttack(Pokemon victim) {
      Random rand = new Random();
      double damage = 0.0;
      double modifier = 1.0;
      double damageDivisor = 250.0;
   
      String s = "";
      String vType = victim.getType1();
    
    //random modifier .85 - 1.00
      modifier = (double) (rand.nextInt(16) + 85) / 100.0;      
      s = name + " performed " + fastAttack + " on " + victim.getSpecies();
         
      if (vType.equals("Water") || vType.equals("Flying")) {
            
         s = s + "\n It was super effective!";
         modifier = modifier * 2.0;          
      } else if (vType.equals("Grass")  
             || vType.equals("Electric") || vType.equals("Dragon")) { 
         s = s + "\n It was not very effective.";
         modifier = modifier * 0.5;
      } else if (vType.equals("Ground")) {
         s = s + "\n It had no effect.";
         modifier = 0;
      }
          //check for same types for bonus
      if (type1.equals(vType) && type2.equals(victim.getType2())) {
         modifier = modifier *  1.5;
      }
      //bulbapedia damage formula:
      damage = (((2 * level) + 10) / damageDivisor) 
         * attackPower * (fastAttackPower + 2) * modifier;      
      //perform hit on victim pokemon
      victim.beAttacked((int) damage);
      return s;
   }

   /**
   * Game-play fast attack simulation.
   * @param victim the Pokemon being attacked
      * @return String explaining attack and effectiveness
   */
   public String performSpecialAttack(Pokemon victim) {
      Random rand = new Random();
      double damage = 0.0;
      double modifier = 1.0;
      double damageDivisor = 250.0;
      
      String s = "";
      String vType = victim.getType1();
      
      //random modifier .85 - 1.00
      modifier = (double) (rand.nextInt(16) + 85) / 100.0;       
      s = name + " performed " + specialAttack + " on " + victim.getSpecies();
      if (vType.equals("Water") || vType.equals("Flying")) {
            
         s = s + "\n It was super effective!";
         modifier = modifier * 2.0;          
      } else if (vType.equals("Grass")  
             || vType.equals("Electric") || vType.equals("Dragon")) { 
         s = s + "\n It was not very effective.";
         modifier = modifier * 0.5;
      } else if (vType.equals("Ground")) {
         s = s + "\n It had no effect.";
         modifier = 0;
      }
          //check for same types for bonus
      if (type1.equals(vType) && type2.equals(victim.getType2())) {
         modifier = modifier *  1.5;
      }
      //bulbapedia damage formula:
      damage = (((2 * level) + 10) / damageDivisor) 
         * attackPower * (fastAttackPower + 2) * modifier;      
      //perform hit on victim pokemon
      victim.beAttacked((int) damage);
      return s;
   }
}
