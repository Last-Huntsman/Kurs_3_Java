package ru.zyuzyukov.kurs_3_java.servlets;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.annotation.WebListener;
import ru.zyuzyukov.kurs_3_java.application.ApplicationContext;

@WebListener
public class ServletContextListener implements jakarta.servlet.ServletContextListener {
        ApplicationContext appContext;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        appContext = new ApplicationContext();
        sce.getServletContext().setAttribute("appContext", appContext);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
