import java.util.Random;
/**
* Flareon Pokemon object class.
* Tianhui Zhou
* since 09/20/2018
*/
public class Flareon extends Eevee implements FireType {
   /** The minimum attack power for species. */
   static final int BASE_ATTACK_POWER = 246;
   /** The minimum defense power for species. */
   static final int BASE_DEFENSE_POWER = 204;
   /** The minimum stamina power for species. */
   static final int BASE_STAMINA_POWER = 130;
   
 /** Constructure with no name. */ 
   public Flareon() {
      super("Flareon", "Flareon", 136, FIRE_COLOR, 0.9, 25.0,
         FIRE_TYPE, BASE_ATTACK_POWER, BASE_DEFENSE_POWER, BASE_STAMINA_POWER);
      chooseFastAttack();
      chooseSpecialAttack();
   }
      
 /** Constructor with name.
  * @param name The user-defined name.
  */ 
   public Flareon(String name) {
      super("Flareon", name, 136, FIRE_COLOR, 0.9, 25.0,
         FIRE_TYPE, BASE_ATTACK_POWER, BASE_DEFENSE_POWER, BASE_STAMINA_POWER);
      chooseFastAttack();
      chooseSpecialAttack();
   
   }
   
  /** 
   * Fire-type specific fast attack chooser.
   */ 
   protected void chooseFastAttack() {
      Random randGen = new Random();
      int index;
   
      index = randGen.nextInt(FIRE_FAST_ATTACKS.length);
      fastAttack = FIRE_FAST_ATTACKS[index];
      fastAttackPower = FIRE_FAST_ATK_POWER[index];
   } //close chooseFastAttack
  
  /**
   * Fire-type specific special attack chooser.
   */
   protected void chooseSpecialAttack() {
      Random randGen = new Random();
      int index;
   
      index = randGen.nextInt(FIRE_SPECIAL_ATTACKS.length);
      specialAttack = FIRE_SPECIAL_ATTACKS[index];
      specialAttackPower = FIRE_SPECIAL_ATK_POWER[index];
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
         
      if (vType.equals("Grass") || vType.equals("Ice") 
             || vType.equals("Bug") || vType.equals("Steel")) {
            
         s = s + "\n It was super effective!";
         modifier = modifier * 2.0;          
      } else if (vType.equals("Water")  
             || vType.equals("Fire") || vType.equals("Dragon") 
             || vType.equals("Rock")) { 
         s = s + "\n It was not very effective.";
         modifier = modifier * 0.5;
      }
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
      * Game-play special attack simulation.
      * @param victim the Pokemon being attacked.
      * @return String explaining attack and effectiveness.
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
      //check effectiveness of attack
      if (vType.equals("Grass") || vType.equals("Ice") 
             || vType.equals("Bug") || vType.equals("Steel")) {
            
         s = s + "\n It was super effective!";
         modifier = modifier * 2.0;          
      } else if (vType.equals("Water")  
             || vType.equals("Fire") || vType.equals("Dragon") 
             || vType.equals("Rock")) { 
         s = s + "\n It was not very effective.";
         modifier = modifier * 0.5;
      }
         //check for same types for bonus
      if (type1.equals(vType) && type2.equals(victim.getType2())) {
         modifier = modifier *  1.5;
      }
      //bulbapedia damage formula:
      damage = (((2 * level) + 10) / damageDivisor) 
         * attackPower * (specialAttackPower + 2) * modifier;      
      //perform hit on victim pokemon
      victim.beAttacked((int) damage);
      return s;
   }
}





