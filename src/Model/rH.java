package Model;

public class rH implements Exp{
    Exp expression;

    public rH(Exp exp)
    {
        expression = exp;
    }

    @Override
    public Value eval(MyIDictionary<String, Value> tbl, MyIHeap<Value> hp) throws MyException {
        RefValue val = (RefValue) expression.eval(tbl, hp);
        if (val.getType() instanceof RefType)
        {
            int address = val.getAddress();
            if(hp.isDefined(address))
            {
                return hp.rH(address);
            }
            else
                throw new MyException("Expresion value not defined!");
        }
        else
            throw new MyException("Expression value not matching!");
    }

    @Override
    public String toString() {
        return "rH(" + expression.toString() + ")";
    }
}
