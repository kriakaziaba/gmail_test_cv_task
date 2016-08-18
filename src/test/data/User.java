package data;

/**
 * Created by DiR on 17.08.2016.
 */
public class User {
    public User(String mail, String password){
        this.mail = mail;
        this.password = password;
    }
    private String mail;
    private String password;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object user){
        User us = (User) user;
        return mail.equals(us.getMail());
    }
}
