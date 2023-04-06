package cn.silence.service.api;


import cn.silence.service.pojo.in.SaveCodeCatalogIn;
import cn.silence.service.pojo.in.SaveCodeLibraryIn;
import cn.silence.service.pojo.in.SelCodeCatalogListIn;
import cn.silence.service.pojo.in.SelCodeLibraryListIn;
import cn.silence.service.pojo.vo.CodeCatalogVo;
import cn.silence.service.pojo.vo.CodeLibraryVo;

import java.util.List;

/**
 * <em>CodeService</em>
 *
 * @author rainofsilence
 * @date 2023/4/2 20:23
 * @desc 枚举值公共服务
 */
public interface CodeCommonService {

    boolean isExistsCodeCatalog(String codeNo);

    boolean isExistsCodeLibrary(String codeNo, String itemNo);

    String selectCodeCatalogIdByCodeNo(String codeNo);

    String selectCodeLibraryIdByCodeNoAndItemNo(String codeNo, String itemNo);

    List<CodeCatalogVo> selectCodeCatalog(SelCodeCatalogListIn in);

    List<CodeLibraryVo> selectCodeLibrary(SelCodeLibraryListIn in);

    String saveCodeCatalog(SaveCodeCatalogIn in);

    String saveCodeLibrary(SaveCodeLibraryIn in);

}
