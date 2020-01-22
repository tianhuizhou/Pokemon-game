import java.util.Random;
/**
* Squirtle Pokemon object class.
* @author Tianhui Zhou
* @since 09/21/2018
*/
public class Squirtle extends Pokemon implements WaterType {
   /** The minimum attack power for species. */
   static final int BASE_ATTACK_POWER = 94;
   /** The minimum defense power for species. */
   static final int BASE_DEFENSE_POWER = 122;
   /** The minimum stamina power for species. */
   static final int BASE_STAMINA_POWER = 88;
   
   /**
   * Constructor with no name.
   */
   public Squirtle() {
      super("Squirtle", "Squirtle", 7, WATER_COLOR, 0.5, 9.0,
         WATER_TYPE, "", BASE_ATTACK_POWER, 
         BASE_DEFENSE_POWER, BASE_STAMINA_POWER);
      
      chooseFastAttack();
      chooseSpecialAttack();
   } //close the constructor with no name.
   
   /**
   * Constructor with name.
   * @param name The user-defined name.
   */
   public Squirtle(String name) {
      super("Squirtle", name, 7, WATER_COLOR, 0.5, 9.0, 
         WATER_TYPE, "", BASE_ATTACK_POWER, 
         BASE_DEFENSE_POWER, BASE_STAMINA_POWER);
     
      chooseFastAttack();
      chooseSpecialAttack();
   } //close the constructor with name.

/**
* Constructor with species and name for subclasses.
*@param species The Pokemon's species.
   *@param name The optional user-given name.
   *@param num The Pokedex number for this species.
   *@param ht The height of this Pokemon.
   *@param wt The weight of this Pokemon. 
   *@param baseAttackPwr The low limit of Attack Power for species.
   *@param baseDefensePwr The low limit of Defense Power for species.
   *@param baseStaminaPwr The low limit of Stamina Power for speices. 
   */
   protected Squirtle(String species, String name, int num,
       double ht, double wt, int baseAttackPwr, int baseDefensePwr, 
       int baseStaminaPwr) {
    
      super(species, name, num, WATER_COLOR, ht, wt, WATER_TYPE,
         "", baseAttackPwr, baseDefensePwr, baseStaminaPwr);
       
      chooseFastAttack();
      chooseSpecialAttack();
   } //close the Constructor
   
   /**
      * Water-type specific fast attack chooser.
      */
   protected void chooseFastAttack() {
      Random randGen = new Random();
      int index;
   
      index = randGen.nextInt(WATER_FAST_ATTACKS.length);
      fastAttack = WATER_FAST_ATTACKS[index];
      fastAttackPower = WATER_FAST_ATK_POWER[index];
   } //close chooseFastAttack
   
   /**
   * Water-type specific special attack chooser.
   */
   protected void chooseSpecialAttack() {
      Random randGen = new Random();
      int index;
   
      index = randGen.nextInt(WATER_SPECIAL_ATTACKS.length);
      specialAttack = WATER_SPECIAL_ATTACKS[index];
      specialAttackPower = WATER_SPECIAL_ATK_POWER[index];
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
   
      if (vType.equals("Fire") || vType.equals("Ground")
          || vType.equals("Rock")) {
      
         s = s + "\n It was super effective!";
         modifier = modifier * 2.0;
      } else if (vType.equals("Water") || vType.equals("Grass")
          || vType.equals("Dragon")) {
      
         s = s + "\n It was not very effective.";
         modifier = modifier * 0.5;
      }
    //check for same types 
      if (type1.equals(vType) && type2.equals(victim.getType2())) {
         modifier = modifier *  1.5;
      }
      //bulbapedia damage formula:
      damage = (((2 * level) + 10) / damageDivisor) 
          * attackPower * (fastAttackPower + 2) * modifier;
     
      //perform hit on victim pokemon
      victim.beAttacked((int) damage);
      return s;
   } //close performFastAttack
   
   /**
     *Game-play special attack simulation.
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
         
      modifier = (double) (rand.nextInt(16) + 85) / 100.0;       
      s = name + " performed " + specialAttack + " on " + victim.getSpecies();
      
      if (vType.equals("Fire") || vType.equals("Ground")
          || vType.equals("Rock")) {
      
         s = s + "\n It was super effective!";
         modifier = modifier * 2.0;
      } else if (vType.equals("Water") || vType.equals("Grass")
          || vType.equals("Dragon")) {
      
         s = s + "\n It was not very effective.";
         modifier = modifier * 0.5;
      }
    //check for same types 
      if (type1.equals(vType) && type2.equals(victim.getType2())) {
         modifier = modifier *  1.5;
      }
      //bulbapedia damage formula:
      damage = (((2 * level) + 10) / damageDivisor) 
          * attackPower * (fastAttackPower + 2) * modifier;
     
      //perform hit on victim pokemon
      victim.beAttacked((int) damage);
      return s;
   } //close performSpecialAttack
   
   /**
      * Reduces Pokemon's HP by damage/defensePower.
      * Doesn't allow HP to go less than 0
      * Implementation of "fainting" not done here
      * @param damage Hit points to take off HP
      */
   protected void beAttacked(int damage) {
      //part of bulbapedia damage formula
      damage = damage / defensePower;
      
      if (hP > damage) {
         hP = hP - damage;
      } else {
         hP = 0; //"Pokemon fainted"
      }
   }     

}