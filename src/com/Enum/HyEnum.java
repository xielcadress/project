package com.Enum;

public enum HyEnum {
	
	jrl("金融类") {},
	kjl("科技类") {},
	qcl("汽车类") {},
	kxl("快消类") {},
	fdcl("房地产类") {},
	yxl("游戏类") {},
	shfwl("生活服务类") {},
	yyl("医药类") {},
	swfwl("商务服务类") {},
	jtl("交通类") {},
	
	qtjgl("其他机构类") {};

	private String value;

	private HyEnum(String value)
	{
		this.value = value;
	}

	public String getValue()
	{
		return value;
	}
}
