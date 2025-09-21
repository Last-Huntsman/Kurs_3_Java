package ru.zyuzyukov.kurs_3_java.servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import ru.zyuzyukov.kurs_3_java.application.ApplicationContext;
import ru.zyuzyukov.kurs_3_java.db.entity.Employer;
import ru.zyuzyukov.kurs_3_java.db.repositories.EmployerRepository;
import ru.zyuzyukov.kurs_3_java.db.service.BaseService;
import ru.zyuzyukov.kurs_3_java.dto.EmployerDto;
import ru.zyuzyukov.kurs_3_java.mapper.EmployerMapper;
import ru.zyuzyukov.kurs_3_java.mapper.Mapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet("/employer")
@RequiredArgsConstructor
public class EmployerServlet extends HttpServlet {
    private final String index = "WEB-INF/views/employer.jsp";

    private BaseService<EmployerDto,Employer> service ;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ApplicationContext context = (ApplicationContext) config.getServletContext().getContext("appContext");
        service = context.getEmployerService();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("EmployServlet doGet");
        List<EmployerDto> employerDtoList = service.findAll();
        req.setAttribute("employers", employerDtoList);
        System.out.println(employerDtoList);
        req.getRequestDispatcher(index).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String name = req.getParameter("name");
        switch (action) {
            case "add":
                service.save(new EmployerDto(UUID.randomUUID(), name, new ArrayList<>(), true));
                break;
            case "update":
                UUID id = UUID.fromString(req.getParameter("id"));
                service.update(new EmployerDto(id, name, new ArrayList<>(), true));
                break;
            case "delete":
                UUID idDelete = UUID.fromString(req.getParameter("id"));
                service.delete(idDelete);
                break;
        }

        resp.sendRedirect(req.getContextPath() + "/employer");
    }

}
