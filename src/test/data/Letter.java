package data;

public class Letter  {
    private User to;
    private User from;
    private String subject;
    private String message;
    private String file;

    public Letter(){
        to = new User("","");
        from = new User("","");
    }

    public Letter(User to, User from, String subject, String message){//todo maybe better builder
        this.to = to;
        this.from = from;
        this.subject = subject;
        this.message = message;
    }

    public User getTo() {
        return to;
    }

    public void setTo(User to) {
        this.to = to;
    }

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPathToAttachment() {
        return file;
    }

    public void setPathToAttachment(String pathToAttachment) {
        this.file = pathToAttachment;
    }
}
