package cn.silence.dao.common.controller;

import cn.silence.dao.common.entity.PageInfo;
import cn.silence.dao.common.entity.Result;
import cn.silence.dao.common.service.CommonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.List;

/**
 * 通用controller
 *
 * @param <V> vo对象
 * @param <T> entity实体
 */
public class CommonController<V, T> {

    @Resource
    private CommonService<V, T> commonService;

    /*
        CRUD、分页、排序测试
     */

    // 方便测试暂时改成GetMapping
    @GetMapping("page")
//    @PostMapping("page")
    public Result<PageInfo<V>> page(V entityVo) {
        return commonService.page(entityVo);
    }

    // 方便测试暂时改成GetMapping
    @GetMapping("list")
//    @PostMapping("list")
    public Result<List<V>> list(V entityVo) {
        return commonService.list(entityVo);
    }

    @GetMapping("get/{id}")
    public Result<V> get(@PathVariable("id") String id) {
        return commonService.get(id);
    }

    // 方便测试暂时改成GetMapping
    @GetMapping("save")
//    @PostMapping("save")
    public Result<V> save(V entityVo) {
        return commonService.save(entityVo);
    }

    @GetMapping("delete/{id}")
    public Result<String> delete(@PathVariable("id") String id) {
        return commonService.delete(id);
    }
}
