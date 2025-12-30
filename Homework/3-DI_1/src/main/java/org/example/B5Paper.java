package org.example;

import org.springframework.stereotype.Component;

/**
 * B5 纸张实现
 */
@Component  // ✅ 注解：告诉 Spring 我是一个 Bean
public class B5Paper implements Paper {
    public static final int charPerLine = 12;
    public static final int LinePerPage = 10;
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
        return "B5Paper";
    }
}