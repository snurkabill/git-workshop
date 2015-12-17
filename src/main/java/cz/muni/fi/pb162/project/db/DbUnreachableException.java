package cz.muni.fi.pb162.project.db;

/**
 * @author Filip Prochazka <433457@mail.muni.cz>
 */
public class DbUnreachableException extends DbException {

    /**
     */
    public DbUnreachableException() {
    }

    /**
     * @param message description
     */
    public DbUnreachableException(String message) {
        super(message);
    }

    /**
     * @param cause previous exception
     */
    public DbUnreachableException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message description
     * @param cause previous exception
     */
    public DbUnreachableException(String message, Throwable cause) {
        super(message, cause);
    }
}
