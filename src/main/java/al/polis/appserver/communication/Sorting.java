package al.polis.appserver.communication;

import lombok.Data;

@Data
public class Sorting {

    private String field;
    private String direction;
    private Boolean ignoreCase;
    private String nullHandling;
}
