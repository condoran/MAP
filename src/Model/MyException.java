package Model;

public class MyException extends Exception{
    String msg;

    public MyException(String m)
    {
        super();
        msg = m;
    }


    @Override
    public String toString() {
        return msg;
    }
}
