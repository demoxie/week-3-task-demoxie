package Exceptions;

public class UnauthorivedUserException extends RuntimeException{
    public UnauthorivedUserException() {
        System.out.println("You're not authorized to use the library or borrow books");
    }
}
