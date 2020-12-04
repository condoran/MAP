package Controller;

import Repository.*;
import Model.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Controller {
    IRepo repo;
    boolean dispalyFlag;

    public Controller(IRepo repo)
    {
        this.repo = repo;
        dispalyFlag = false;
    }

    Map<Integer, Value> unsafeGarbageCollector(List<Integer> symTableAddr, Map<Integer, Value> heap) {
        return heap.entrySet().stream().filter(e -> symTableAddr.contains(e.getKey())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    List<Integer> getAddrFromSymTable(Collection<Value> symTableValues, Collection<Value> heap) {
        return Stream.concat(heap.stream().filter(v -> v instanceof RefValue)
                .map(v ->
                {
                    RefValue val = (RefValue) v;
                    return val.getAddr();
                }),
                symTableValues.stream().filter(v -> v instanceof RefValue).map(v -> {
            RefValue v1 = (RefValue) v;
            return v1.getAddr();
        })).collect(Collectors.toList());
    }

    public void displayFlag(boolean flag)
    {
        dispalyFlag = flag;
    }

    public IRepo returnRepo()
    {
        return repo;
    }

    PrgState oneStep(PrgState state) throws MyException{
        MyIStack<IStmt> stk=state.getStk();
        if(stk.isEmpty())
            throw new MyException("prgstate stack is empty");
        IStmt crtStmt = stk.pop();
        return crtStmt.execute(state);
    }

    public void allStep() throws MyException {
        PrgState prg = repo.getCrtPrg(); // repo is the controller field of type MyRepoInterface
        //here you can display the prg state
        if (dispalyFlag)
            System.out.println(prg.toString());
        int i = 0;

        repo.logPrgStateExec(prg);
        while (!prg.getStk().isEmpty()){
            oneStep(prg);
            List<Value> l = prg.getOut().getList();
            prg.getHeap().setContent(unsafeGarbageCollector(getAddrFromSymTable(prg.getSymTable().getContent().values(), prg.getHeap().getContent().values()), prg.getHeap().getContent()));
            if (i != l.size()) {
                System.out.println(l.get(i).toString());
                i++;
            }
            repo.logPrgStateExec(prg);
            //here you can display the prg state
            if (dispalyFlag)
                System.out.println(prg.toString());
        }}
}
