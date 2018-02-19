package by.vorokhobko.servletwithuser.html;

import by.vorokhobko.servletwithuser.User;
import java.util.List;

/**
 * SimpleBuilder.
 *
 * Class SimpleBuilder is the part of the building html document for user part 004, lesson 3.
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @since 19.02.2018.
 * @version 1.
 */
public class SimpleBuilder {
    /**
     * The class field.
     */
    private StringBuilder builder = new StringBuilder();
    /**
     * The method starts building web-browser.
     */
    private String getHeader() {
        return "<!DOCTYPE html>\n"
                + "<html lang=\"en\">\n"
                + "<head>\n"
                + "<meta charset=\"UTF-8\">\n"
                + "<title>CreateUsers</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "<h2>ALL USERS</h2>";
    }
    /**
     * The method shows all users for web-client.
     * @param contextPath - contextPath.
     * @param list - list.
     */
    public String showUsers(List<User> list, String contextPath) {
        this.builder.append(getHeader());
        this.builder.append("<body><form method='post'>");
        this.builder.append("<table border = \"2\">");
        for (User user : list) {
            this.builder.append("<tr>"
                    + "<th>CHOICE</th>\n"
                    + "<th>ID</th>\n"
                    + "<th>NAME</th>\n"
                    + "<th>LOGIN</th>\n"
                    + "<th>EMAIL</th>\n"
                    + "<th>TIME</th>\n"
                    + "</tr>"
                    + "<tr>"
                    + String.format("<td><input type='radio' name='id' value='%s'</td>", user.getId())
                    + String.format("<td>%d</td>", user.getId())
                    + String.format("<td>%s</td>", user.getName())
                    + String.format("<td>%s</td>", user.getLogin())
                    + String.format("<td>%s</td>", user.getEmail())
                    + String.format("<td>%s</td>", user.getCreateDate())
                    + "</tr>");
        }
        this.builder.append("</table><br>");
        this.builder.append("<input type='submit' value='Add user' formaction='" + contextPath + "/create'>"
                + "<input type='submit' value='Update user' formaction='" + contextPath + "/update'>"
                + "<input type='submit' value='Delete user' formaction='" + contextPath + "/delete'>"
                + "</form></body></html>");
        return this.builder.toString();
    }
    /**
     * The method adds user for web-client.
     * @param contextPath - contextPath.
     */
    public String addUsers(String contextPath) {
        this.builder.append(getHeader());
        this.builder.append("<body><form action='" + contextPath + "/create' method='post' accept-charset = 'UTF-8'>"
                + "Name User: <input type = 'text' name = 'name'></br>"
                + "Login User: <input type = 'text' name = 'login'></br>"
                + "Email User: <input type = 'text' name = 'email'></br>"
                + "<input type = 'submit' name = 'Create User'></br></form>");
        this.builder.append("<form action='" + contextPath + "/show' method='get' accept-charset = 'UTF-8'>"
                + "<input type='submit' value='Back'>"
                + "</from></body></html>");
        return this.builder.toString();
    }
    /**
     * The method deletes user for web-client.
     * @param contextPath - contextPath.
     */
    public String deleteUser(String contextPath) {
        this.builder.append(getHeader());
        this.builder.append("<body>Deletion was completed successfully!.<br>");
        this.builder.append("<form action='" + contextPath + "/show' method='get' accept-charset='UTF-8'>"
                + "<input type='submit' value='Back'>"
                + "</form></body></html>");
        return this.builder.toString();
    }
    /**
     * The method not deletes user for web-client.
     * @param contextPath - contextPath.
     */
    public String notDeleteUser(String contextPath) {
        this.builder.append(getHeader());
        this.builder.append("<body>Try again!");
        this.builder.append("<form action='" + contextPath + "/show' method='get' accept-charset='UTF-8'>"
                + "<input type='submit' value='Back'>"
                + "</form></body></html>");
        return this.builder.toString();
    }
    /**
     * The method not updates user for web-client.
     * @param contextPath - contextPath.
     */
    public String notEditUser(String contextPath) {
        this.builder.append(getHeader());
        this.builder.append("<body>We don't have ths ID!");
        this.builder.append("<form action='" + contextPath + "/show' method = 'get' accept-charset='UTF-8'>"
                + "<input type='submit' value='Back'>"
                + "</form></body></html>");
        return this.builder.toString();
    }
    /**
     * The method updates user for web-client.
     * @param contextPath - contextPath.
     */
    public String editUser(String contextPath, int id) {
        this.builder.append(getHeader());
        builder.append("<body><form action='" + contextPath + "/update' method='post' accept-charset='UTF-8'>"
                + "<input type='hidden' name='id' value='" + id + "'>"
                + "ID: " + id + "<br>"
                + "Name User: <input type = 'text' name = 'name'></br>"
                + "Login User: <input type = 'text' name = 'login'></br>"
                + "Email User: <input type = 'text' name = 'email'></br>"
                + "<input type='submit' value='Update user'>"
                + "</form>");
        builder.append("<form action='" + contextPath + "/show' method='get' accept-charset='UTF-8'>"
                + "<input type='submit' value='Back'>"
                + "</form></body></html>");
        return this.builder.toString();
    }
}