package cz.luzoubek.miniserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {
    public static final String SUCCESS_MESSAGE = "Success";
    
    private String responseMessage;
    private ResponseData data;

    public Response(String message) {
        this.responseMessage = message;
    }
}
