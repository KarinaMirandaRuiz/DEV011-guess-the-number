import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class GuessTheNumberGame {
    // Inicia el juego y generación del número a adivinar
    static int targetNumber = new Random().nextInt(101);
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Método main (punto de entrada principal para la ejecución del programa)
    public static void main(String[] args) {

        // Imprime el número a adivinal
        System.out.println("INICIA EL JUEGO");
        // System.out.println("targetNumber: " + targetNumber);

        // try para manejar el IOException en caso de error al capturar en consola
        try {

            // Captura de nomber por comando de línea
            System.out.println("Por favor ingrese su nombre");
            String name = br.readLine();

            // Validación de nombre no vacío
            while (name.isEmpty() | name.length() == 1) {
                System.out.println("Por favor, ingrese un nombre válido.");
                name = br.readLine();
            }
            System.out.println("Bienvenid@ " + name + "!!!");

            // Instancia de los jugadores
            Player humanPlayer = new HumanPlayer(name);
            Player computerPlayer = new ComputerPlayer("Computer");

            // Cliclo del juego
            boolean checkGuess;
            String turnPlay = "computer";
            do
                // Validación de los intentos
                // checkGuess = checkGuess(humanPlayer);
                if (turnPlay.equals("human")){
                    turnPlay = "computer";
                    checkGuess = checkGuess(computerPlayer);
                }else{
                    turnPlay = "human";
                    checkGuess = checkGuess(humanPlayer);
                }
            while(!checkGuess);

            System.out.println(humanPlayer.getGuesses());

        } catch (IOException e) {
            System.err.println("Error de entrada/salida: " + e.getMessage());
            throw new RuntimeException(e);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Declaración de método
    private static boolean checkGuess(Player player){
        // DONE: Ejecuta un turno, obtiene la suposición y evalúa el nuevo estado de la partida.

        boolean validation = false;

        try {
            Integer guess = player.makeGuess();
            if (guess == targetNumber){
                System.out.println("Right on the nail " + player.getName() + "!!!");
                validation = true;

            } else if (guess > (targetNumber + 30)){
                System.out.println("Very very high!!");

            } else if (guess > (targetNumber + 10)){
                System.out.println("Too high!");

            } else if (guess > targetNumber){
                System.out.println("Little high!");

            } else if (guess < targetNumber - 30){
                System.out.println("Very very low!!");

            } else if (guess < targetNumber - 10){
                System.out.println("Too low!");

            } else {
                System.out.println("Little low!");
            }
        } catch (IOException e) {
            System.err.println("Error al ejecutar MakeGuess: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return validation;
    }
}
