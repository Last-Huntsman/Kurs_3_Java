package ru.zyuzyukov.kurs_3_java.servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.zyuzyukov.kurs_3_java.application.ApplicationContext;
import ru.zyuzyukov.kurs_3_java.db.entity.Employment;
import ru.zyuzyukov.kurs_3_java.db.service.BaseService;
import ru.zyuzyukov.kurs_3_java.dto.EmploymentDto;
import ru.zyuzyukov.kurs_3_java.mapper.EmploymentMapper;
import ru.zyuzyukov.kurs_3_java.mapper.VacancyMapper;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@WebServlet("/employment")

public class EmploymentServlet extends HttpServlet {
    private final String index = "WEB-INF/views/employment.jsp";
    private BaseService<EmploymentDto, Employment> service;
    private EmploymentMapper mapper;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ApplicationContext context =
                (ApplicationContext) config.getServletContext().getAttribute("appContext");
        service = context.getEmploymentService();
        mapper = context.getEmploymentMapper();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        List<EmploymentDto> employmentDtos = service.findAll();
        req.setAttribute("employments", employmentDtos);
        req.getRequestDispatcher(index).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        switch (action) {
            case "add" -> {
                UUID workerId = UUID.fromString(req.getParameter("workerId"));
                UUID vacancyId = UUID.fromString(req.getParameter("vacancyId"));
                service.save(mapper.createDto(UUID.randomUUID(), workerId, vacancyId, LocalDate.now(), null));
            }
            case "open" -> {
                UUID id = UUID.fromString(req.getParameter("id"));
                UUID workerId = UUID.fromString(req.getParameter("workerId"));
                UUID vacancyId = UUID.fromString(req.getParameter("vacancyId"));
                service.update(mapper.createDto(id, workerId, vacancyId, LocalDate.now(), null));
            }
            case "close" -> {
                UUID id = UUID.fromString(req.getParameter("id"));
                UUID workerId = UUID.fromString(req.getParameter("workerId"));
                UUID vacancyId = UUID.fromString(req.getParameter("vacancyId"));
                LocalDate dateOpen = LocalDate.parse(req.getParameter("date_open"));
                service.update(mapper.createDto(id, workerId, vacancyId, dateOpen, LocalDate.now()));
            }
            case "delete" -> {
                UUID id = UUID.fromString(req.getParameter("id"));
                service.delete(id);
            }
        }

        resp.sendRedirect(req.getContextPath() + "/employment");
    }


}
