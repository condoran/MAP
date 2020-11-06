package Model;

public class PrgState {
    MyIStack<IStmt> exeStack;
    MyIDictionary<String, Value> symTable;
    MyIList<Value> out;
    IStmt originalProgram; //optional field, but good to have

    public PrgState(MyIStack<IStmt> stk, MyIDictionary<String, Value> symtbl,
                    MyIList<Value> ot, IStmt prg){
        exeStack=stk;
        symTable=symtbl;
        out = ot;
        originalProgram=prg;//recreate the entire original prg
        stk.push(prg);
    }

    @Override
    public String toString() {
        return "Execution Stack: " + exeStack.toString() + "\nSymbol Table: " + symTable.toString() + "\n Output: " + out.toString();
    }

    public MyIDictionary<String, Value> getSymTable()
    {
        return symTable;
    }

    public MyIList<Value> getOut()
    {
        return out;
    }

    public MyIStack<IStmt> getStk()
    {
        return exeStack;
    }


}
