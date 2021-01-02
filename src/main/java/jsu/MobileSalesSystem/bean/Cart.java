package jsu.MobileSalesSystem.bean;

public class Cart extends Bean{
    private Integer cart_id;
    private String user_name;
    private Integer phone_id;

    public Cart(Integer cart_id, String user_name, Integer phone_id) {
        this.cart_id = cart_id;
        this.user_name = user_name;
        this.phone_id = phone_id;
    }

    public Cart() {
    }

    public Integer getCart_id() {
        return cart_id;
    }

    public void setCart_id(Integer cart_id) {
        this.cart_id = cart_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Integer getPhone_id() {
        return phone_id;
    }

    public void setPhone_id(Integer phone_id) {
        this.phone_id = phone_id;
    }
}
