package com.epam.rd.autotasks;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Words {

/*
    public static void main(String[] args) {
        String string1 = " Roma Roma roma Roma Roma Roma Roma Roma Roma Roma Roma roMA";
        String string2 = " One1 one1 one1 one1 one1 one1 one1 one1 one1 one1 one1 one1 oNe1";
        List<String> list = new ArrayList<>();
        list.add(string1);
        list.add(string2);

        System.out.println(countWords(list));
    }
*/

    public String countWords(List<String> lines) { //убрать статик
        //throw new UnsupportedOperationException();
        ArrayList<String> wordsList = new ArrayList<>();
        String separator = " ";

        // получаем список слов длиннее 4 символов
        for (String str : lines) {

            String[] wordsArray = str.split(separator);

            for (String word : wordsArray) {
                if (word.length() >= 4) wordsList.add(word);
            }
        }

        //посчитать количество повторений каждого слова(нужны слова ≥10 раз)
        HashSet<String> result = new HashSet<>();

        for (int i = 0; i < wordsList.size(); i++) {

            int counter = 0;
            String checkWord = wordsList.get(i);

            for (String word : wordsList) {
                if (word.equals(checkWord)) {
                    counter++;
                }
            }

            if (counter >= 10) {
                result.add(String.format("%s - %d", checkWord, counter));
            }
        }

        return result.toString();
    }
}
