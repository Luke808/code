package com.accenture.smsf.codegen.service.impl;

import com.accenture.smsf.codegen.config.property.CodeGenProperties;
import com.accenture.smsf.codegen.service.CodeGenerator;
import com.accenture.smsf.codegen.utils.StringUtils;
import com.accenture.smsf.framework.boot.stereotype.Service;
import freemarker.template.Configuration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

@Service("applicationGenerator")
@Slf4j
public class ApplicationGeneratorImpl implements CodeGenerator {

    @Autowired
    private CodeGenProperties codeGenProperties;

    @Autowired
    private Configuration configuration;

    @Override
    public void gen() throws Exception {
        Map<String, Object> data = new HashMap<>();
        data.put("author", codeGenProperties.getAuthor());
        data.put("moduleName", codeGenProperties.getModuleName());
        data.put("moduleNameUpperCase", StringUtils.toUpperCaseFirstOne(codeGenProperties.getModuleName()));
        data.put("basePackage", codeGenProperties.getBasePackage());

        File controllerFile = new File(codeGenProperties.getProjectPath() +
                codeGenProperties.getJavaPath() +
                "/" +
                codeGenProperties.getBasePackagePath() +
                "/" +
                codeGenProperties.getModuleName() +
                "/" +
                StringUtils.toUpperCaseFirstOne(codeGenProperties.getModuleName()) +
                "Application.java");
        if (!controllerFile.getParentFile().exists()) {
            controllerFile.getParentFile().mkdirs();
        } else {
            controllerFile.delete();
        }
        configuration.getTemplate("application.ftl").process(data, new FileWriter(controllerFile));

        log.info("Application生成成功!");
    }

}
