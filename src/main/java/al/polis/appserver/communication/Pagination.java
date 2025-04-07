package al.polis.appserver.communication;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Data
@ToString
@Slf4j
public class Pagination {

    private int pageNumber;
    private int pageSize;
    private Sorting[] sort;

    public Pagination() {
    }

    public Pagination(int pageNumber, int pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    public Pagination(int pageNumber, int pageSize, Sorting[] sort) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.sort = sort;
    }

    // TODO: implementare generazione Sort
    public Sort toSort() {
        throw new UnsupportedOperationException("La generazione del Sort non è ancora stata implementata");
    }

    public Pageable toPageable() {
//        log.debug("PageNumber = " + pageNumber + "; PageSize = " + pageSize);
        Pageable pag = PageRequest.of(pageNumber, pageSize);
        return pag;
    }
}
