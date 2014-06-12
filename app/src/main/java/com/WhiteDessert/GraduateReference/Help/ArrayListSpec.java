package com.WhiteDessert.GraduateReference.Help;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by yazeed44 on 18/05/14.
 */
public class ArrayListSpec extends ArrayList<Spec> {


    public void addArray(Spec[] specs){

       Collections.addAll(this,specs);
    }
}
