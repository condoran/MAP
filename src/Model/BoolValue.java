package Model;

public class BoolValue implements Value {
    boolean val;

    public BoolValue(boolean b)
    {
        val = b;
    }

    public boolean getVal()
    {
        return val;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof BoolValue))
            return false;
        BoolValue o = (BoolValue) obj;
        return val == o.val;
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
