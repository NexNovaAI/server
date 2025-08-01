package ai.nova.nex.server.dto;

import ai.nova.nex.server.config.base.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author 小正
 * @date 2025年08月01日 10:39
 * @Description 系统 - 角色表
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName(value = "sys_roles", autoResultMap = true)
@Accessors(chain = true)
public class SysRolesDTO extends SuperEntity<SysRolesDTO> {
    public String roleName;
    public String roleCode;
    public String description;
}
