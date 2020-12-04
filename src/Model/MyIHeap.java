package Model;

import java.util.HashMap;
import java.util.Map;

public interface MyIHeap<V> {
    public int allocate(V expression);
    public V rH(int exp);
    public void wH(int var_name, V exp);
    public boolean isDefined(int ex);
    public void setContent(Map<Integer, V> map);
    public HashMap<Integer, V> getContent();
}
