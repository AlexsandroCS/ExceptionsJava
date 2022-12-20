package model.exceptions;

// Exception = Programa vai parar com alguma exceção.
// RuntimeException = Programa vai continuar mesmo com exceções.
public class DomainException extends Exception{
    private static final long serialVersionUID = 1L;

    public DomainException(String msg){
        super(msg);
    }
}
