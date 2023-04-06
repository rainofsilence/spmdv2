package cn.silence.service.pojo.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <em>CodeCatalogVo</em>
 *
 * @author rainofsilence
 * @date 2023/4/3 21:09
 * @desc
 */
@Data
public class CodeCatalogVo implements Serializable {
    private static final long serialVersionUID = 2757132266143588150L;
    private String codeNo;
    private String codeName;
    private String description;
    private Boolean inuse;
    private String sortNo;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

}
