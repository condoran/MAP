package Model;

public interface Exp {
    Value eval(MyIDictionary<String,Value> tbl, MyIHeap<Value> hp) throws MyException;
}
