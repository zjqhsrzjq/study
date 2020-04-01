package com.example.george.study.service.abstractStudy;

public class TestChild extends Test {


    private String company;

    TestChild(String name, Integer age,String company){
        super(name, age);
        setCompany(company);
    }


    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

}
