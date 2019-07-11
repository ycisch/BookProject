package com.nuc.entiy;

import java.util.List;

/**
 *  id       用户id
 *  username 用户名
 *  password 用户密码
 *  email    用户邮箱
 *  address  用户地址
 *  phone    用户金额
 *
 *  list_shop  用户购物车
 *  list_order 用户订单
 */

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String address;
    private String phone;
    private float money;

    private List<Shop> list_shop;
    private List<Order> list_order;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public List<Shop> getList_shop() {
        return list_shop;
    }

    public void setList_shop(List<Shop> list_shop) {
        this.list_shop = list_shop;
    }

    public List<Order> getList_order() {
        return list_order;
    }

    public void setList_order(List<Order> list_order) {
        this.list_order = list_order;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", money='" + money + '\'' +
                ", list_shop=" + list_shop +
                ", list_order=" + list_order +
                '}';
    }
}
