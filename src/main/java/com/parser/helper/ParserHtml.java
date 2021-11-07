package com.parser.helper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ParserHtml {

    private String urlForParse;
    private Map<String, Integer> uniqueWords = new HashMap<>();

    public ParserHtml(String urlForParse) {
        this.urlForParse = urlForParse;
    }

    public String getTextFromPage() {

        String textFromPage = null;

        try {
            Document doc = Jsoup.connect(urlForParse).get();
            textFromPage = doc.text();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return textFromPage;
    }

    public void splitString(String string) {
        String[] s = string.split(Delimiter.DELIMITERS);
        for (String we : s) {
            if (uniqueWords.containsKey(we)) {
                int f = uniqueWords.get(we) + 1;
                uniqueWords.put(we, f);
            } else {
                uniqueWords.put(we, 1);
            }
        }
    }

    public void outputSortedUniqueWords() {
        sortByValue(uniqueWords).forEach((key, value) -> System.out.println(value + " " + key));
    }
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue
            (Map<K, V> map) {

        return map.entrySet()
                .stream()
                .sorted(Map.Entry.<K, V> comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }
}
