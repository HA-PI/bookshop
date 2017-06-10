package a.b;

//import org.json.simple.JSONObject;

/**
 * Created by moyu on 2017/6/8.
 */
public class Name {

    public String fullname;
    public String dickname;

    public Name(String fullname, String dickname) {
        this.fullname = fullname;
        this.dickname = dickname;
    }

    @Override
    public String toString() {
        return "Name->>{" +
                "fullname='" + fullname + '\'' +
                ", dickname='" + dickname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;

        Name name = (Name) o;

        return fullname.equals(name.fullname);
    }

    @Override
    public int hashCode() {
        return fullname.hashCode();
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDickname() {
        return dickname;
    }

    public void setDickname(String dickname) {
        this.dickname = dickname;
    }
}
