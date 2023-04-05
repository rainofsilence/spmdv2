package cn.silence.common.toolkit;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * <em>BeanCopyUtil</em>
 *
 * @author rainofsilence
 * @date 2023/04/02 22:01:27
 * @desc
 */
public class BeanUtilsPlus extends BeanUtils {

    /**
     * 集合数据的拷贝
     *
     * @param sources: 数据源类
     * @param target:  目标类::new(eg: UserVO::new)
     * @return
     */
    public static <S, T> List<T> copyListProperties(List<S> sources, Supplier<T> target) {
        return copyListProperties(sources, target, null);
    }


    /**
     * 带回调函数的集合数据的拷贝（可自定义字段拷贝规则）
     *
     * @param sources:  数据源类
     * @param target:   目标类::new(eg: UserVO::new)
     * @param callback: 回调函数
     * @return
     */
    public static <S, T> List<T> copyListProperties(List<S> sources, Supplier<T> target, BeanUtilsPlusCallback<S, T> callback) {
        List<T> list = new ArrayList<>(sources.size());
        for (S source : sources) {
            T t = target.get();
            copyProperties(source, t);
            list.add(t);
            if (callback != null) {
                // 回调
                callback.callback(source, t);
            }
        }
        return list;
    }

    /**
     *
     * @param source
     * @param target
     * @return
     * @param <S>
     * @param <T>
     */
    public static <S, T> T copyProperties(S source, Supplier<T> target) {
        if (source==null) return null;
        T t = target.get();
        copyProperties(source, t);
        return t;
    }
}

@FunctionalInterface
interface BeanUtilsPlusCallback<S, T> {

    /**
     * @param s
     * @param t
     */
    void callback(S s, T t);
}
