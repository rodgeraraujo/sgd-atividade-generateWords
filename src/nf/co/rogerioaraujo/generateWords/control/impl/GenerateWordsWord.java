//
//   _____                     _       _ _ _           _
//  |   __|___ ___ ___ ___ ___| |_ ___| | | |___ ___ _| |___
//  |  |  | -_|   | -_|  _| .'|  _| -_| | | | . |  _| . |_ -|
//  |_____|___|_|_|___|_| |__,|_| |___|_____|___|_| |___|___|
//
//                                              Version 1.2.0
//                   Rogerio Araujo <rogerio.araujo@mail.com>

package nf.co.rogerioaraujo.generateWords.control.impl;

import nf.co.rogerioaraujo.generateWords.model.Values;
import nf.co.rogerioaraujo.generateWords.control.interfaces.GenerateInterface;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GenerateWordsWord implements GenerateInterface {

    List<String> allWords = new ArrayList<>();
    List<String> syllables  = new ArrayList<>();
    List<String> words = new ArrayList<>();
    List<String> numberCombinations = new ArrayList<>();

    @Override
    public List<String> generateWords(Values obj) {

        //salva todas as combinaçoes de silabas, utilizando vogais e consoantes
        getSyllables(obj);

        //salva novas palavras utilizando 3 silabas
        generateWord();

        //salva todos os pares de numeros (duas casas decimais)
        getNumbersPairs(obj);

        //salva todas as palavras com numeros e silabas (limitado a 10 mill)
        getWords(words, numberCombinations);

        //retorna um array list com todas as 10 mil palavras
        return allWords;
    }

    @Override
    public void listToTXT(List<String> result) throws IOException {
        FileWriter writer = new FileWriter("output.txt");

        for (String word: result) {
            for(String str: result) {
                writer.write(str + "\n");
            }
        }

        System.out.println("Listagem completa\nSaida: output.txt \nTamanho do arquivo: " + fileSize() + " bytes");
    }

    private long fileSize() {
        File output = new File("output.txt");
        return output.length();
    }

    private void getWords(List<String> words, List<String> numberCombinations) {
        int cont = 0;
        for (int letter = 0; letter < 100; ++letter){

            for (int number = 0; number < numberCombinations.size(); ++number){

                if (words.equals(numberCombinations.get(number))) continue;

                //metodo para salvar nova palavra
                saveNewWord(words, numberCombinations, number, cont);
                cont++;

            }
        }
    }

    private void saveNewWord(List<String> words, List<String> numberCombinations, int number, int cont) {
        String word = words.get(cont);
        String text = word + numberCombinations.get(number);
//        System.out.println(text);
        allWords.add(text);
    }

    private void getNumbersPairs(Values obj) {

        for (int i = 0; i < obj.getNumbers().size(); ++i){

            for (int j = 0; j < obj.getNumbers().size(); ++j){

                if (obj.getNumbers().get(i).equals(obj.getNumbers().get(j))) continue;

                    numberCombinations.add(obj.getNumbers().get(j)+obj.getNumbers().get(i));
                    numberCombinations.add(obj.getNumbers().get(i)+obj.getNumbers().get(j));

            }
        }

    }

    private List<String> generateWord() {

        for (int i = 0; i < syllables.size(); ++i){

            for (int j = 0; j < syllables.size(); ++j){

                if (syllables.get(i).equals(syllables.get(j))) continue;

                for (int k = 0; k < syllables.size(); ++k){

                    if ((syllables.get(i).equals(syllables.get(k))) || (syllables.get(j).equals(syllables.get(k)))) continue;

                    words.add(syllables.get(i) + syllables.get(j) + syllables.get(k));

                }
            }
        }

        return words;
    }

    private void getSyllables(Values obj) {

        for (String vowel: obj.getVowels()) {
            for (String consonat: obj.getConsonants()) {
                syllables.add(consonat + vowel);
            }
        }

        //Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
//        for (String vowel: obj.getVowels()) {
//            for (String consonat: obj.getConsonants()) {
//                syllables.add(vowel + consonat);
//            }
//        }

    }

}
