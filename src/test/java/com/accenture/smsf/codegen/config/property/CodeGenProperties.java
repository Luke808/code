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
