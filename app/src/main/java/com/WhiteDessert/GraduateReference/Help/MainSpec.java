package com.WhiteDessert.GraduateReference.Help;

import java.io.Serializable;

/**
 * Created by yazeed on 13/04/14.
 */
public class MainSpec implements Serializable{

    public String name;
    public Spec[] spec;
    public MainSpec(String name , Spec[] spec){
        this.name = name;
        this.spec = spec;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSpecs(Spec[] spec){this.spec = spec;}

    public String getName(){
        return this.name;
    }

    public Spec[] getSpecs(){return this.spec;}

}
