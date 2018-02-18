package pl.bolka.aleksander.ticTacToe;

import java.util.HashMap;
import java.util.Map;

public class Row {

    private Map<Integer,Sign> fields;

    public Row() {
        this.fields = new HashMap<Integer, Sign>();
        fields.put(1,Sign.NONE);
        fields.put(2,Sign.NONE);
        fields.put(3,Sign.NONE);
    }

    public Map<Integer, Sign> getFields() {
        return fields;
    }

    public void setFields(Map<Integer, Sign> fields) {
        this.fields = fields;
    }
}
