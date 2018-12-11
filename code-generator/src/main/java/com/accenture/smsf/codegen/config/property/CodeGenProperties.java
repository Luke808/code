package com.accenture.smsf.codegen.config.property;

import com.accenture.smsf.framework.boot.stereotype.Component;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * @author s.c.gao
 */
@ConfigurationProperties(prefix = CodeGenProperties.PREFIX)
@Data
@Component
public class CodeGenProperties {

    public static final String PREFIX = "smsf.codegen";

    private List<Resource> resources = new ArrayList<>();

    private String author = "s.c.gao";

    private String projectModulePath = "code-generator-output";

    private String moduleName = "task";

    private String projectPath = System.getProperty("user.dir") + "/" + projectModulePath;

    private String resourcePath = "/src/main/resources";

    private String javaPath = "/src/main/java";

    private String basePackage = "com.accenture.smsf.apisp.task";

    private String entityPackage = basePackage + "." + moduleName + "." + "core.entity";

    private String mapperPackage = basePackage + "." + moduleName + "." + "core.mapper";

    private String servicePackage = basePackage + "." + moduleName + "." + "service";

    private String controllerPackage = basePackage + "." + moduleName + "." + "controller";

    public String getBasePackagePath() {
        return basePackage.replace(".", "/");
    }

    public String getServicePath() {
        return servicePackage.replace(".", "/");
    }

    public String getControllerPath() {
        return controllerPackage.replace(".", "/");
    }

    @Data
    public static class Resource {

        /**
         * 数据库表名
         */
        private String tableName;
        /**
         * 数据库表名对应的模型名称
         */
        private String modelName;
        /**
         * 主键列名
         */
        private String primaryKeyColumn = "id";
    }
}
