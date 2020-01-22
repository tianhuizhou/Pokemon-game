import java.util.Comparator;
/**
 * a NameComparator class.
 * It is a good example from javacodegeeks.com
 * I just make a little change on parameters.
 * @author Tianhui Zhou.
 * @since 12/02/2018
 */

public class CpComparator implements Comparator<Pokemon> {

   @Override
   public int compare(Pokemon o1, Pokemon o2) {
      try{
         int cp1 = o1.getCP();
         int cp2 = o2.getCP();
      
      // ascending order (descending order would be: name2.compareTo(name1))
      
         if(cp1 == cp2){
            return 0; 
         } else {
            return cp1 - cp2;
         }     
      } catch (NullPointerException m){
      }
      return 1;
   }

}