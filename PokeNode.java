/**
 * Specific class for a PokeNode class.
 * @author Tianhui Zhou
 * @since Nov 23, 2018
 */
public class PokeNode {
   // data fields
  /** Data held in Node. */
   private Pokemon poke;
  /** Link to left child Node. */
   private PokeNode left;
  /** Link to right child Node.*/
   private PokeNode right;
  /** a number for counting Pokemon's amount. */
   private int number = 1;
  
  /**
   * Constructor.
   * @param p the pokemon object.
   * @param numCaught amount pokemon the user caught.
   * @param lChild the address of left child.
   * @param rChild the address of right child.   
   */
   public PokeNode(Pokemon p, int numCaught, PokeNode lChild,
       PokeNode rChild) {
     
      poke = p;
      number = numCaught;
      lChild = left;
      rChild = right;
      
   } //close Constructor
   
   /**
    * Accessor method.
    * @return the pokemon's address
    */
   public Pokemon getPokemon() {
      return poke;
   }
   
   /**
    * Accessor method.
    * @return the pokemon's number
    */
   public int getKey() {
      return poke.getNumber();
   }
   
   /**
    * Accessor method.
    * @return the pokemon's amount
    */
   public int getNumCaught() {
      return number;
   }
   
   /**
    * Accessor method.
    * @return the leftChild's address
    */
   public PokeNode getLChild() {
      return left;
   }
   
   /**
    * Accessor method.
    * @return the rightChild's address
    */
   public PokeNode getRChild() {
      return right;
   }
   
   /**
    * Mutator method.
    * increase the amount of pokemon.
    */ 
   public void increaseNumCaught() {
      this.number++;
   }
   
   /** 
    * Mutator method.
    * decrease the a,ount of pokemon.
    * cannot decrease when the number is 0.
    * @throws NumException when number less than 1, it will be thrown.
    */
   public void decreaseNumCaught()throws TreeException {
      if (this.number >= 1) {
         this.number--;
      } else {
         
         throw new TreeException("You do not have the pokemon now");
      }
   }
   
   /**
    * Mutator method.
    * @param newLChild a new left child.
    */
   public void setLChild(PokeNode newLChild) {
      left = newLChild;
   }
   
   /**
   * Mutator method.
   * @param newRChild a new right child.
   */
   public void setRChild(PokeNode newRChild) {
      right = newRChild;
   }

} //ends of the class