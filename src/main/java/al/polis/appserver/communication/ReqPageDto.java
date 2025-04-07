package al.polis.appserver.communication;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.domain.Pageable;

@Data
@ToString
public class ReqPageDto<T> {

    private Pagination pagination;
    private T data;

    public ReqPageDto() {
    }

    public ReqPageDto(T data, Pagination pagination) {
        this.pagination = pagination;
        this.data = data;
    }

    public ReqPageDto(Pagination pagination) {
        this.pagination = pagination;
    }

    public Pageable generatePageable() {
        if (pagination != null) {
            return pagination.toPageable();
        } else {
            return null;
        }
    }
}
