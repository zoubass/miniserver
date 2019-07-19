package cz.luzoubek.miniserver.service.impl;

import static cz.luzoubek.miniserver.model.Response.SUCCESS_MESSAGE;

import cz.luzoubek.miniserver.model.CrawlRequest;
import cz.luzoubek.miniserver.model.CrawledPage;
import cz.luzoubek.miniserver.model.Response;
import cz.luzoubek.miniserver.service.UrlCrawler;
import java.io.IOException;
import java.net.UnknownHostException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

@Service
public class UrlCrawlerImpl implements UrlCrawler {

    private static final String ERROR_MESSAGE = "Failed to crawl URL %s, reason: %s";

    @Override
    public Response crawlUrl(CrawlRequest request) {
        try {
            Document document = Jsoup.connect(request.getUrl()).get();
            return new Response(SUCCESS_MESSAGE, new CrawledPage(document.toString()));
        } catch (UnknownHostException e) {
            return new Response(String.format(ERROR_MESSAGE, request.getUrl(), "Unknown host: " + e.getMessage()));
        } catch (IOException e) {
            return new Response(String.format(ERROR_MESSAGE, request.getUrl(), e.getMessage()));
        }
    }
}
