package lxw.addressbook.addressbook.domain;

import lombok.Data;

@Data
public class User {
    private Integer id;

    private String name;

    private String realName;

    private String openId;

    private String phone;

    private Integer userType;

    private String email;

    private String wechatId;

    private String sex;

    private String city;
}