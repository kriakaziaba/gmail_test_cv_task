package factory.interfaces;

import data.Letter;

import java.io.File;

public interface SendMail {
    void sendMail(Letter letter);
    void sendMail(Letter letter, File file);
}
