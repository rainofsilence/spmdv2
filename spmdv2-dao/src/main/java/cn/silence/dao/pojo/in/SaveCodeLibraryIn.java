package cn.silence.dao.pojo.in;

import cn.silence.dao.pojo.vo.CodeSaveVo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <em>SaveCodeLibraryIn</em>
 *
 * @author rainofsilence
 * @date 2023/4/3 20:13
 * @desc
 */
@Data
public class SaveCodeLibraryIn implements Serializable {
    private static final long serialVersionUID = 8622728214193075699L;
    private String codeNo;
    List<CodeSaveVo> codeSaveVoList;
}
