package pl.bolka.aleksander.ticTacToe;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class RowTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private Row row;

    @Before
    public void setUp() throws Exception {
        row = new Row();
    }

    @Test
    public void when_create_new_object_Then_create_3_empty_fields(){
        assertThat(row.getFields().size(),equalTo(3));
    }

    @Test
    public void when_set_fields_with_wrong_key_Then_exception() throws Exception {
        expectedException.expect(RuntimeException.class);
        row.setField(4,Sign.NONE);
    }

    @Test
    public void when_set_fields_second_time_Then_exception(){
        row.setField(1,Sign.CROSS);
        expectedException.expect(RuntimeException.class);
        row.setField(1,Sign.CROSS);
    }

    @Test
    public void when_get_field_with_wrong_key_Then_exception() throws Exception {
        expectedException.expect(RuntimeException.class);
        row.getField(4);
    }

    @Test
    public void when_get_field_with_null_key_Then_exception(){
        expectedException.expect(RuntimeException.class);
        row.getField(null);
    }

}