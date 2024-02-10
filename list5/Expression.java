public class Expression
{   
    
    // dodawanie dwóch wyrażeń
    static public Node Add(Expression a, Expression b)
    {
        return new Node("+", a, b);
    }

    // mnożenie dwóch wyrażeń
    static public Node Multiply(Expression a, Expression b)
    {
        return new Node("*", a, b);
    }

    public int evaluate()
    {
        return 0;
    }

    public Expression derivate()
    {
        return null;
    }

}
