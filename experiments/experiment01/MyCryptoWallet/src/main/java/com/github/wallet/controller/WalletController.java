package com.github.wallet.controller;

/**
 * @author Tenerife
 * Su san
 * @date 2026/1/14 19:10
 */

import com.github.wallet.entity.Token;
import com.github.wallet.mapper.TokenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    private TokenMapper tokenMapper;

    /**
     * 资产看板页 (需要登录)
     */
    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        // 1. Session 权限检查 (模拟实验3)
        // 假设登录时 setAttribute("user", ...)
        if (session.getAttribute("loginUser") == null) {
            return "redirect:/login"; // 未登录重定向
        }

        // 2. 业务查询 (模拟实验4)
        List<Token> tokens = tokenMapper.selectAllTokens();

        // 3. 计算总价值 (简单模拟逻辑)
        // 实际项目这里应该调用 Service 层

        // 4. 存入 Model
        model.addAttribute("tokenList", tokens);

        // 5. 返回 Thymeleaf 视图
        return "wallet_dashboard";
    }

    /**
     * 添加资产 (表单提交)
     */
    @PostMapping("/add")
    public String addToken(Token token) {
        // Spring MVC 自动将表单参数封装为 Token 对象
        tokenMapper.insertToken(token);
        return "redirect:/wallet/dashboard";
    }
}
