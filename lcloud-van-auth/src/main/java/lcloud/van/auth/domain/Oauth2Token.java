package lcloud.van.auth.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * 功能描述：
 *
 * @Author: XKK
 * @Date: 2021/5/28 9:12
 */
@Data
@ApiModel
@Builder
public class Oauth2Token {

    @ApiModelProperty("访问令牌")
    private String token;

    @ApiModelProperty("刷新令牌")
    private String refreshToken;

    @ApiModelProperty("有效时间(秒)")
    private int expiresIn;

}
