package cn.silence.dao.mapper;

import cn.silence.dao.entity.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author rainofsilence
 * @since 2023/04/05
 */
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    /**
     * 用来测试mapper.xml功能是否正常
     *
     * @return
     */
    List<UserInfo> listAllTest();
}
