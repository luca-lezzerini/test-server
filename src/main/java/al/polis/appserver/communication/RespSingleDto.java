package al.polis.appserver.communication;

import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class RespSingleDto<T> extends ResponseWithStatusDto {

    private T data;

    public RespSingleDto() {
    }

    public RespSingleDto(T data) {
        this.data = data;
        setStatus(Collections.emptyList());
    }

    public RespSingleDto(T data, List<ServerStatus> lista) {
        this.data = data;
        setStatus(lista);
    }

    public RespSingleDto(List<ServerStatus> lista) {
        setStatus(lista);
    }

}
