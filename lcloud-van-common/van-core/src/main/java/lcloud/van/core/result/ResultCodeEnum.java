package lcloud.van.core.result;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 功能描述：
 *
 * @Author: XKK
 * @Date: 2021/6/1 14:57
 */
@AllArgsConstructor
@NoArgsConstructor
public enum ResultCodeEnum implements IResultCode,Serializable {

    SUCCESS("200","success"),
    ERROR("500","error"),

    USER_NOT_EXIST("A201","用户不存在"),
    USER_ACCOUNT_LOCKED("A0202","用户账户被冻结"),
    USER_ACCOUNT_INVALID("A0203","用户账户已作废"),

    USERNAME_OR_PASSWORD_ERROR("A0210","用户名或密码错误"),
    INPUT_PASSWORD_EXCEED_LIMIT("A0211","用户输入密码次数超限"),
    CLIENT_AUTHENTICATION_FAILED("A0212","客户端认证失败"), // *
    TOKEN_INVALID_OR_EXPIRED("A0230","token无效或已过期"),

    USER_AUTHORIZED_ERROR ("A0300","访问权限异常"),
    USER_ACCESS_UNAUTHORIZED ("A0301","访问未授权");

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    private String code;

    private String msg;
}
