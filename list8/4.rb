# Szymon Fica
# lista 8 zadanie 4

# klasa przechowująca napis w postaci jawnej 
class Jawna
    def initialize(napis)
        @napis = napis
    end

    def zaszyfruj(key)
        ans = ''
        chars = @napis.split('')
        chars.each { |c|
            ans += key[c]
        }
        x = Zaszyfrowana.new(ans)
        x
    end

    def to_s
        @napis
    end
end

# klasa przechowująca napis zaszyfrowany
class Zaszyfrowana
    def initialize(napis)
        @napis = napis
    end

    def odszyfruj(key)
        inverted_key = key.invert
        ans = ''
        chars = @napis.split('')
        chars.each { |c|
            ans += inverted_key[c]
        }
        x = Jawna.new(ans)
        x
    end

    def to_s
        @napis
    end
end

dict = {
    'a' => 'n',
    'b' => 'o',
    'c' => 'p',
    'd' => 'q',
    'e' => 'r',
    'f' => 's',
    'g' => 't',
    'h' => 'u',
    'i' => 'v',
    'j' => 'w',
    'k' => 'x',
    'l' => 'y',
    'm' => 'z',
    'n' => 'a',
    'o' => 'b',
    'p' => 'c',
    'q' => 'd',
    'r' => 'e',
    's' => 'f',
    't' => 'g',
    'u' => 'h',
    'v' => 'i',
    'w' => 'j',
    'x' => 'k',
    'y' => 'l',
    'z' => 'm',
}


a = Jawna.new("kotekwlazlnaplotek")
print "słowo przed zaszyfrowaniem: "
puts a.to_s
b = a.zaszyfruj(dict)
print "słowo po zaszyfrowaniu: "
puts b.to_s

c = b.odszyfruj(dict)
print "słowo po odszyfrowaniu: "
puts c.to_s
