# Szymon Fica
# lista 9 zadanie 1
# ruby 1.rb

# klasa reprezentuje funkcje podaną w argumencie konstruktora jako blok

class Function 

    def initialize(&f)
        @delta = 1.0e-3 # delta do policzenia całki oraz pochodnej
        @f = f
    end

    # metoda zwraca wartość f(x)
    def value(x)
        @f.call(x)
    end

    # metoda zwraca tablicę z miejscami zerowymi na przedziale [a, b]
    # z dokładnością do e
    def zero(a, b, e)
        tab = Array.new((b-a)/e) {|x| a + x*e}
        tab.push(b)
        positivity = tab.map{|x| self.value(x) > 0}
        ans = Array.new();
        for i in (1..(tab.size))
            if(positivity[i] != positivity[i-1])
                ans.push(tab[i])
            end
        end
        if(ans.size == 0)
            nil
        else 
            ans
        end
    end

    # metoda zwraca przybliżoną wartość całki na przedziale [a, b]
    def field(a, b)
        tab = Array.new((b-a)/@delta) {|x| a + x*@delta}
        tab.push(b)
        val = tab.map{|x| self.value(x)}
        sum = val.reduce(0){|acc, x| acc+x}
        sum * @delta
    end

    # metoda zwraca przybliżoną pochodną funkcji w punkcie x
    def deriv(x) 
        (self.value(x) - self.value(x-@delta))/@delta
    end

end

f = Function.new(){|x| (x**3) - 4*(x**2) + x + 2}
puts "Niech f(x) = x^3 - 4x^3 + x^2 + 2"
puts "Przykładowe wartości f(x):"
puts "f(0) = #{ f.value(0)}"
puts "f(1) = #{f.value(1)}"
puts "f(3) = #{f.value(3)}"
puts "f(0.5) = #{f.value(0.5)}"
puts "Miejsca zerowe na [-1, 4] z dokładnością 0.025: "
puts f.zero(-1, 4, 0.025)
puts "Pole pod wykresem na przedziale [-0.5, 1]: #{f.field(-0.5, 1)}"
puts 
puts "Pochodna w punkcie 0.5: #{f.deriv(0.5)}"
puts "Pochodna w punkcie 1: #{f.deriv(1)}"

        