package Model;

public class IfStmt implements IStmt {
    Exp exp;
    IStmt thenS;
    IStmt elseS;
    //....

    IfStmt(Exp e, IStmt t, IStmt el) {exp=e; thenS=t;elseS=el;}

    @Override
    public String toString(){ return "(IF("+ exp.toString()+") THEN(" +thenS.toString()
            +")ELSE("+elseS.toString()+"))";
    }

    @Override
    public PrgState execute(PrgState state) throws MyException
    {
        MyIStack<IStmt> stk = state.getStk();
        if (!exp.eval(state.getSymTable()).getType().equals(new BoolType()))
            throw new MyException("If expresion not returning boolean value");

        if (exp.eval(state.getSymTable()).equals(new BoolValue(true)))
            stk.push(thenS);
        else
            stk.push(elseS);

        return state;
    }
    //...

}
