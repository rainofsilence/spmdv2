package cn.silence.service.impl;

import cn.silence.common.toolkit.BeanUtilsPlus;
import cn.silence.common.toolkit.BusinessException;
import cn.silence.common.toolkit.ErrorCode;
import cn.silence.dao.entity.CodeCatalog;
import cn.silence.dao.entity.CodeLibrary;
import cn.silence.dao.mapper.CodeCatalogMapper;
import cn.silence.dao.mapper.CodeLibraryMapper;
import cn.silence.dao.pojo.in.SaveCodeCatalogIn;
import cn.silence.dao.pojo.in.SaveCodeLibraryIn;
import cn.silence.dao.pojo.in.SelCodeCatalogListIn;
import cn.silence.dao.pojo.in.SelCodeLibraryListIn;
import cn.silence.dao.pojo.vo.CodeCatalogVo;
import cn.silence.dao.pojo.vo.CodeLibraryVo;
import cn.silence.service.CodeCommonService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <em>CodeServiceImpl</em>
 *
 * @author rainofsilence
 * @date 2023/4/2 20:23
 * @desc
 */
@Service
public class CodeCommonServiceImpl implements CodeCommonService {

    @Resource
    private CodeCatalogMapper codeCatalogMapper;
    @Resource
    private CodeLibraryMapper codeLibraryMapper;

    @Override
    public boolean isExistsCodeCatalog(String codeNo) {
        if (StringUtils.isBlank(codeNo)) return false;
        QueryWrapper<CodeCatalog> codeCatalogQueryWrapper = new QueryWrapper<>();
        codeCatalogQueryWrapper.eq("code_no", codeNo);
        CodeCatalog cc = codeCatalogMapper.selectOne(codeCatalogQueryWrapper);
        return cc != null;
    }

    @Override
    public boolean isExistsCodeLibrary(String codeNo, String itemNo) {
        if (StringUtils.isAnyBlank(codeNo, itemNo)) return false;
        QueryWrapper<CodeLibrary> codeLibraryQueryWrapper = new QueryWrapper<>();
        codeLibraryQueryWrapper.eq("code_no", codeNo).eq("item_no", itemNo);
        CodeLibrary cl = codeLibraryMapper.selectOne(codeLibraryQueryWrapper);
        return cl != null;
    }

    @Override
    public String selectCodeCatalogIdByCodeNo(String codeNo) {
        if (StringUtils.isBlank(codeNo)) return null;
        QueryWrapper<CodeCatalog> codeCatalogQueryWrapper = new QueryWrapper<>();
        codeCatalogQueryWrapper.eq("code_no", codeNo);
        CodeCatalog cc = codeCatalogMapper.selectOne(codeCatalogQueryWrapper);
        return cc == null ? null : cc.getId();
    }

    @Override
    public String selectCodeLibraryIdByCodeNoAndItemNo(String codeNo, String itemNo) {
        if (StringUtils.isAnyBlank(codeNo, itemNo)) return null;
        QueryWrapper<CodeLibrary> codeLibraryQueryWrapper = new QueryWrapper<>();
        codeLibraryQueryWrapper.eq("code_no", codeNo).eq("item_no", itemNo);
        CodeLibrary cl = codeLibraryMapper.selectOne(codeLibraryQueryWrapper);
        return cl == null ? null : cl.getId();
    }

    @Override
    public List<CodeCatalogVo> selectCodeCatalog(SelCodeCatalogListIn in) {
        QueryWrapper<CodeCatalog> codeCatalogQueryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(in.getCodeNo())) codeCatalogQueryWrapper.eq("code_no", in.getCodeNo());
        if (StringUtils.isNotBlank(in.getCodeNoLike()))
            codeCatalogQueryWrapper.likeRight("code_no", in.getCodeNoLike());
        if (StringUtils.isNotBlank(in.getCodeNameLike()))
            codeCatalogQueryWrapper.likeRight("code_name", in.getCodeNameLike());
        List<CodeCatalog> codeCatalogList = codeCatalogMapper.selectList(codeCatalogQueryWrapper);
        return BeanUtilsPlus.copyListProperties(codeCatalogList, CodeCatalogVo::new);
    }

    @Override
    public List<CodeLibraryVo> selectCodeLibrary(SelCodeLibraryListIn in) {
        if (StringUtils.isBlank(in.getCodeNo())) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "CodeNo must be not null!");
        }
        QueryWrapper<CodeLibrary> codeLibraryQueryWrapper = new QueryWrapper<>();
        codeLibraryQueryWrapper.eq("code_no", in.getCodeNo());
        if (StringUtils.isNotBlank(in.getItemNo())) codeLibraryQueryWrapper.eq("item_no", in.getItemNo());
        if (StringUtils.isNotBlank(in.getItemNoLike())) codeLibraryQueryWrapper.likeRight("item_no", in.getItemNo());
        if (StringUtils.isNotBlank(in.getItemName())) codeLibraryQueryWrapper.eq("item_name", in.getItemName());
        if (StringUtils.isNotBlank(in.getItemNameLike()))
            codeLibraryQueryWrapper.likeRight("item_name", in.getItemName());
        List<CodeLibrary> codeLibraryList = codeLibraryMapper.selectList(codeLibraryQueryWrapper);
        return BeanUtilsPlus.copyListProperties(codeLibraryList, CodeLibraryVo::new);
    }

    @Override
    public String saveCodeCatalog(SaveCodeCatalogIn in) {
        if (StringUtils.isAnyBlank(in.getCodeNo(), in.getCodeName())) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "CodeNo,CodeName must be not null!");
        }
        CodeCatalog cc = BeanUtilsPlus.copyProperties(in, CodeCatalog::new);
        String id = selectCodeCatalogIdByCodeNo(in.getCodeNo());
        if (StringUtils.isBlank(id)) {
            cc.setId(in.getCodeNo());
            codeCatalogMapper.insert(cc);
            return null;
        }
        cc.setId(id);
        codeCatalogMapper.updateById(cc);
        return null;
    }

    @Override
    @Transactional
    public String saveCodeLibrary(SaveCodeLibraryIn in) {
        if (StringUtils.isBlank(in.getCodeNo())) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "CodeNo must be not null!");
        }
        if (!isExistsCodeCatalog(in.getCodeNo())) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "CodeNo is not exists in CodeCatalog!");
        }
        in.getCodeSaveVoList().forEach(codeSaveVo -> {
            if (StringUtils.isAnyBlank(codeSaveVo.getItemNo(), codeSaveVo.getItemName())) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "ItemNo,ItemName must be not null!");
            }
            CodeLibrary cl = BeanUtilsPlus.copyProperties(codeSaveVo, CodeLibrary::new);
            cl.setCodeNo(in.getCodeNo());
            String id = selectCodeLibraryIdByCodeNoAndItemNo(in.getCodeNo(), codeSaveVo.getItemNo());
            if (StringUtils.isBlank(id)) {
                cl.setId(in.getCodeNo() + codeSaveVo.getItemNo());
                codeLibraryMapper.insert(cl);
                return;
            }
            cl.setId(id);
            codeLibraryMapper.updateById(cl);
        });
        return null;
    }

}
