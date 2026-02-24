package com.example.test_platform;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Paths;

@Controller
public class TestController {

    @GetMapping("/run-test")
    @ResponseBody
    public String runTest() {
        try {
            // 获取项目根目录
            String projectDir = Paths.get("").toAbsolutePath().toString();

            // 构建 Maven 命令（确保已安装 Maven 并配置 PATH）
            ProcessBuilder pb = new ProcessBuilder("/opt/homebrew/bin/mvn", "test", "-Dtest=DemoTest");
            pb.directory(Paths.get(projectDir).toFile());
            pb.redirectErrorStream(true); // 合并 stdout 和 stderr

            Process process = pb.start();

            // 读取输出
            StringBuilder output = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    output.append(line).append("\n");
                }
            }

            process.waitFor();
            return output.toString();
        } catch (Exception e) {
            return "❌ 执行失败: " + e.getMessage();
        }
    }
}
