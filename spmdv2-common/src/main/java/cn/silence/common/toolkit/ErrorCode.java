package cn.silence.common.toolkit;

/**
 * 响应错误码
 *
 * @author rainofsilence
 * @date 2022/11/1 周二
 */
public enum ErrorCode {
    SUCCESS(200, "ok"),
    PARAMS_ERROR(40000, "请求参数错误"),
    NOT_LOGIN_ERROR(40100, "未登陆"),
    SYSTEM_ERROR(50000, "系统内部异常"),
    ;

    private final int code;

    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
