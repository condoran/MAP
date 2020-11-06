package Repository;

import Model.PrgState;

import java.util.ArrayList;
import java.util.List;

public class Repo implements IRepo {
    List<PrgState> list = new ArrayList<PrgState>();

    @Override
    public void add(PrgState s) {
        list.add(s);
    }

    @Override
    public PrgState getCrtPrg() {
        PrgState curr = list.get(0);
        list.remove(0);
        return curr;
    }
}
