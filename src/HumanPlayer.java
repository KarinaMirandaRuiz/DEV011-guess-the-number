import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HumanPlayer extends Player{
    // Declaración de los métodos de un jugador 'human'
    Integer makeGuess() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("--- Round: Human Player ---");
        System.out.println("Make your guess!");
        Integer number = null;
        do{
            try {
                String input = br.readLine();
                number = Integer.parseInt(input);
                System.out.println("Human guess: " + number);

                this.addGuess(number);

            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido.");
            } catch (IOException e) {
                System.out.println("Error de entrada/salida: " + e.getMessage());
            }
        } while (number == null);
        return number;
    }

    // Constructor
    public HumanPlayer(String name) {
        super(name);
    }

}
