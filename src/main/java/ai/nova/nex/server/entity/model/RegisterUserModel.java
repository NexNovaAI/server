package ai.nova.nex.server.entity.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 小正
 * @date 2025年07月29日 20:08
 * @Description 请填写此类描述
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserModel {
    public String username;
    public String password;
    public String mailbox;
    @JsonProperty("mailbox_code")
    public String mailboxCode;
    @JsonProperty("register_address")
    public String registerAddress;
}
