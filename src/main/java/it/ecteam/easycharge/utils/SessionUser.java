package it.ecteam.easycharge.utils;

import it.ecteam.easycharge.bean.UserBean;

public class SessionUser {

    private static UserBean userSession;

    private SessionUser() {
        //constructor
    }

    public static void setSession(UserBean userSession) {
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
