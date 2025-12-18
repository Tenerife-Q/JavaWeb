package com.springmvcexp2.entity;

/**
 * @author Tenerife
 * Su san
 * @date 2025/12/18 14:41
 */

// 如果没装 Lombok，请手动生成 Getter, Setter, 无参构造, 全参构造
public class User {
    private String uname;
    private String upwd;
    private Integer uage;

    // 1. 无参构造方法 (必须有)
    public User() {
    }

    // 2. 全参构造方法 (为了方便初始化)
    public User(String uname, String upwd, Integer uage) {
        this.uname = uname;
        this.upwd = upwd;
        this.uage = uage;
    }

    // 3. Getter 和 Setter 方法
    public String getUname() { return uname; }
    public void setUname(String uname) { this.uname = uname; }

    public String getUpwd() { return upwd; }
    public void setUpwd(String upwd) { this.upwd = upwd; }

    public Integer getUage() { return uage; }
    public void setUage(Integer uage) { this.uage = uage; }
}
