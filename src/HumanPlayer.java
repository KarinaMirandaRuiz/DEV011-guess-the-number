import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HumanPlayer extends Player {
    int makeGuess() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Make your guess!:");
        Integer number = null;
        try {
            String input = br.readLine();
            number = Integer.parseInt(input);
            System.out.println("Número ingresado: " + number);

        } catch (NumberFormatException e) {
            System.err.println("Error: Ingrese un número válido.");
        } catch (IOException e) {
            System.err.println("Error de entrada/salida: " + e.getMessage());
        }
        return number;
    }
}
