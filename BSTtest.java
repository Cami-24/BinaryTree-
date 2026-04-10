import org.junit.Test;
import static org.junit.Assert.*;

public class BSTtest {

    @Test
    public void testInsertAndSearch() {
        BinarySearchTree<Association<String, String>> tree = new BinarySearchTree<>();

        tree.insert(new Association<>("chien", "perro"));
        tree.insert(new Association<>("maison", "casa"));
        tree.insert(new Association<>("femme", "mujer"));

        assertEquals("perro", tree.search("chien"));
        assertEquals("casa", tree.search("maison"));
        assertEquals("mujer", tree.search("femme"));
    }

    @Test
    public void testSearchFound() {
        BinarySearchTree<Association<String, String>> tree = new BinarySearchTree<>();

        tree.insert(new Association<>("chien", "perro"));

        String result = tree.search("chien");

        assertNotNull(result);
        assertEquals("perro", result);
    }

    @Test
    public void testSearchNotFound() {
        BinarySearchTree<Association<String, String>> tree = new BinarySearchTree<>();

        tree.insert(new Association<>("chien", "perro"));

        String result = tree.search("gato");

        assertNull(result);
    }

}