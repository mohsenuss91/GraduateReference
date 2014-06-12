package com.WhiteDessert.GraduateReference.Help;

import java.io.Serializable;

/**
 * Created by yazeed on 13/04/14.
 */
public class Spec implements Serializable {


    private static final long serialVersionUID = 1L;
    public String name;
    public SubSpec[] subSpec;
    private String desc;
    private String whereToStudy;
    private String subSpecsString;
    public Spec(String name , SubSpec[] subSpec){
        this.name = name;
        this.subSpec = subSpec;

    }

    public Spec(String name){
        this.name = name;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSubSpecsString(String subSpecsString){this.subSpecsString = subSpecsString;}
    public void setDesc(String desc){this.desc = desc;}
    public void setSubSpec(SubSpec[] subSpec){
        this.subSpec = subSpec;
    }
public void setWhereToStudy(String whereToStudy){this.whereToStudy = whereToStudy;}

    public String getName(){
        return this.name;
    }
    public SubSpec[] getSubSpec(){
        return this.subSpec;
    }
    public String getDesc(){return this.desc;}
    public String getSubSpecsString(){return this.subSpecsString;}
    public String getWhereToStudy(){return this.whereToStudy;}
}
