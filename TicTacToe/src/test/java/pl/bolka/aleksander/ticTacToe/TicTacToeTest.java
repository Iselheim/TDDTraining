package pl.bolka.aleksander.ticTacToe;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

import static org.hamcrest.Matchers.*;

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

    @Test
    public void when_first_player_Then_next_player_returns_cross(){
        assertThat(ticTacToe.nextPlayer(),is(Sign.CROSS));
    }

    @Test
    public void when_last_player_was_cross_Then_next_must_be_circle(){
        ticTacToe.play(1,1);
        assertThat(ticTacToe.nextPlayer(),is(Sign.CIRCLE));
    }

    @Test
    public void when_last_player_was_circle_Then_next_must_be_cross(){
        ticTacToe.play(1,1);
        ticTacToe.play(2,2);
        assertThat(ticTacToe.nextPlayer(),is(Sign.CROSS));
    }

    @Test
    public void when_no_winner_Then_return_play_return_false(){
        assertThat(ticTacToe.play(1,1),is(false));
    }

    @Test
    public void when_whole_row_with_same_sign_Then_win(){
        ticTacToe.play(1,1);
        ticTacToe.play(2,1);
        ticTacToe.play(1,2);
        ticTacToe.play(2,2);
        assertThat(ticTacToe.play(1,3),is(true));
    }

    @Test
    public void when_whole_column_with_same_sign_Then_win(){
        ticTacToe.play(1,1);
        ticTacToe.play(2,2);
        ticTacToe.play(2,1);
        ticTacToe.play(2,3);
        assertThat(ticTacToe.play(3,1),is(true));
    }

}