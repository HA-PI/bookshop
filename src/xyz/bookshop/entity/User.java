package xyz.bookshop.entity;

import java.sql.Date;

/**
 * Created by moyu on 2017/6/12.
 */
public class User {
    private String username;
    private String password;
    private Date date;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }

    public User(String username, String password, Date date) {
        this.username = username;
        this.password = password;
        this.date = date;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
