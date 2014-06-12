package com.WhiteDessert.GraduateReference.Help;

/**
 * Created by yazeed44 on 13/05/14.
 */
public class MuslimScientist {

     public int image;
    public String name,desc,wikiUrl;
    public MuslimScientist(int image , String name , String desc,String wikiUrl){
    this.image = image;
        this.name = name;
        this.desc = desc +".";
        this.wikiUrl = wikiUrl;
    }

    public void setImage(int image){
      this.image = image;
    }
    public void setName(String name){
 this.name = name;
    }
    public void setDesc(String desc){
this.desc = desc;
    }
    public void setWikiUrl(String wikiUrl){this.wikiUrl = wikiUrl;}



    public int getImage(){
return image;
    }
    public String getWikiUrl(){return wikiUrl;}
    public String getName(){
return name;
    }
    public String getDesc(){
return desc;
    }
}
