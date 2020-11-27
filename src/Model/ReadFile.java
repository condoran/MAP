package Model;

import java.io.BufferedReader;
import java.io.IOException;

public class ReadFile implements IStmt{

    Exp exp;
    String varName;

    public ReadFile(Exp exp, String string)
    {
        this.exp = exp;
        this.varName = string;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        MyIDictionary<String, Value> table = state.getSymTable();
        MyIDictionary<String, BufferedReader> fileTable = state.getFileTable();
        if (table.isDefined(varName))
        {
            Value val = table.lookup(varName);
            if (val.getType().equals(new IntType()))
            {
                if (exp.eval(table).getType().equals(new StringType()))
                {
                    StringValue strVal = (StringValue) exp.eval(table);
                    BufferedReader buff = fileTable.lookup(strVal.getVal());
                    try {
                        String line = buff.readLine();
                        IntValue valInt;

                        if (line == null)
                        {
                            valInt = new IntValue(0);
                        }
                        else {
                            valInt = new IntValue(Integer.parseInt(line));
                        }

                        table.update(varName, valInt);
                    } catch (Exception e) {
                        throw new MyException("File read failed: " + e.getMessage());
                    }
                }
                else
                {
                    throw new MyException("Expresion is not a string!");
                }
            }
            else
                throw new MyException("Variable is not an int!");
        }
        else
            throw new MyException("Variable is not defined!");
        state.setFileTable(fileTable);
        state.setSymTable(table);
        return state;
    }

    @Override
    public String toString() {
        return "Reading from " + exp.toString() + " in variable " + varName;
    }
}
