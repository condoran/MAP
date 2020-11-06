package Model;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;

public class MyDictionary<T, V> implements MyIDictionary<T, V> {
    Hashtable<T, V> dict = new Hashtable<T, V>();

    @Override
    public boolean isDefined(T id) {
        return dict.containsKey(id);
    }

    @Override
    public V lookup(T id) {
        return dict.get(id);
    }

    @Override
    public void update(T id, V val) throws MyException {
        if (!dict.containsKey(id))
            throw new MyException("The variable is not available in the table");
        dict.replace(id, val);
    }

    @Override
    public void add(T id, V val) throws MyException {
        if (dict.containsKey(id))
            throw new MyException("The variable is already in the table");
        dict.put(id, val);
    }

    @Override
    public String toString() {
        return dict.toString();
    }
}
