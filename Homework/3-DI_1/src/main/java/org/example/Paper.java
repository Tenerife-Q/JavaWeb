package org.example;

/**
 * 纸张接口
 */
public interface Paper {
    String newline = "\r\n";
    String newpage = "==========\r\n";

    /**
     * 输出字符到纸张
     * @param c 字符
     * @param index 字符索引
     */
    void putInChar(char c, int index);

    /**
     * 得到输出到纸张上的内容
     * @return 内容
     */
    String getContent();
}