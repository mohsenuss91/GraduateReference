package com.WhiteDessert.GraduateReference.Help;

import java.io.Serializable;

/**
 * Created by yazeed on 13/04/14.
 */
public class SubSpec implements Serializable {

    public String name;
    public String hint;
    public SubSpec(String name){
        this.name = name;

    }

    public void setName(String name){
        this.name = name;
    }

    public void setHint(String hint){
        this.hint = hint;
    }

    public String getName(){
        return this.name;
    }

    public String getHint(){
        return this.hint;
    }
}
