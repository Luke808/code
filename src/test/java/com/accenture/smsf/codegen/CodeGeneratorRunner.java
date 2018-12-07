package com.accenture.smsf.codegen;

import com.accenture.smsf.codegen.config.property.CodeGenProperties;
import com.accenture.smsf.codegen.service.CodeGenerator;
import com.accenture.smsf.framework.boot.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

@Component
@Slf4j
public class CodeGeneratorRunner implements ApplicationRunner {

    @Autowired
    private CodeGenerator codeGenerator;

    @Autowired
    private CodeGenProperties codeGenProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        codeGenProperties.getResources().forEach(resource -> {
            log.info(resource.getModelName() + " === " + resource.getTableName());
        });
        codeGenerator.gen();
    }
}
