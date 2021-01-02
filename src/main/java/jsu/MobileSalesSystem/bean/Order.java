package jsu.MobileSalesSystem.bean;

import java.util.Date;

public class Order extends Bean{
    private String ouser_name;
    private String ophone_name;
    private Double order_price;
    private String order_adress;
    private Date order_date;

    public Order() {
    }

    public Order(String ouser_name, String ophone_name, Double order_price, String order_adress, Date order_date) {
        this.ouser_name = ouser_name;
        this.ophone_name = ophone_name;
        this.order_price = order_price;
        this.order_adress = order_adress;
        this.order_date = order_date;
    }

    public String getOuser_name() {
        return ouser_name;
    }

    public void setOuser_name(String ouser_name) {
        this.ouser_name = ouser_name;
    }

    public String getOphone_name() {
        return ophone_name;
    }

    public void setOphone_name(String ophone_name) {
        this.ophone_name = ophone_name;
    }

    public Double getOrder_price() {
        return order_price;
    }

    public void setOrder_price(Double order_price) {
        this.order_price = order_price;
    }

    public String getOrder_adress() {
        return order_adress;
    }

    public void setOrder_adress(String order_adress) {
        this.order_adress = order_adress;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "ouser_name='" + ouser_name + '\'' +
                ", ophone_name='" + ophone_name + '\'' +
                ", order_price=" + order_price +
                ", order_adress='" + order_adress + '\'' +
                ", order_date=" + order_date +
                '}';
    }
}
