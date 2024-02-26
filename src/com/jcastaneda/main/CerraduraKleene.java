package com.jcastaneda.main;

import java.util.ArrayList;
import java.util.Scanner;

public class CerraduraKleene {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Cuantas palabras contiene tu lenguaje?");
        int numberWords = s.nextInt();

        ArrayList<String> words = new ArrayList<>();
        System.out.println("Porfavor digite las " + numberWords + " palabras de su lenguaje");
        for (int i = 0; i < numberWords; i++) {
            String word = s.next();
            words.add(word);
        }

        System.out.println("Que nivel de cerradura de Kleene deseas conocer?");
        int numberKleene = s.nextInt();

        ArrayList<String> kleeneLock = calcularCerraduraKleene(words, numberKleene);

        System.out.println("El conjunto de palabras que corresponde al nivel " + numberKleene + " de cerradura son: ");
        for (String word: kleeneLock) {
            System.out.println(word);
        }

        System.out.println("Cantidad de palabras: " + kleeneLock.size());

    }

    public static ArrayList<String> calcularCerraduraKleene(ArrayList<String> lenguage,int words) {
        ArrayList<String> result = new ArrayList<>();

        if(words == 0){
            result.add("");
        }
        else {
            result.addAll(lenguage);
            for (int i = 1; i < words; i++){
                ArrayList<String> temp = new ArrayList<>();
                for (String word: result) {
                    for (String originalWord: lenguage) {
                        temp.add(word + originalWord);
                    }
                }
                result = temp;
            }
        }
        return result;
    }
}
