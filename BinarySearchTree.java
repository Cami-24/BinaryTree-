public class BinarySearchTree<E extends BinarySearchTree.KeyValue> {
    Node<E> root;

    public BinarySearchTree() {
        root = null;
    }

    public interface KeyValue {
        String getKey();
        String getValue();
    }

    // Insertion operation
    void insert(E data) {
        root = insertRec(root, data);
    }

    Node<E> insertRec(Node<E> root, E data) {
        if (root == null) return new Node<E>(data);

        if (data.getKey().compareTo(root.data.getKey()) < 0)
            root.left = insertRec(root.left, data);
        else if (data.getKey().compareTo(root.data.getKey()) > 0)
            root.right = insertRec(root.right, data);

        return root;
    }

    String minValue(Node<E> root) {
        String minv = root.data.getKey();
        while (root.left != null) {
            minv = root.left.data.getKey();
            root = root.left;
        }
        return minv;
    }

    // Search operation
    String search(String key) {
        return searchRec(root, key.toLowerCase());
    }

    String searchRec(Node<E> root, String key) {
        if (root == null) return null;

        if (root.data.getKey().equals(key))
            return root.data.getValue();

        if (key.compareTo(root.data.getKey()) < 0)
            return searchRec(root.left, key);

        return searchRec(root.right, key);
    }

    // Inorder traversal
    void inorder() {
        inorderRec(root);
        System.out.println("\n");
    }

    void inorderRec(Node<E> root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data.getKey() + " ");
            inorderRec(root.right);
        }
    }

    // Preorder traversal
    void preorder() {
        preorderRec(root);
        System.out.println("\n");
        
    }

    void preorderRec(Node<E> root) {
        if (root != null) {
            System.out.print(root.data.getKey() + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Postorder traversal
    void postorder() {
        postorderRec(root);
        System.out.println("\n");
    }

    void postorderRec(Node<E> root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.data.getKey() + " ");
        }
    }

}