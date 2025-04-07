package al.polis.appserver.communication;

public enum ErrorSeverityEnum {
    OK(0),
    INFO(1),
    WARNING(2),
    ERROR(3),
    FATAL(4);

    private int code;

    private ErrorSeverityEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
