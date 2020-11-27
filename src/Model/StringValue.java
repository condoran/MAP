package Model;

public class StringValue implements Value{

    String val;

    public StringValue(String val)
    {
        this.val = val;
    }

    public String getVal()
    {
        return val;
    }


    @Override
    public Type getType() {
        return new StringType();
    }
}
