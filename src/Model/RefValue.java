package Model;

public class RefValue implements Value{
    int address;
    Type locationType;

    public RefValue()
    {}

    public RefValue(int add, Type loc)
    {
        this.address = add;
        this.locationType = loc;
    }
    //..................................

    public int getAddr() {
        return address;
    }

    @Override
    public Type getType() {
        return new RefType(locationType);
    }

    public int getAddress() { return address; }

    @Override
    public String toString() {
        return Integer.toString(address) + " - " + locationType;
    }
}
