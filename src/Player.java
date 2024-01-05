// Se importa la biblioteca para declarar la lista
import java.io.IOException;
import java.util.List;

abstract class Player {
    private String name;
    protected List<Integer> guesses;

    public Player(){
    }
    abstract int makeGuess() throws IOException;
    public String getName(){
        return name;
    }
    public List<Integer> getGuesses() {
        return guesses;
    }
}