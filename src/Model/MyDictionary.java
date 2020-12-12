package Model;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

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
    public void delete(T id) throws MyException {
        try{
            dict.remove(id);
        }
        catch (Exception e)
        {
            throw new MyException("Variable is not defined in the table!");
        }
    }

    @Override
    public Hashtable<T, V> getContent() {
        return dict;
    }

    @Override
    public String toString() {
        return dict.toString();
    }
}
