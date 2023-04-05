package cn.silence.dao.pojo.in;

import lombok.Data;

import java.io.Serializable;

/**
 * <em>SelCodeCatalogListIn</em>
 *
 * @author rainofsilence
 * @date 2023/4/3 20:59
 * @desc
 */
@Data
public class SelCodeCatalogListIn implements Serializable {
    private static final long serialVersionUID = 1097374703449967299L;
    private String codeNo;
    private String codeNoLike;
    private String codeNameLike;
    private String orderName;
    private String collation;
}
