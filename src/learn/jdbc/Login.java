package learn.jdbc;

/**
 * @author sowhile
 * @version 1.0
 * <p>
 * 2022/11/30 15:30
 */
public class Login {
    private String user;
    private String password;

    public Login() {
    }

    public Login(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
