package com.wxx.generator.utils;

/**
 * @author 她爱微笑
 * @date 2020/7/27
 */
public class GenInfo {

    private static final String CONSTRUCT = "/src/main/java";

    /**
     * 模块绝对路径 (模块右键 Copy Path)
     */
    private String projectPath = "/Users/xxx/xxx/xxx-user/xxx-user-rest";

    /**
     * 作者
     */
    private String author = "YLJUN";

    /**
     * 数据库连接
     */
    private String url = "jdbc:mysql://localhost:3306/bishe?useUnicode=true&useSSL=false&characterEncoding=utf8";
    private String driverName = "com.mysql.jdbc.Driver";
    private String userName = "root";
    private String password = "123456";
    private String dbName = "bishe";

    /**
     * 是否生成 controller 与 service
     */
    private Boolean genController = true;
    private Boolean genService = true;

    /**
     * controller service 包名
     */
    private String controllerPackageName = "com.xx.xx.user.rest.controller";
    private String servicePackageName = "com.xx.xx.user.rest.service";
    private String serviceImplPackageName = "com.xx.xx.user.rest.service.impl";

    /**
     * dao包名
     */
    private String entityPackageName = "com.xx.xx.user.rest.model.pojo";
    private String mapperPackageName = "com.xx.xx.user.rest.dao.mapper";
    private String xmlPackageName = "com.xx.xx.user.rest.dao.mapping";

    /**
     * 表前缀
     */
    private String tablePrefix = "eb_";

    /**
     * 是否覆盖已存在的文件
     */
    private Boolean overrideExistFile = true;

    /**
     * controller统一前缀
     */
    private String modelName;

    public String getProjectPath() {
        return projectPath + CONSTRUCT;
    }

    public String getServiceImplPackageName() {
        return servicePackageName + ".impl";
    }

    public String getDbName() {
        return dbName;
    }

    public String getAuthor() {
        return author;
    }

    public String getUrl() {
        return url;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getGenController() {
        return genController;
    }

    public Boolean getGenService() {
        return genService;
    }

    public String getControllerPackageName() {
        return controllerPackageName;
    }

    public String getServicePackageName() {
        return servicePackageName;
    }

    public String getEntityPackageName() {
        return entityPackageName;
    }

    public String getMapperPackageName() {
        return mapperPackageName;
    }

    public String getXmlPackageName() {
        return xmlPackageName;
    }

    public String getTablePrefix() {
        return tablePrefix;
    }

    public Boolean getOverrideExistFile() {
        return overrideExistFile;
    }

    public String getModelName() {
        return modelName;
    }

    public GenInfo setProjectPath(String projectPath) {
        this.projectPath = projectPath;
        return this;
    }

    public GenInfo setAuthor(String author) {
        this.author = author;
        return this;
    }

    public GenInfo setUrl(String url) {
        this.url = url;
        return this;
    }

    public GenInfo setDriverName(String driverName) {
        this.driverName = driverName;
        return this;
    }

    public GenInfo setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public GenInfo setPassword(String password) {
        this.password = password;
        return this;
    }

    public GenInfo setGenController(Boolean genController) {
        this.genController = genController;
        return this;
    }

    public GenInfo setGenService(Boolean genService) {
        this.genService = genService;
        return this;
    }

    public GenInfo setControllerPackageName(String controllerPackageName) {
        this.controllerPackageName = controllerPackageName;
        return this;
    }

    public GenInfo setServicePackageName(String servicePackageName) {
        this.servicePackageName = servicePackageName;
        return this;
    }

    public GenInfo setServiceImplPackageName(String serviceImplPackageName) {
        this.serviceImplPackageName = serviceImplPackageName;
        return this;
    }

    public GenInfo setEntityPackageName(String entityPackageName) {
        this.entityPackageName = entityPackageName;
        return this;
    }

    public GenInfo setMapperPackageName(String mapperPackageName) {
        this.mapperPackageName = mapperPackageName;
        return this;
    }

    public GenInfo setXmlPackageName(String xmlPackageName) {
        this.xmlPackageName = xmlPackageName;
        return this;
    }

    public GenInfo setTablePrefix(String tablePrefix) {
        this.tablePrefix = tablePrefix;
        return this;
    }

    public GenInfo setOverrideExistFile(Boolean overrideExistFile) {
        this.overrideExistFile = overrideExistFile;
        return this;
    }

    public GenInfo setDbName(String dbName) {
        this.dbName = dbName;
        return this;
    }

    public GenInfo setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public static GenInfo build() {
        return new GenInfo();
    }

    public void over() {
        MybatisGenUtils.codeCreate(this);
    }
}
