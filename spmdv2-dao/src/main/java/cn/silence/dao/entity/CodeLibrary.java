package cn.silence.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 码值表
 * </p>
 *
 * @author rainofsilence
 * @since 2023/04/05
 */
@Getter
@Setter
@TableName("code_library")
public class CodeLibrary implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("code_no")
    private String codeNo;

    @TableField("code_name")
    private String codeName;

    @TableField("item_no")
    private String itemNo;

    @TableField("item_name")
    private String itemName;

    @TableField("description")
    private String description;

    @TableField("inuse")
    private Boolean inuse;

    @TableField("sort_no")
    private String sortNo;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;
}
