import java.util.*;
/**
  * PriorityQueue of Pokemon.
  * 100 pokemon fills both PriorityQueue and the stack.
  * Print both PriorityQueue and stack.
  * @author Tianhui Zhou.
  * @since 10/30/2018
  */
public class PriorityQueueOfPokemon {
    /** main method including two structure.
     *  @param args no use args.
     */
   public static void main(String[] args) {
        /** stack.*/
      Deque<Pokemon> pokeStack = new ArrayDeque<Pokemon>();
        /** priorityQueue.*/
      PriorityQueue<Pokemon> pq = new PriorityQueue<Pokemon>();
        /** initialize a pokemon variable. */
      Pokemon pTemp = new Bulbasaur();
        
        /** a loop for adding 100 pokemon for both stack and pq.*/
      for (int a = 0; a < 10; a++) {
         pTemp = new Bulbasaur();
         pq.add(pTemp);
         pokeStack.push(pTemp);
         
         pTemp = new Bulbasaur("alpha");
         pq.add(pTemp);
         pokeStack.push(pTemp);
         
         pTemp = new Bulbasaur("Bee");
         pq.add(pTemp);
         pokeStack.push(pTemp);
         
         pTemp = new Bulbasaur("cat");
         pq.add(pTemp);
         pokeStack.push(pTemp);
         
         pTemp = new Charizard();
         pq.add(pTemp);
         pokeStack.push(pTemp);
         
         pTemp = new Eevee();
         pq.add(pTemp);
         pokeStack.push(pTemp);
         
         pTemp = new Flareon();
         pq.add(pTemp);
         pokeStack.push(pTemp);
         
         pTemp = new Ivysaur();
         pq.add(pTemp);
         pokeStack.push(pTemp);
         
         pTemp = new Jolteon();
         pq.add(pTemp);
         pokeStack.push(pTemp);
         
         pTemp = new Squirtle();
         pq.add(pTemp);
         pokeStack.push(pTemp);
         
         pTemp = new Vaporeon();
         pq.add(pTemp);
         pokeStack.push(pTemp);
         
         pTemp = new Wartortle();
         pq.add(pTemp);
         pokeStack.push(pTemp);
         
         pTemp = new Charmeleon();
         pq.add(pTemp);
         pokeStack.push(pTemp);
      
      } // close for loop
      
      /** toString for printing priority queue.*/
      System.out.println("*************"
          + "Priority queue***********");
      while (pq.size() > 0) {
         Pokemon currPq = pq.poll();
         System.out.println(currPq.toString());
      }
      
      /** toString for printing stack.*/
      System.out.println("*************"
          + "Stack*************");
      while (pokeStack.size() > 0) {
         Pokemon currS = pokeStack.pop();
         System.out.println(currS.toString());
      }
   } //ends of main method
    
} //ends of class