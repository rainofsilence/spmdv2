package cn.silence.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * <em>Application</em>
 *
 * @author rainofsilence
 * @date 2023/04/05 2:51:51
 * @desc
 */
@SpringBootApplication
@ComponentScan({"cn.silence.**"})
@MapperScan(basePackages = "cn.silence.dao.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
