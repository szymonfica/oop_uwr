# Szymon Fica
# lista 8 zadanie 2
# 
#

# klasa reprezentująca czas w godzinach i sekundach
class Czas
    #konstruktor
    def initialize(godz)
        @godziny = godz
    end
    
    # metoda zwraca czas w sekundach
    def sekundy
        3600 * @godziny
    end

    # metoda zmienia przechowywany czas na podaną w argumencie liczbę sekund
    def sekundy=(sek)
        @godziny = sek / 3600
    end

    # metoda zwraca czas w godzinach
    def godziny
        @godziny
    end
    
    # metoda zmienia przechowywany czas na podaną w argumencie liczbę godzin
    def godziny=(godz)
        @godziny = godz
    end


end

# klasa reprezentująca długość w kilometrach i milach morskich
class Dlugosc
    #konstruktor
    def initialize(km)
        @kilometry = km
    end

    # metoda zwraca przechowywaną dlugość w milach morskich
    def mile_morskie
        (1/1.852) * @kilometry
    end

    # metoda zmienia przechowywaną dlugość na podaną w argumencie liczbę mili
    def mile_morskie=(mile)
        @kilometry = 1.852 * mile
    end

    # metoda zwraca przechowywaną dlugość w kilometrach
    def kilometry
        @kilometry
    end

    # metoda zmienia przechowywaną dlugość na podaną w argumencie liczbę kilometrów
    def kilometry=(km)
        @kilometry = km
    end

# klasa reprezentująca prędkość w km/h i węzłach
class Predkosc

    # konstruktor
    def initialize(pr)
        @kmh = pr
        @helper_dl = Dlugosc.new(pr)

    end

    # metoda zmienia prędkość na podaną w argumencie w km/h
    def kmh(pr)
        @kmh = pr
    end

    # metoda zwraca przechowywaną predkość w km/h
    def kmh
        @kmh
    end

    # metoda zwraca przechowywaną predkość w węzłach
    def wezly
        @helper_dl.mile_morskie
    end

    # metoda zmienia prędkość na podaną w argumencie w węzłach
    def wezly=(kn)
        @helper_dl.mile_morskie=(kn)
        @kmh = @helper_dl.kilometry
    end

end

# klasa reprezentująca przyspieszenie w km/s^2 i mm/h^2
class Przyspieszenie

    # konstruktor
    def initialize(wartosc)
        @kmss = wartosc
    end

    # metoda zmienia przyspieszenie na podaną w argumencie w km/s^2
    def kmss(wartosc)
        @kmss = wartosc
    end

    # metoda zwraca przechowywane przyspieszenie w km/s^2
    def kmss
        @kmss
    end

    # metoda zwraca przechowywane przyspieszenie w mm/h^2
    def mmhh
        @kmss * 12960000000000 
    end

    # metoda zmienia przyspieszenie na podaną w argumencie w mm/h^2
    def mmhh=(wartosc)
        @kmss = wartosc / 12960000000000
    end

end

p1 = Predkosc.new(1)

puts "Prędkość:"
puts "#{p1.kmh} km/h      ||   #{p1.wezly} kn"
puts
p1.wezly=(539.9568034557235)
puts "Zmiana prędkości metodą wezly=() na 539.9568034557235 kn"
puts "#{p1.kmh} km/h ||   #{p1.wezly} kn"
puts
p1.wezly=(269.97840172786175)
puts "Zmiana prędkości metodą wezly=() na 269.97840172786175 kn"
puts "#{p1.kmh} km/h  ||   #{p1.wezly} kn"

a1 = Przyspieszenie.new(1)

puts
puts "Przyspieszenie:"

puts "#{a1.kmss} km/s^2    ||   #{a1.mmhh} mm/h^2"
puts
a1.mmhh=(648000000000000)
puts "Zmiana przyspieszenia metodą mmhh=() na 648000000000000 mm/h^2"
puts "#{a1.kmss} km/s^2   ||   #{a1.mmhh} mm/h^2"
puts
a1.mmhh=(90720000000000)
puts "Zmiana przyspieszenia metodą mmhh=() na 90720000000000 mm/h^2"
puts "#{a1.kmss} km/s^2    ||   #{a1.mmhh} mm/h^2"


end
