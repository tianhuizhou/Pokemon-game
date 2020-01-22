
import java.util.Comparator;
/**
 * a NameComparator class.
 * It is a good example from javacodegeeks.com
 * I just make a little change on parameters.
 * @author Tianhui Zhou.
 * @since 12/02/2018
 */

public class NameComparator implements Comparator<Pokemon> {

   @Override
   public int compare(Pokemon o1, Pokemon o2) {
      try{
         String name1 = o1.getSpecies();
         String name2 = o2.getSpecies();
      
      // ascending order (descending order would be: name2.compareTo(name1))
         return name1.compareTo(name2);}
      catch (NullPointerException v){
      }
      return 1;
   }

}