package Exceptions;

public class BookReturnDueExpiredException extends RuntimeException{
    public BookReturnDueExpiredException() {
        System.out.println("Return date has passed due date");
    }
}
