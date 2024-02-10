# Szymon Fica
# lista 10 zadanie 1
# 
# kompilacja: ruby 1.rb
#
# Klasa Collection implementuje  tablice jednowymiarowe podawane jako argument
# w konstruktorze i podstawowe metody do służące do edytowania tablicy

# Klasa Sorter implementuje dwie metody sortowania obiektów Collection,
# algorytm sortowania bąbelkowego oraz sortowanie przez wybieranie,
# oba algorytmy działają w O(n^2), gdzie n to liczba elementów w kolekcji.
# Obie metody w Sorter korzystają wyłącznie z metod udostępnianych przez
# klasę Collection i nie odwoływują się w żaden sposób do implementacji Collection


class Collection
    def initialize(tab)
        unless tab.kind_of?(Array)
            raise "Expected Array"
        end

        @tab = tab
        @length = tab.length
    end

    def length
        @length
    end

    def get(i)
        @tab[i]
    end

    def set(i, value)
        @tab[i] = value
    end

    def swap(i, j)
        a, b = @tab[i], @tab[j]
        @tab[i], @tab[j] = b, a
    end

    def to_s
        @tab.to_s
    end
end

class Sorter 

    # sortowanie bąbelkowe
    def bubble_sort(tab)
        n = tab.length - 1
        n.times do |i|
            (n-i).times do |j|
                if tab.get(j) > tab.get(j+1)
                    tab.swap(j, j+1)
                end
            end
        end
    end

    # sortowanie przez wybieranie
    def select_sort(tab)
        n = tab.length
        n.times do |i|
            a = i
            (n-i).times do |j|
                if tab.get(a) > tab.get(j+i)
                    a = j+i
                end
            end
            tab.swap(i, a)
        end
    end
end

sorter = Sorter.new

print "Bubble sort: \n"
puts "Tablica przed sortowaniem: "
A = Collection.new(Array.new(10){|x| rand(70) - 27})
puts A
puts "Tablica po sortowaniu: "
sorter.bubble_sort(A)
puts A

print "\nSelect sort: \n"
B = Collection.new(Array.new(10){|x| rand(70) - 27})
puts "Tablica przed sortowaniem: "
puts B
sorter.select_sort(B)
puts "Tablica po sortowaniu: "
puts B


print "\nTest czasowy metod sortowania na tablicach o długości 1000: \n"

require 'benchmark'

Benchmark.bm do |x|
    x.report("Bubble sort: ") {sorter.bubble_sort(Collection.new(Array.new(1000){|x| rand(5000)}))}
    x.report("Select sort: ") {sorter.select_sort (Collection.new(Array.new(1000){|x| rand(5000)}))}
end
