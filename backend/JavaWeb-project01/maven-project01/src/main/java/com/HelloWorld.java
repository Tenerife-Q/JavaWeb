package com;

/**
 * @author Tenerife
 * Su san
 * @date 2025/11/16 16:11
 *
 * POM 项目对象模型
 * Maven 坐标
 * groupId 域名反写 隶属组织名
 * artifactId  Maven 项目名称 通常是模块名 项目文件下面新建模块
 * version 定义当前项目版本号 SNAPSHOT不稳定   RELEASE 稳定发行版本
 *
 *
 * Dependency 依赖管理模型
 * 导入其他maven模块
 * 1. File -> ProjectStructure -> + import module -> 选择pom.xml文件
 * 2. 右侧Maven面板 -> + -> 选择pom.xml文件
 *   建议先将需要导入的maven新项目拷贝到自己的项目目录下面
 *   再选择maven中的pom文件导入
 *
 *
 *   一起构建生命周期 本质上是一个插件执行程序
 *   右侧Maven面板LifeCycle
 *   clean清理
 *   compile编译
 *   test测试
 *   package打包
 *   install安装到本地
 */
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello Maven!");
    }
}
