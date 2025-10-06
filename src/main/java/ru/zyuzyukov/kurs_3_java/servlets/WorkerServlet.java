package ru.zyuzyukov.kurs_3_java.servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.zyuzyukov.kurs_3_java.application.ApplicationContext;
import ru.zyuzyukov.kurs_3_java.db.entity.Worker;
import ru.zyuzyukov.kurs_3_java.db.service.BaseService;
import ru.zyuzyukov.kurs_3_java.dto.WorkerDto;
import ru.zyuzyukov.kurs_3_java.mapper.WorkerMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet("/worker")
public class WorkerServlet extends HttpServlet {
    private final String index = "WEB-INF/views/worker.jsp";
    private BaseService<WorkerDto, Worker> service;
    private WorkerMapper mapper;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ApplicationContext context = (ApplicationContext) config.getServletContext().getAttribute("appContext");
        service = context.getWorkerService();
        mapper = context.getWorkerMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<WorkerDto> workers = service.findAll();
        req.setAttribute("workers", workers);
        req.getRequestDispatcher(index).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String name = req.getParameter("name");

        switch (action) {
            case "add":
                service.save(mapper.createDto(UUID.randomUUID(), name));
                break;
            case "update":
                UUID id = UUID.fromString(req.getParameter("id"));
                service.update(mapper.createDto(id, name));
                break;
            case "delete":
                UUID idDelete = UUID.fromString(req.getParameter("id"));
                service.delete(idDelete);
                break;
        }

        resp.sendRedirect(req.getContextPath() + "/worker");
    }
}
