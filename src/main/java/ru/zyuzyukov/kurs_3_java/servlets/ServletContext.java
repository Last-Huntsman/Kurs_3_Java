package ru.zyuzyukov.kurs_3_java.servlets;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import ru.zyuzyukov.kurs_3_java.dto.EmployerDto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@WebListener
public class ServletContext implements ServletContextListener {
    List<EmployerDto> employers;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        employers = new ArrayList<>();
        employers.add(new EmployerDto(UUID.randomUUID(), "egor"));
        employers.add(new EmployerDto(UUID.randomUUID(), "egor1"));
        sce.getServletContext().setAttribute("employers", employers);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        employers = null;
    }
}
