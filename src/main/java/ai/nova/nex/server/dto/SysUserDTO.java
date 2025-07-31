package ai.nova.nex.server.dto;

import ai.nova.nex.server.config.base.SuperEntity;
import ai.nova.nex.server.enums.OTPStatusEnum;
import ai.nova.nex.server.enums.UserStatusEnum;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author 小正
 * @date 2025年07月29日 19:10
 * @Description 系统 - 用户表
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName(value = "sys_user", autoResultMap = true)
@Accessors(chain = true)
public class SysUserDTO extends SuperEntity<SysUserDTO> {
    public String username;
    public String password;
    public String mailbox;
    public String phone;
    public String otpContent;
    public OTPStatusEnum otpStatus;
    public String registerAddress;
    public String lastLoginAddress;
    public Boolean superAdmin;
    public UserStatusEnum userStatus;
}
