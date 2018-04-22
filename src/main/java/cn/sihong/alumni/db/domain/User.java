package cn.sihong.alumni.db.domain;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class User {
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qq='" + qq + '\'' +
                ", phone='" + phone + '\'' +
                ", wechat='" + wechat + '\'' +
                ", mail='" + mail + '\'' +
                ", address='" + address + '\'' +
                ", motto='" + motto + '\'' +
                ", isDeleted=" + isDeleted +
                ", password='" + password + '\'' +
                '}';
    }

    private Integer id;
    private String name;
    private String qq;
    private String phone;
    private String wechat;
    private String mail;
    private String address;
    private String motto;
    private Integer isDeleted;
    private String xm;

    private String password;

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", id);
        map.put("name", name);
        map.put("qq", qq);
        map.put("phone", phone);
        map.put("wechat", wechat);
        map.put("mail", mail);
        map.put("address", address);
        map.put("motto", motto);
        map.put("password", password);
        map.put("xm", xm);
        return map;
    }

}
