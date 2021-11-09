package com.parser.Controller;

import com.parser.dto.UrlDTO;
import com.parser.entity.Url;
import com.parser.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("parser")
@RequiredArgsConstructor
public class UrlController {

  private  final UrlRepository repository;
    private final UrlDTO urlDTO;

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addUrl(@RequestBody Url urlRequest) {
        urlDTO.createUrlFromRequestUrl(urlRequest);
    }

    @GetMapping("/get")
    public List<Url> getAll() {
        return repository.findAll();
    }

}

