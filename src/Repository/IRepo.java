package Repository;
import Model.PrgState;

public interface IRepo {
    void add(PrgState s);
    PrgState getCrtPrg();
}
