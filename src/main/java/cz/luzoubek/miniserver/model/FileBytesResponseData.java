package cz.luzoubek.miniserver.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class FileBytesResponseData extends ResponseData {

    private String hex;
    private String base64;
    private String ascii;
    private int numberOfBytes;
}
