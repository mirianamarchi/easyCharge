package it.ecteam.easycharge.utils;

import it.ecteam.easycharge.bean.UserBean;

public class SessionUser {

    private static UserBean userSession;

    public SessionUser() {
        //constructor
    }

    public void setSession(UserBean userSession) {
        if (SessionUser.userSession == null) {
            SessionUser.userSession = userSession;
        }
    }

    public static UserBean getSession() {
        return userSession;
    }

    public static void closeSession() {
        userSession = null;
    }
}
