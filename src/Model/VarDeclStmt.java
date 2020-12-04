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
        sym.add(name, typ.defaultValue());
        return state;
    }

    @Override
    public String toString() {
        return typ.toString() + " " + name;
    }
}
