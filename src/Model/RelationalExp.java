package Model;

import com.sun.jdi.IntegerValue;

public class RelationalExp implements Exp{
    Exp ex1, ex2;
    int op;

    public RelationalExp(Exp ex1, Exp ex2, int op){
        this.ex1 = ex1;
        this.ex2 = ex2;
        this.op = op;
    }

    @Override
    public Value eval(MyIDictionary<String, Value> tbl) throws MyException {
        if (ex1.eval(tbl).getType().equals(new IntType()))
        {
            if (ex2.eval(tbl).getType().equals(new IntType()))
            {
                IntValue value1 = (IntValue) ex1.eval(tbl);
                IntValue value2 = (IntValue) ex2.eval(tbl);
                if (op == 1)
                    return new BoolValue(value1.getVal() < value2.getVal());
                else if (op == 2)
                    return new BoolValue(value1.getVal() <= value2.getVal());
                else if (op == 3)
                    return new BoolValue(value1.getVal() == value2.getVal());
                else if (op == 4)
                    return new BoolValue(value1.getVal() != value2.getVal());
                else if (op == 5)
                    return new BoolValue(value1.getVal() > value2.getVal());
                else
                    return new BoolValue(value1.getVal() >= value2.getVal());
            }
            else
                throw new MyException("Variable is not int!");
        }
        else
            throw new MyException("Variable is not int!");
    }
}
