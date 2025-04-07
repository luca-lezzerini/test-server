package al.polis.appserver.communication;

import lombok.Getter;

@Getter
public enum ServerErrorEnum {

    OK("Success!",
            "",
            ErrorSeverityEnum.OK),
    DELETE_COURSE_NOT_ALLOWED("The course has relationships and cannot be deleted.",
            "Remove relationships to delete the course",
            ErrorSeverityEnum.ERROR);

    private final String message;
    private final String action;
    private final ErrorSeverityEnum severity;

    private ServerErrorEnum(String message, String action, ErrorSeverityEnum severity) {
        this.message = message;
        this.action = action;
        this.severity = severity;
    }

}
