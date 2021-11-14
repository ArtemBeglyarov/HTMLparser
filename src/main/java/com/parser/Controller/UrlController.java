package com.parser.Controller;

import com.parser.dto.ServiceUrl;
import com.parser.entity.Url;
import com.parser.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("parser")
@RequiredArgsConstructor
public class UrlController {

    private final UrlRepository repository;
    private final ServiceUrl serviceUrl;

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addUrl(@RequestBody Url urlRequest) {
        serviceUrl.createUrlFromRequestUrl(urlRequest);
    }

    @GetMapping("/getAllUrl")
    public String getAll() {
        System.out.println(serviceUrl.getAllUrl());
        return serviceUrl.getAllUrl();
    }

    @GetMapping("/getUrl{id}")
    public Optional<Url> getUrl(@PathVariable String id) {
        Optional<Url> url = repository.findById(Long.parseLong(id));
        return url;
    }

    @DeleteMapping("/deleteUrl{id}")
    public void deleteUrl(@PathVariable String id) {
        serviceUrl.deleteUrl();
    }
}

