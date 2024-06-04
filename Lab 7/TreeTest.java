public class TreeTest {
    public static void main(String[] args) {
        Tree test = new Tree();
        test.insertNode(97);
        test.insertNode(39);
        test.insertNode(72);
        test.insertNode(83);
        test.insertNode(8);
        test.insertNode(58);
        test.insertNode(17);
        test.insertNode(5);
        test.insertNode(71);
        test.insertNode(30);
        
        
        test.preorderTraversal();
        System.out.println();
        test.inorderTraversal();
        System.out.println();
        test.postorderTraversal();
        System.out.println();
        System.out.println(test.inorderSearch(39));
        System.out.println(test.preorderSearch(25));
        System.out.println(test.postorderSearch(71));
        test.outputTree(9);
        test.remove(17);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        test.outputTree(8);
    }
}
