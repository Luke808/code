package com.accenture.smsf.codegen.service.impl;

import com.accenture.smsf.codegen.config.property.CodeGenMybatisProperties;
import com.accenture.smsf.codegen.config.property.CodeGenProperties;
import com.accenture.smsf.codegen.service.CodeGenerator;
import com.accenture.smsf.framework.boot.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.*;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CodeGeneratorImpl implements CodeGenerator {

    @Autowired
    private CodeGenProperties codeGenProperties;

    @Autowired
    private CodeGenMybatisProperties codeGenMybatisProperties;

    @Override
    public void gen() {
        List<String> warnings = null;
        MyBatisGenerator generator = null;
        try {
            Configuration cfg = new Configuration();
            cfg.addContext(initConfig());
            cfg.validate();

            DefaultShellCallback callback = new DefaultShellCallback(true);
            warnings = new ArrayList<String>();
            generator = new MyBatisGenerator(cfg, callback, warnings);
            generator.generate(null);
        } catch (Exception e) {
            throw new RuntimeException("数据库配置失败!", e);
        }

        if (generator == null || generator.getGeneratedJavaFiles().isEmpty() || generator.getGeneratedXmlFiles().isEmpty()) {
            throw new RuntimeException("Model 和  Mapper 生成失败, warnings: " + warnings);
        }

        log.info("生成成功!");
    }

    public Context initMybatisGeneratorContext() {
        Context context = new Context(ModelType.FLAT);
        // 设置context的一些属性
        context.setId(codeGenMybatisProperties.getContext().getId());
        context.setTargetRuntime(codeGenMybatisProperties.getContext().getTargetRuntime());
        context.addProperty(PropertyRegistry.CONTEXT_BEGINNING_DELIMITER, "`");
        context.addProperty(PropertyRegistry.CONTEXT_ENDING_DELIMITER, "`");
        // 设置jdbc
        JDBCConnectionConfiguration jdbcConnectionConfiguration = new JDBCConnectionConfiguration();
        jdbcConnectionConfiguration.setConnectionURL(codeGenMybatisProperties.getDatasource().getUrl());
        jdbcConnectionConfiguration.setUserId(codeGenMybatisProperties.getDatasource().getUsername());
        jdbcConnectionConfiguration.setPassword(codeGenMybatisProperties.getDatasource().getPassword());
        jdbcConnectionConfiguration.setDriverClass(codeGenMybatisProperties.getDatasource().getDriverClassName());
        context.setJdbcConnectionConfiguration(jdbcConnectionConfiguration);
        // 设置 mapping xml
        SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = new SqlMapGeneratorConfiguration();
        sqlMapGeneratorConfiguration.setTargetProject(codeGenMybatisProperties.getProjectPath() + codeGenMybatisProperties.getResourcePath());
        sqlMapGeneratorConfiguration.setTargetPackage("mappings." + codeGenMybatisProperties.getModuleName());
        context.setSqlMapGeneratorConfiguration(sqlMapGeneratorConfiguration);
        // 设置 entity
        JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
        javaModelGeneratorConfiguration.setTargetProject(codeGenMybatisProperties.getProjectPath() + codeGenMybatisProperties.getJavaPath());
        javaModelGeneratorConfiguration.setTargetPackage(codeGenMybatisProperties.getEntityPackage());
        context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);
        // 设置 mapper
        JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = new JavaClientGeneratorConfiguration();
        javaClientGeneratorConfiguration.setTargetProject(codeGenMybatisProperties.getProjectPath() + codeGenMybatisProperties.getJavaPath());
        javaClientGeneratorConfiguration.setTargetPackage(codeGenMybatisProperties.getMapperPackage());
        javaClientGeneratorConfiguration.setConfigurationType("XMLMAPPER");
        context.setJavaClientGeneratorConfiguration(javaClientGeneratorConfiguration);

        // 增加 mapper 插件
        addMapperPlugin(context);

        return context;
    }

    private void addMapperPlugin(Context context) {
        PluginConfiguration pluginConfiguration = new PluginConfiguration();
        pluginConfiguration.setConfigurationType("tk.mybatis.mapper.generator.MapperPlugin");
        pluginConfiguration.addProperty("mappers", codeGenMybatisProperties.getMapperPackage());
        context.addPluginConfiguration(pluginConfiguration);
    }

    private Context initConfig() {
        Context context = initMybatisGeneratorContext();
        codeGenProperties.getResources().forEach(resource -> {
            TableConfiguration tableConfiguration = new TableConfiguration(context);
            tableConfiguration.setTableName(resource.getTableName());
            tableConfiguration.setDomainObjectName(resource.getModelName());
            tableConfiguration.setGeneratedKey(new GeneratedKey(resource.getPrimaryKeyColumn(), "Mysql", true, null));
            context.addTableConfiguration(tableConfiguration);
        });

        return context;
    }
}
