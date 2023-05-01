package exceptions;

public class InvalidLoginException extends RuntimeException {

    //O username ou password digitado pelo usuário está incorreto.

    public InvalidLoginException() {
        super("Login inválido.");
    }
}
