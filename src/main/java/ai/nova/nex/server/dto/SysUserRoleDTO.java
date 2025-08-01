package ai.nova.nex.server.dto;

import ai.nova.nex.server.config.base.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.Fastjson2TypeHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author 小正
 * @date 2025年08月01日 10:52
 * @Description 系统 - 用户角色表
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName(value = "sys_user_role", autoResultMap = true)
@Accessors(chain = true)
public class SysUserRoleDTO extends SuperEntity<SysUserRoleDTO> {
    public Long uid;
    @TableField(typeHandler = Fastjson2TypeHandler.class)
    public List<String> roleCodes;
}
