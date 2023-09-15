package it.ecteam.easycharge.utils;

import it.ecteam.easycharge.bean.UserBean;

public class SessionUser {

    private static UserBean userSession;

    public SessionUser() {}

    public static void setSession(UserBean userSession) {
        if (this.userSession == null) {
            this.userSession = userSession;
        }
    }

    public static UserBean getSession() {
        return userSession;
    }

    public static void closeSession() {
        userSession = null;
    }
}
