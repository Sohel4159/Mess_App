package com.example.mess_app;
import  java.util.*;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBhelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "student_data";
    private static final int DATABASE_VERSION = 1;
    private static final String Col1 = "reg_no";
    private static final String Col2 = "name";
    private static final String Col3 = "room_no";


    public DBhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create your table
        String createTableQuery = "CREATE TABLE " + DATABASE_NAME + " ( " +
                Col1 + " TEXT PRIMARY KEY, " +
                Col2 + " TEXT, " +
                Col3 + " TEXT)";
        db.execSQL(createTableQuery);
       // db.rawQuery("insert into "+DATABASE_NAME+" ("+Col1+ "," + Col2+ ","+ Col3+") values('2020BIT059','Bhange Sohel Nahnu','SHGD05' )",null);
       // INSERT INTO students (id, name, age) VALUES (1, 'John Doe', 25);
    }


//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        // Create your table
//        String createTableQuery = "CREATE TABLE "+ DATABASE_NAME+"  ( "+Col1+"TEXT PRIMARY KEY ," +
//                Col2+" TEXT,"+ Col3 +"TEXT)";
//                db.execSQL(createTableQuery);
////        SQLiteDatabase db1 = this.getWritableDatabase();
////        ContentValues values = new ContentValues();
////        values.put("reg_no", "2020BIT059");
////        values.put("name", "Bhange Sohel Nahnu");
////        values.put("room_no","ShGD07");
////        db1.insert(DATABASE_NAME,null,values);
//    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle database upgrades if needed

    }




    public long insertData(String reg_no, String name,String room_no) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Col1, reg_no);
        values.put(Col2, name);
        values.put(Col3,room_no);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(DATABASE_NAME, null, values);

        // Close the database
        db.close();

        return  newRowId;


    }

public boolean isPresent(String reg) {
    SQLiteDatabase readable = this.getReadableDatabase();

    Cursor cursor = readable.rawQuery("SELECT * FROM " + DATABASE_NAME  , null);
    boolean ans = false;
    // int nameColumnIndex = cursor.getColumnIndex(Col1);

    int c1= cursor.getColumnIndex(Col1);
    int c2= cursor.getColumnIndex(Col2);
    int c3= cursor.getColumnIndex(Col3);
    while (cursor.moveToNext())
    {
        String reg1 = cursor.getString(c1);
        String name = cursor.getString(c2);
        String room = cursor.getString(c3);

        Log.d("cursorEx",String.valueOf(reg1)+" " + reg1);



        if(String.valueOf(reg1).equalsIgnoreCase(reg))
        {

            ans=true;
            break;
        }
        Log.d("count", " "+cursor.getCount());
    }
    cursor.close();
    readable.close();
    return ans;
    }

public ArrayList<StudentData> fetchData()
{
    SQLiteDatabase readable = this.getReadableDatabase();

    Cursor cursor = readable.rawQuery("SELECT * FROM " + DATABASE_NAME  , null);

    ArrayList<StudentData> data=new ArrayList<>();
    // int nameColumnIndex = cursor.getColumnIndex(Col1);

    int c1= cursor.getColumnIndex(Col1);
    int c2= cursor.getColumnIndex(Col2);
    int c3= cursor.getColumnIndex(Col3);
    while (cursor.moveToNext()) {
        String reg1 = (cursor.getString(c1));
        String name = (cursor.getString(c2));
        String room =(cursor.getString(c3));
        data.add(new StudentData(name,reg1,room));
        Log.d( "fetchData: ",reg1+" "+String.valueOf(reg1));
    }

    return data;
}

//

//    }







}
