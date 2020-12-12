package Model;

public class forkStmt implements IStmt{
    IStmt stmt;

    public forkStmt(IStmt stmt)
    {
        this.stmt = stmt;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        return state.copy(stmt);
    }

    @Override
    public String toString() {
        return "fork(" + stmt.toString() + ")";
    }
}
