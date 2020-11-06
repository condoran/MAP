package Model;

public class VarDeclStmt implements IStmt {
    String name;
    Type typ;

    @Override
    public PrgState execute(PrgState state) throws MyException {
        MyIDictionary<String, Value> sym = state.getSymTable();
        if (typ.equals( new IntType()))
            sym.add(name, new IntValue(0));
        else if (typ.equals(new BoolType()))
            sym.add(name, new BoolValue(false));
        return state;
    }
    //.....
}
