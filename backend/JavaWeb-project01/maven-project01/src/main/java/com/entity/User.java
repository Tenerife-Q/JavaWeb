package com.entity;

/**
 * 用户实体类
 */
public class User {
    private Long id;
    private String name;
    private String idCard;
    private Integer age;
    private Integer status;  // 0-禁用，1-正常，2-冻结

    public User() {}

    public User(Long id, String name, String idCard, Integer status) {
        this.id = id;
        this.name = name;
        this.idCard = idCard;
        this.status = status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getIdCard() { return idCard; }
    public void setIdCard(String idCard) { this.idCard = idCard; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
}