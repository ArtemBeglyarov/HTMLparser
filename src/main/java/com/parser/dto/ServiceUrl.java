package com.parser.dto;

import com.parser.entity.Url;
import com.parser.helper.ParserHtml;
import com.parser.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceUrl {

    private final UrlRepository urlRepository;

    private final ParserHtml parserHtml;

    public void createUrlFromRequestUrl(Url urlRequest) {
        Url url = new Url();
        url.setUrl(urlRequest.getUrl());
        urlRepository.save(url);
        parserHtml.setUrlForParse(url.getUrl());
        parserHtml.splitString(parserHtml.getTextFromPage());
        parserHtml.outputSortedUniqueWords(url);
    }

    public Url getUrl(Long id) {
       return urlRepository.getById(id);
    }
    public void deleteUrl(Long id) {
        urlRepository.deleteById(id);
    }
    public String getAllUrl() {
       return urlRepository.findAll().toString();
    }
}
