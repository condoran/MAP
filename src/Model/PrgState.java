package Model;

import java.io.BufferedReader;
import java.util.Dictionary;

public class PrgState {
    MyIStack<IStmt> exeStack = new MyStack<IStmt>();
    MyIDictionary<String, Value> symTable = new MyDictionary<String, Value>();
    MyIList<Value> out = new MyList<Value>();
    MyIDictionary<String, BufferedReader> fileTable = new MyDictionary<String, BufferedReader>();
    IStmt originalProgram; //optional field, but good to have

    public PrgState() {}

    public PrgState(MyIStack<IStmt> stk, MyIDictionary<String, Value> symtbl, MyIList<Value> ot, IStmt prg,
                    MyIDictionary<String, BufferedReader> fileTable){
        exeStack=stk;
        symTable=symtbl;
        out = ot;
        this.fileTable = fileTable;
        originalProgram=prg;//recreate the entire original prg
        stk.push(prg);
    }

    @Override
    public String toString() {
        return "Execution Stack: " + exeStack.toString() + "\nSymbol Table: " + symTable.toString() + "\nOutput: " + out.toString() + "\nFile Table: " + fileTable.toString() + "\n";
    }

    public MyIDictionary<String, BufferedReader> getFileTable() { return fileTable; }

    public void setFileTable(MyIDictionary<String, BufferedReader> fileTable) { this.fileTable = fileTable; }

    public MyIDictionary<String, Value> getSymTable()
    {
        return symTable;
    }

    public void setSymTable(MyIDictionary<String, Value> table) { this.symTable = table; }

    public MyIList<Value> getOut()
    {
        return out;
    }

    public MyIStack<IStmt> getStk()
    {
        return exeStack;
    }


}
