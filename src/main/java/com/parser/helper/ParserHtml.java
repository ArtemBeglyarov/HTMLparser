package com.parser.helper;

import com.parser.entity.UniqueWordStatistics;
import com.parser.entity.Url;
import com.parser.repository.UniqueWordStatisticsRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ParserHtml {
    @Getter
    @Setter
    private String urlForParse;
    Map<String, Integer> uniqueWords = new HashMap<>();

    private final UniqueWordStatisticsRepository uniqueWordStatisticsRepository;
    private  List<UniqueWordStatistics> uniqueWordStatisticsList;


    //    @Autowired
//    Repository repository;
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

    public List<UniqueWordStatistics> outputSortedUniqueWords(Url url) {
        sortByValue(uniqueWords).forEach((key, value) -> System.out.println(value + " " + key));

        uniqueWordStatisticsList = sortByValue(uniqueWords).entrySet()
                .stream().map(entry -> UniqueWordStatistics.builder()
                        .word(entry.getKey())
                        .count(entry.getValue()).url(url).build()).collect(Collectors.toList());

        System.out.println();
//        repository.add(uniqueWordStatisticsList)
        uniqueWordStatisticsRepository.saveAll(uniqueWordStatisticsList);
        return uniqueWordStatisticsList;
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue
            (Map<K, V> map) {

        return map.entrySet()
                .stream()
                .sorted(Map.Entry.<K, V>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }
}
