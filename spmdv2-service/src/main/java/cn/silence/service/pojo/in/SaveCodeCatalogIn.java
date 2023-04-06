package cn.silence.service.pojo.in;

import lombok.Data;

import java.io.Serializable;

/**
 * <em>SaveCodeCatalogIn</em>
 *
 * @author rainofsilence
 * @date 2023/4/4 20:18
 * @desc
 */
@Data
public class SaveCodeCatalogIn implements Serializable {
    private static final long serialVersionUID = -6527027928261373879L;
    private String codeNo;
    private String codeName;
    private String description;
    private Boolean inuse;
    private String sortNo;
}
