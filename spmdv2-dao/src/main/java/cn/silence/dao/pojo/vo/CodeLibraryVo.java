package cn.silence.dao.pojo.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <em>CodeLibraryVo</em>
 *
 * @author rainofsilence
 * @date 2023/4/3 21:14
 * @desc
 */
@Data
public class CodeLibraryVo implements Serializable {
    private static final long serialVersionUID = -1992647952197075712L;
    private String codeNo;
    private String codeName;
    private String itemNo;
    private String itemName;
    private String description;
    private Boolean inuse;
    private String sortNo;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
}
