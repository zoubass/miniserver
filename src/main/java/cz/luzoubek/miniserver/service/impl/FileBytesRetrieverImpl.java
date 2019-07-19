package cz.luzoubek.miniserver.service.impl;

import static cz.luzoubek.miniserver.model.Response.SUCCESS_MESSAGE;

import cz.luzoubek.miniserver.model.FileBytesResponseData;
import cz.luzoubek.miniserver.model.Response;
import cz.luzoubek.miniserver.service.FileByteRetriever;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import org.apache.commons.codec.binary.Hex;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Service
public class FileBytesRetrieverImpl implements FileByteRetriever {

    private static final String ERROR_MESSAGE = "Cannot read the file, reason: %s";
    private static final String INDEX_OUT_OF_BOUNDS_MESSAGE = "Wanted number of bytes (%s) is higher than the file's byte array length";
    private static final String FILE_NAME = "Assignment.pdf";


    @Override
    public Response getBytesFromStaticFile(int numberOfBytes) {

        try (DataInputStream dataInputStream = new DataInputStream(new ClassPathResource(FILE_NAME).getInputStream())) {
            byte[] fileBytes = new byte[numberOfBytes];

            dataInputStream.readFully(fileBytes);
            String hex = Hex.encodeHexString(fileBytes);
            String base64 = Base64.getEncoder().encodeToString(fileBytes);
            String ascii = new String(fileBytes, StandardCharsets.UTF_8);

            FileBytesResponseData responseData = new FileBytesResponseData(hex, base64, ascii, numberOfBytes);
            return new Response(SUCCESS_MESSAGE, responseData);
        } catch (EOFException e) {
            return new Response(String.format(INDEX_OUT_OF_BOUNDS_MESSAGE, numberOfBytes));
        } catch (IOException e) {
            return new Response(String.format(ERROR_MESSAGE, e.getMessage()));
        }
    }
}
