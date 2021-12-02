package mk.ukim.finki.bazi.is_fagus.model.exceptions;

public class NotAuthenticatedException extends RuntimeException {

    public NotAuthenticatedException(){
        super("Please login");
    }
}
