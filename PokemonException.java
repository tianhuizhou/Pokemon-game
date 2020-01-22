/**
  * An Exception for use with the Pokemon class.
  * @author Tianhui Zhou
  * @since 10/28/2018
  */
public class PokemonException extends RuntimeException {
   /** a variable for the message.*/
   private String message = "";
   /** get the message.
    * @return String message when throwing the exception.
    */
   public String getMessage() {
      return this.message;
   }

   /** set a message for the Exception.
    * @param message1 the message that will be thrown.
    */
   public void setMessage(String message1) {
      this.message = message1;
   }
      
} //end of class