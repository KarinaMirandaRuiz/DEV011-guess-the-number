import java.util.Random;

public class ComputerPlayer extends Player {
    // Declaración de los métodos de un jugador 'computer'
    Integer makeGuess() {
        Random random = new Random();
        int number = random.nextInt(101);
        this.addGuess(number);

        System.out.println("--- Round: Computer Player ---");
        System.out.println("Compute guess: " + number);

        return number;
    }

    // Constructor
    public ComputerPlayer(String name) {
        super(name);
    }
}
