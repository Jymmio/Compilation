import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Chemin vers votre fichier de test
        String filePath = "./add1.i";

        // Instanciation du lexer
        Lexer lexer = new Lexer(null);

        try (BufferedReader br = new BufferedReader(new FileReader(new File(filePath)))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Tokenisation de chaque ligne
                lexer.setInput(line);
                Token token;
                do {
                    token = lexer.nextToken();
                    // Affichage des tokens
                    System.out.println(token);
                } while (token != null && token.getType() != Lexer.EOF);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}