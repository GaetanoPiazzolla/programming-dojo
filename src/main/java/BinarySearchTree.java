import structures.TreeNode;

public class BinarySearchTree {

    private static TreeNode root;

    public static TreeNode find(int data) {
        return find(data, root);
    }

    private static TreeNode find(int data, TreeNode node) {
        if (data == node.val) {
            return node;
        }
        if (data < node.val && node.left != null) {
            return find(data, node.left);
        }
        if (data > node.val && node.right != null) {
            return find(data, node.right);
        }
        return null;
    }

    public static void insert(int data) {
        insert(data, root);
    }

    private static void insert(int data, TreeNode node) {
        if (node.val > data) {
            if (node.left == null) {
                node.left = new TreeNode(data);
            } else {
                insert(data, node.left);
            }
        }
        if (node.val < data) {
            if (node.right == null) {
                node.right = new TreeNode(data);
            } else {
                insert(data, node.right);
            }
        }
    }

    public static void main(String[] args) {
        root = new TreeNode(10);
        insert(11);
        insert(9);
        insert(8);
        insert(10);
        insert(12);

        System.out.println("found -> " + find(10));
        System.out.println("found -> " + find(11));
        System.out.println("found -> " + find(12));
        System.out.println("null -> " + find(13));

    }

}
