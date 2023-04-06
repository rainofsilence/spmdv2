package cn.silence.web.controller;

import cn.silence.common.toolkit.BaseResponse;
import cn.silence.common.toolkit.GsonUtil;
import cn.silence.common.toolkit.ResultUtils;
import cn.silence.service.pojo.in.SaveCodeCatalogIn;
import cn.silence.service.pojo.in.SaveCodeLibraryIn;
import cn.silence.service.pojo.in.SelCodeCatalogListIn;
import cn.silence.service.pojo.in.SelCodeLibraryListIn;
import cn.silence.service.pojo.vo.CodeCatalogVo;
import cn.silence.service.pojo.vo.CodeLibraryVo;
import cn.silence.service.api.CodeCommonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <em>CodeController</em>
 *
 * @author rainofsilence
 * @date 2023/04/02 22:17:17
 * @desc
 */
@RestController
@RequestMapping("/code")
@Slf4j
public class CodeCommonController {

    @Resource
    private CodeCommonService codeCommonService;

    /**
     * 查询code_catalog列表
     *
     * @param in
     * @return
     */
    @PostMapping("/listCodeCatalog")
    public BaseResponse<List<CodeCatalogVo>> listCodeCatalog(@RequestBody SelCodeCatalogListIn in) {
        log.info("CodeCommonController.listCodeCatalog start, param={}", GsonUtil.toJSONString(in));
        return ResultUtils.success(codeCommonService.selectCodeCatalog(in));
    }

    /**
     * 查询code_library列表
     *
     * @param in
     * @return
     */
    @PostMapping("/listCodeLibrary")
    public BaseResponse<List<CodeLibraryVo>> listCodeLibrary(@RequestBody SelCodeLibraryListIn in) {
        log.info("CodeCommonController.listCodeLibrary start, param={}", GsonUtil.toJSONString(in));
        return ResultUtils.success(codeCommonService.selectCodeLibrary(in));
    }


    /**
     * 新增或更新code_catalog
     *
     * @param in
     * @return
     */
    @PostMapping("/saveCodeCatalog")
    public BaseResponse<String> saveCodeCatalog(@RequestBody SaveCodeCatalogIn in) {
        log.info("CodeCommonController.saveCodeCatalog start, param={}", GsonUtil.toJSONString(in));
        return ResultUtils.success(codeCommonService.saveCodeCatalog(in));
    }

    /**
     * 新增或更新code_library
     *
     * @param in
     * @return
     */
    @PostMapping("/saveCodeLibrary")
    public BaseResponse<String> saveCodeLibrary(@RequestBody SaveCodeLibraryIn in) {
        log.info("CodeCommonController.saveCodeLibrary start, param={}", GsonUtil.toJSONString(in));
        return ResultUtils.success(codeCommonService.saveCodeLibrary(in));
    }
}
