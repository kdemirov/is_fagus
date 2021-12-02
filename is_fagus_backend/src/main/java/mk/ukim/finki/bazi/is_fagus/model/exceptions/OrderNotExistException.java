package mk.ukim.finki.bazi.is_fagus.model.exceptions;

public class OrderNotExistException extends RuntimeException {

    public OrderNotExistException(Long id){
        super(String.format("Order with id %d does not exist",id));
    }
}
