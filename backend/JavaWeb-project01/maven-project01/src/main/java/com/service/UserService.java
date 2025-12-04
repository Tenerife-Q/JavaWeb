package com.service;

import com.entity.User;
import java.time.LocalDate;

/**
 * 用户服务类（简化版 - 学习单元测试用）
 */
public class UserService {

    /**
     * 根据身份证号获取年龄
     */
    public Integer getAge(String idCard) {
        // 基本检查
        if (idCard == null || idCard.length() != 18) {
            return null;
        }

        try {
            // 提取出生日期（第7-14位）
            int birthYear = Integer.parseInt(idCard.substring(6, 10));
            int birthMonth = Integer.parseInt(idCard.substring(10, 12));
            int birthDay = Integer.parseInt(idCard.substring(12, 14));

            LocalDate birthDate = LocalDate.of(birthYear, birthMonth, birthDay);
            LocalDate now = LocalDate.now();

            // 未来日期检查
            if (birthDate.isAfter(now)) {
                return null;
            }

            // 计算年龄
            int age = now.getYear() - birthYear;
            if (now.getMonthValue() < birthMonth ||
                    (now.getMonthValue() == birthMonth && now.getDayOfMonth() < birthDay)) {
                age--;
            }

            return age < 0 ? null : age;

        } catch (Exception e) {
            return null;  // 任何异常都返回null
        }
    }

    /**
     * 判断是否成年
     */
    public boolean isAdult(String idCard) {
        Integer age = getAge(idCard);
        return age != null && age >= 18;
    }

    /**
     * 用户登录
     */
    public boolean login(String username, String password) {
        if (username == null || password == null) {
            throw new IllegalArgumentException("用户名和密码不能为null");
        }

        if (username.trim().isEmpty() || password.trim().isEmpty()) {
            throw new IllegalArgumentException("用户名和密码不能为空");
        }

        if (username.length() < 3 || username.length() > 20) {
            throw new IllegalArgumentException("用户名长度必须在3-20之间");
        }

        if (password.length() < 6 || password.length() > 20) {
            throw new IllegalArgumentException("密码长度必须在6-20之间");
        }

        return "admin".equals(username.trim()) && "123456".equals(password);
    }

    /**
     * 查询用户
     */
    public User getUser(Long id) {
        if (id == null || id <= 0) {
            return null;
        }

        if (id == 1L) {
            return new User(1L, "张三", "110000200001011234", 1);
        } else if (id == 999L) {
            return new User(999L, "禁用用户", "110000199001011234", 0);
        }
        return null;
    }

    /**
     * 更新用户状态
     */
    public boolean updateUserStatus(Long userId, Integer status) {
        if (userId == null || status == null) {
            throw new IllegalArgumentException("用户ID和状态不能为null");
        }

        if (userId <= 0) {
            throw new IllegalArgumentException("用户ID必须大于0");
        }

        if (status < 0 || status > 2) {
            throw new IllegalArgumentException("状态值必须是0、1、2之一");
        }

        User user = getUser(userId);
        return user != null;
    }
}