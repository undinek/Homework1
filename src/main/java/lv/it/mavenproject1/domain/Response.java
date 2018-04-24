package lv.it.mavenproject1.domain;

public class Response {

    private String message;

    public Response() {
    }

    public Response(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String setMessage() {
        return this.message;
    }

}