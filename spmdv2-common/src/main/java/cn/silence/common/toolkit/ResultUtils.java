package cn.silence.common.toolkit;

/**
 * 响应工具类
 *
 * @author rainofsilence
 * @date 2022/11/1 周二
 */
public class ResultUtils {

    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(ErrorCode.SUCCESS.getCode(), data, ErrorCode.SUCCESS.getMessage());
    }

    public static BaseResponse error(ErrorCode errorCode) {
        return new BaseResponse<>(errorCode);
    }

    public static BaseResponse error(int code, String message) {
        return new BaseResponse<>(code, null, message);
    }

    public static BaseResponse error(ErrorCode errorCode, String message) {
        return new BaseResponse<>(errorCode.getCode(), null, message);
    }
}
