package jsu.MobileSalesSystem.bean;

public class Admin extends Bean{
    private String adminname;
    private String adminpwd;

    public Admin() {
    }

    public Admin(String adminname, String adminpwd) {
        this.adminname = adminname;
        this.adminpwd = adminpwd;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getAdminpwd() {
        return adminpwd;
    }

    public void setAdminpwd(String adminpwd) {
        this.adminpwd = adminpwd;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminname='" + adminname + '\'' +
                ", adminpwd='" + adminpwd + '\'' +
                '}';
    }
}
