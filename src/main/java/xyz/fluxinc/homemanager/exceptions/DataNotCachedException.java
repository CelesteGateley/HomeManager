package xyz.fluxinc.homemanager.exceptions;

public class DataNotCachedException extends Exception {

    public DataNotCachedException(Exception e) {
        super(e);
    }

    public DataNotCachedException(String message) {
        super(message);
    }
}
