package ai.nova.nex.server.component;

import ai.nova.nex.server.service.business.AccountService;
import cn.dev33.satoken.stp.StpInterface;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author 小正
 * @date 2025年08月01日 09:53
 * @Description 自定义权限加载接口实现类
 */
@Component
@Slf4j
public class StpInterfaceImpl implements StpInterface {

    @Resource
    private AccountService accountService;

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        long userId;
        if (loginId instanceof String str) {
            try {
                userId = Long.parseLong(str);
            } catch (NumberFormatException e) {
                log.warn("无法将UserID转换: {}", loginId);
                userId = -1L; // 或者抛出异常或返回空列表
            }
        } else if (loginId instanceof Long lng) {
            userId = lng;
        } else {
            log.warn("不支持的loginId类型: {}", loginId.getClass().getName());
            userId = -1L;
        }
        return Stream.of(
                        accountService.getUserPermissionCodes(userId),
                        accountService.getUserTemporaryPermissions(userId)
                )
                .flatMap(List::stream)
                .distinct()
                .toList();
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        return accountService.getUserRoleCodes((Long) loginId);
    }
}
