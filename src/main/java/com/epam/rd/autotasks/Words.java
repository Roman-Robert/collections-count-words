package com.epam.rd.autotasks;


import java.util.*;

public class Words {

    public String countWords(List<String> lines) throws UnsupportedOperationException {
        //throw new UnsupportedOperationException();

        ArrayList<String> wordsList = new ArrayList<>();

        // получаем список слов длиннее 4 символов
        for (String str : lines) {

            String[] wordsArray = str.toLowerCase().replaceAll("[.,]", "").split(" ");

            for (String word : wordsArray) {
                if (word.length() >= 4) wordsList.add(word);
            }
        }

        //считаем количество повторений каждого слова(нужны слова ≥10 раз)
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < wordsList.size(); i++) {

            int counter = 0;

            String checkWord = wordsList.get(i);

            for (String word : wordsList) {
                if (word.equals(checkWord)) {
                    counter++;
                }
            }

            if (counter >= 10) {
                map.put(checkWord, counter);
            }
        }


        //сортировка map
        List<Map.Entry<String, Integer>> listOfValues = new LinkedList<>(map.entrySet());

        listOfValues.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return -o1.getValue().compareTo(o2.getValue());
            }
        });

        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : listOfValues) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        

        return sortedMap.toString().replaceAll("=", " - ")
                                .replaceAll(", ", "\n")
                                .replaceAll("[{}]","");
    }
}