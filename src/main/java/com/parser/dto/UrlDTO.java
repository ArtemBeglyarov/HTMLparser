package com.parser.dto;

import com.parser.entity.Url;
import com.parser.helper.ParserHtml;
import com.parser.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UrlDTO {

    private final UrlRepository urlRepository;
    ParserHtml parserHtml = new ParserHtml();

    public Url createUrlFromRequestUrl(Url urlRequest) {
        Url url = new Url();
        url.setUrl(urlRequest.getUrl());
        parserHtml.setUrlForParse(url.getUrl());
        parserHtml.splitString(parserHtml.getTextFromPage());
        parserHtml.outputSortedUniqueWords(url);
        return urlRepository.save(url);
    }
//        private List<UniqueWordStatistics> uniqueWordStatistics() {
//
//        }
}
