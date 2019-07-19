package cz.luzoubek.miniserver.service;

import cz.luzoubek.miniserver.model.CrawlRequest;
import cz.luzoubek.miniserver.model.Response;

public interface UrlCrawler {

    Response crawlUrl(CrawlRequest url);
}
