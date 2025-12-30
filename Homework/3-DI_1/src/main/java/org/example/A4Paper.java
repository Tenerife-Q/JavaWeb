//package org.example;
//
///**
// * @ClassName : A4Paper
// * @Description :
// * @Author : ZJ
// * @Date: 2025-11-10 17:51
// */
//public class A4Paper {
//    public static final String newline = "\r\n";
//    public static final String newpage = "==========\r\n";
//    public static final int charPerLine = 10;
//    public static final int LinePerPage = 8;
//    public String content="";
//    public void putInChar(char c,int index){//输出字符到纸张
//        content+=c;
//        if ((index!=0)&&(index % charPerLine)==0){
//            content+=newline;
//        }
//        if ((index!=0)&&(index % (charPerLine*LinePerPage))==0){
//            content+=newpage;
//        }
//    }
//    public String getContent(){//得到输出到纸张上的内容
//        return content;
//    }
//
//    @Override
//    public String toString() {//显示类的信息
//        return "A4Paper";
//    }
//}

package org.example;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * A4 纸张实现
 */
@Component  // ✅ 注解：告诉 Spring 我是一个 Bean
@Primary
public class A4Paper implements Paper {
    public static final int charPerLine = 10;
    public static final int LinePerPage = 8;
    public String content = "";

    @Override
    public void putInChar(char c, int index) {
        content += c;
        if ((index != 0) && (index % charPerLine) == 0) {
            content += newline;
        }
        if ((index != 0) && (index % (charPerLine * LinePerPage)) == 0) {
            content += newpage;
        }
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "A4Paper";
    }
}