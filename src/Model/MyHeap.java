package Model;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class MyHeap<V> implements MyIHeap<V>{
    HashMap<Integer, V> heap = new HashMap<Integer, V>();
    AtomicInteger val = new AtomicInteger(0);

    public boolean isDefined(int ex)
    {
        return heap.containsKey(ex);
    }

    @Override
    public void setContent(Map<Integer, V> map) {
        heap = (HashMap<Integer, V>) map;
    }

    @Override
    public HashMap<Integer, V> getContent() {
        return heap;
    }

    @Override
    public int allocate(V expression) {
        heap.put(val.incrementAndGet(), expression);
        return val.get();
    }

    @Override
    public V rH(int address) {
        return heap.get(address);
    }

    @Override
    public void wH(int var_name, V exp) {
        heap.put(var_name, exp);
    }

    @Override
    public String toString() {
        return heap.toString();
    }
}
