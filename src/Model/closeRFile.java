package Model;

import java.io.BufferedReader;
import java.io.IOException;

public class closeRFile implements IStmt{
    Exp exp;

    public closeRFile(Exp exp)
    {
        this.exp = exp;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        MyIDictionary<String, Value>table = state.getSymTable();
        MyIDictionary<String, BufferedReader> fileTable = state.getFileTable();
        if (exp.eval(table, state.getHeap()).getType().equals(new StringType()))
        {
            StringValue val = (StringValue) exp.eval(table, state.getHeap());
            if (fileTable.isDefined(val.getVal()))
            {
                BufferedReader buff = fileTable.lookup(val.getVal());
                try
                {
                    buff.close();
                } catch (IOException e) {
                    throw new MyException("File close failed!");
                }
                fileTable.delete(val.getVal());
            }
            else
                throw new MyException("The file is not oppened!");
        }
        else
            throw new MyException("Expresion is not a string!");
        state.setFileTable(fileTable);
        return state ;
    }

    @Override
    public String toString() {
        return "Close File: " + exp.toString();
    }
}
