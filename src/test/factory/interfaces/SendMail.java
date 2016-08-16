package test.factory.interfaces;

import java.io.File;

public interface SendMail {
    public void sendMail(String to, String subject, String messageBody);
    public void sendMailWithFile(String to, String subject, String messageBody, File file);
}
