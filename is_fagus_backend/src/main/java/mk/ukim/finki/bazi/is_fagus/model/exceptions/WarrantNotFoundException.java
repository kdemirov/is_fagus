package mk.ukim.finki.bazi.is_fagus.model.exceptions;

public class WarrantNotFoundException extends RuntimeException{
    public WarrantNotFoundException(Long id){
        super(String.format("Warrant with id %d does not exist",id));
    }
}
