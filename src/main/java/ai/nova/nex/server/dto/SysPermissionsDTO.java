package ai.nova.nex.server.dto;

import ai.nova.nex.server.config.base.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author 小正
 * @date 2025年08月01日 10:45
 * @Description 系统 - 权限表
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName(value = "sys_permissions", autoResultMap = true)
@Accessors(chain = true)
public class SysPermissionsDTO extends SuperEntity<SysPermissionsDTO> {
    public String permissionName;
    public String permissionCode;
    public String description;
}
