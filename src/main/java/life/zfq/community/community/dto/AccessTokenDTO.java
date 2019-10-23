package life.zfq.community.community.dto;

/**
 * Author: zhouFaQuan
 * Date: 2019/10/21 18:35
 */
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private  String client_state;
    private String redirect_uri;

    public String getRedirect_uri() {
        return redirect_uri;
    }

    public void setRedirect_uri(String redirect_uri) {
        this.redirect_uri = redirect_uri;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getClient_state() {
        return client_state;
    }

    public void setClient_state(String client_state) {
        this.client_state = client_state;
    }
}
