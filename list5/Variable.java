import javax.swing.text.DefaultStyledDocument.ElementSpec;

// klasa dla zmiennych  
public class Variable extends Expression
{
    int value; // wartość zmiennej
    String name; // nazwa zmiennej

    Variable(String name, int value)
    {
        this.value = value;
        this.name = name;
    }

    Variable(String name)
    {
        this.value = 0;
        this.name = name;
    }

    // zmiana wartości zmiennej
    void set_value(int value){
        this.value = value;
    }
    
    @Override
    public int evaluate()
    {
        return value;
    }

    public String toString() 
    {
        return name;       
    }

    @Override
    public Expression derivate()
    {
        return new Const(1);
    }
    
}
