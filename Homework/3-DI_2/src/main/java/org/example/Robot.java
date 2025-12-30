package org.example;

import org.springframework.stereotype.Component;

/**
 * @ClassName : Robot
 * @Description :
 * @Author : ZJ
 * @Date: 2025-11-12 16:38
 */
@Component
public class Robot implements Thinkable {
    @Override
    public void thinking() {
        System.out.println("Thinking Robot");
    }
}
