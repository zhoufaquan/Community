package life.zfq.community.community.dto;

import lombok.Data;

/**
 * Author: zhouFaQuan
 * Date: 2019/10/21 18:35
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private  String client_state;
    private String redirect_uri;


}
