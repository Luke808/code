package com.ac.smsf.codegen.core.condition;

import lombok.Data;

import java.util.List;

@Data
public class FilterRule {
	
	//AND OR
	private String condition;
	
	//字段名
	private String field;
	
	//比较符 >,>=,=,<,<=,!=
	private String operator;
	
	//子查询条件
	private List<FilterRule> rules;
	
	//字段类型(string,int,date....)
	private String type;
	
	//条件值
	private String value;

}
