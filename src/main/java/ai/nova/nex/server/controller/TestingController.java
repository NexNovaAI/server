package ai.nova.nex.server.controller;

import ai.nova.nex.server.config.base.Result;
import cn.dev33.satoken.annotation.SaCheckPermission;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 小正
 * @date 2025年08月01日 11:57
 * @Description 测试控制器
 */
@RequestMapping("/testing")
@RestController
@Slf4j
public class TestingController {

    @GetMapping("/1")
    public Result<String> test1() {
        return Result.succeed("测试成功");
    }

    @GetMapping("/2")
    @SaCheckPermission("testing.2")
    public Result<String> test2() {
        return Result.succeed("测试成功");
    }

    @GetMapping("/3")
    @SaCheckPermission("testing.3")
    public Result<String> test3() {
        return Result.succeed("测试成功");
    }
}
