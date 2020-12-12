package Repository;
import Model.MyException;
import Model.PrgState;

import java.util.List;

public interface IRepo {
    void add(PrgState s);
    void logPrgStateExec(PrgState prg) throws MyException;
    List<PrgState> getPrgList();
    void setPrgList(List<PrgState> l);
}
