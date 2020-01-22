/**
 * a class for PokeTree.
 * @author Tianhui Zhou.
 * @since 11/23/2018.
 */
public class PokeTree {
   private String sPokedex = "";
   /** Root node instance varible.*/
   private PokeNode root = null;
   /** No parameter constructor.*/
   public PokeTree() {
   //empty Constructor
   }
   
   /**
    * Adds a pokemon to the PokeTree.
    * recursive method.
    * @param p The pokemon to be added
    */
   public void add(Pokemon p) {
      root = add(root, p);
   }
   
   /**
    * recursively adds an item to the tree.
    * @param node The root of the tree/subtree.
    * @param p The object to be added.
    * @return The current node.
    */
   private PokeNode add(PokeNode node, Pokemon p) {
      // make a new node if not already in the tree
      if (node == null) {
         return new PokeNode(p, 1, null, null);
      } else if (node.getKey() == p.getNumber()) {
         // if add a pokemon it is already in the tree
         // increase the NumCaught
         node.increaseNumCaught();
         return node;
      } else if (node.getKey() < p.getNumber()) {
         // if add a pokemon which number is greater than node
         // set it to the node's rihgt child
         node.setRChild(this.add(node.getRChild(), p));
         return node;
      } else {
         // if aa a pokemon which number is smaller than node
         // set it to the node's left child
         node.setLChild(this.add(node.getLChild(), p));
         return node;
      }
   }
   
   /**
    * get a pokemon from the tree with same searchy key.
    * @param searchKey An object containing the search key.
    * @return the data item in the tree with matching key.
    */
   public Pokemon get(Pokemon searchKey) {
      return this.get(root, searchKey);
   }
   
   /** 
    * Recursive methog to get an item from the tree.
    * @param node The root of the tree/subtree.
    * @param searchKey An object storing the key to get.
    * @return the data item in tree with matching key.
    * @throws TreeException if item not found.
    */
   private Pokemon get(PokeNode node, Pokemon searchKey) {
      // if not found, throw exception
      if (node == null) {
         throw new TreeException("The pokemon not found!");
      } else {
         // if they are matched, return the pokemon's address
         if (searchKey.getNumber() == node.getKey()) {
            return node.getPokemon();
         } else if (searchKey.getNumber() < node.getKey()) {
         // if the searchKey is smaller than node
         // then search the left subtree
            return this.get(node.getLChild(), searchKey);
         } else {
         // if the searchKey is greater than node
         // then search the right subtree
            return this.get(node.getRChild(), searchKey);
         }
      }
   }
   
   /**
    * removes a pokemon from the PokeTree.
    * @param p a pokemon storing the key to remove.
    */
   public void remove(Pokemon p) {
      root = this.remove(root, p);
   }
    
    /**
     * recursive remove a pokemon from the tree.
     * @param node The root of the tree/subtree
     * @param p An pokemon storing only the key to remove.
     * @return root of current subtree.
     */
   private PokeNode remove(PokeNode node, Pokemon p) {
         // if item not found, throw exception
      if (node == null) {
         throw new TreeException("Pokemon not found!");
      } else if (p.getNumber() < node.getKey()) {
            // if searchKey is less than the node
            // continue to left
         node.setLChild(this.remove(node.getLChild(), p));
         return node;
      } else if (p.getNumber() > node.getKey()) {
            // if searchKey is greater than the node
            // continue to right
         node.setRChild(this.remove(node.getRChild(), p));
         return node;
      } else {
         // searchKey match with the node
          // decrease 1 on the Caught number
         node.decreaseNumCaught();
         if (node.getNumCaught() == 0) {
           // if the node contains only one pokemon
           // delete it 
            node = this.remove(node);
            return node;
         }
      }
      return node; 
   }
   
   /**
    * Helper method that takes a node out of tree.
    * @param node The node to remove
    * @return The node that replaces removed node or null.
    */
   private PokeNode remove(PokeNode node) {
       //if the node is a leaf, return null
      if (node.getLChild() == null && node.getRChild() == null) {
         return null;
      }
      // if node has a single right child node,
      // then return a reference to the right child node
      else if (node.getLChild() == null) {
         return node.getRChild();
      }
      // if node has a single left child node,
      // then return a reference to the left child node
      else if (node.getRChild() == null) {
         return node.getLChild();
      }
      // if the node has two child nodes
      else {
      // get next Smaller Item, which is Largest Item in Left Subtree
      // The next Smaller Item is stored at the rightmost node in the left
      // subtree.
         PokeNode largestItemInLeftSubtree = this.getItemWithLargestSearchKey(
             node.getLChild());
      // replace the node's item with this item
         PokeNode l = node.getLChild();
         PokeNode r = node.getRChild();
         node = new PokeNode(largestItemInLeftSubtree.getPokemon(),
            largestItemInLeftSubtree.getNumCaught(), l, r);
      // delete the rightmost node in the left subtree
         node.setLChild(this.removeNodeWithLargestSearchKey(node
             .getLChild()));
         return node;
      }
   }
   /**
   * Returns the item with the largest search key in the (sub)tree.
   * Helper method for removing interior nodes.
   * @param node The root of the tree/subtree
   * @return The data item with largest key
   */
   private PokeNode getItemWithLargestSearchKey(PokeNode node) {
   // if no right child, then this node contains the largest item
      if (node.getRChild() == null) {
         return node;
      }
      // if not, keep looking on the right
      else {
         return this.getItemWithLargestSearchKey(node.getRChild());
      }
   }

  /**
   * Removes the node with the largest search key.
   * Helper method for removing interior nodes.
   * Remove the node formerly occupied by item with largest search key.
   * To be called after item is moved to new node location.
   * 
   * @param node The root of the tree/subtree
   * @return root of (sub)tree with node removed.
   */
   private PokeNode removeNodeWithLargestSearchKey(PokeNode node) {
   // if no right child, then this node contains the largest item
   // so replace it with its left child
      if (node.getRChild() == null) {
         return node.getLChild();
      }
      // if not, keep looking on the right
      else {
         node.setRChild(this.removeNodeWithLargestSearchKey(node
             .getRChild()));
         return node;
      }
   }
   
   /**
    * print method.
    */
   public void printPokeTree() {
      this.printPokeTree(root);
   }
   
   /**
    * inorder display of nodes.
    * @param rootP The root of the tree/subtree
    */
   private void printPokeTree(PokeNode rootP) {
      if (rootP != null) {
         printPokeTree(rootP.getLChild());
         sPokedex = sPokedex + "  " + rootP.getPokemon().toString()
             + "\nCaught: " + rootP.getNumCaught() + "\n" + "\n";
         printPokeTree(rootP.getRChild());
         
      } 
   }  
   public String getSpokedex(){
      return sPokedex;
    
   }
} //ends PokeTree class