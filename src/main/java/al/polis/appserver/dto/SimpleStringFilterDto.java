package al.polis.appserver.dto;

import al.polis.appserver.communication.Pagination;
import lombok.Data;

@Data
public class SimpleStringFilterDto {
    private String filter;
    private Pagination pagination;
}
