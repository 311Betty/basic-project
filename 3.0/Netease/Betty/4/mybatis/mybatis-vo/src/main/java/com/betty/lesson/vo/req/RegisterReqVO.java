package com.betty.lesson.vo.req;

/**
 * @author 白靖
 * @version 1.0.0
 * @ClassName RegisterReqVO.java
 * @Description TODO
 * @createTime 2020年05月21日 16:00:00
 */
public class RegisterReqVO {


    private String username;
    private String password;
    private String phone;
    private String email;
    private String sex;
    private String createWhere;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCreateWhere() {
        return createWhere;
    }

    public void setCreateWhere(String createWhere) {
        this.createWhere = createWhere;
    }

    @Override
    public String toString() {
        return "RegisterReqVO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                ", createWhere='" + createWhere + '\'' +
                '}';
    }
}
