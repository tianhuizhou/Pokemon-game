/**
* interface for Fire type Pokemon.
* Fails checkstyle because no methods.
* @author Tianhui Zhou
* @since 2/22/2018
*/
public interface ElectricType {
   /** constants **/
   /** Type name String. */
   String ELECTRIC_TYPE = new String("Electric");
   /** Type color String. */
   String ELECTRIC_COLOR = new String("Yellow");
   /** Array of type fast attack names. */
   String[] ELECTRIC_FAST_ATTACKS = {"Volt Switch", "Thunder Shock"};
   /** Array of type special attack names. */
   String[] ELECTRIC_SPECIAL_ATTACKS = {"Thunder", "Thunderbolt", 
      "Discharge"};
   /** Array of fast attack powers, coincides with name array. */
   int[] ELECTRIC_FAST_ATK_POWER = {20, 5}; 
   /** Array of special attack powers, coincides with name array. */     
   int[] ELECTRIC_SPECIAL_ATK_POWER = {100, 80, 65};

}