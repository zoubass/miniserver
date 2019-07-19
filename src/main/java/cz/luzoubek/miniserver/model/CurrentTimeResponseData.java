package cz.luzoubek.miniserver.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CurrentTimeResponseData extends ResponseData {

    private long currentTimeInMillis;
}
