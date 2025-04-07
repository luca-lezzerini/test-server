package al.polis.appserver.communication;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ResponseWithStatusDto {

    private List<ServerStatus> status = new ArrayList<>();

}
