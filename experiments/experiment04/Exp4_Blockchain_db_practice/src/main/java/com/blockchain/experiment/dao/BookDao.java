package com.blockchain.experiment.dao;

/**
 * @author Tenerife
 * Su san
 * @date 2025/12/30 16:35
 */

import com.blockchain.experiment.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface BookDao {
    /**
     * 根据图书名称进行模糊查询
     * @param bookname 图书名称关键词
     * @return 图书列表
     */
    List<Book> getList(@Param("bookname") String bookname);

    /**
     * 插入book对象
     * @param book 图书对象
     * @return 受影响行数
     */
    int insertBook(Book book);
}