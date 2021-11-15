package com.parser.Controller;

import com.parser.dto.ServiceUrl;
import com.parser.entity.Url;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("parser")
@RequiredArgsConstructor
public class UrlController {


    private final ServiceUrl serviceUrl;

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Url addUrl(@RequestBody Url urlRequest) {
        return serviceUrl.createUrlFromRequestUrl(urlRequest);
    }

    @GetMapping("/getAllUrl")
    public String getAll() {
        System.out.println(serviceUrl.getAllUrl());
        return serviceUrl.getAllUrl();
    }

    @GetMapping("/getUrl/{id}")
    public Url getUrl(@PathVariable Long id) {
        return serviceUrl.getUrl(id);
    }

    @DeleteMapping("/deleteUrl/{id}")
    public void deleteUrl(@PathVariable("id") Long id) {
        serviceUrl.deleteUrl(id);
    }
}

