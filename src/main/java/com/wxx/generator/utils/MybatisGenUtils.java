package com.wxx.generator.utils;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 她爱微笑
 * @date 2020/7/27
 */
public class MybatisGenUtils {

    /**
     * 代码生成
     *
     * @param genInfo
     */
    public static void codeCreate(final GenInfo genInfo) {
        System.out.println("-------开始生成代码-------");
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setFileOverride(genInfo.getOverrideExistFile());
        gc.setEnableCache(false);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        //输入路径
        gc.setOutputDir(genInfo.getProjectPath());
        //作者
        gc.setAuthor(genInfo.getAuthor());
        gc.setOpen(false);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(genInfo.getUrl());
        dsc.setDriverName(genInfo.getDriverName());
        dsc.setUsername(genInfo.getUserName());
        dsc.setPassword(genInfo.getPassword());
        mpg.setDataSource(dsc);

        //自定义配置,必须配置,不然报错
        InjectionConfig injectionConfig = new InjectionConfig() {
            //自定义属性注入:abc
            //在.ftl(或者是.vm)模板中，通过${cfg.abc}获取属性
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>(1);
                map.put("myModelName", genInfo.getModelName());
                this.setMap(map);
            }
        };

        mpg.setCfg(injectionConfig);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(null);
        pc.setModuleName(null);

        pc.setController(genInfo.getGenController() ? genInfo.getControllerPackageName() : "TTT");
        pc.setService(genInfo.getGenService() ? genInfo.getServicePackageName() : "TTT");
        pc.setServiceImpl(genInfo.getGenService() ? genInfo.getServiceImplPackageName() : "TTT");

        //配置dao包名
        pc.setEntity(genInfo.getEntityPackageName());
        pc.setMapper(genInfo.getMapperPackageName());
        pc.setXml(genInfo.getXmlPackageName());
        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 此处可以修改为您的表前缀
        strategy.setTablePrefix(new String[]{genInfo.getTablePrefix()});
        strategy.setNaming(NamingStrategy.underline_to_camel);

        TemplateConfig tc = new TemplateConfig();
        tc.setController("/templates/mycontroller.java");

        mpg.setTemplate(tc);
        List<String> tableList = showTables(dsc, genInfo.getDbName());
        String[] tables = new String[tableList.size()];
        tableList.toArray(tables);

        strategy.setInclude(tables);
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();

        destory(gc);

        System.out.println("");
        System.out.println("-------代码生成完成-------");
    }


    /**
     * 删除不必要的代码
     */
    public static void destory(GlobalConfig globalConfig) {
        String outputDir = globalConfig.getOutputDir() + "/TTT";
        UtilCollection.deleteDir(new File(outputDir));
    }

    /**
     * 显示所有表名,这里查询了注释
     *
     * @param dsc    数据源配置
     * @param dbName 数据库名
     */
    public static List<String> showTables(DataSourceConfig dsc, String dbName) {
        List<String> list = new ArrayList<String>();
        try {
            ResultSet resultSet = dsc.getConn().createStatement().executeQuery("select TABLE_NAME as tableName,TABLE_COMMENT as tableComment from information_schema.`TABLES` where TABLE_SCHEMA = '" + dbName + "'");
            while (resultSet.next()) {
                String tableName = resultSet.getString(1);
                list.add(tableName);
                System.err.println(tableName);
            }
            System.err.println("");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
