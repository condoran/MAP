package Model;

public class While implements IStmt{
    Exp exp;
    IStmt stmt;
    
    public While(Exp ex, IStmt stmt)
    {
        exp = ex;
        this.stmt = stmt;
    }
    
    @Override
    public PrgState execute(PrgState state) throws MyException {
        if (exp.eval(state.getSymTable(), state.getHeap()).getType().equals(new BoolType()))
        {
            if (exp.eval(state.getSymTable(), state.getHeap()).equals(new BoolValue(true)))
            {
                state.getStk().push(this);
                state.getStk().push(stmt);
            }
        }
        else
            throw new MyException("Expresion is not boolean!");
        return state;
    }

    @Override
    public String toString() {
        return "while (" + exp + ") " + stmt;
    }
}
