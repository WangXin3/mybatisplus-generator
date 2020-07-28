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
                .setPackageName("com.wxx.testmybatisplus")
                //设置模块路径
                .setProjectPath("C:\\Users\\10758\\Desktop\\test-mybatisplus")
                //设置是否覆盖已存在文件
                .setOverrideExistFile(false)
                //生成
                .over();
    }
}
