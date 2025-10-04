package ru.zyuzyukov.kurs_3_java.servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.zyuzyukov.kurs_3_java.application.ApplicationContext;
import ru.zyuzyukov.kurs_3_java.db.entity.Vacancy;
import ru.zyuzyukov.kurs_3_java.db.service.BaseService;
import ru.zyuzyukov.kurs_3_java.dto.VacancyDto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet("/vacancy")
public class VacancyServlet extends HttpServlet {
    private final String index = "WEB-INF/views/vacancy.jsp";
    private BaseService<VacancyDto, Vacancy> service;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ApplicationContext context = (ApplicationContext) config.getServletContext().getAttribute("appContext");
        service = context.getVacancyService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<VacancyDto> vacancies = service.findAll();
        req.setAttribute("vacancies", vacancies);
        req.getRequestDispatcher(index).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String post = req.getParameter("post");
        String description = req.getParameter("description");
        Integer salary = Integer.valueOf(req.getParameter("salary"));
        UUID employerId = UUID.fromString(req.getParameter("employerId"));

        switch (action) {
            case "add":
                service.save(new VacancyDto(UUID.randomUUID(), employerId, salary, description, post, true));
                break;
            case "update":
                UUID id = UUID.fromString(req.getParameter("id"));
                service.update(new VacancyDto(id, employerId, salary, description, post, true));
                break;
            case "delete":
                UUID idDelete = UUID.fromString(req.getParameter("id"));
                service.delete(idDelete);
                break;
        }

        resp.sendRedirect(req.getContextPath() + "/vacancy");
    }
}
