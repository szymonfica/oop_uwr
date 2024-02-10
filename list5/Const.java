// klasa dla stałych

public class Const extends Expression
{   
    int value;

    Const(int value)
    {
        this.value = value;
    }

    @Override
    public int evaluate()
    {
        return value;
    }
    
    public String toString() 
    {
        return Integer.toString(value);
    }

    @Override
    public Expression derivate()
    {
        return new Const(0); 
    }

}
