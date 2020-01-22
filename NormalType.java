/**
* interface for Normal type Pokemon.
* Fails checkstyle because no methods.
* @author Tianhui Zhou
* @since 09/20/2018
*/
public interface NormalType {
   /** constants **/
   /** Type name String. */
   String NORMAL_TYPE = new String("Normal");
   /** Type color String. */
   String NORMAL_COLOR = new String("Pink");
   /** Array of type fast attack names. */
   String[] NORMAL_FAST_ATTACKS = {"Tackle", "Quick Attack"};
   /** Array of type special attack names. */
   String[] NORMAL_SPECIAL_ATTACKS = {"Body Slam", "Swift"};
   /** Array of fast attack powers, coincides with name array. */
   int[] NORMAL_FAST_ATK_POWER = {5, 8}; 
   /** Array of special attack powers, coincides with name array. */     
   int[] NORMAL_SPECIAL_ATK_POWER = {50, 60};
   
      
}