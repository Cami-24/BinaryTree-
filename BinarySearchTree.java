public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    // Insertion operation
    void insert(Association<String, String> data) {
        root = insertRec(root, data);
    }

    Node insertRec(Node root, Association<String, String> data) {
    if (root == null) return new Node(data);

    if (data.key.compareTo(root.data.key) < 0)
        root.left = insertRec(root.left, data);
    else if (data.key.compareTo(root.data.key) > 0)
        root.right = insertRec(root.right, data);

    return root;
}

    String minValue(Node root) {
        String minv = root.data.key;
        while (root.left != null) {
            minv = root.left.data.key;
            root = root.left;
        }
        return minv;
    }

    // Search operation
    String search(String key) {
        return searchRec(root, key.toLowerCase());
    }

    String searchRec(Node root, String key) {
        if (root == null) return null;

        if (root.data.key.equals(key))
            return root.data.value;

        if (key.compareTo(root.data.key) < 0)
            return searchRec(root.left, key);

        return searchRec(root.right, key);
    }

    // Inorder traversal
    void inorder() {
        inorderRec(root);
        System.out.println("\n");
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data.key + " ");
            inorderRec(root.right);
        }
    }

    // Preorder traversal
    void preorder() {
        preorderRec(root);
        System.out.println("\n");
        
    }

    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.data.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Postorder traversal
    void postorder() {
        postorderRec(root);
        System.out.println("\n");
    }

    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.data.key + " ");
        }
    }

}