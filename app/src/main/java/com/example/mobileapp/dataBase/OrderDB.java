package com.example.mobileapp.dataBase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mobileapp.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderDB {

    private static final String ORDER_TABLE = "ORDER_TABLE";

    private static final String COLUMN_ID_ORDER = "COLUMN_ID_ORDER";
    private static final String COLUMN_USER = "COLUMN_USER";
    private static final String COLUMN_ADDRESS= "COLUMN_ADDRESS";

    public static String createOrder(){
        String createTableOrder = "CREATE TABLE " + ORDER_TABLE + " ("
                + COLUMN_ID_ORDER + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_USER + " INTEGER, "
                + COLUMN_ADDRESS + " TEXT)";

        return createTableOrder;
    }

    public static boolean addOneOrder(Order order, SQLiteDatabase db) {
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_USER, order.getUser());
        cv.put(COLUMN_ADDRESS, order.getAddress());

        long insert = db.insert(ORDER_TABLE, null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }

    public static List<Order> getAllOrders(SQLiteDatabase db) {
        List<Order> returnList = new ArrayList<>();

        String queryString = "SELECT * FROM " + ORDER_TABLE;

        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            do {
                int idOrder = cursor.getInt(0);
                int user = cursor.getInt(1);
                String address = cursor.getString(2);

                Order newOrder = new Order(idOrder, user, address);
                returnList.add(newOrder);

            } while (cursor.moveToFirst());

        } else {

        }
        cursor.close();
        db.close();
        return returnList;
    }

}


// apelat din cos