import javax.swing.JFrame;
import java.util.*;

/**
* Demonstrates using GUI with Pokemon class.
* @author Tianhui Zhou
* @since 12/05/2018
*/

public class PokemonFrame {
   /** main method.
   * @param args not used
   */
   public static void main(String[ ] args) {
      //setup basic JFrame
        
      JFrame frm = new JFrame("Pokemon");
      frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //Add StudentPanel object to Frame
      frm.getContentPane().add(new PokemonPanel());
      //Display to screen
      frm.pack();
      frm.setVisible(true);
      
   }
}