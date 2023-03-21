package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;

import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.ArrayUtils;

public class UsersServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        String pathInfo = request.getPathInfo();

        if (pathInfo == null) {
            showUsers(request, response);
            return;
        }

        String[] pathParts = pathInfo.split("/");
        String id = ArrayUtils.get(pathParts, 1, "");

        showUser(request, response, id);
    }

    private List getUsers() throws JsonProcessingException, IOException {
        // BEGIN
        ObjectMapper objectMapper = new ObjectMapper();
        Path path = Paths.get("src/main/resources/users.json").toAbsolutePath().normalize();
        String usersData = Files.readString(path);
        return objectMapper.readValue(usersData, List.class);
        // END
    }

    private void showUsers(HttpServletRequest request,
                          HttpServletResponse response)
                throws IOException {

        // BEGIN
        response.setContentType("text/html;charset=UTF-8");
        List<Map<String, String>> users = getUsers();
        StringBuilder body = new StringBuilder();
        body.append("""
                <!DOCTYPE html>
                <html lang="ru">
                    <head>
                        <meta charset="UTF-8">
                        <title>Example application</title>
                        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
                              rel="stylesheet"
                              integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
                              crossorigin="anonymous">
                    </head>
                    <body>
                    <table>
                """);

        for (Map<String, String> user : users) {
            String id = user.get("id");
            String fullName = user.get("firstName") + " " + user.get("lastName");
            body.append("<tr>");
            body.append("<td>" + id + "</id>");
            body.append("<td><a href=\"/user/" + id + "\">" + fullName + "</a></id>");
            body.append("</tr>");
        }
        body.append("""                  
                    </table>
                    </body>
                </html>""");

        PrintWriter out = response.getWriter();
        out.println(body);
        // END
    }

    private void showUser(HttpServletRequest request,
                         HttpServletResponse response,
                         String id)
                 throws IOException {

        // BEGIN
        response.setContentType("text/html;charset=UTF-8");
        List<Map<String, String>> users = getUsers();
        StringBuilder body = new StringBuilder();

        Map<String, String> user = users
                .stream()
                .filter(x -> x.get("id").equals(id))
                .findAny()
                .orElse(null);

        if (user == null) {
            response.sendError(404);
        } else {
            String requiredId = user.get("id");
            String fullName = user.get("firstName") + " " + user.get("lastName");
            body.append("""
            <!DOCTYPE html>
            <html lang=\"ru\">
                <head>
                    <meta charset=\"UTF-8\">
                    <title>Example application</title>
                    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\"
                          rel=\"stylesheet\"
                          integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\"
                          crossorigin=\"anonymous\">
                </head>
                <body>

            """);
            for (Map.Entry<String, String> entry : user.entrySet()) {
                body.append("<div>");
                body.append(entry.getKey() + ": " + entry.getValue() + " ");
                body.append("</div");
            }
            body.append("""
                        </body>
                    </html>""");
            PrintWriter out = response.getWriter();
            out.println(body);
        }
        // END
    }
}
