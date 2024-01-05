import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public Main(){};
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Por favor ingrese su nombre");
            String name = br.readLine();

            while (name.isEmpty() | name.length() == 1) {
                System.out.println("Por favor, ingrese un nombre válido.");
                name = br.readLine();
            }
            System.out.println("Bienvenid@ " + name + "!!!");
            HumanPlayer humanPlayer = new HumanPlayer();
            int humanGuess = humanPlayer.makeGuess();
            ComputerPlayer computerPlayer = new ComputerPlayer();
            int computerGuess = computerPlayer.makeGuess();

            System.out.println("numeros ingresados" + humanGuess + computerGuess);

        } catch (IOException e) {
            System.err.println("Error de entrada/salida: " + e.getMessage());
        }
    }

}
