package com.jcastaneda.main;

import java.util.ArrayList;

public class CerraduraKleene {
    public static void main(String[] args) {

    }

    public static ArrayList<String> cerraduraKleene(ArrayList<String> lenguage,int words) {
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
