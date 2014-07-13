package com.WhiteDessert.GraduateReference.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by yazeed44 on 12/05/14.
 */
public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "reference.db";
    public static String DB_PATH = "/data/data/com.whitedessert.graduatereference/databases/";

    public static final int DB_VERSION = 3;
    public static final String TABLE_SPECS = "specs";
    public static final String TABLE_UNIVS = "univs";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME ="name";
    public static final String COLUMN_REGION ="region";
    public static final String COLUMN_RANK = "rank";
    public static final String COLUMN_IMAGE = "image";
    public static final String COLUMN_MAIN_URL ="mainUrl";
    public static final String COLUMN_DESC = "desc";
    public static final String  COLUMN_WHERE_TO_STUDY = "whereToStudy";
    public static final String COLUMN_SUB_SPECS ="subSpecs";

    private final Context context;
    public SQLiteDatabase myDataBase;


    public MySQLiteHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
        this.context = context;
        if(android.os.Build.VERSION.SDK_INT >= 17){
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        }
        else
        {
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        }
        Log.i("MySQLiteHelper","Database path = " + DB_PATH);
    }

    /**
     * Creates a empty database on the system and rewrites it with your own database.
     * */
    public void createDataBase() throws IOException {

        boolean dbExist = checkDataBase();

        if(dbExist){
//do nothing - database already exist
        }else{

//By calling this method and empty database will be created into the default system path
//of your application so we are gonna be able to overwrite that database with our database.
            this.getReadableDatabase();

            try {

                copyDataBase();

            } catch (IOException e) {

                throw new Error("Error copying database");

            }
        }

    }

    /**
     * Check if the database already exist to avoid re-copying the file each time you open the application.
     * @return true if it exists, false if it doesn't
     */
    public boolean checkDataBase(){

        SQLiteDatabase checkDB = null;

        try{
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

        }catch(SQLiteException e){

//database does't exist yet.

        }

        if(checkDB != null){

            checkDB.close();

        }

        return checkDB != null ? true : false;
    }

    /**
     * Copies your database from your local assets-folder to the just created empty database in the
     * system folder, from where it can be accessed and handled.
     * This is done by transfering bytestream.
     * */
    private void copyDataBase() throws IOException{

//Open your local db as the input stream
        InputStream myInput = context.getAssets().open(DB_NAME);
        Log.i("MySQLiteHelper", "the input = " + myInput.toString());
// Path to the just created empty db
        String outFileName = DB_PATH + DB_NAME;

//Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

//transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);
        }

//Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    public void openDataBase() throws android.database.SQLException{

//Open the database
        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

    }

    @Override
    public synchronized void close() {

        if(myDataBase != null)
            myDataBase.close();

        super.close();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
