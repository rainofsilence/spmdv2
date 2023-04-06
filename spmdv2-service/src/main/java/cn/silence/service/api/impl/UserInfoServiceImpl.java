package cn.silence.service.api.impl;

import cn.silence.common.toolkit.BeanUtilsPlus;
import cn.silence.dao.entity.UserInfo;
import cn.silence.dao.mapper.UserInfoMapper;
import cn.silence.service.aop.MyAnnotation;
import cn.silence.service.pojo.vo.UserInfoVo;
import cn.silence.service.api.UserInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <em>UserInfoService</em>
 *
 * @author rainofsilence
 * @date 2023/04/02 18:21:51
 * @desc
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @MyAnnotation("aop 测试")
    @Override
    public List<UserInfoVo> listAll() {
        QueryWrapper<UserInfo> userInfoQueryWrapper = new QueryWrapper<>();
        List<UserInfo> userInfoList = userInfoMapper.selectList(userInfoQueryWrapper);
        if (userInfoList.size() > 0) {
            return BeanUtilsPlus.copyListProperties(userInfoList, UserInfoVo::new);
        }
        return new ArrayList<>();
    }
}
