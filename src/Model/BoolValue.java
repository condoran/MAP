package Model;

public class BoolValue implements Value {
    boolean val;

    BoolValue(boolean b)
    {
        val = b;
    }

    public boolean getVal()
    {
        return val;
    }

    @Override
    public String toString(){
        return Boolean.toString(val);
    }

    @Override
    public Type getType() {
        return new BoolType();
    }
}
