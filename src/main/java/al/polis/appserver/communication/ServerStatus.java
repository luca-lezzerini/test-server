package al.polis.appserver.communication;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;

@Data
@Slf4j
public class ServerStatus {

    private Integer code;
    private Integer severity;
    private String message;
    private String action;
    private String helpReference;
    private String traceId = "Java - Trace ID Not Available";

    public ServerStatus(Integer code, Integer severity, String message, String action) {
        this.code = code;
        this.severity = severity;
        this.message = message;
        this.action = action;
        helpReference = "";
        populateTraceId();
    }

    private void populateTraceId() {
        traceId = Long.toHexString(Instant.now().toEpochMilli());
    }

    public ServerStatus(Integer code, Integer severity, String message, String action, String helpReference) {
        this.code = code;
        this.severity = severity;
        this.message = message;
        this.action = action;
        this.helpReference = helpReference;
        populateTraceId();
    }

    public ServerStatus(ServerErrorEnum error) {
        this.severity = error.getSeverity().getCode();
        this.message = error.getMessage();
        this.action = error.getAction();
        populateTraceId();
    }

    public static ServerStatus createUnknownError() {
        return new ServerStatus(-1, 5, "Unknown error", "Contact technical support", "");
    }

    public static ServerStatus createNoError() {
        return new ServerStatus(0, 0, "Ok", "", "");
    }
    
}
