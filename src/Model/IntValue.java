package Model;

public class IntValue implements Value {
    int val;
    public IntValue(int v)
    {
        val=v;
    }

    int getVal() {return val;}

    @Override
    public String toString() {
        return Integer.toString(val);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof IntValue))
            return false;
        IntValue o = (IntValue) obj;
        return val == o.val;
    }

    @Override
    public Type getType() {
        return new IntType();
    }
}
