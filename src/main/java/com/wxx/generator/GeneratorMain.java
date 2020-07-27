package com.wxx.generator;

import com.wxx.generator.utils.GenInfo;

/**
 * @author 她爱微笑
 * @date 2020/7/27
 */
public class GeneratorMain {
    public static void main(String[] args) {
        GenInfo.build()
                .setUrl("jdbc:mysql://localhost:3306/gulimall_oms?useUnicode=true&useSSL=false&characterEncoding=utf8")
                .setUserName("root")
                .setPassword("root")
                // 数据库名称
                .setDbName("gulimall_oms")
                // 表前缀
                .setTablePrefix("oms_")
                // controller统一前缀
                .setModelName("order")
                // 作者
                .setAuthor("wangxin")
                //设置模块路径
                .setProjectPath("C:\\Users\\10758\\Desktop\\test")
                //设置controller包名
                .setControllerPackageName("com.wxx.gulimall.controller")
                //设置service包名
                .setServicePackageName("com.wxx.gulimall.service")
                //设置dao包名
                .setEntityPackageName("com.wxx.gulimall.entity")
                .setMapperPackageName("com.wxx.gulimall.mapper")
                // mapper.xml存放路径 不用改
                .setXmlPackageName("mapper")
                //设置是否生成controller
                .setGenController(true)
                //设置是否生成service
                .setGenService(true)
                //设置是否覆盖已存在文件
                .setOverrideExistFile(false)
                //生成
                .over();
    }
}
