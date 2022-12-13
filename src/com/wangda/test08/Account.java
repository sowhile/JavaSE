package com.wangda.test08;

public class Account {
    public String name;
    private int money;
    private String password;


    public Account() {
    }

    public Account(String name, int money, String password) {
        setName(name);
        setMoney(money);
        setPassword(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() >= 2 && name.length() <= 4)
            this.name = name;
        else {
            System.out.println("姓名长度不合法，默认姓名未命名。");
            this.name = "未命名";
        }
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        if (money > 20)
            this.money = money;
        else {
            System.out.println("余额必须>20，默认余额100");
            this.money = 100;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.length() == 6)
            this.password = password;
        else {
            System.out.println("密码必须是6位，默认密码000000");
            this.password = "000000";
        }
    }
}
