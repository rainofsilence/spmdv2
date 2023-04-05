package cn.silence.web.controller;

import cn.silence.common.toolkit.GsonUtil;
import cn.silence.web.Application;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * <em>UserInfoControllerTest</em>
 *
 * @author rainofsilence
 * @date 2023/04/05 22:50:28
 * @desc
 */
@SpringBootTest(classes = Application.class)
@Slf4j
class UserInfoControllerTest {

    @Resource
    private UserInfoController userInfoController;

    @Test
    void listTest() {
        log.info(GsonUtil.toJSONString(userInfoController.list()));
    }
}