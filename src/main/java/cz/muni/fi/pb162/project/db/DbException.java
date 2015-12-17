package cz.muni.fi.pb162.project.db;

/**
 * @author Filip Prochazka <433457@mail.muni.cz>
 */
public class DbException extends Exception {

    /**
     */
    public DbException() {
    }

    /**
     * @param message description
     */
    public DbException(String message) {
        super(message);
    }

    /**
     * @param cause previous exception
     */
    public DbException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message description
     * @param cause previous exception
     */
    public DbException(String message, Throwable cause) {
        super(message, cause);
    }

}
