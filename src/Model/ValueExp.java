package Model;

public class ValueExp implements Exp {
    Value e;


    public ValueExp(Value e)
    {
        this.e = e;
    }

    @Override
    public Value eval(MyIDictionary<String,Value> tbl, MyIHeap<Value> hp) throws MyException{
        return e;
    }

    @Override
    public String toString() {
        return e.toString();
    }
}
