package Model;

public interface MyIDictionary<T, V> {
    boolean isDefined(T id);
    V lookup(T id);
    void update(T id, V val) throws MyException;
    void add(T id, V val) throws MyException;
    void delete(T id) throws MyException;
}
