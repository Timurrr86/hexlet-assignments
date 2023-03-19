package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import static exercise.Data.getCompanies;

public class CompaniesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        // BEGIN
        String search = request.getParameter("search");
        List<String> companies = getCompanies();
        if (search != null) {
            companies = companies.stream().
                    filter(x -> x.contains(search)).
                    toList();
        }
        PrintWriter out = response.getWriter();
        if (search == null || search.equals("")) {
            for (String company : getCompanies()) {
                out.println(company);
                }
        } else if (companies.isEmpty()) {
            out.println("Companies not found\n");
        } else {
            for (String company : companies) {
                out.println(company);
            }
        }
        // END
    }
}
