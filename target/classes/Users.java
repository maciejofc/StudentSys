package pl.my.studentsys.homepage;

public class Users {
    private int id;
    private String fullName;
    private String email;
    private String password;

    public Users(int id, String fullName, String email, String password) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        if (fullName == null)
            fullName = "";
        return fullName;
    }

    public String getEmail() {
        if (email == null)
            email = "";
        return email;
    }

    public String getPassword() {
        if (password == null)
            password = "";
        return password;
    }
}
