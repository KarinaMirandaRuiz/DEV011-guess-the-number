import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class HumanPlayerTest {

    @Test
    void makeGuess() {
        //Reader reader = new StringReader("course1\ncourse2\ncourse3");
        //BufferedReader bufferedReader = new BufferedReader(reader);
        //System.out.println(bufferedReader);

        HumanPlayer calc = new HumanPlayer("testHuman");

        // Configure the input flow using ByteArrayInputStream
        // String input = "10"; // user input
        // InputStream in = new ByteArrayInputStream(input.getBytes());
        // System.setIn(in);

        BufferedReader bufferedReader = Mockito.mock(BufferedReader.class);
        try {
            Mockito.when(bufferedReader.readLine()).thenReturn("1", "2", "3");
            calc.makeGuess(); // called tested method

            // Check that the entered value is correct
            assertEquals(10, calc.makeGuess(), 0.001);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}