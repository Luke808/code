package com.accenture.smsf.codegen;

import com.accenture.smsf.codegen.config.property.CodeGenProperties;
import com.accenture.smsf.codegen.service.CodeGenerator;
import com.accenture.smsf.framework.boot.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

@Component
@Slf4j
public class CodeGeneratorRunner implements ApplicationRunner {

    @Autowired
    @Qualifier("daoGenerator")
    private CodeGenerator daoGenerator;

    @Autowired
    @Qualifier("serviceGenerator")
    private CodeGenerator serviceGenerator;

    @Autowired
    @Qualifier("controllerGenerator")
    private CodeGenerator controllerGenerator;

    @Autowired
    private CodeGenProperties codeGenProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        daoGenerator.gen();
        serviceGenerator.gen();
        controllerGenerator.gen();
    }
}
