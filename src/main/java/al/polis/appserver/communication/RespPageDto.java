package al.polis.appserver.communication;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@NoArgsConstructor
public class RespPageDto<T> extends ResponseWithStatusDto {

    private Page<T> page;

    public RespPageDto(Page<T> page, List<ServerStatus> status) {
        this.page = page;
    }

}
