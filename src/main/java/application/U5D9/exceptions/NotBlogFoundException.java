package application.U5D9.exceptions;

public class NotBlogFoundException extends RuntimeException {
    public NotBlogFoundException(int id){
        super("il blog con id " + id + " non è stato trovato");}
    }
