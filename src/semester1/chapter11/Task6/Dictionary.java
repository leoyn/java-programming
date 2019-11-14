package semester1.chapter11.Task6;

public class Dictionary {
    public String[] keys;
    public String[] values;

    public Dictionary() {
        keys = new String[0];
        values = new String[0];
    }

    public Dictionary add(String key, String value) {
        String[] newKeys = new String[keys.length + 1];
        String[] newValues = new String[values.length + 1];

        for(int i = 0; i < keys.length; i++) {
            newKeys[i] = keys[i];
            newValues[i] = values[i];
        }

        newKeys[keys.length] = key;
        newValues[values.length] = value;

        keys = newKeys;
        values = newValues;

        return this;
    }

    public String get(String key) {
        for(int i = 0; i < keys.length; i++) {
            if(key == keys[i]) return values[i];
        }

        return null;
    }
}