package Model;

public class LogicExp implements Exp {
    Exp e1;
    Exp e2;
    int op; //1 - and, 2 - or

    public LogicExp(Exp e1, Exp e2, int op)
    {
        this.e1 = e1;
        this.e2 = e2;
        this.op = op;
    }

    @Override
    public Value eval(MyIDictionary<String,Value> tbl, MyIHeap<Value> hp) throws MyException{
        Value v1, v2;
        v1 = e1.eval(tbl, hp);
        if (v1.getType().equals(new BoolType()))
        {
            v2 = e2.eval(tbl, hp);
            if (v2.getType().equals(new BoolType()))
            {
                BoolValue b1 = (BoolValue)v1;
                BoolValue b2 = (BoolValue)v2;
                boolean a, b;
                a = b1.getVal();
                b = b2.getVal();
                if (op==1)
                    return new BoolValue(a && b);
                else if (op == 2)
                    return new BoolValue(a || b);
            }
            else
                throw new MyException("The value in the logic expresion is not boolean");
        }
        else
            throw new MyException("The value in the logic expresion is not boolean");
        return new IntValue(-1);
    }

    @Override
    public String toString() {
        String s;
        s = e1.toString();
        if (op==1) s += " & ";
        if (op ==2) s += " | ";
        s += e2.toString();
        return s;
    }
}
