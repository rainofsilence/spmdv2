package cn.silence.common.toolkit;

import lombok.Data;

import java.io.Serializable;

/**
 * <em>BaseResponse</em>
 *
 * @author rainofsilence
 * @date 2023/03/26 19:00:30
 * @desc
 */
@Data
public class BaseResponse<T> implements Serializable {
    private static final long serialVersionUID = 3536435571756552263L;

    private int code;

    private T data;

    private String message;

    public BaseResponse(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public BaseResponse(int code, T data) {
        this(code, data, "");
    }

    public BaseResponse(ErrorCode errorCode) {
        this(errorCode.getCode(), null, errorCode.getMessage());
    }
}
