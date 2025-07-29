package ai.nova.nex.server.service.business.i;

import ai.nova.nex.server.service.business.AccountService;
import ai.nova.nex.server.service.db.SysUserService;
import ai.nova.nex.server.service.system.SystemAESService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author 小正
 * @date 2025年07月29日 19:59
 * @Description 请填写此类描述
 */
@Service
@Slf4j
public class IAccountService implements AccountService {
    @Resource
    private SysUserService SysUserService;
    @Resource
    private SystemAESService SystemAESService;
}
