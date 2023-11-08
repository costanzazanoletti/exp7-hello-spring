package com.experis.course.hellospring.model;

public class Student {

  private String code;
  private String name;

  public Student(String code, String name) {
    this.code = code;
    this.name = name;
  }

  public Student() {

  }

  public String getCode() {
    return code;
  }

  public String getName() {
    return name;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public void setName(String name) {
    this.name = name;
  }
}
