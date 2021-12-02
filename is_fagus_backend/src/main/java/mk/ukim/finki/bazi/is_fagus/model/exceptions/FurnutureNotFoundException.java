package mk.ukim.finki.bazi.is_fagus.model.exceptions;

public class FurnutureNotFoundException  extends RuntimeException{

    public FurnutureNotFoundException(Long id){
        super(String.format("Furniture with id %d was not found",id));
    }
}
