package cz.muni.fi.pb162.project.db;

/**
 * @author Filip Prochazka <433457@mail.muni.cz>
 */
public class CannotStoreException extends DbException {

    /**
     */
    public CannotStoreException() {
    }

    /**
     * @param message description
     */
    public CannotStoreException(String message) {
        super(message);
    }

    /**
     * @param cause previous exception
     */
    public CannotStoreException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message description
     * @param cause previous exception
     */
    public CannotStoreException(String message, Throwable cause) {
        super(message, cause);
    }

}
