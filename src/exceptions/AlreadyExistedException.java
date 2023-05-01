package exceptions;

public class AlreadyExistedException extends RuntimeException{

    // Já existe um usuário com o mesmo login inserido.


    public AlreadyExistedException(String message) {
        super("Já existe alguém com esse usuário.");
    }
}
