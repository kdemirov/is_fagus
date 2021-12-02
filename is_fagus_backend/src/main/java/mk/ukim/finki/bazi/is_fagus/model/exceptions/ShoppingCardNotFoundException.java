package mk.ukim.finki.bazi.is_fagus.model.exceptions;

public class ShoppingCardNotFoundException extends RuntimeException{

    public ShoppingCardNotFoundException(Long id){
        super(String.format("Shopping cart with id %d was not found",id));
    }
}
