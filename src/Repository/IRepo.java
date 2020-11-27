package Repository;
import Model.MyException;
import Model.PrgState;

public interface IRepo {
    void add(PrgState s);
    PrgState getCrtPrg();
    void logPrgStateExec(PrgState prg) throws MyException;
}
