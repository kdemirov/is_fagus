package mk.ukim.finki.bazi.is_fagus.model.exceptions;

public class ManagerNotFoundException extends RuntimeException {

    public ManagerNotFoundException(Long id){
        super(String.format("Manager with id %d does not exist",id));
    }
}
