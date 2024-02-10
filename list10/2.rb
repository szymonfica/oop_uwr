# Szymon Fica
# lista 10 zadanie 2
# 
# kompilacja: ruby 2.rb
#
# klasa Kolekcja implementuje kolekcję przechowującą elementy dowolnego
# typu w kolejności rosnącej wraz z metodą dodawania elementu do listy,
# oraz odczytania i-tego elementu
# 
# klasa Wyszukiwanie przyjumuje jako argument obiekt klasy Kolekcja i 
# udostępnia dwie moteody: wyszukiwanie binarne działajace w czasie O(log(n))
# oraz wyszukiwanie liniowe działajace w O(n)
# metody zwracają indeks na którym znajdują się argumemnty, w obu
# metodach w przypadku gdy elemenet nie występuje w kolekcji zwracane jest -1
#

class Kolekcja 
    def initialize
        @tab = []
    end

    def length()
        @tab.length
    end

    def push(value)
        it = @tab.length
        @tab.push(value)
        while it > 0
            if @tab[it] < @tab[it-1]
                a, b = @tab[it], @tab[it-1]
                @tab[it], @tab[it-1] = b, a
            end
            it = it - 1
        end
    end 

    def get(i)
        @tab[i]
    end

    def to_s
        @tab.to_s
    end

end


class Wyszukiwanie
    def wyszukiwanie_liniowe(kol, elem)
        it = kol.length - 1
        while it >= 0
            if kol.get(it) == elem
                return it
            end
            it = it - 1
        end
        return -1
    end

    def wyszukiwanie_binarne(kol, elem)
        if kol.get(0) > elem or kol.get(-1) < elem
            return -1
        end
        p, q = 0, kol.length - 1
        while p + 1 < q
            mid = (p + q)/2
            if kol.get(mid) <= elem
                p = mid
            else
                q = mid
            end
        end
        if kol.get(p) == elem
            return p
        else
            return -1
        end
        end

end

puts "Nowa kolekcja: A = Kolekcja.new"
puts "Dodane elementy w kolejności: 1, 7, 3, 2, 6, 4"
A = Kolekcja.new
A.push(1)
A.push(7)
A.push(3)
A.push(2)
A.push(6)
A.push(4)
puts
puts "Aktualny stan A:"
puts A.to_s
puts

B = Wyszukiwanie.new
puts "Rezultaty metody wyszukiwanie_liniowe na kolekcji A: "
puts "w_l(A, 4): #{B.wyszukiwanie_liniowe(A, 4)}"
puts "w_l(A, 10): #{B.wyszukiwanie_liniowe(A, 10)}"
puts "w_l(A, 1): #{B.wyszukiwanie_liniowe(A, 1)}"
puts
puts "Rezultaty metody wyszukiwanie_binarne na kolekcji A: "
puts "w_b(A, 4): #{B.wyszukiwanie_binarne(A, 4)}"
puts "w_b(A, 5): #{B.wyszukiwanie_binarne(A, 5)}"
puts "w_b(A, 1): #{B.wyszukiwanie_binarne(A, 1)}"
