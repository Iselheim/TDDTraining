package pl.bolka.aleksander.ticTacToe;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pl.bolka.aleksander.ticTacToe.TicTacToe;

public class TicTacToeTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private TicTacToe ticTacToe;

    @Before
    public void init() {
        ticTacToe = new TicTacToe();
    }

    @Test
    public void whenXOutsideBoardThenException() {
        expectedException.expect(RuntimeException.class);
        ticTacToe.play(4, 2);
    }

    @Test
    public void whenXUnderZeroThenException(){
        expectedException.expect(RuntimeException.class);
        ticTacToe.play(-1,2);
    }

    @Test
    public void whenYOutsideBoardThenException() {
        expectedException.expect(RuntimeException.class);
        ticTacToe.play(2,4);
    }

    @Test
    public void whenYUnderZeroThenException(){
        expectedException.expect(RuntimeException.class);
        ticTacToe.play(2,-1);
    }

    @Test
    public void whenPlayTwoTimeInSamePlaceThenException(){
        ticTacToe.play(2,2);
        expectedException.expect(RuntimeException.class);
        ticTacToe.play(2,2);
    }

}