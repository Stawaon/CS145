// Exercise 21.25: Tree.java
// TreeNode and Tree class declarations for a binary search tree.

// class TreeNode definition
class TreeNode<T extends Comparable<T>> {
   // package access members
   TreeNode<T> leftNode; // left node  
   T data; // node value
   TreeNode<T> rightNode; // right node

   // constructor initializes data and makes this a leaf node
   public TreeNode(T nodeData) { 
      data = nodeData;              
      leftNode = rightNode = null; // node has no children
   }

   // locate insertion point and insert new node; ignore duplicate values
   public void insert(T insertValue) {
      // insert in left subtree
      if (insertValue.compareTo(data) <0) {
         // insert new TreeNode
         if (leftNode == null) {
            leftNode = new TreeNode<>(insertValue);
         }
         else { // continue traversing left subtree recursively
            leftNode.insert(insertValue); 
         }
      }
      // insert in right subtree
      else if (insertValue.compareTo(data)> 0) {
         // insert new TreeNode
         if (rightNode == null) {
            rightNode = new TreeNode<>(insertValue);
         }
         else { // continue traversing right subtree recursively
            rightNode.insert(insertValue); 
         }
      }
   }
}

// class Tree definition
public class Tree<T extends Comparable<T>> {
   private TreeNode<T> root;

   // constructor initializes an empty Tree of integers
   public Tree() { 
      root = null; 
   }

   // insert a new node in the binary search tree
   public void insertNode(T insertValue) {
      if (root == null) {
         root = new TreeNode<>(insertValue); // create root node
      }
      else {
         root.insert(insertValue); // call the insert method
      }
   }

   // public remove method
   public void remove(T key) {
      root = removeNode(root, key);
   }

   // recursive method removes node
   private TreeNode<T> removeNode(TreeNode<T> root, T key) {
      if (root == null) {
         return root;
      }

      if (key.compareTo(root.data) < 0) { // if key is smaller, it is in left subtree
         root.leftNode = removeNode(root.leftNode, key);
      } else if (key.compareTo(root.data) > 0) { // if key is larger, it is in right subtree
         root.rightNode = removeNode(root.rightNode, key);
      } else {
         // If node has only one or no branches
         if (root.leftNode == null) {
            return root.rightNode; // replace with right branch
         } else if (root.rightNode == null) {
            return root.leftNode; // replace with left branch
         }

         // If node has 2 branches
         root.data = findMin(root.rightNode).data;
         root.rightNode = removeNode(root.rightNode, root.data);
      }

      return root;
   }
   
   // Helper method for finding the minimum value in a tree
   private TreeNode<T> findMin(TreeNode<T> node) {
      // minimum value will be left-most leaf node
      while (node.leftNode != null) {
         node = node.leftNode;
      }
      return node;
   }
   // begin preorder traversal
   public void preorderTraversal() { 
      preorderHelper(root); 
   }

   // recursive method to perform preorder traversal
   private void preorderHelper(TreeNode<T> node) {
      if (node == null) {
         return;
      }

      System.out.printf("%s ", node.data); // output node data
      preorderHelper(node.leftNode); // traverse left subtree
      preorderHelper(node.rightNode); // traverse right subtree
   }

   public boolean preorderSearch(T key) {
      return preorderSearchHelper(root, key);
   }

   private boolean preorderSearchHelper(TreeNode<T> node, T key) {
      if (node == null) {
         return false;
      }

      // Search current node
      if (node.data.equals(key)) {
         return true;
      }

      // Search left node
      if (preorderSearchHelper(node.leftNode, key)) {
         return true;
      }

      // Search right node
      return preorderSearchHelper(node.rightNode, key);
   }

   // begin inorder traversal
   public void inorderTraversal() { 
      inorderHelper(root); 
   }

   // recursive method to perform inorder traversal
   private void inorderHelper(TreeNode<T> node) {
      if (node == null) {
         return;
      }

      inorderHelper(node.leftNode); // traverse left subtree
      System.out.printf("%s ", node.data); // output node data
      inorderHelper(node.rightNode); // traverse right subtree
   }

   // in-order search
   public boolean inorderSearch(T key) {
      return inorderSearchHelper(root, key);
   }

   private boolean inorderSearchHelper(TreeNode<T> node, T key) {
      if (node == null) {
         return false;
      }

      // Search left subtree
      if (inorderSearchHelper(node.leftNode, key)) {
         return true;
      }

      // Search current Node
      if (node.data.equals(key)) {
         return true;
      }

      // Search in right subtree
      return inorderSearchHelper(node.rightNode, key);
   }

   // begin postorder traversal
   public void postorderTraversal() { 
      postorderHelper(root); 
   }

   // recursive method to perform postorder traversal
   private void postorderHelper(TreeNode<T> node) {
      if (node == null) {
         return;
      }
  
      postorderHelper(node.leftNode); // traverse left subtree
      postorderHelper(node.rightNode); // traverse right subtree
      System.out.printf("%s ", node.data); // output node data
   }

   public boolean postorderSearch(T key) {
      return postorderSearchHelper(root, key);
   }

   private boolean postorderSearchHelper(TreeNode<T> node, T key) {
      if (node == null) {
         return false;
      }

      // Search left node
      if (postorderSearchHelper(node.leftNode, key)) {
         return true;
      }

      // Search right node
      if (postorderSearchHelper(node.rightNode, key)) {
         return true;
      }

      // Current node check
      return node.data.equals(key);
   }

   // begin printing tree
   public void outputTree(int totalSpace) {
      outputTreeHelper(root, totalSpace>= 0 ? totalSpace : 0);
   }

   // recursive method to print tree
   private void outputTreeHelper(TreeNode<T> currentNode, int spaces) {
      // recursively print right branch, then left
      if (currentNode != null) {
         outputTreeHelper(currentNode.rightNode, spaces + 5);

         for (int k = 0; k <spaces; k++) {
            System.out.print(" ");
         }

         System.out.println(currentNode.data);
         outputTreeHelper(currentNode.leftNode, spaces + 5);
      }
   }
}