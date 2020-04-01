package com.example.george.study.common.enums;

public enum TestFactoryType implements BaseEnum{

    FIRST(1,"first"),
    SECOND(2,"second"),
    THIRD(3,"third"),
    FOURTH(4,"fourth");

    private Integer code;

    private String desc;

    TestFactoryType(Integer code, String desc){
        this.code =code;
        this.desc =desc;
    }

    public static String getDesc(Integer code){
        for(TestFactoryType type: TestFactoryType.values()){
            if(type.code.equals(code)){
                return type.desc;
            }
        }
        return null;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getDesc() {
        return desc;
    }
}
