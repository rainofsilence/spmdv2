package cn.silence.dao;


import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.jupiter.api.Test;

import java.util.Collections;

/**
 * <em>MybatisPlusGeneratorTest</em>
 *
 * @author rainofsilence
 * @date 2023/04/01 22:12:56
 * @desc
 */
class CodeGeneratorTest {

    private static final String URL = "jdbc:mysql://localhost:3306/spmd?characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";
    private static final String PARENT_PACKAGE = "cn.silence";
    private static final String MODULE_NAME = "dao";
    private static final String OUTPUT_DIR = System.getProperty("user.dir") + "/src/test/resources/";
    private static final String XML_OUTPUT_DIR =
            String.format("%s/%s/%s/mapper/", OUTPUT_DIR, PARENT_PACKAGE.replace(".", "/"), MODULE_NAME);


    @Test
    void generator() {
        FastAutoGenerator.create(URL, USERNAME, PASSWORD)
                .globalConfig(builder -> {
                    builder.author("rainofsilence") // 设置作者
                            .commentDate("yyyy/MM/dd") // 注释日期
                            // .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(OUTPUT_DIR) // 指定输出目录
                    ;
                })
                .packageConfig(builder -> {
                    builder.parent(PARENT_PACKAGE) // 设置父包名
                            .moduleName(MODULE_NAME) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, XML_OUTPUT_DIR)) // 设置mapperXml生成路径
                    ;
                })
                .strategyConfig(builder -> {
                    builder
                            // .addInclude("user_info") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_") // 设置过滤表前缀
                            .entityBuilder() // Entity 策略
                            .enableLombok() // 开启 lombok 模型
                            .enableTableFieldAnnotation() // 开启生成实体时生成字段注解
                            .logicDeleteColumnName("deleted") // 逻辑删除字段名(数据库)
                            .logicDeletePropertyName("Boolean") // 逻辑删除属性名(实体)
                            .enableFileOverride()
                            .mapperBuilder() // Mapper 策略
                            .enableBaseResultMap() // 启用 BaseResultMap 生成
                            .enableBaseColumnList() // 启用 BaseColumnList
                            .enableFileOverride() // 覆盖已生成文件
                    ;

                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateConfig(builder -> {
                    builder
                            .disable(TemplateType.CONTROLLER) // 不生成 Controller
                            .disable(TemplateType.SERVICE) // 不生成 Service
                            .disable(TemplateType.SERVICE_IMPL) // 不生成 ServiceImpl
                    ;
                })
                .execute();
    }
}
