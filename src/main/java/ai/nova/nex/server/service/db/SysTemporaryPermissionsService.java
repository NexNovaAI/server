package ai.nova.nex.server.service.db;

import ai.nova.nex.server.config.base.SuperService;
import ai.nova.nex.server.dto.SysTemporaryPermissionsDTO;

import java.util.List;

/**
 * @author 小正
 * @date 2025年08月01日 11:12
 * @blog https://blog.xiaozhengkeji.com/
 * @Description 请填写此类描述
 */
public interface SysTemporaryPermissionsService extends SuperService<SysTemporaryPermissionsDTO> {
    List<SysTemporaryPermissionsDTO> getByUserId(Long userId,boolean isUsable);
}
