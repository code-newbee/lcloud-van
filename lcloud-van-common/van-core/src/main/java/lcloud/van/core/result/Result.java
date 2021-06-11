package lcloud.van.core.result;

import lombok.Data;

import java.io.Serializable;

/**
 * 功能描述：
 *
 * @Author: XKK
 * @Date: 2021/6/1 14:57
 */
@Data
public class Result<T> implements Serializable {

    private String code;

    private T data;

    private String msg;

    private static <T> Result<T> result(String code, String msg, T data) {
        Result<T> result = new Result<T>();
        result.setCode(code);
        result.setData(data);
        result.setMsg(msg);
        return result;
    }

    private static <T> Result<T> result(IResultCode resultCode, T data) {
        return result(resultCode.getCode(), resultCode.getMsg(), data);
    }

    public static <T> Result<T> success() {
        return success(null);
    }

    public static <T> Result<T> success(T data) {
        ResultCodeEnum rce = ResultCodeEnum.SUCCESS;
        if (data instanceof Boolean && Boolean.FALSE.equals(data)) {
            rce = ResultCodeEnum.ERROR;
        }
        return result(rce, data);
    }

    public static <T> Result<T> failed(IResultCode resultCode) {
        return result(resultCode.getCode(), resultCode.getMsg(), null);
    }


}
