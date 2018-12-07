package ${basePackage}.${moduleName}.controller;
import ${basePackage}.${moduleName}.core.entity.${modelNameUpperCamel};
import ${basePackage}.${moduleName}.service.${modelNameUpperCamel}Service;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import com.accenture.smsf.framework.starter.web.core.annotation.RestController;

import java.util.List;

/**
 *
 * @author ${author}
 */
@RestController
@RequestMapping("/${moduleName}/${modelNameLowerCamel}")
public class ${modelNameUpperCamel}Controller {

    @Autowired
    ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @PostMapping("/save")
    public int save(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {
        return ${modelNameLowerCamel}Service.save(${modelNameLowerCamel});
    }

    @PostMapping("/batch-save")
    public int save(@RequestBody List<${modelNameUpperCamel}> ${modelNameLowerCamel}s) {
        return ${modelNameLowerCamel}Service.save(${modelNameLowerCamel}s);
    }

    @DeleteMapping("/delete")
    public int delete(@RequestParam("id") String id) {
	    return ${modelNameLowerCamel}Service.delete(id);
    }

    @DeleteMapping("/batch-delete")
    public int batchDelete(@RequestParam("ids") String ids) {
        return ${modelNameLowerCamel}Service.batchDelete(ids);
    }

    @PutMapping("/update")
    public int update(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {
	    return ${modelNameLowerCamel}Service.update(${modelNameLowerCamel});
    }

    @GetMapping("/find")
    public ${modelNameUpperCamel} find(@RequestParam("id") String id) {
        return ${modelNameLowerCamel}Service.findById(id);
    }

    @GetMapping("/list")
    public PageInfo<${modelNameUpperCamel}> list(@RequestParam(value="pageNumber", defaultValue = "0") int pageNumber,
    @RequestParam(value="pageSize", defaultValue = "0") int pageSize) {
        List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.list(pageNumber, pageSize);
        return new PageInfo(list);
    }
}
