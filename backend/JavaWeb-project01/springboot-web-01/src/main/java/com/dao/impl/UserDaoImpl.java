package com.dao.impl;

import cn.hutool.core.io.IoUtil;
import com.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/19 14:12
 */
//将当前类交给IOC容器管理 @Repository  处理数据流 比@Component更准确
@Repository("userDao")//@Controller @Service @Repository @Component 都是声名bean的注解
public class UserDaoImpl implements UserDao {
    @Override
    public List<String> findAll() {
        //1.加载并读取user.txt 文件 获取用户数据
        //InputStream in = new FileInputStream(new File("E:\\JavaWeb\\backend\\JavaWeb-project01\\springboot-web-01\\src\\main\\resources"));
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());
        return lines;
    }
}
