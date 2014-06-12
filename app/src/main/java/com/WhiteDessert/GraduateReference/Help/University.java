package com.WhiteDessert.GraduateReference.Help;

import java.io.Serializable;

/**
 * Created by yazeed on 04/04/14.
 */
public class University implements Serializable{

    public String name,region;
    public Integer rank;
    public String image;
    public String mainUrl;
    //private College colleges[];

// سوف اكمل الكليات لاحقا عندما احصل على الملفات

    //read from left to right

    public University(String name , String region,Integer rank, String image,String mainUrl/*,College colleges[]*/){
     this.name = name;
        this.region = region;
        this.rank = rank;
        this.image = new StringBuffer(image).delete(0,11).toString();
        this.mainUrl = mainUrl;

    }

    public University(){

    }

    //Setters

    public void setName(String name){
        this.name = name;
    }
    public void setRegions(String region){
       this.region = region;
    }

    public void setRank(Integer rank){
        this.rank = rank;
    }

    public void setImage(String image){
        this.image = image;
    }

    public void setMainUrl(String mainUrl){this.mainUrl = mainUrl;}
    /*public void setColleges(College colleges[]){
        this.colleges = colleges;

    }*/



    //Getters

    public String getName(){

        return this.name;
    }
    public String getRegions(){
        return this.region;
    }

    public Integer getRank(){
        return this.rank;
    }

    public String getImage(){
        return this.image;
    }

    public String getMainUrl(){return this.mainUrl;}
   /* public College[] getColleges(){
        return this.colleges;
    }*/

}
