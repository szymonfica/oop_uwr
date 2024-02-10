/*
 * Szymon Fica
 * lista 5, zadanie 2 i 4
 * 
 * vsc
 * 
 * javac Main.java
 * java Main
 * 
 * Klasa Expression reprezentuje wyrażenia algebraiczne w postaci drzew binarnych,
 * zawiera metody operacji arytmetycznych dodawania, mnożenia i liczenia pochodnych
 * 
 * 
 */

public class Main
{
    public static void main(String[] args)
    {
        Variable a = new Variable("a", 7);
        Variable b = new Variable("b", 13);
        Variable c = new Variable("c", 14);
        Variable d = new Variable("d", 27);
        Variable x = new Variable("x", 1);

        System.out.println("Zmienna a = " + a.value);
        System.out.println("Zmienna b = " + b.value);
        System.out.println("Zmienna c = " + c.value);
        System.out.println("Zmienna d = " + d.value);
        System.out.println("Zmienna x = " + x.value);
        
        System.out.println();
        
        Expression expr1 = Expression.Add(Expression.Multiply(a, Expression.Multiply(new Const(5), b)), Expression.Multiply(c, Expression.Add(new Const(3), d)));
        System.out.println("expr1: " + expr1.toString() + " = " + expr1.evaluate());
        
        System.out.println("zmiana wartosci zmiennych (a = 2, b = 3)");

        a.set_value(2);
        b.set_value(3);

        System.out.println("expr1: " + expr1.toString() + " = " + expr1.evaluate());

        System.out.println();

        Expression expr2 = Expression.Multiply(x, new Const(11));
        System.out.println("expr2: " + expr2.toString() + " = " + expr2.evaluate());
        Expression d2 = expr2.derivate();
        System.out.println("pochodna expr2: " + d2.toString() + "\npo uproszczeniu pochodna expr2 to: 11");
        
        System.out.println();

        Expression expr3 = Expression.Multiply(x, Expression.Multiply(x, new Const(11)));
        System.out.println("expr3: " + expr3.toString() + " = " + expr3.evaluate());
        Expression d3 = expr3.derivate();
        System.out.println("pochodna expr3: " + d3.toString() + "\npo uproszczeniu pochodna expr3 to: 22*x");
    
    }
}
