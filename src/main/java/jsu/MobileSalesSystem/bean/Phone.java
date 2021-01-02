package jsu.MobileSalesSystem.bean;

public class Phone extends Bean{
    private Integer phone_id;
    private String phone_name;
    private String phone_classify;
    private Double phone_price;


    public Phone(Integer phone_id, String phone_name, String phone_classify, Double phone_price) {
        this.phone_id = phone_id;
        this.phone_name = phone_name;
        this.phone_classify = phone_classify;
        this.phone_price = phone_price;
    }
    public Phone() {
    }

    public Integer getPhone_id() {
        return phone_id;
    }

    public void setPhone_id(Integer phone_id) {
        this.phone_id = phone_id;
    }

    public String getPhone_name() {
        return phone_name;
    }

    public void setPhone_name(String phone_name) {
        this.phone_name = phone_name;
    }

    public String getPhone_classify() {
        return phone_classify;
    }

    public void setPhone_classify(String phone_classify) {
        this.phone_classify = phone_classify;
    }

    public Double getPhone_price() {
        return phone_price;
    }

    public void setPhone_price(Double phone_price) {
        this.phone_price = phone_price;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "phone_id=" + phone_id +
                ", phone_name='" + phone_name + '\'' +
                ", phone_classify='" + phone_classify + '\'' +
                ", phone_price=" + phone_price +
                '}';
    }
}
