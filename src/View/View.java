package View;

import Controller.*;
import Model.*;
import Repository.*;

import java.util.Scanner;

public class View {
    Controller ctrl;

    public View()
    {
        IRepo repo = new Repo();
        Scanner s = new Scanner(System.in);
        this.ctrl = new Controller(repo);
        while (true) {
            Menu();
            int option = s.nextInt();
            if (option == 1) {
                Option1();
                try {
                    ctrl.allStep();
                } catch (MyException e) {
                    System.out.println(e.toString());
                }
            }
            else if (option == 2) {
                Option2();
                try {
                    ctrl.allStep();
                } catch (MyException e) {
                    System.out.println(e.toString());
                }
            }
            else if (option == 3) {
                Option3();
                try {
                    ctrl.allStep();
                } catch (MyException e) {
                    System.out.println(e.toString());
                }
            }
            else if (option == 4)
            {
                ctrl.displayFlag(true);
            }
            else if (option == 5)
            {
                ctrl.displayFlag(false);
            }
            else if (option == 6)
                break;
        }
    }

    private void Menu()
    {
        System.out.println("1. int v; v=2;Print(v)");
        System.out.println("2. int a;int b; a=2+3*5;b=a+1;Print(b)");
        System.out.println("3. bool a; int v; a=true;(If a Then v=2 Else v=3);Print(v)");
        System.out.println("4. Display flag on");
        System.out.println("5. Display flag off");
        System.out.println("6. Exit");
    }

    private void Option1()
    {
        IRepo repo = ctrl.returnRepo();
        IStmt ex1= new CompStmt(new VarDeclStmt("v",new IntType()),
                new CompStmt(new AssignStmt("v",new ValueExp(new IntValue(2))), new PrintStmt(new
                        VarExp("v"))));
        MyStack<IStmt> stack = new MyStack<>();
        PrgState prg = new PrgState(stack, new MyDictionary<String, Value>(), new MyList<Value>(), ex1);
        repo.add(prg);
    }

    private void Option2()
    {
        IRepo repo = ctrl.returnRepo();
        IStmt ex2 = new CompStmt( new VarDeclStmt("a",new IntType()),
                new CompStmt(new VarDeclStmt("b",new IntType()),
                        new CompStmt(new AssignStmt("a", new ArithExp(new ValueExp(new IntValue(2)),new
                                ArithExp(new ValueExp(new IntValue(3)), new ValueExp(new IntValue(5)), 3), 1)),
                                new CompStmt(new AssignStmt("b",new ArithExp(new VarExp("a"), new
                                        ValueExp(new IntValue(1)), 1)), new PrintStmt(new VarExp("b"))))));
        MyStack<IStmt> stack = new MyStack<>();
        PrgState prg = new PrgState(stack, new MyDictionary<String, Value>(), new MyList<Value>(), ex2);
        repo.add(prg);
    }

    private void Option3()
    {
        IRepo repo = ctrl.returnRepo();
        IStmt ex3 = new CompStmt(new VarDeclStmt("a",new BoolType()),
                new CompStmt(new VarDeclStmt("v", new IntType()),
                        new CompStmt(new AssignStmt("a", new ValueExp(new BoolValue(true))),
                                new CompStmt(new IfStmt(new VarExp("a"),new AssignStmt("v",new ValueExp(new
                                        IntValue(2))), new AssignStmt("v", new ValueExp(new IntValue(3)))), new PrintStmt(new
                                        VarExp("v"))))));
        MyStack<IStmt> stack = new MyStack<>();
        PrgState prg = new PrgState(stack, new MyDictionary<String, Value>(), new MyList<Value>(), ex3);
        repo.add(prg);
    }
}
