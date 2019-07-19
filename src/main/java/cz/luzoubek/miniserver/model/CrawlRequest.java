package cz.luzoubek.miniserver.model;

import lombok.Data;

@Data
public class CrawlRequest {

    private String url;
    private int depth;
}
