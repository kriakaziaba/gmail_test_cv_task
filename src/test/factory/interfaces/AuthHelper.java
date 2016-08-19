package factory.interfaces;

import data.User;

public interface AuthHelper {
    void goToGmail();

    boolean loginAsPositive(User user);

    void logOut();

    void changeUser();
}
