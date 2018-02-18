package pl.bolka.aleksander.ticTacToe;

import java.util.HashMap;
import java.util.Map;

public class Board {

    private final Map<Integer, Row> rows;

    public Board() {
        this.rows = new HashMap<>();
        rows.put(1,new Row());
        rows.put(2,new Row());
        rows.put(3,new Row());
    }

    public Map<Integer, Row> getRows() {
        return rows;
    }

    public Row getRow(Integer key){
        if (key == null || !rows.containsKey(key)){
            throw new RuntimeException("Key dont exist");
        }
        return rows.get(key);
    }

}
