public class Node {
    Association<String, String> data;
    Node left, right;

    public Node(Association<String, String> data) {
        this.data = data;
        left = right = null;
    }
}