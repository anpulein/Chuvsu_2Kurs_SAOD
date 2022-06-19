package Lab_2;

public class Example1 {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(5);
        binaryTree.add(2);
        binaryTree.add(4);
        binaryTree.add(6);
        binaryTree.add(2);
        binaryTree.add(3);
        binaryTree.add(10);
        binaryTree.add(6);
        binaryTree.add(2);
        binaryTree.add(9);
        binaryTree.add(8);

        binaryTree.print();

        System.out.println("Count value in binaryTree: " + binaryTree.countValue(2));
    }
}
