package by.vorokhobko.servletwithuser.servlets;

import by.vorokhobko.servletwithuser.User;
import by.vorokhobko.servletwithuser.UserStore;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test.
 *
 * @author Evgeny Vorokhobko (vorokhobko2011@yandex.ru).
 * @version 1.
 * @since 18.03.2018.
 */
public class ShowAllElementTest {
    /**
     * The class field.
     */
    private UserStore userStore = UserStore.INSTANCE;
    /**
     * Test Add.
     */
    @Test
    public void whenAddUserInBD() throws IOException {
        CreateServlet create = new CreateServlet();
        this.userStore.createConnection();
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getParameter("name")).thenReturn("test");
        when(request.getParameter("login")).thenReturn("test");
        when(request.getParameter("email")).thenReturn("test");
        when(request.getParameter("createDate")).thenReturn(String.valueOf(new Timestamp(System.currentTimeMillis())));
        when(request.getParameter("password")).thenReturn("test");
        when(request.getParameter("role")).thenReturn("USER");

        create.doPost(request, response);
        User user = this.userStore.searchLoginAndPassword("test", "test");
        assertThat(user.getLogin(), is("test"));
    }
    /**
     * Test Add.
     */
    @Test
    public void whenUpdateUserInBD() throws IOException {
        UpdateServlet update = new UpdateServlet();
        this.userStore.createConnection();
        List<User> list = this.userStore.findAll();
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        when(request.getParameter("name")).thenReturn("testUpdate");
        when(request.getParameter("login")).thenReturn("testUpdate");
        when(request.getParameter("email")).thenReturn("testUpdate");
        when(request.getParameter("createDate")).thenReturn(String.valueOf(new Timestamp(System.currentTimeMillis())));
        when(request.getParameter("password")).thenReturn("testUpdate");
        when(request.getParameter("role")).thenReturn("USER");
        String id = null;
        for (User user : list) {
            if (this.userStore.compareLoginAndPassword("test", "test")) {
                id = String.valueOf(user.getId());
            }
        }
        when(request.getParameter("id")).thenReturn(id);

        update.doPost(request, response);
        User user = this.userStore.searchLoginAndPassword("testUpdate", "testUpdate");
        assertThat(user.getLogin(), is("testUpdate"));
    }
    /**
     * Test Add.
     */
    @Test
    public void whenDeleteUserInBD() throws IOException {
        DeleteServlet delete = new DeleteServlet();
        this.userStore.createConnection();
        List<User> list = this.userStore.findAll();
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        String id = null;
        for (User user : list) {
            if (this.userStore.compareLoginAndPassword("testUpdate", "testUpdate")) {
                id = String.valueOf(user.getId());
            }
        }
        when(request.getParameter("id")).thenReturn(id);

        delete.doPost(request, response);
        User user = this.userStore.searchLoginAndPassword("testUpdate", "testUpdate");
        assertNull(user);
    }
}