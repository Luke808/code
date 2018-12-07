package com.accenture.smsf.codegen.service.impl;

import com.accenture.smsf.codegen.config.property.CodeGenMybatisProperties;
import com.accenture.smsf.codegen.config.property.CodeGenProperties;
import com.accenture.smsf.codegen.service.CodeGenerator;
import com.accenture.smsf.framework.boot.stereotype.Service;
import freemarker.template.Configuration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileWriter;

@Service("serviceGenerator")
@Slf4j
public class ServiceGeneratorImpl implements CodeGenerator {

    @Autowired
    private CodeGenProperties codeGenProperties;

    @Autowired
    private CodeGenMybatisProperties codeGenMybatisProperties;

    @Autowired(required=false)
    private Configuration configuration;

    @Override
    public void gen() throws Exception{

//        codeGenProperties.getResources().forEach(resource -> {
//            // 创建 Service 接口
//            File serviceFile =
//                    new File(codeGenProperties.getProjectPath() +
//                            codeGenProperties.getJavaPath() +
//                            codeGenProperties.getServicePath()
//                            + resource.getModelName() + "Service.java");
//            // 查看父级目录是否存在, 不存在则创建
//            if (!serviceFile.getParentFile().exists()) {
//                serviceFile.getParentFile().mkdirs();
//            }
//            configuration.getTemplate("service.ftl").process(data, new FileWriter(serviceFile));
//
//            log.info("Service.java 生成成功!");
//
//            // 创建 Service 接口的实现类
//            File serviceImplFile = new File(codeGenProperties.getProjectPath() +
//                    codeGenProperties.getJavaPath() +
//                    codeGenProperties.getServicePath()
//                    + resource.getModelName() + "ServiceImpl.java");
//            // 查看父级目录是否存在, 不存在则创建
//            if (!serviceImplFile.getParentFile().exists()) {
//                serviceImplFile.getParentFile().mkdirs();
//            }
//
//            configuration.getTemplate("service-impl.ftl").process(data, new FileWriter(serviceImplFile));
//
//            log.info("ServiceImpl.java 生成成功!");
//        });

    }


}
