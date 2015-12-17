package cz.muni.fi.pb162.project.db;

import java.io.IOException;
import java.net.NoRouteToHostException;
import java.net.UnknownHostException;

/**
 * @author Filip Prochazka <433457@mail.muni.cz>
 */
public class MyStorage implements Storage {
    private final Connector connector;
    private final int maxAttempts;

    /**
     * @param connector   the Connector implementation
     * @param maxAttempts max attempts for storing the data
     * @throws NullPointerException
     * @throws IllegalArgumentException
     */
    public MyStorage(Connector connector, int maxAttempts) {
        if (connector == null) {
            throw new NullPointerException("connector is a null");
        }

        if (maxAttempts < 1) {
            throw new IllegalArgumentException("maxAttempts must be at least 1");
        }

        this.connector = connector;
        this.maxAttempts = maxAttempts;
    }

    @Override
    public void store(String host, Object data) throws DbUnreachableException, CannotStoreException {
        Connection connection;

        try {
            connection = connector.getConnection(host);
        } catch (UnknownHostException | NoRouteToHostException e) {
            throw new DbUnreachableException("Host " + host + " cannot be reached", e);
        }

        int remaining = maxAttempts;
        do {
            try {
                connection.sendData(data);
                break;

            } catch (IOException e) {
                if (--remaining == 0) {
                    throw new CannotStoreException("Unable to store data to host " + host, e);
                }
            }

        } while (true);
    }
}
