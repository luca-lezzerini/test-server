package al.polis.appserver.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LongIdDto {

    private Long id;

    public LongIdDto() {
    }

    public LongIdDto(Long id) {
        this.id = id;
    }

}
