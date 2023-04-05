package cn.silence.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author rainofsilence
 * @since 2023/04/05
 */
@Getter
@Setter
@TableName("user_info")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    /**
     * 登录账号
     */
    @TableField("username")
    private String username;

    /**
     * 登录密码
     */
    @TableField("password")
    private String password;

    /**
     * 昵称
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 性别
     */
    @TableField("gender")
    private String gender;

    /**
     * 真实姓名
     */
    @TableField("real_name")
    private String realName;

    /**
     * 证件类型
     */
    @TableField("id_type")
    private String idType;

    /**
     * 证件号码
     */
    @TableField("id_card")
    private String idCard;

    /**
     * 手机号
     */
    @TableField("phone")
    private String phone;

    /**
     * 邮件
     */
    @TableField("email")
    private String email;

    /**
     * 最后登录ip
     */
    @TableField("last_login_ip")
    private String lastLoginIp;

    @TableField("last_login_time")
    private LocalDateTime lastLoginTime;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;

    @TableField("delete_time")
    private LocalDateTime deleteTime;

    @TableField("deleted")
    @TableLogic
    private Boolean deleted;
}
