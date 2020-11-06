package Model;

public class IntValue implements Value {
    int val;
    IntValue(int v)
    {
        val=v;
    }

    int getVal() {return val;}

    @Override
    public String toString() {
        return Integer.toString(val);
    }

    @Override
    public Type getType() {
        return new IntType();
    }
}
