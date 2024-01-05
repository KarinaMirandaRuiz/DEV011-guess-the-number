import java.util.Random;

public class ComputerPlayer extends Player {
    int makeGuess() {
        Random random = new Random();
        int number = random.nextInt(101);
        System.out.println("Número ingresado: " + number);
        return number;
    }
}
