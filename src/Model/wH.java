package Model;

public class wH implements IStmt{
    String var_name;
    Exp expression;

    public wH(String var_name, Exp exp)
    {
        this.var_name = var_name;
        expression = exp;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        if (state.getSymTable().isDefined(var_name))
        {
            Value v = state.getSymTable().lookup(var_name);
            if (v.getType() instanceof RefType)
            {
                RefValue refValue = (RefValue) v;
                if (state.getHeap().isDefined(refValue.getAddr()))
                {
                    Value val = expression.eval(state.getSymTable(), state.getHeap());
                    if (val.getType().equals(state.getHeap().rH(refValue.getAddr()).getType()))
                    {
                        state.getHeap().wH(refValue.getAddr(), val);
                    }
                    else
                        throw new MyException("The type of the expression is not matching!");
                }
                else
                    throw new MyException("The address is not defined in the heap!");
            }
            else
                throw new MyException("The type from the address is wrong");
        }
        else
            throw new MyException("The variable is not defined!");

        return state;
    }

    @Override
    public String toString() {
        return "wH(" + var_name + ", " + expression.toString() + ")";
    }
}
