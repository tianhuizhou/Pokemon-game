import java.util.Random;
/**
*  Eevee pokemon object class.
*  Single-type Normal implements one interface.
*  Parent class to Vaporeon, Jolteon, Flareon.
*  @author Tianhui Zhou.
*  @version 1.0.
*  @since 09/21/2018.
*/
public class Eevee extends Pokemon implements NormalType {
   /** The minimum attack power for species. */
   static final int BASE_ATTACK_POWER = 104;
   /** The minimum defense power for species. */
   static final int BASE_DEFENSE_POWER = 121;
   /** The minimum stamina power for species. */
   static final int BASE_STAMINA_POWER = 110;
  
  /**
   * Constructor with no name.
   */
   public Eevee() {
      super("Eevee", "Eevee", 133, NORMAL_COLOR, 0.3, 6.5,
         NORMAL_TYPE, "",BASE_ATTACK_POWER, 
         BASE_DEFENSE_POWER, BASE_STAMINA_POWER);
      
      chooseFastAttack();
      chooseSpecialAttack();
   } //close the constructor with no name.
   
   /**
   * Constructor with name.
   * @param name The user-defined name.
   */
   public Eevee(String name) {
      super("Eevee", name, 133, NORMAL_COLOR, 0.3, 6.5, 
         NORMAL_TYPE, "",BASE_ATTACK_POWER, 
         BASE_DEFENSE_POWER, BASE_STAMINA_POWER);
     
      chooseFastAttack();
      chooseSpecialAttack();
   } //close the constructor with name.
   
   /**
* Constructor with species and name for subclasses.
*@param species The Pokemon's species.
   *@param name The optional user-given name.
   *@param num The Pokedex number for this species.
   *@param colorN The color of this pokemon.
   *@param ht The height of this Pokemon.
   *@param wt The weight of this Pokemon. 
   *@param typeN the second type of this Pokemon.
   *@param baseAttackPwr The low limit of Attack Power for species.
   *@param baseDefensePwr The low limit of Defense Power for species.
   *@param baseStaminaPwr The low limit of Stamina Power for speices.
*/
   protected Eevee(String species, String name, int num, String colorN,
       double ht, double wt, String typeN, int baseAttackPwr, 
       int baseDefensePwr, int baseStaminaPwr) {
    
      super(species, name, num, colorN, ht, wt, typeN, "",
         baseAttackPwr, baseDefensePwr, baseStaminaPwr);
       
      chooseFastAttack();
      chooseSpecialAttack();
   } //close the Constructor
   
   /**
      * Normal-type specific fast attack chooser.
      */
   protected void chooseFastAttack() {
      Random randGen = new Random();
      int index;
   
      index = randGen.nextInt(NORMAL_FAST_ATTACKS.length);
      fastAttack = NORMAL_FAST_ATTACKS[index];
      fastAttackPower = NORMAL_FAST_ATK_POWER[index];
   } //close chooseFastAttack
   
   /**
   * Normal-type specific special attack chooser.
   */
   protected void chooseSpecialAttack() {
      Random randGen = new Random();
      int index;
   
      index = randGen.nextInt(NORMAL_SPECIAL_ATTACKS.length);
      specialAttack = NORMAL_SPECIAL_ATTACKS[index];
      specialAttackPower = NORMAL_SPECIAL_ATK_POWER[index];
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
   
      if (vType.equals("Steel") 
          || vType.equals("Rock")) {
      
         s = s + "\n It was super effective!";
         modifier = modifier * 0.5;
      } else if (vType.equals("Ghost")) {
      
         s = s + "\n It was not very effective.";
         modifier = modifier * 0;
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
   
      if (vType.equals("Steel")     || vType.equals("Rock")) {
      
         s = s + "\n It was super effective!";
         modifier = modifier * 0.5;
      } else if (vType.equals("Ghost")) {
      
         s = s + "\n It was not very effective.";
         modifier = modifier * 0;
      }
    //check for same types 
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


} //close Eevee class