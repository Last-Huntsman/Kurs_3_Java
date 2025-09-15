package ru.zyuzyukov.kurs_3_java.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.zyuzyukov.kurs_3_java.dto.EmployerDto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet("/employer")
public class EmployerServlet extends HttpServlet {
    private final String index = "WEB-INF/views/employer.jsp";
    private List<EmployerDto> employerDtos;

    @Override
    public void init() throws ServletException {
        final Object employers = getServletContext().getAttribute("employers");
        if (!(employers instanceof List)) {
            throw new ServletException("employers must be a list of employers");

        } else {
            employerDtos = (List<EmployerDto>) employers;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("EmployServlet doGet");
        req.setAttribute("employers", employerDtos);
        System.out.println(employerDtos);
        req.getRequestDispatcher(index).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String name = req.getParameter("name");
        switch (action) {
            case "add":
                employerDtos.add(new EmployerDto(UUID.randomUUID(), name));
                break;
            case "update":
                UUID id = UUID.fromString(req.getParameter("id"));
                employerDtos.stream().filter(employerDto -> employerDto.getId().equals(id)).findFirst().ifPresent(employerDto -> employerDto.setName(name));
                break;
            case "delete":
               UUID id1 = UUID.fromString(req.getParameter("id"));

                List<EmployerDto> list = new ArrayList<>();
                for (EmployerDto employerDto : employerDtos) {
                    if (employerDto.getId().equals(id1)) {
                        continue;
                    } else {
                        list.add(employerDto);
                    }
                }

                employerDtos= list;
                break;
        }

        resp.sendRedirect(req.getContextPath() + "/employer");
    }

}
