package test.factory.interfaces;

import test.data.Letter;

import java.io.File;

public interface SendMail {
    void sendMail(Letter letter);
    void sendMail(Letter letter, File file);
}
