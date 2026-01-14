package com.github.wallet.mapper;

import com.github.wallet.entity.Token;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface TokenMapper {
    // 查询所有资产
    List<Token> selectAllTokens();

    // 添加新资产
    int insertToken(Token token);
}