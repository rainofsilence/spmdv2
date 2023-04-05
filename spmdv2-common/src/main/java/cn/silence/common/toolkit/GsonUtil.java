package cn.silence.common.toolkit;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * <em>GsonUtil</em>
 *
 * @author rainofsilence
 * @date 2023/04/02 21:23:18
 * @desc
 */
@Slf4j
public class GsonUtil {

    /**
     * Obj -> JSONString
     *
     * @param obj
     * @return
     */
    public static String toJSONString(Object obj) {
        if (Objects.isNull(obj)) return "";
        try {
            Gson gson = new Gson();
            return gson.toJson(obj);
        } catch (Exception e) {
            log.error("GsonUtil.toJSONString FAIL, {}", e.getMessage());
        }
        return "";
    }
}
