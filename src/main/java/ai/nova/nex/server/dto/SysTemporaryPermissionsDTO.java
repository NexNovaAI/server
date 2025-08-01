package ai.nova.nex.server.dto;

import ai.nova.nex.server.config.base.SuperEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.Fastjson2TypeHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

/**
 * @author 小正
 * @date 2025年08月01日 10:55
 * @Description 系统 - 临时权限表
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName(value = "sys_temporary_permissions", autoResultMap = true)
@Accessors(chain = true)
public class SysTemporaryPermissionsDTO extends SuperEntity<SysTemporaryPermissionsDTO> {
    public Long uid;
    public Long grantedBy;
    @TableField(typeHandler = Fastjson2TypeHandler.class)
    public List<String> permissionCodes;
    public Date startAt;
    public Date expiresAt;
}
