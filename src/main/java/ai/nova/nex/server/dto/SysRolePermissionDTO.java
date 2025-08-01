package ai.nova.nex.server.dto;

import ai.nova.nex.server.config.base.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author 小正
 * @date 2025年08月01日 10:46
 * @Description 系统 - 角色权限表
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName(value = "sys_role_permission", autoResultMap = true)
@Accessors(chain = true)
public class SysRolePermissionDTO extends SuperEntity<SysRolePermissionDTO> {
    public String roleCode;
    public List<String> permissionCodes;
}
