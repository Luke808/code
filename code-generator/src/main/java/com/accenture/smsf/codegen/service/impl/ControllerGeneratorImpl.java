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

@Service("controllerGenerator")
@Slf4j
public class ControllerGeneratorImpl implements CodeGenerator {

    @Autowired
    private CodeGenProperties codeGenProperties;

    @Autowired
    private Configuration configuration;

    @Override
    public void gen() throws Exception {
        for (CodeGenProperties.Resource resource : codeGenProperties.getResources()) {
            Map<String, Object> data = new HashMap<>();
            data.put("author", codeGenProperties.getAuthor());
            data.put("moduleName", codeGenProperties.getModuleName());
            data.put("modelNameUpperCamel", resource.getModelName());
            data.put("modelNameLowerCamel", StringUtils.toLowerCaseFirstChar(resource.getModelName()));
            data.put("basePackage", codeGenProperties.getBasePackage());

            File controllerFile = new File(codeGenProperties.getProjectPath() +
                    codeGenProperties.getJavaPath() +
                    "/" +
                    codeGenProperties.getControllerPath() +
                    "/" +
                    resource.getModelName() +
                    "Controller.java");
            if (!controllerFile.getParentFile().exists()) {
                controllerFile.getParentFile().mkdirs();
            } else {
                controllerFile.delete();
            }
            configuration.getTemplate("controller.ftl").process(data, new FileWriter(controllerFile));

        }
        log.info("Controller生成成功!");
    }

}
