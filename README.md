the file odm.txt contains all Polish words, 
the file Zadania2022.pdf has the problem description (it's the first one)

szyfr/zaszyfruj.java allows you to use the formula f(n) = (p * n + q) % 33, to encode a given message with given p and q
szyfr/odszyfruj.java is the actual program that deciphers a given text (without knowing the p or q) by brute force. It tests every possibility, decodes the text and validates if the words separated by spaces in the deciphered message are real words from the Polish dictionary.