package com.bysj.event.znz.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author: Hv
 * @E-MAIL: huowei@yuntongxun.com
 * @CreateDate: 2021/03/27 13:53
 * @Description:
 * @Version: 1.0
 */
public class CodeGenerator {
    public static void main(String[] args) {
        process("", "stu");
    }

    public static void process(String moduleName, String tableName) {
        AutoGenerator engine = new AutoGenerator();
        engine.setGlobalConfig(getGlocalConfig());
        // 设置数据源
        engine.setDataSource(getDataSource());
        // 设置包配置
        engine.setPackageInfo(getPackage(moduleName));
        // 设置表配置
        engine.setStrategy(getStrategy(tableName));
        // 配置模板
        engine.setCfg(getInjectionConfig(moduleName));
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        engine.setTemplate(templateConfig);
        engine.setTemplateEngine(new FreemarkerTemplateEngine());
        engine.execute();
    }

    private static DataSourceConfig getDataSource() {
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUrl("jdbc:mysql://localhost/test?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("root");
        return dataSourceConfig;
    }

    /**
     * 表配置
     */
    private static StrategyConfig getStrategy(String tableName) {
        StrategyConfig config = new StrategyConfig();
        // 表映射到实体全名策略
        config.setNaming(NamingStrategy.underline_to_camel);
        // 字段映射到实体的命名策略
        config.setColumnNaming(NamingStrategy.underline_to_camel);
        // 包含的表名
        config.setInclude(tableName);
        // 是否为lombok模型（默认 false）
        config.setEntityLombokModel(true);
        // 是否生成实体时，生成字段注解
        config.setEntityTableFieldAnnotationEnable(true);
        return config;
    }

    private static PackageConfig getPackage(String moduleName) {
        PackageConfig config = new PackageConfig();
        config.setParent("com.hw.study.spingmybatisdemo");
        config.setModuleName(moduleName);
        return config;
    }

    private static GlobalConfig getGlocalConfig() {
        GlobalConfig config = new GlobalConfig();
        config.setOutputDir(System.getProperty("user.dir") + "/src/main/java");
        config.setAuthor("huowei");
        config.setOpen(false);
        config.setEntityName("%sEntity");
        return config;
    }

    private static InjectionConfig getInjectionConfig(String moduleName) {
        // 自定义配置
        InjectionConfig config = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return System.getProperty("user.dir") + "/src/main/resources/mapper/" + moduleName
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        ArrayList<String> strings = Lists.newArrayList("Mapper.xml", "Service.java", "ServiceImpl.java", "Controller.java");
        config.setFileCreate((configBuilder, fileType, filePath) -> {
            // 判断自定义文件夹是否需要创建
            return strings.stream().noneMatch(filePath::contains);
        });
        config.setFileOutConfigList(focList);
        return config;
    }
}
