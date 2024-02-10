public class Node extends Expression
{
    String symbol;

    Expression left, right;

    // konstruktor węzła, argumenty to lewe i prawe wyrażenie oraz symbol operacji
    Node(String symbol, Expression left, Expression right){
        this.symbol = symbol;
        this.left = left;
        this.right = right;
    }

    // metoda evaluate oblicza wartość wyrażenia
    @Override
    public int evaluate()
    {
        int result = 0;
        if(symbol == "+"){
            result = left.evaluate() + right.evaluate();
        }
        else if(symbol == "*"){
            result = left.evaluate() * right.evaluate();
        }
        return result;
    }

    // metoda toString zwraca reprezentację wyrażenia
    public String toString() 
    {
        return "(" + left.toString() + " " + symbol + " " + right.toString() + ")";     
    }


    // metoda derivate zwraca pochodą wyrażenia
    @Override
    public Expression derivate()
    {   
        if(symbol == "+"){
            return new Expression().Add(left.derivate(), right.derivate());
        }
        return new Expression().Add(Expression.Multiply(left.derivate(), right), Expression.Multiply(left, right.derivate()));
        
    }

}
