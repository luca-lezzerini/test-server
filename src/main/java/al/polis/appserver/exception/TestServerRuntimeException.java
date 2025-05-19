package al.polis.appserver.exception;

public class TestServerRuntimeException extends RuntimeException {
    public TestServerRuntimeException() {
    }

    public TestServerRuntimeException(String message) {
        super(message);
    }

    public TestServerRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public TestServerRuntimeException(Throwable cause) {
        super(cause);
    }

    public TestServerRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
