package szyfr;
import java.io.*;
import java.util.*;

public class odszyfruj {

    private static final char[] alfabet = {
            ' ', 'a', 'ą', 'b', 'c', 'ć', 'd', 'e', 'ę', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'ł',
            'm', 'n', 'ń', 'o', 'ó', 'p', 'r', 's', 'ś', 't', 'u', 'w', 'y', 'z', 'ź', 'ż'
    };

    private static final int MOD = alfabet.length;

    public static void main(String[] args) throws IOException {
        Set<String> polishWords = loadPolishWords("odm.txt");
        Scanner in = new Scanner(System.in);
        System.out.println("Podaj tekst to odszyfrowania: ");
        String encryptedMessage = in.nextLine();

        for (int p = 1; p < MOD; p++) {
            if(p%3 == 0 || p%11 == 0)
                continue;

            for (int q = 0; q < MOD; q++) {
                String decryptedMessage = decryptMessage(encryptedMessage, p, q);

                if (isValidMessage(decryptedMessage, polishWords)) {
                    System.out.println("Zdekodowana wiadomość: " + decryptedMessage);
                    System.out.println("Dla: p=" + p + ", q=" + q);
                }
            }
        }
    }

    private static Set<String> loadPolishWords(String filename) throws IOException {
        Set<String> words = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] wordArray = line.split(", ");
                words.addAll(Arrays.asList(wordArray));
            }
        }
        return words;
    }

    private static String decryptMessage(String encryptedMessage, int p, int q) {
        StringBuilder decrypted = new StringBuilder();

        int pInverse = modInverse(p, MOD);

        for (char c : encryptedMessage.toCharArray()) {
            int encryptedIndex = findIndex(c);
            if (encryptedIndex == -1) continue;

            int decryptedIndex = (pInverse * (encryptedIndex - q + MOD)) % MOD;
            decrypted.append(alfabet[decryptedIndex]);
        }

        return decrypted.toString();
    }

    private static boolean isValidMessage(String message, Set<String> polishWords) {
        String[] words = message.split(" ");
        for (String word : words) {
            if (!polishWords.contains(word)) {
                return false;
            }
        }
        return true;
    }

    private static int findIndex(char c) {
        for (int i = 0; i < alfabet.length; i++) {
            if (alfabet[i] == c) {
                return i;
            }
        }
        return -1;
    }

    private static int modInverse(int a, int mod) {
        for (int x = 1; x < mod; x++) {
            if ((a * x) % mod == 1) {
                return x;
            }
        }
        return -1;
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}

