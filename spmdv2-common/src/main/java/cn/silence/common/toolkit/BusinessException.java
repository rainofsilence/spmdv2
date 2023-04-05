package cn.silence.common.toolkit;



/**
 * @author rainofsilence
 * @date 2022/11/2 周三
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = -6756292905165881829L;
    private final int code;

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    public BusinessException(ErrorCode errorCode, String message) {
        super(message);
        this.code = errorCode.getCode();
    }

    public int getCode() {
        return code;
    }
}
