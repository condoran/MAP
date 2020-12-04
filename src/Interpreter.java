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
                        "v",
                        new IntType()
                ),
                new CompStmt(
                        new AssignStmt(
                                "v",
                                new ValueExp(
                                        new IntValue(2)
                                )
                        ),
                        new PrintStmt(
                                new VarExp(
                                        "v"
                                )
                        )
                )
        );
        PrgState prg1 = new PrgState(new MyStack<>(), new MyDictionary<String, Value>(), new MyList<Value>(),ex1, new MyDictionary<String, BufferedReader>(), new MyHeap<Value>());
        IRepo repo1 = new Repo("log1.txt");
        repo1.add(prg1);
        Controller ctr1 = new Controller(repo1);
        IStmt ex2 = new CompStmt(
                new VarDeclStmt(
                        "a",
                        new IntType()),
                new CompStmt(new VarDeclStmt(
                        "b",
                        new IntType()
                ),
                        new CompStmt(
                                new AssignStmt(
                                        "a",
                                        new ArithExp(
                                                new ValueExp(
                                                        new IntValue(2)
                                                ),
                                                new ArithExp(
                                                        new ValueExp(
                                                                new IntValue(3)
                                                        ),
                                                        new ValueExp(
                                                                new IntValue(5)
                                                        ),
                                                        3
                                                ),
                                                1
                                        )
                                ),
                                new CompStmt(
                                        new AssignStmt(
                                                "b",
                                                new ArithExp(
                                                        new VarExp("a"),
                                                        new ValueExp(
                                                                new IntValue(1)
                                                        ),
                                                        1
                                                )
                                        ),
                                        new PrintStmt(
                                                new VarExp("b")
                                        )
                                )
                        )
                )
        );
        PrgState prg2 = new PrgState(new MyStack<>(), new MyDictionary<String, Value>(), new MyList<Value>(),ex2, new MyDictionary<String, BufferedReader>(), new MyHeap<Value>());
        IRepo repo2 = new Repo("log2.txt");
        repo2.add(prg2);
        Controller ctr2 = new Controller(repo2);
        IStmt ex3 = new CompStmt(
                new VarDeclStmt(
                        "a",
                        new BoolType()
                ),
                new CompStmt(new VarDeclStmt(
                        "v",
                        new IntType()
                ),
                        new CompStmt(
                                new AssignStmt(
                                        "a",
                                        new ValueExp(
                                                new BoolValue(true)
                                        )
                                ),
                                new CompStmt(
                                        new IfStmt(
                                                new VarExp("a"),
                                                new AssignStmt(
                                                        "v",
                                                        new ValueExp(
                                                                new IntValue(2)
                                                        )
                                                ),
                                                new AssignStmt(
                                                        "v",
                                                        new ValueExp(
                                                                new IntValue(3)
                                                        )
                                                )
                                        ),
                                        new PrintStmt(
                                                new VarExp("v")
                                        )
                                )
                        )
                )
        );
        PrgState prg3 = new PrgState(new MyStack<>(), new MyDictionary<String, Value>(), new MyList<Value>(),ex3, new MyDictionary<String, BufferedReader>(), new MyHeap<Value>());
        IRepo repo3 = new Repo("log3.txt");
        repo3.add(prg3);
        Controller ctr3 = new Controller(repo3);
        IStmt ex4 = new CompStmt(
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
        );
        PrgState prg4 = new PrgState(new MyStack<>(), new MyDictionary<String, Value>(), new MyList<Value>(),ex4, new MyDictionary<String, BufferedReader>(), new MyHeap<Value>());
        IRepo repo4 = new Repo("log4.txt");
        repo4.add(prg4);
        Controller ctr4 = new Controller(repo4);
        IStmt ex5 = new CompStmt(
                new VarDeclStmt(
                        "v",
                        new RefType(
                                new IntType()
                        )
                ),
                new CompStmt(
                        new New(
                                "v",
                                new ValueExp(
                                        new IntValue(20)
                                )
                        ),
                        new CompStmt(
                                new PrintStmt(
                                        new rH(
                                                new VarExp(
                                                        "v"
                                                )
                                        )
                                ),
                                new CompStmt(
                                        new wH(
                                                "v",
                                                new ValueExp(
                                                        new IntValue(30)
                                                )
                                        ),
                                        new PrintStmt(
                                                new ArithExp(
                                                        new rH(
                                                                new VarExp(
                                                                        "v"
                                                                )
                                                        ),
                                                        new ValueExp(
                                                                new IntValue(5)
                                                        ), 1
                                                )
                                        )
                                )
                        )
                )
        );
        PrgState prg5 = new PrgState(new MyStack<>(), new MyDictionary<String, Value>(), new MyList<Value>(),ex5, new MyDictionary<String, BufferedReader>(), new MyHeap<Value>());
        IRepo repo5 = new Repo("log5.txt");
        repo5.add(prg5);
        Controller ctr5 = new Controller(repo5);
        IStmt ex6 = new CompStmt(
                new VarDeclStmt(
                        "v",
                        new RefType(
                                new IntType()
                        )
                ),
                new CompStmt(
                        new New(
                                "v",
                                new ValueExp(
                                        new IntValue(20)
                                )
                        ),
                        new CompStmt(
                                new VarDeclStmt(
                                        "a",
                                        new RefType(
                                                new RefType(
                                                        new IntType()
                                                )
                                        )
                                ),
                                new CompStmt(
                                        new New(
                                                "a",
                                                new VarExp("v")
                                        ),
                                        new CompStmt(
                                                new PrintStmt(
                                                        new rH(
                                                                new VarExp("v")
                                                        )

                                                ),
                                                new PrintStmt(
                                                        new rH(
                                                                new rH(
                                                                        new VarExp("a")
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                )
        );
        PrgState prg6 = new PrgState(new MyStack<>(), new MyDictionary<String, Value>(), new MyList<Value>(),ex6, new MyDictionary<String, BufferedReader>(), new MyHeap<Value>());
        IRepo repo6 = new Repo("log6.txt");
        repo6.add(prg6);
        Controller ctr6 = new Controller(repo6);
        IStmt ex7 = new CompStmt(
                new VarDeclStmt(
                        "v",
                        new IntType()
                ),
                new CompStmt(
                        new AssignStmt(
                                "v",
                                new ValueExp(
                                        new IntValue(4)
                                )
                        ),
                        new CompStmt(
                                new While(
                                        new RelationalExp(
                                                new VarExp("v"),
                                                new ValueExp(
                                                        new IntValue(0)
                                                ),
                                                5
                                        ),
                                        new CompStmt(
                                                new PrintStmt(
                                                        new VarExp("v")
                                                ),
                                                new AssignStmt(
                                                        "v",
                                                        new ArithExp(
                                                                new VarExp("v"),
                                                                new ValueExp(
                                                                        new IntValue(1)
                                                                ),
                                                                2
                                                        )
                                                )
                                        )
                                ),
                                new PrintStmt(
                                        new VarExp("v")
                                )
                        )
                )
        );
        PrgState prg7 = new PrgState(new MyStack<>(), new MyDictionary<String, Value>(), new MyList<Value>(),ex7, new MyDictionary<String, BufferedReader>(), new MyHeap<Value>());
        IRepo repo7 = new Repo("log7.txt");
        repo7.add(prg7);
        Controller ctr7 = new Controller(repo7);
        TextMenu menu = new TextMenu();
        menu.addCommand(new ExitCommand("0", "exit"));
        menu.addCommand(new RunExample("1", ex1.toString(), ctr1));
        menu.addCommand(new RunExample("2", ex2.toString(), ctr2));
        menu.addCommand(new RunExample("3", ex3.toString(), ctr3));
        menu.addCommand(new RunExample("4", ex4.toString(), ctr4));
        menu.addCommand(new RunExample("5", ex5.toString(), ctr5));
        menu.addCommand(new RunExample("6", ex6.toString(), ctr6));
        menu.addCommand(new RunExample("7", ex7.toString(), ctr7));
        menu.show();
    }
}