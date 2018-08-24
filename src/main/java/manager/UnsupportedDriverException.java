package manager;

import java.io.Serializable;

public class UnsupportedDriverException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = -1468109695483543144L;

    public UnsupportedDriverException() {
        super();
    }

    public UnsupportedDriverException(String message) {
        super(message);
    }

    public UnsupportedDriverException(String message, Throwable cause) {
        super(message, cause);
    }

}
