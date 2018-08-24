package manager;

import java.io.Serializable;

public class PropertiesNotFoundException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = -1468109695483543148L;

    public PropertiesNotFoundException() {
        super();
    }

    public PropertiesNotFoundException(String message) {
        super(message);
    }

    public PropertiesNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
