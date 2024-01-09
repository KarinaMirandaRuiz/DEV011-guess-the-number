import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class GuessTheNumberGameTest {
    //private static Player mockPlayer;
    private static final PrintStream originalOut = System.out;
    private static final PrintStream originalErr = System.err;
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    //@Mock
    private static HumanPlayer mockHumanPlayer;
    //@Mock
    private static ComputerPlayer mockComputerPlayer;

    @BeforeEach
    public void setUp(){

        mockHumanPlayer = mock(HumanPlayer.class);
        when(mockHumanPlayer.getName()).thenReturn("mockUser");
        doReturn(Arrays.asList(1,2,3)).when(mockHumanPlayer).getGuesses();

        mockComputerPlayer = mock(ComputerPlayer.class);
        when(mockComputerPlayer.getName()).thenReturn("mockComputer");

        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));

    };

    @AfterEach
    public void restoreStreams(){
        System.setOut(originalOut);
        System.setErr(originalErr);
        //reset(mockComputerPlayer);
    };

    @Test
    void getTheCorrectName(){
//        String[] strings = new String[0];
//        GuessTheNumberGame.main(strings);
//        assertEquals("mockUser", outContent.toString()
//                .trim());
        assertEquals("mockUser", mockHumanPlayer.getName());
        assertEquals("mockComputer", mockComputerPlayer.getName());
    }

    @Test
    void getGuesses(){
        assertEquals(mockHumanPlayer.getGuesses(),Arrays.asList(1,2,3));
    }

    @Test
    void generateTargetNumberInRange(){
        assertTrue(GuessTheNumberGame.targetNumber>=0);
        assertTrue(GuessTheNumberGame.targetNumber<=100);

    }

    @Test
    void checkExactAnswerAsHuman() {
        GuessTheNumberGame.targetNumber = 50;

        when(mockHumanPlayer.makeGuess()).thenReturn(50);
        assertTrue(GuessTheNumberGame.checkGuess(mockHumanPlayer));
        assertEquals("Right on the nail mockUser!!!",outContent.toString()
                .trim());
        System.setOut(originalOut);
    };

    @Test
    void checkLittleHighAnswerAsHuman(){
        //restoreStreams();
        GuessTheNumberGame.targetNumber = 50;

        when(mockHumanPlayer.makeGuess()).thenReturn(60);
        assertEquals(false, GuessTheNumberGame.checkGuess(mockHumanPlayer));
        assertEquals("Little high!50",outContent.toString().trim());
        System.setOut(originalOut);
    };

    @Test
    void checkTooHighAnswerAsHuman(){
        //restoreStreams();
        GuessTheNumberGame.targetNumber = 50;

        when(mockHumanPlayer.makeGuess()).thenReturn(70);
        assertEquals(false, GuessTheNumberGame.checkGuess(mockHumanPlayer));
        assertEquals("Too high!50",outContent.toString().trim());
        System.setOut(originalOut);
    };

    @Test
    void checkVeryVeryHighAnswerAsHuman(){
        //restoreStreams();
        GuessTheNumberGame.targetNumber = 50;

        when(mockHumanPlayer.makeGuess()).thenReturn(80);
        assertEquals(false, GuessTheNumberGame.checkGuess(mockHumanPlayer));
        assertEquals("Too high!50",outContent.toString().trim());
        System.setOut(originalOut);
    };

    @Test
    void checkExactAnswerAsComputer() {
        //restoreStreams();
        GuessTheNumberGame.targetNumber = 50;

        when(mockComputerPlayer.makeGuess()).thenReturn(50);
        assertTrue(GuessTheNumberGame.checkGuess(mockComputerPlayer));
        assertEquals("Right on the nail mockComputer!!!",outContent.toString().trim());
        System.setOut(originalOut);
    };

    @Test
    void checkLittleLowerAnswerAsComputer(){
        //restoreStreams();
        GuessTheNumberGame.targetNumber = 50;

        //reset(mockComputerPlayer);
        when(mockComputerPlayer.makeGuess()).thenReturn(40);
        assertEquals(false, GuessTheNumberGame.checkGuess(mockComputerPlayer));
        assertEquals("Little low!50",outContent.toString().trim());
    }

    @Test
    void checkTooLowerAnswerAsComputer(){
        GuessTheNumberGame.targetNumber = 50;

        when(mockComputerPlayer.makeGuess()).thenReturn(30);
        assertEquals(false, GuessTheNumberGame.checkGuess(mockComputerPlayer));
        assertEquals("Too low!50",outContent.toString().trim());

    }
    @Test
    void checkVeryVeryLowerAnswerAsComputer(){
        GuessTheNumberGame.targetNumber = 50;

        when(mockComputerPlayer.makeGuess()).thenReturn(19);
        assertEquals(false, GuessTheNumberGame.checkGuess(mockComputerPlayer));
        assertEquals("Very very low!!50",outContent.toString().trim());

    }
}