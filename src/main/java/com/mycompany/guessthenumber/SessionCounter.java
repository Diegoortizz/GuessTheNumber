package com.mycompany.guessthenumber;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionCounter implements HttpSessionListener {

    private int numberOfUsers = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("add");
        numberOfUsers++;
        se.getSession().getServletContext().setAttribute("numberConnected", numberOfUsers);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("del");
        numberOfUsers--;
        se.getSession().getServletContext().setAttribute("numberConnected", numberOfUsers);
    }

}
