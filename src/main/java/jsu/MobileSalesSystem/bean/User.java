package jsu.MobileSalesSystem.bean;

import java.util.Date;

public class User extends Bean{
    private Integer vuser_id;
    private String vuser_name;
    private String vuser_pwd;
    private String vaddress;
    private Date vuser_date;

    public User() {
    }

    public Integer getVuser_id() {
        return vuser_id;
    }

    public void setVuser_id(Integer vuser_id) {
        this.vuser_id = vuser_id;
    }

    public String getVuser_name() {
        return vuser_name;
    }

    public void setVuser_name(String vuser_name) {
        this.vuser_name = vuser_name;
    }

    public String getVuser_pwd() {
        return vuser_pwd;
    }

    public void setVuser_pwd(String vuser_pwd) {
        this.vuser_pwd = vuser_pwd;
    }

    public String getVaddress() {
        return vaddress;
    }

    public void setVaddress(String vaddress) {
        this.vaddress = vaddress;
    }

    public Date getVuser_date() {
        return vuser_date;
    }

    public void setVuser_date(Date vuser_date) {
        this.vuser_date = vuser_date;
    }

    public User(Integer vuser_id, String vuser_name, String vuser_pwd, String vaddress, Date vuser_date) {
        this.vuser_id = vuser_id;
        this.vuser_name = vuser_name;
        this.vuser_pwd = vuser_pwd;
        this.vaddress = vaddress;
        this.vuser_date = vuser_date;
    }
}
