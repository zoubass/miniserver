package cz.luzoubek.miniserver.controller;

import cz.luzoubek.miniserver.model.CrawlRequest;
import cz.luzoubek.miniserver.model.CurrentTimeResponseData;
import cz.luzoubek.miniserver.model.Response;
import cz.luzoubek.miniserver.service.FileByteRetriever;
import cz.luzoubek.miniserver.service.UrlCrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private static final String SUCCESS = "success";

    private FileByteRetriever fileByteRetriever;

    private UrlCrawler urlCrawler;

    @Autowired
    public RestController(FileByteRetriever fileByteRetriever, UrlCrawler urlCrawler) {
        this.fileByteRetriever = fileByteRetriever;
        this.urlCrawler = urlCrawler;
    }

    @GetMapping("/current_time")
    public Response currentTime() {
        return new Response(SUCCESS, new CurrentTimeResponseData(System.currentTimeMillis()));
    }

    @GetMapping("/retrieve_bytes/{numberOfBytes}")
    public Response retrieveBytes(@PathVariable int numberOfBytes) {
        return fileByteRetriever.getBytesFromStaticFile(numberOfBytes);
    }

    @GetMapping("/crawl")
    public Response crawlUrl(@RequestBody CrawlRequest request) {
        return urlCrawler.crawlUrl(request);
    }

    @ExceptionHandler(Exception.class)
    public Response catchException(Exception e) {
        return new Response("FAILED, reason:" + e.getMessage());
    }
}
