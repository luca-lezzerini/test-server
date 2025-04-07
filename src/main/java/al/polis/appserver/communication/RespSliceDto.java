package al.polis.appserver.communication;

import lombok.Data;
import org.springframework.data.domain.Slice;

import java.util.Collections;
import java.util.List;

@Data
public class RespSliceDto<T> extends RispostaConStatusDto {
    
    private Slice<T> slice;
    
    public RespSliceDto(Slice<T> slice) {
        this.slice = slice;
        setStatus(Collections.emptyList());
    }
    public RespSliceDto(Slice<T> slice, List<MetadatoStatus> status) {
        this.slice = slice;
        setStatus(status);
    }
}
