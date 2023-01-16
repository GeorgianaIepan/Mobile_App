package com.example.mobileapp.dataBase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mobileapp.model.OrderProduct;

import java.util.ArrayList;
import java.util.List;

public class OrderProductDB {

    private static final String ORDER_PRODUCT_TABLE = "ORDER_PRODUCT_TABLE";

    private static final String COLUMN_ID_ORDER_PRODUCT = "COLUMN_ID_ORDER_PRODUCT";
    private static final String COLUMN_ORDER = "COLUMN_ORDER";
    private static final String COLUMN_PRODUCT = "COLUMN_PRODUCT";
    private static final String COLUMN_ORDER_PRODUCT_QUANTITY = "COLUMN_ORDER_PRODUCT_QUANTITY";

    public static String createOrderProduct(){
        String createTableOrderProduct = "CREATE TABLE " + ORDER_PRODUCT_TABLE + " ("
                + COLUMN_ID_ORDER_PRODUCT + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_ORDER + " INTEGER, "
                + COLUMN_PRODUCT + " INTEGER, "
                + COLUMN_ORDER_PRODUCT_QUANTITY + " INTEGER)";

        return createTableOrderProduct;
    }

    public static boolean addOneOrderProduct(OrderProduct orderProduct, SQLiteDatabase db) {
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ORDER, orderProduct.getOrder());
        cv.put(COLUMN_PRODUCT, orderProduct.getProduct());
        cv.put(COLUMN_ORDER_PRODUCT_QUANTITY, orderProduct.getQuantity());

        long insert = db.insert(ORDER_PRODUCT_TABLE, null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }

    public static List<OrderProduct> getAllOrderProducts(SQLiteDatabase db) {
        List<OrderProduct> returnList = new ArrayList<>();

        String queryString = "SELECT * FROM " + ORDER_PRODUCT_TABLE;

        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            do {
                int idOrderProduct = cursor.getInt(0);
                int orderProductOrder = cursor.getInt(1);
                int orderProductProduct = cursor.getInt(2);
                int orderProductQuantity = cursor.getInt(3);

                OrderProduct newOrderProduct = new OrderProduct(idOrderProduct, orderProductOrder, orderProductProduct, orderProductQuantity);
                returnList.add(newOrderProduct);

            } while (cursor.moveToFirst());

        } else {

        }
        cursor.close();
        db.close();
        return returnList;
    }

}
