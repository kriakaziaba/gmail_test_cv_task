package data;

public class Letter  {
    public User to;
    public User from;
    public String subject;
    public String message;

    public Letter(){
        to = new User("","");
        from = new User("","");
    }
}
