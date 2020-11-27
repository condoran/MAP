import Controller.*;
import Model.*;
import View.ExitCommand;
import View.RunExample;
import View.TextMenu;
import Repository.*;

import java.io.BufferedReader;

class Interpreter {
    public static void main(String[] args) {
        IStmt ex1 = new CompStmt(
                new VarDeclStmt(
                        "varf",
                        new StringType()
                ),
                new CompStmt(
                        new AssignStmt(
                                "varf",
                                new ValueExp(
                                        new StringValue("test.in")
                                )
                        ),
                        new CompStmt(
                                new openRFile(
                                        new VarExp(
                                                "varf"
                                        )
                                ),
                                new CompStmt(
                                        new VarDeclStmt(
                                                "varc",
                                                new IntType()
                                        ),
                                        new CompStmt(
                                                new ReadFile(
                                                        new VarExp(
                                                                "varf"
                                                        ),
                                                        "varc"
                                                ),
                                                new CompStmt(
                                                        new PrintStmt(
                                                                new VarExp(
                                                                        "varc"
                                                                )
                                                        ),
                                                        new CompStmt(
                                                                new ReadFile(
                                                                        new VarExp(
                                                                                "varf"
                                                                        ),
                                                                        "varc"
                                                                ),
                                                                new CompStmt(
                                                                        new PrintStmt(
                                                                                new VarExp(
                                                                                        "varc"
                                                                                )
                                                                        ),
                                                                        new closeRFile(
                                                                                new VarExp(
                                                                                        "varf"
                                                                                )
                                                                        )
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                )
        );;
        PrgState prg1 = new PrgState(new MyStack<>(), new MyDictionary<String, Value>(), new MyList<Value>(),ex1, new MyDictionary<String, BufferedReader>());
        IRepo repo1 = new Repo("log1.txt");
        repo1.add(prg1);
        Controller ctr1 = new Controller(repo1);
//        IStmt ex2 = new ....;
//        PrgState prg2 = new PrgState(new MyStack<>(), new MyDictionary<String, Value>(), new MyList<Value>(),ex2, new MyDictionary<String, BufferedReader>());
//        IRepo repo2 = new Repo("log2.txt");
//        repo2.add(prg2);
//        Controller ctr2 = new Controller(repo2);
//        IStmt ex3 = new ...;
//        PrgState prg3 = new PrgState(new MyStack<>(), new MyDictionary<String, Value>(), new MyList<Value>(),ex3, new MyDictionary<String, BufferedReader>());
//        IRepo repo3 = new Repo("log3.txt");
//        repo3.add(prg3);
//        Controller ctr3 = new Controller(repo3);
        TextMenu menu = new TextMenu();
        menu.addCommand(new ExitCommand("0", "exit"));
        menu.addCommand(new RunExample("1", ex1.toString(), ctr1));
        //menu.addCommand(new RunExample("2", ex2.toString(), ctr2));
        //menu.addCommand(new RunExample("3", ex3.toString(), ctr3));
        menu.show();
    }
}