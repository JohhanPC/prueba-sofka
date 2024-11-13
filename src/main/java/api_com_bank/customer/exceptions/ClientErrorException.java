package api_com_bank.customer.exceptions;

public class ClientErrorException extends RuntimeException{

    public ClientErrorException(String message) {
        super(message);
    }

    public ClientErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
