import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Super clase abstracta para generar HumanPlayer y ComputerPlayer
abstract class Player {

    // Declaración de los atributos de un jugador
    private final String name;
    protected List<Integer> guesses;

    // Declaración de los métodos de un jugador
    abstract Integer makeGuess() throws IOException;
    public String getName(){
        return name;
    }

    public List<Integer> getGuesses() {
        return guesses;
    }

    public void addGuess(Integer number){
        guesses.add(number);
    }

    // Constructor
    public Player(String name){
        this.name = name;
        this.guesses = new ArrayList<>();
    }
}
