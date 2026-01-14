package com.github.wallet.entity;

/**
 * @author Tenerife
 * Su san
 * @date 2026/1/14 19:03
 */

import java.math.BigDecimal;
import java.util.Date;

/**
 * 数字资产实体类
 */
public class Token {
    private Integer id;
    private String symbol;
    private String network;
    private BigDecimal balance;
    private Date updateTime;

    // 省略 Getter/Setter 和 toString()
    // 实际开发中可以使用 Lombok @Data 注解简化

    public Token() {}

    public Token(String symbol, String network, BigDecimal balance) {
        this.symbol = symbol;
        this.network = network;
        this.balance = balance;
    }

    // Getter & Setter ...
    public String getSymbol() { return symbol; }
    public void setSymbol(String symbol) { this.symbol = symbol; }
    public String getNetwork() { return network; }
    public void setNetwork(String network) { this.network = network; }
    public BigDecimal getBalance() { return balance; }
    public void setBalance(BigDecimal balance) { this.balance = balance; }
}
