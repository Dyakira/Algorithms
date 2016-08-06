package chapter1;

/**
 * Created by Dyakira on 2016/5/6.
 */
public class BinaryTree {

    private Node root = null;

    public void BinaryTree(int value){
        root = null;
    }

    //二叉排序树
    public void insert(int value) {
        Node newNode = new Node(value);
        // 树是空的
        if (root == null)
            root = newNode;
        else {
            Node current = root;
            Node parentNode;
            while (true) {
                parentNode = current;
                if (value < current.value) {
                    current = current.leftChild;
                    // 要插入的节点为左孩子节点
                    if (current == null) {
                        parentNode.leftChild = newNode;
                        return;
                    }
                } else {
                    // 要插入的节点为右孩子节点
                    current = current.rightChild;
                    if (current == null) {
                        parentNode.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    private class Node{
        private Node leftChild;
        private Node rightChild;
        private int value;

        public Node(int value){
            this.value = value;
            this.leftChild = null;
            this.rightChild = null;
        }
    }

    // 先续遍历树中的所有节点
    public void preOrderTraversal(Node currentRoot) {
        if (currentRoot != null) {
            System.out.print(currentRoot.value + " ");
            preOrderTraversal(currentRoot.leftChild);
            preOrderTraversal(currentRoot.rightChild);
        }
    }

    // 中续遍历树中的所有节点
    public void inOrderTraversal(Node currentNode) {
        if (currentNode != null) {
            inOrderTraversal(currentNode.leftChild);
            System.out.print(currentNode.value + " ");
            inOrderTraversal(currentNode.rightChild);
        }
    }

    // 后续遍历树中的所有节点
    public void postOrderTraversal(Node currentNode) {
        if (currentNode != null) {
            postOrderTraversal(currentNode.leftChild);
            postOrderTraversal(currentNode.rightChild);
            System.out.print(currentNode.value + " ");
        }
    }


    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.insert(6);
        bt.insert(3);
        bt.insert(42);
        bt.insert(54);
        bt.insert(33);
        bt.insert(10);
        bt.insert(23);
        bt.preOrderTraversal(bt.root);
        System.out.println("-------");
        bt.inOrderTraversal(bt.root);
        System.out.println("-------");
        bt.postOrderTraversal(bt.root);
        System.out.println("-------");
    }
}
