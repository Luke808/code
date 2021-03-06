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

    @Data
    public static class DbConnection {
        private String url;

        private String username;

        private String password;

        private String driverClassName = "com.mysql.jdbc.Driver";
    }

    @Data
    public static class Context {
        private String id = "CodeGen";

        private String targetRuntime = "Mybatis3";
    }

}
