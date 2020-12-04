package Model;

public class New implements IStmt{
    String var_name;
    Exp exp;

    public New(String var_name, Exp exp)
    {
        this.var_name = var_name;
        this.exp = exp;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        if (state.getSymTable().isDefined(var_name))
        {
            Value val = state.getSymTable().lookup(var_name);
            if(val.getType() instanceof RefType)
            {
                Value val2 = exp.eval(state.getSymTable(), state.getHeap());
                if (val2.getType().equals(((RefType) val.getType()).getInner()))
                {
                    state.getSymTable().update(var_name, new RefValue(state.getHeap().allocate(val2), val2.getType()));
                }
                else
                    throw new MyException("Expression type not matching!");
            }
            else
                throw new MyException("Expression value type wrong");
        }
        else
            throw new MyException("Wrong variable name!");

        return state;
    }

    @Override
    public String toString() {
        return "new(" + var_name + ", " + exp.toString() + ")";
    }
}
