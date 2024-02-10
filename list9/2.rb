# Szymon Fica
# lista 9 zadanie 2
# ruby 2.rb

# klasa reprezentuje funkcje podaną w argumencie konstruktora jako blok
class Function2D
    
    def initialize(&f)
        @delta =  0.05
        @epsilon = 0.01 # epsilon do policzenia błędu bezwzględnego
        @f = f
    end

    # metoda zwraca punkty z prostokątu ograniczonymi podanymi
    # współrzędnymi oddalonymi o deltę
    def Function2D.punkty(x1, x2, y1, y2, delta)
        wsp_x = ((x2-x1)/delta).floor()
        wsp_y = ((y2-y1)/delta).floor()
        tab = Array.new(wsp_x){ |x| Array.new(wsp_y){|y| [x*delta, y*delta] } }
        return tab
    end

    # metoda zwraca wartość f(x)
    def value(x, y)
        @f.call(x, y)
    end

    # metoda zwraca objętość pomiędzy prostokątem [a, b] x [c, d] a wykresem funkcji
    def volume(a, b, c, d)
        tab = Function2D.punkty(a, b, c, d, @delta)
        wartosci = tab.map{|arr| arr.map{|x,y| self.value(x,y)}}
        sum = 0
        for i in (0...(tab.size - 1))
            for j in (0...tab[0].size - 1)
                sum += wartosci[i][j]
            end
        end
        
        return sum*(@delta * @delta)
    end

    # metoda sprawdza czy wartośći 'a' i 'b' różnią się o mniej niż epsilon
    def Function2D.blad(a, b, ep)
        (a - b).abs() < ep
    end

    # metoda zwracazwraca pary (x, y) takie, że f.value(x,y) ≈ height"
    # dla a <= x <= b, c <= y <= d"
    def countourLine(a, b, c, d,height)
        tab = []
        x, y = a, c
        while (y < d)
            while (x < b)
                if(Function2D.blad(self.value(x,y), height, @epsilon))
                    tab.push([x,y])
                end
                x += @delta
            end
            y += @delta
            x = a
        end
        return tab
    end
end


f = Function2D.new(){|x, y| (x**2) + 4*y + 1}
puts "Niech f(x) = x^2 + 4*y + 1"
puts
puts "Przykładowe wartości f(x):"
puts "f(0, 0) = #{f.value(0, 0)}"
puts "f(1, 2) = #{f.value(1, 2)}"
puts "f(7, 27) = #{f.value(7, 27)}"
puts
puts "Przybliżone objętości między wykresem f(x) a prostokątem [a, b] x [c, d]:"
puts
puts "[0, 1] x [0, 1]: #{f.volume(0, 1, 0, 1)}"
puts "[3, 4] x [0, 2]: #{f.volume(3, 4, 0, 2)}"
puts "[0, 2] x [0, 1]: #{f.volume(0, 2, 0, 1)}"
puts
puts "Metoda 'countourLine' zwraca pary (x, y) takie, że f.value(x,y) ≈ height"
puts "dla a <= x <= b, c <= y <= d"
puts 
puts "f.countourLine(1, 4, 2, 5, 12):"
puts "#{f.countourLine(1, 4, 2, 5, 12)}"
