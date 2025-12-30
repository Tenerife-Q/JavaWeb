package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //从类的根路径（classpath）下加载 XML 配置文件来创建和管理 Spring Bean
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Game game = (Game)context.getBean("game");
        game.play();
    }
}
