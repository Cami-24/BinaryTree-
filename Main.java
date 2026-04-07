import java.io.BufferedReader;
import java.io.FileReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BinarySearchTree tree = new BinarySearchTree();

        //leer el archivo y cargar el árbol
        BufferedReader br = new BufferedReader(new FileReader("diccionario.txt"));
        String line;

        while ((line = br.readLine()) != null) {
            line = line.replace("(", "").replace(")", "");
            String[] parts = line.split(",");

            String french = parts[0].trim().toLowerCase();
            String spanish = parts[1].trim().toLowerCase();

            tree.insert(new Association<String, String>(french, spanish));
        }

        br.close();

        System.out.println("Diccionario ordenado:");
        tree.inorder();

        //Traducir texto
        BufferedReader br2 = new BufferedReader(new FileReader("texto.txt"));

        while ((line = br2.readLine()) != null) {
            String[] words = line.split(" ");

            for (String word : words) {
                String clean = word.toLowerCase().replaceAll("[^a-zA-Z]", "");

                // L' contraccion de le o la
                if (clean.equals("l")) clean = "le";

                String translation = tree.search(clean);

                if (translation != null)
                    System.out.print(translation + " ");
                else
                    System.out.print("*" + word + "* ");
            }
        }
        
        System.out.println();
        br2.close();
    }
    
}