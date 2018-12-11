//
//   _____                     _       _ _ _           _
//  |   __|___ ___ ___ ___ ___| |_ ___| | | |___ ___ _| |___
//  |  |  | -_|   | -_|  _| .'|  _| -_| | | | . |  _| . |_ -|
//  |_____|___|_|_|___|_| |__,|_| |___|_____|___|_| |___|___|
//
//                                              Version 0.0.1
//                   Rogerio Araujo <rogerio.araujo@mail.com>

package nf.co.rogerioaraujo.generateWords.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Values {

    private List<String> numbers = new ArrayList<String>(Arrays.asList("01234567".split("")));
    private List<String> vowels =  new ArrayList<String>(Arrays.asList("aeiou".split("")));
    private List<String> consonants = new ArrayList<String>(Arrays.asList("bcdfghjklmnpqrstvxywz".split("")));

    public Values() {
    }

    public Values(List<String> numbers, List<String> vowels, List<String> consonants) {
        this.numbers = numbers;
        this.vowels = vowels;
        this.consonants = consonants;
    }

    public List<String> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<String> numbers) {
        this.numbers = numbers;
    }

    public List<String> getVowels() {
        return vowels;
    }

    public void setVowels(List<String> vowels) {
        this.vowels = vowels;
    }

    public List<String> getConsonants() {
        return consonants;
    }

    public void setConsonants(List<String> consonants) {
        this.consonants = consonants;
    }
}

