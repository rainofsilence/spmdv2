package cn.silence.service;


import cn.silence.dao.pojo.vo.UserInfoVo;

import java.util.List;

/**
 * <em>UserInfoService</em>
 *
 * @author rainofsilence
 * @date 2023/04/02 18:21:35
 * @desc
 */
public interface UserInfoService {

    List<UserInfoVo> listAll();
}
