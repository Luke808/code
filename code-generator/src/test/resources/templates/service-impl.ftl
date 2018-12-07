package ${basePackage}.${moduleName}.service.impl;

import ${basePackage}.${moduleName}.mapper.${modelNameUpperCamel}Mapper;
import ${basePackage}.${moduleName}.entity.${modelNameUpperCamel};
import ${basePackage}.${moduleName}.service.${modelNameUpperCamel}Service;
import com.accenture.smsf.codegen.core.service.impl.AbstractMapperServiceImpl;
import com.accenture.smsf.framework.boot.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ${author}
 */
@Service
public class ${modelNameUpperCamel}ServiceImpl extends AbstractMapperServiceImpl<${modelNameUpperCamel}> implements ${modelNameUpperCamel}Service {

    @Autowired
    private ${modelNameUpperCamel}Mapper ${modelNameLowerCamel}Mapper;

}
