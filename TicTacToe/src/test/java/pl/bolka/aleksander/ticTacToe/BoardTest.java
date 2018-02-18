package pl.bolka.aleksander.ticTacToe;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

import static org.hamcrest.Matchers.*;


public class BoardTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private Board board;

    @Before
    public void setUp() throws Exception {
        board = new Board();
    }

    @Test
    public void when_board_create_Then_should_have_3_rows() throws Exception {
        assertThat(board.getRows().size(),equalTo(3));

    }

    @Test
    public void when_get_row_with_null_key_Then_exception(){
        expectedException.expect(RuntimeException.class);
        board.getRow(null);
    }

    @Test
    public void when_get_row_with_key_besides_range_Then_exception(){
        expectedException.expect(RuntimeException.class);
        board.getRow(4);
    }

    @Test
    public void when_get_row_with_existing_key_Then_return_row(){
        assertThat(board.getRow(1),is(not(nullValue())));
    }

}