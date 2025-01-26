# Szyfr - Aplikacja do Odszyfrowywania Wiadomości

## Opis Projektu

Aplikacja `Szyfr` to program służący do odszyfrowywania wiadomości zaszyfrowanych za pomocą funkcji permutacyjnej polskiego alfabetu: 

\[ f(n) = (p * n + q) % 33 \]

gdzie p, q są niewiadome.

Aplikacja, po podaniu zaszyfrowanego ciągu znaków, samodzielnie znajduje wartości `p` i `q`, które odtwarzają tekst w sposób zgodny z podanym słownikiem języka polskiego. Dzięki temu możliwe jest odszyfrowanie nawet dłuższych, skomplikowanych wiadomości.

## Funkcjonalności

- Odszyfrowywanie tekstu zaszyfrowanego funkcją permutacji.
- Automatyczne przeszukiwanie wszystkich możliwych wartości `p` i `q` w celu znalezienia prawidłowego odszyfrowania.
- Walidacja odszyfrowanego tekstu na podstawie słownika polskich słów.
- Obsługa polskich znaków diakrytycznych.

## Algorytm Działania

1. **Wczytanie słownika polskich słów**:
   Program odczytuje plik słownika zawierający wszystkie poprawne polskie słowa.

2. **Iteracja po możliwych wartościach `p` i `q`**:
   - `p` spełnia warunki \( p != 3k && p != 11k \) (gcd(p, MOD) = 1).
   - `q` przyjmuje wartości od 0 do 32.

3. **Odszyfrowanie wiadomości**:
   - Zaszyfrowane litery są przekształcane zgodnie z równaniem odwrotnym:
     n = (f(n) rev_mod 33 - q) / p
   - Gdzie rev_mod to odwrotność modularna względem długości alfabetu.

4. **Walidacja**:
   - Odszyfrowany ciąg znaków jest dzielony na słowa i sprawdzany pod kątem zgodności ze słownikiem.

5. **Wynik**:
   - Dla poprawnych \( p \) i \( q \) program wypisuje odszyfrowaną wiadomość wraz z parametrami \( p \) i \( q \).

## Wymagania

- JDK 8 lub nowszy
- Plik słownika w formacie tekstowym (np. `odm.txt`) zawierający polskie słowa, rozdzielone przecinkami i spacjami.

## Struktura Plików

- `src/szyfr/odszyfruj.java` – Kod źródłowy aplikacji.
- `resources/odm.txt` – Plik słownika polskich słów.

## Uruchamianie Programu

1. **Kompilacja**:
   Skompiluj kod źródłowy przy użyciu komendy:
   ```bash
   javac -d out src/szyfr/odszyfruj.java
