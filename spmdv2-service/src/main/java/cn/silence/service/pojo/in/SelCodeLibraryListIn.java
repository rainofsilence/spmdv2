package cn.silence.service.pojo.in;

import lombok.Data;

import java.io.Serializable;

/**
 * <em>selectCodeLibraryIn</em>
 *
 * @author rainofsilence
 * @date 2023/4/3 19:49
 * @desc
 */
@Data
public class SelCodeLibraryListIn implements Serializable {
    private static final long serialVersionUID = 6453657655105674202L;
    private String codeNo;
    private String itemNo;
    private String itemNoLike;
    private String itemName;
    private String itemNameLike;
    private String orderName;
    private String collation;
}
