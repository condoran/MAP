package Controller;

import Repository.*;
import Model.*;

public class Controller {
    IRepo repo;
    boolean dispalyFlag;

    public Controller(IRepo repo)
    {
        this.repo = repo;
        dispalyFlag = false;
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

        while (!prg.getStk().isEmpty()){
            oneStep(prg);
            //here you can display the prg state
            if (dispalyFlag)
                System.out.println(prg.toString());
        }}
}
