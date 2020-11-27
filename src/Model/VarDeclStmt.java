package Model;

public class VarDeclStmt implements IStmt {
    String name;
    Type typ;

    public VarDeclStmt(String v, Type intType) {
        name = v;
        typ = intType;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        MyIDictionary<String, Value> sym = state.getSymTable();
        if (typ.equals( new IntType()))
            sym.add(name, new IntValue(0));
        else if (typ.equals(new BoolType()))
            sym.add(name, new BoolValue(false));
        else if (typ.equals(new StringType()))
            sym.add(name, new StringValue(""));
        return state;
    }

    @Override
    public String toString() {
        return typ.toString() + " " + name;
    }
}
