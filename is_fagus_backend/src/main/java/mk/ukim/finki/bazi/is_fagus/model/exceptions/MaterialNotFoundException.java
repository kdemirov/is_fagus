package mk.ukim.finki.bazi.is_fagus.model.exceptions;

public class MaterialNotFoundException extends RuntimeException {

    public MaterialNotFoundException(Long id){
        super(String.format("Material with id %d does not exist",id));
    }
}
