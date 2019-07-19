package cz.luzoubek.miniserver.service;

import cz.luzoubek.miniserver.model.Response;

public interface FileByteRetriever {

    Response getBytesFromStaticFile(int numberOfBytes);

}
