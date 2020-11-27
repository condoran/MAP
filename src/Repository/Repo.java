package Repository;

import Model.MyException;
import Model.PrgState;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Repo implements IRepo {
    List<PrgState> list = new ArrayList<PrgState>();
    String logFilePath;

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

    @Override
    public void logPrgStateExec() throws MyException {
        PrintWriter logFile;
        try {
            logFile = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath, true)), true);
        }catch (IOException exception) {
            throw new MyException(exception.getMessage());
        }
        PrgState state = list.get(0);
        logFile.println(state.toString());
        if (state.getStk().isEmpty()) {
            list.remove(0);
        }
    }
}
