package com.accenture.smsf.codegen.config.property;

import com.accenture.smsf.framework.boot.stereotype.Component;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author s.c.gao
 */
@ConfigurationProperties(prefix = CodeGenMybatisProperties.PREFIX)
@Data
@Component
public class CodeGenMybatisProperties {

    public static final String PREFIX = "smsf.codegen.mybatis";

    private Context context = new Context();

    private DbConnection datasource = new DbConnection();

    private String mappingXmlRootDirectory = "mappings.";

    private String moduleName = "sample";

    private String projectPath = System.getProperty("user.dir");

    private String resourcePath = "/src/main/resources";

    private String javaPath = "/src/main/java";

    private String entityPackage = "com.accenture.smsf.codegen.sample.core.entity";

    private String mapperPackage = "com.accenture.smsf.codegen.sample.core.mapper";

    private String servicePackage = "com.accenture.smsf.codegen.sample.service";

    private String controllerPackage = "com.accenture.smsf.codegen.sample.controller";

    @Data
    public static class DbConnection {
        private String url = "jdbc:mysql://10.237.161.213:3306/smsf_authority?useUnicode=true&characterEncoding=utf8";

        private String username = "user_dev";

        private String password = "Zaq_2wsx";

        private String driverClassName = "com.mysql.jdbc.Driver";
    }

    @Data
    public static class Context {
        private String id = "CodeGen";

        private String targetRuntime = "Mybatis3";
    }

}
