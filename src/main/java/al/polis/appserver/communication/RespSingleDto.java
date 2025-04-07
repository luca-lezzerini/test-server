package al.polis.appserver.communication;

import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class RespSingleDto<T> extends RispostaConStatusDto {

    private T data;

    public RespSingleDto() {
    }

    public RespSingleDto(T data) {
        this.data = data;
        setStatus(Collections.emptyList());
    }

    public RespSingleDto(T data, List<MetadatoStatus> lista) {
        this.data = data;
        setStatus(lista);
    }

    public RespSingleDto(List<MetadatoStatus> lista) {
        setStatus(lista);
    }

    public RespSingleDto(T data, List<MetadatoStatus> lista, List<MetadatoStatusApplicativo> appMessage) {
        this.data = data;
        setStatus(lista);
        setStatusApplicativo(appMessage);
    }

    public RespSingleDto(List<MetadatoStatus> lista, List<MetadatoStatusApplicativo> appMessage) {
        setStatus(lista);
        setStatusApplicativo(appMessage);
    }

}
