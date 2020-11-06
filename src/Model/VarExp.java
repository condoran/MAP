package Model;

public class VarExp implements Exp {
    String id;

    public VarExp(String id)
    {
        this.id = id;
    }

    @Override
    public Value eval(MyIDictionary<String,Value> tbl) throws MyException
    {
        return tbl.lookup(id);
    }

    @Override
    public String toString() {
        return id;
    }
}
