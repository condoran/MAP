package Model;

public class StringType implements Type{
    @Override
    public Value defaultValue() {
        return new StringValue("");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof StringType)
            return true;
        else
            return false;
    }
}
