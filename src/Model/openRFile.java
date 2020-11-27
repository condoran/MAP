package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class openRFile implements IStmt{
    Exp exp;

    public openRFile(Exp exp)
    {
        this.exp = exp;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        MyIDictionary<String, Value> table = state.getSymTable();
        MyIDictionary<String, BufferedReader> fileTable = state.getFileTable();
        if (exp.eval(table).getType().equals(new StringType()))
        {
            StringValue string = (StringValue) exp.eval(table);
            try
            {
                BufferedReader read = new BufferedReader(new FileReader(string.getVal()));
                fileTable.add(string.getVal(), read);
            } catch (Exception e) {
                throw new MyException("Can't open file: " + e.getMessage());
            }
        }
        else
        {
            throw new MyException("Expresion not a string!");
        }
        state.setFileTable(fileTable);
        return state;
    }

    @Override
    public String toString() {
        return "Opening file: " + exp.toString();
    }
}
