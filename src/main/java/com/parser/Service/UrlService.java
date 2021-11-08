package com.parser.Service;

import com.parser.entity.Url;
import com.parser.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UrlService {

    private final UrlRepository urlRepository;

    public Url createUrl(Url url) {
         return  urlRepository.save(url);
    }
    public Url findUrl(Long ID) {
        return urlRepository.getById(ID);
    }
    public void updateUrl(Url url) {
        urlRepository.save(url);
    }
    public void deleteUrl(Long ID) {
        urlRepository.deleteById(ID);
    }
    public List<Url> getAllUrl() {
        return urlRepository.findAll();
    }
}
