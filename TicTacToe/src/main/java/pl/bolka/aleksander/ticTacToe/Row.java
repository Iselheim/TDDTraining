package pl.bolka.aleksander.ticTacToe;

import java.util.HashMap;
import java.util.Map;

public class Row {

    private final Map<Integer,Sign> fields;

    public Row() {
        this.fields = new HashMap<>();
        fields.put(1,Sign.NONE);
        fields.put(2,Sign.NONE);
        fields.put(3,Sign.NONE);
    }

    public Map<Integer, Sign> getFields() {
        return fields;
    }

    public Sign getField(Integer key){
        if (key == null || !fields.containsKey(key)){
            throw new RuntimeException("Wrong key");
        }
        return fields.get(key);
    }

    public void setField(Integer key,Sign sign){
        if (!fields.containsKey(key)){
            throw new RuntimeException("Wrong key, not exist");
        }
        if (!Sign.NONE.equals(fields.get(key))){
            throw new RuntimeException("Not empty field");
        }
        fields.replace(key,sign);
    }
}
