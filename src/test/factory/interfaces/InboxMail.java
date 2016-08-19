package factory.interfaces;

import data.Letter;
import data.User;

public interface InboxMail {
    Letter openLetterBySubject(User user, String subject);

    String saveAttachedFile(Letter letter, User user);
}
