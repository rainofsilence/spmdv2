package cn.silence.service.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * <em>UserInfoVo</em>
 *
 * @author rainofsilence
 * @date 2023/04/02 21:29:21
 * @desc
 */
@Data
public class UserInfoVo implements Serializable {
    private static final long serialVersionUID = 5335876577589134123L;

    private String username;

    private String nickname;

    private String gender;

    private String genderName;

    private String phone;

    private String email;
}
