package View;

import Controller.Controller;
import Model.MyException;
import View.Command;

public class RunExample extends Command {
    private Controller ctr;

    public RunExample(String key, String desc, Controller ctr) {
        super(key, desc);
        this.ctr = ctr;
    }

    @Override
    public void execute() {
        try {
            ctr.allStep();
        } catch (MyException e) {
            System.out.println(e.toString());
        } //here you must treat the exceptions that can not be solved in the controller    }
    }
}
