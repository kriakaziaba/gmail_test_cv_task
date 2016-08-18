package factory.interfaces;

import data.Letter;

public interface SendMail {
    void sendMail(Letter letter);
    void sendMail(Letter letter, String fileName);
}
