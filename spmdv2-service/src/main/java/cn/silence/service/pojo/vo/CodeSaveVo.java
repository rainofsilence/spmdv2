package cn.silence.service.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * <em>CodeSaveVo</em>
 *
 * @author rainofsilence
 * @date 2023/4/3 20:44
 * @desc
 */
@Data
public class CodeSaveVo implements Serializable {
    private static final long serialVersionUID = -4868388278240648160L;
    private String itemNo;
    private String itemName;
    private String description;
    private Boolean inuse;
    private String sortNo;
}
