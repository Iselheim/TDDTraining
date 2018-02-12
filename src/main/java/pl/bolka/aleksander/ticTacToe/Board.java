package pl.bolka.aleksander.ticTacToe;

import java.util.HashMap;
import java.util.Map;
import pl.bolka.aleksander.ticTacToe.Row;

public class Board {

    private Map<Integer, Row> rows;

    public Board() {
        this.rows = new HashMap<Integer, Row>();
        rows.put(1,new Row());
        rows.put(2,new Row());
        rows.put(3,new Row());
    }

    public Map<Integer, Row> getRows() {
        return rows;
    }

    public void setRows(Map<Integer, Row> rows) {
        this.rows = rows;
    }
}
