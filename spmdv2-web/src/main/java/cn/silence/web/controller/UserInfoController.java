package cn.silence.web.controller;

import cn.silence.common.toolkit.BaseResponse;
import cn.silence.common.toolkit.ResultUtils;
import cn.silence.service.pojo.vo.UserInfoVo;
import cn.silence.service.api.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <em>UserInfoController</em>
 *
 * @author rainofsilence
 * @date 2023/04/02 0:02:51
 * @desc
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;

    @GetMapping("/list")
    public BaseResponse<List<UserInfoVo>> list() {
        log.info("UserInfoController.list start");
        return ResultUtils.success(userInfoService.listAll());
    }
}
