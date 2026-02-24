package com.example.test_platform;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DemoTest {
    @Test
    public void testAddition() {
        System.out.println("✅ 开始执行测试...");
        assertEquals(2, 1 + 1);
        System.out.println("✅ 测试通过！");
    }
}
