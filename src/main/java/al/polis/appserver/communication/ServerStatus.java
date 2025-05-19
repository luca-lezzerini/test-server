package al.polis.appserver.communication;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;

@Data
@Slf4j
public class ServerStatus {

    private ServerErrorEnum code;
    private ErrorSeverityEnum severity;
    private String message;
    private String action;
    private String helpReference;
    private String traceId = "Java - Trace ID Not Available";

    public ServerStatus(ServerErrorEnum code, ErrorSeverityEnum severity, String message, String action) {
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

    public ServerStatus(ServerErrorEnum code, ErrorSeverityEnum severity, String message, String action, String helpReference) {
        this.code = code;
        this.severity = severity;
        this.message = message;
        this.action = action;
        this.helpReference = helpReference;
        populateTraceId();
    }

    public ServerStatus(ServerErrorEnum error) {
        this.severity = error.getSeverity();
        this.message = error.getMessage();
        this.action = error.getAction();
        populateTraceId();
    }

    public static ServerStatus createUnknownError() {
        return new ServerStatus(ServerErrorEnum.UNKNOWN_ERROR);
    }

    public static ServerStatus createNoError() {
        return new ServerStatus(ServerErrorEnum.OK);
    }
    
}
