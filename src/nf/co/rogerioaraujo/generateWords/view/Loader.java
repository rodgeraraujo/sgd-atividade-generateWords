//
//   _____                     _       _ _ _           _
//  |   __|___ ___ ___ ___ ___| |_ ___| | | |___ ___ _| |___
//  |  |  | -_|   | -_|  _| .'|  _| -_| | | | . |  _| . |_ -|
//  |_____|___|_|_|___|_| |__,|_| |___|_____|___|_| |___|___|
//
//                                              Version 0.0.1
//                   Rogerio Araujo <rogerio.araujo@mail.com>

package nf.co.rogerioaraujo.generateWords.view;

import nf.co.rogerioaraujo.generateWords.model.Values;
import nf.co.rogerioaraujo.generateWords.control.impl.GenerateWordsWord;

import java.io.IOException;
import java.util.List;

public class Loader {

    public static void main(String[] args) throws IOException {
        Values value = new Values();
        GenerateWordsWord generate = new GenerateWordsWord();


        // verificar valores de entrada
//        System.out.println(value.getNumbers());
//        System.out.println(value.getConsonants());
//        System.out.println(value.getVowels());

        // gerar palavras
        List<String> result = generate.generateWords(value);

        // total de palavras
        System.out.println("Total de palavras: " + result.size());

        generate.listToTXT(result);

    }
}
