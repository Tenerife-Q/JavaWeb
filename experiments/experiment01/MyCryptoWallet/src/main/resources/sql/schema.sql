CREATE DATABASE IF NOT EXISTS my_wallet;
USE my_wallet;

-- 资产表
CREATE TABLE t_token (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         symbol VARCHAR(10) NOT NULL,  -- 代币符号 (如 BTC, ETH)
                         network VARCHAR(20),          -- 所属网络 (如 Ethereum, Solana)
                         balance DECIMAL(18, 6),       -- 余额
                         update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 初始化数据
INSERT INTO t_token (symbol, network, balance) VALUES ('BTC', 'Bitcoin', 0.5);
INSERT INTO t_token (symbol, network, balance) VALUES ('ETH', 'Ethereum', 4.2);
INSERT INTO t_token (symbol, network, balance) VALUES ('USDT', 'TRON', 1000.0);