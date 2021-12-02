package mk.ukim.finki.bazi.is_fagus.model.exceptions;

public class FurniturePartDoesNotExistException extends RuntimeException {

    public FurniturePartDoesNotExistException(Long id){
        super(String.format("Furniture part with id %d does not exist",id));
    }
}
