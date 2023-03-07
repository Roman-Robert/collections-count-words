package com.epam.rd.autotasks;


import java.util.*;

public class Words {

    public String countWords(List<String> lines) throws UnsupportedOperationException {
        //throw new UnsupportedOperationException();

        ArrayList<String> wordsList = new ArrayList<>();

        // получаем список слов длиннее 4 символов
        for (String str : lines) {

            String[] wordsArray = str.replaceAll("[.,]", "").split(" ");

            for (String word : wordsArray) {
                if (word.length() >= 4) wordsList.add(word);
            }
        }

        //считаем количество повторений каждого слова(нужны слова ≥10 раз)
        HashMap<String, Integer> result = new HashMap<>();

        for (int i = 0; i < wordsList.size(); i++) {

            int counter = 0;

            String checkWord = wordsList.get(i);

            for (String word : wordsList) {
                if (word.equals(checkWord)) {
                    counter++;
                }
            }

            if (counter >= 10) {
                result.put(checkWord, counter);
                //result.add(String.format("%s - %d", checkWord, counter));
            }
        }

        return result.toString().replaceAll("=", " - ")
                                .replaceAll(", ", "\n")
                                .replaceAll("[{}]","");
    }
}