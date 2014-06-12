package com.WhiteDessert.GraduateReference.DataBase;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.WhiteDessert.GraduateReference.Help.RefHlp;
import com.WhiteDessert.GraduateReference.Help.Spec;
import com.WhiteDessert.GraduateReference.Help.University;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by yazeed44 on 12/05/14.
 */
public class ReferenceDB {

    //Database fields

    private SQLiteDatabase database;
    public MySQLiteHelper dbHelper;

    public boolean isFirst =false;
    public ReferenceDB(Context context){
        dbHelper = new MySQLiteHelper(context);
    }
    public void open() throws SQLiteException{
       // database = dbHelper.getWritableDatabase();
        try {
            dbHelper.createDataBase();
        }
        catch(IOException e){
            isFirst = true;
            throw new Error("Unable to create database");

        }

        try {
            dbHelper.openDataBase();
            database = dbHelper.myDataBase;
        }

        catch(SQLException sq){
            isFirst = true;
            throw sq;
        }
    }

    public void close(){
        dbHelper.close();
    }

    //unused
  /*  public void insertUniv(University univ){
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_NAME,univ.getName());
        values.put(MySQLiteHelper.COLUMN_REGION,univ.getRegions());
        values.put(MySQLiteHelper.COLUMN_RANK,univ.getRank());
        values.put(MySQLiteHelper.COLUMN_IMAGE,univ.getImage());
        values.put(MySQLiteHelper.COLUMN_MAIN_URL,univ.getMainUrl());


        database.insert(MySQLiteHelper.TABLE_UNIVS,null,values);
    }*/

    //Unused

  /*  public void insertSpec(Spec spec){
        ContentValues values = new ContentValues();
        String subSpecs = "";

        values.put(MySQLiteHelper.COLUMN_NAME,spec.getName());
        values.put(MySQLiteHelper.COLUMN_DESC,spec.getDesc());
        for(int i = 0 ; i < spec.getSubSpec().length;i++){
         subSpecs += spec.getSubSpec()[i].getName() + "\n";
        }
        values.put(MySQLiteHelper.COLUMN_SUB_SPECS,subSpecs);
        values.put(MySQLiteHelper.COLUMN_WHERE_TO_STUDY,spec.getWhereToStudy());

        database.insert(MySQLiteHelper.TABLE_SPECS,null,values);
    }*/

    // used for one time
  /*  public void insertSpecs(Spec[] specs){
        for(int i = 0 ; i< specs.length;i++){
            Spec spec = specs[i];
            ContentValues values = new ContentValues();
            values.put(MySQLiteHelper.COLUMN_NAME,spec.getName());
            values.put(MySQLiteHelper.COLUMN_DESC,spec.getDesc());
            values.put(MySQLiteHelper.COLUMN_SUB_SPECS,spec.getSubSpecsString());
            values.put(MySQLiteHelper.COLUMN_WHERE_TO_STUDY,spec.getWhereToStudy());
            database.insert(MySQLiteHelper.TABLE_SPECS,null,values);
        }
    }*/

    // used for one time
   /* public void insertSpecs(ArrayList<Spec> specs){
        for(int i = 0 ; i < specs.size();i++){
            Spec spec = specs.get(i);
           insertSpec(spec);
        }
    }*/

    //used for one time
   /* public void insertUnivs(University[] univs){

        for(int i = 0 ; i < univs.length;i++){
            University univ = univs[i];
            ContentValues values = new ContentValues();
            values.put(MySQLiteHelper.COLUMN_NAME,univ.getName());
            values.put(MySQLiteHelper.COLUMN_REGION,univ.getRegions());
            values.put(MySQLiteHelper.COLUMN_RANK,univ.getRank());
            values.put(MySQLiteHelper.COLUMN_IMAGE,univ.getImage());
            values.put(MySQLiteHelper.COLUMN_MAIN_URL,univ.getMainUrl());
            database.insert(MySQLiteHelper.TABLE_UNIVS,null,values);

        }
    }*/

    //used for one time
   /* public void insertUnivs(ArrayList<University> univs){

        for(int i = 0 ; i < univs.size();i++){
            University univ = univs.get(i);
            ContentValues values = new ContentValues();
            values.put(MySQLiteHelper.COLUMN_NAME,univ.getName());
            values.put(MySQLiteHelper.COLUMN_REGION,univ.getRegions());
            values.put(MySQLiteHelper.COLUMN_RANK,univ.getRank());
            values.put(MySQLiteHelper.COLUMN_IMAGE,univ.getImage());
            values.put(MySQLiteHelper.COLUMN_MAIN_URL,univ.getMainUrl());
            database.insert(MySQLiteHelper.TABLE_UNIVS,null,values);
        }
    }*/

    //unused
   /* public void deleteUniv(int id){

        database.delete(MySQLiteHelper.TABLE_UNIVS,MySQLiteHelper.COLUMN_ID +" = " + id,null);
    }*/


    // unused
   /* public University getUniv(int id){

        Cursor cursor = database.rawQuery("SELECT * FROM "+ MySQLiteHelper.TABLE_UNIVS +" WHERE " + MySQLiteHelper.COLUMN_ID + " = " + id,null);

        cursor.moveToFirst();

        University univ = new University(cursor.getString(1),cursor.getString(2),cursor.getInt(3),cursor.getInt(4),cursor.getString(5));

        cursor.close();
        return univ;
    }*/

    // important
    public University getUniv(String name){
        Cursor cursor = database.rawQuery("SELECT * FROM " + MySQLiteHelper.TABLE_UNIVS + " WHERE " + MySQLiteHelper.COLUMN_NAME + " = " + "'"+ name + "'",null);
        cursor.moveToFirst();

        University univ = new University(cursor.getString(1),cursor.getString(2),cursor.getInt(3),cursor.getString(4),cursor.getString(5));

        cursor.close();
        return univ;
    }

    //important
   public Spec getSpec(String name){
       Cursor cursor = database.rawQuery("SELECT * FROM " + MySQLiteHelper.TABLE_SPECS +" WHERE "+ MySQLiteHelper.COLUMN_NAME + " = " + "'" + name + "';",null);
       cursor.moveToFirst();

       Spec spec = new Spec(cursor.getString(1));
       spec.setDesc(cursor.getString(2));
       spec.setSubSpecsString(cursor.getString(3));
       spec.setWhereToStudy(cursor.getString(4));

       cursor.close();
       return spec;
   }

    //very important
    public ArrayList<University> getAllUnivs(){
        ArrayList<University> univs = new ArrayList<University>();

        Cursor cursor = database.rawQuery("SELECT * FROM " + MySQLiteHelper.TABLE_UNIVS,null);

        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            University univ = new University(cursor.getString(1),cursor.getString(2),cursor.getInt(3),cursor.getString(4),cursor.getString(5));
            univs.add(univ);
            cursor.moveToNext();
        }
        //make sure to close the cursor
        cursor.close();

        Collections.sort(univs, RefHlp.COMPRATOR_UNIV);
        return univs;
    }

    //important

    public ArrayList<String> getUnivsNames(){
        ArrayList<String> univNames = new ArrayList<String>();

        Cursor cursor = database.rawQuery("SELECT " + MySQLiteHelper.COLUMN_NAME + " FROM "+ MySQLiteHelper.TABLE_UNIVS,null);

        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            //get the name for univ
            univNames.add(cursor.getString(cursor.getColumnIndex(MySQLiteHelper.COLUMN_NAME)));
            cursor.moveToNext();

        }

        cursor.close();

        return univNames;
    }

    //very important
    public ArrayList<Spec> getAllSpecs(){
        ArrayList<Spec> specs = new ArrayList<Spec>();
        Cursor cursor = database.rawQuery("SELECT * FROM " + MySQLiteHelper.TABLE_SPECS,null);
cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            Spec spec =  new Spec(cursor.getString(1));
            spec.setDesc(cursor.getString(2));
            spec.setSubSpecsString(cursor.getString(3));
            spec.setWhereToStudy(cursor.getString(4));
            specs.add(spec);
            cursor.moveToNext();
        }
cursor.close();
        return specs;
    }

    //unused
   /* public void deleteAllUnivs(){
   //     Cursor cursor = database.rawQuery("DELETE FROM " + MySQLiteHelper.TABLE_UNIVS,null);

        database.rawQuery("DELETE FROM " + MySQLiteHelper.TABLE_UNIVS,null);
    }*/

   /* public ArrayList getUnivsWhereContain(String letters){
       ArrayList<University> univs = new ArrayList<University>();

        Cursor cursor = database.rawQuery("SELECT * FROM " + MySQLiteHelper.TABLE_UNIVS + " WHERE " + MySQLiteHelper.COLUMN_NAME +
                " LIKE '%" + letters +"%';",null);

        cursor.moveToFirst();

        while(!cursor.isAfterLast()){
            University univ = new University(cursor.getString(1),cursor.getString(2),cursor.getInt(3),cursor.getInt(4),cursor.getString(5));
            univs.add(univ);
            cursor.moveToNext();
        }

        cursor.close();

        return univs;
    }*/
}
