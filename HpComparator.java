
import java.util.Comparator;
/**
 * a NameComparator class.
 * It is a good example from javacodegeeks.com
 * I just make a little change on parameters.
 * @author Tianhui Zhou.
 * @since 12/02/2018
 */

public class HpComparator implements Comparator<Pokemon> {

   @Override
   public int compare(Pokemon o1, Pokemon o2) {
      try{
         int hp1 = o1.getHP();
         int hp2 = o2.getHP();
      
      // ascending order (descending order would be: name2.compareTo(name1))
      
         if(hp1 == hp2){
            return 0; 
         } else {
            return hp1 - hp2;
         }     
      } catch (NullPointerException m){
      }
      return 1;
   }

}