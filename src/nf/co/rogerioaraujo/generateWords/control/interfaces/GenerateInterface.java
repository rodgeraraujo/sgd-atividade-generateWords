//
//   _____                     _       _ _ _           _
//  |   __|___ ___ ___ ___ ___| |_ ___| | | |___ ___ _| |___
//  |  |  | -_|   | -_|  _| .'|  _| -_| | | | . |  _| . |_ -|
//  |_____|___|_|_|___|_| |__,|_| |___|_____|___|_| |___|___|
//
//                                              Version 1.0.0
//                   Rogerio Araujo <rogerio.araujo@mail.com>

package nf.co.rogerioaraujo.generateWords.control.interfaces;

import nf.co.rogerioaraujo.generateWords.model.Values;

import java.io.IOException;
import java.util.List;

public interface GenerateInterface {

    List<String> generateWords(Values obj);

    void listToTXT(List<String> result) throws IOException;

}
