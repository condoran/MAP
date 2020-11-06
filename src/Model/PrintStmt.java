package Model;

public class PrintStmt implements IStmt {
    Exp exp;
    //....

    @Override
    public String toString(){ return "print(" +exp.toString()+")";}

    @Override
    public PrgState execute(PrgState state) throws MyException{
        MyIStack<IStmt> stk = state.getStk();
        MyIList<Value> out = state.getOut();
        out.add(exp.eval(state.getSymTable()));
        return state;
    }
    //...
}
