package factory.interfaces;

import data.Letter;
import data.User;

import java.io.File;

public interface InboxMail {
    Letter openLetterBySubject(User user, String subject);

    void saveAttachedFile(Letter letter);
}
