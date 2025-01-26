package szyfr;
import java.util.*;
import java.util.HashMap;

public class zaszyfruj {
    public static void main(String args[])
    {
        Character alfabet[] = {
                ' ', 'a', 'ą', 'b', 'c', 'ć', 'd', 'e', 'ę', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'ł',
                'm', 'n', 'ń', 'o', 'ó', 'p', 'r', 's', 'ś', 't', 'u', 'w', 'y', 'z', 'ź', 'ż'
        };
        HashMap<Character, Integer> letter_to_index = new HashMap<Character, Integer>();

        for(int i = 0; i < 33; i++)
        {
            letter_to_index.put(alfabet[i], i);
        }

        Scanner in = new Scanner(System.in);
        System.out.println("Podaj tekst do zaszyfrowania: ");
        String text = in.nextLine();
        System.out.println("Podaj p: ");
        int p = Integer.parseInt(in.nextLine());
        System.out.println("Podaj q: ");
        int q = Integer.parseInt(in.nextLine());

        int n = text.length();
        StringBuilder coded = new StringBuilder();
        for(int i = 0; i < n; i++)
        {
            char e = text.charAt(i);
            coded.append(alfabet[(letter_to_index.get(e) * p + q) % 33]);
        }
        System.out.println("Zaszyfrowane: ");
        System.out.println(coded);
    }
}
