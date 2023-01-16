package com.example.mobileapp.dataBase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mobileapp.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDB {

   private static final String USER_TABLE = "USER_TABLE";

   private static final String COLUMN_ID_USER = "COLUMN_ID_USER";
   private static final String COLUMN_USER_USERNAME = "COLUMN_USER_USERNAME";
   private static final String COLUMN_USER_NAME = "COLUMN_USER_NAME";
   private static final String COLUMN_USER_PASSWORD = "COLUMN_USER_PASSWORD";
   private static final String COLUMN_USER_EMAIL = "COLUMN_USER_EMAIL";
   private static final String COLUMN_USER_PHONE = "COLUMN_USER_PHONE";

   public static String createUser(){
       String createTableUser = "CREATE TABLE " + USER_TABLE + " ("
               + COLUMN_ID_USER + " INTEGER PRIMARY KEY AUTOINCREMENT, "
               + COLUMN_USER_USERNAME + " TEXT, "
               + COLUMN_USER_NAME + " TEXT, "
               + COLUMN_USER_PASSWORD + " TEXT, "
               + COLUMN_USER_EMAIL + " TEXT, "
               + COLUMN_USER_PHONE + " TEXT)";

       return createTableUser;
   }

    public static boolean addOneUser(User user, SQLiteDatabase db) {
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_USER_USERNAME, user.getUsername());
        cv.put(COLUMN_USER_NAME, user.getName());
        cv.put(COLUMN_USER_PASSWORD, user.getPassword());
        cv.put(COLUMN_USER_EMAIL, user.getEmail());
        cv.put(COLUMN_USER_PHONE, user.getPhoneNumber());

        long insert = db.insert(USER_TABLE, null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }

    public static List<User> getEveryoneUsers(SQLiteDatabase db) {
        List<User> returnList = new ArrayList<>();

        String queryString = "SELECT * FROM " + USER_TABLE;

        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            do {
                int idUser = cursor.getInt(0);
                String userUsername = cursor.getString(1);
                String userName = cursor.getString(2);
                String userPassword = cursor.getString(3);
                String userEmail = cursor.getString(4);
                String userPhone = cursor.getString(5);

                User newUser = new User(idUser, userUsername, userName, userPassword, userEmail, userPhone);
                returnList.add(newUser);

            } while (cursor.moveToNext());

        } else {
            System.out.println("Tabel gol");
        }
        cursor.close();
        db.close();
        return returnList;
    }

}
