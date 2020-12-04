package Model;

import java.util.ArrayList;
import java.util.List;

public class MyList<V> implements MyIList<V> {
    List<V> list = new ArrayList<V>();

    @Override
    public void add(V o) {
        list.add(o);
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public List<V> getList() {return list;}
}
