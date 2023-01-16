package com.example.mobileapp.dataBase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mobileapp.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDB {

    private static final String PRODUCT_TABLE = "PRODUCT_TABLE";

    private static final String COLUMN_ID_PRODUCT = "COLUMN_ID_PRODUCT";
    private static final String COLUMN_PRODUCT_PRICE = "COLUMN_PRODUCT_PRICE";
    private static final String COLUMN_PRODUCT_NAME= "COLUMN_PRODUCT_NAME";
    private static final String COLUMN_PRODUCT_STOCK = "COLUMN_PRODUCT_STOCK";
    private static final String COLUMN_PRODUCT_DESCRIPTION = "COLUMN_PRODUCT_DESCRIPTION";

    public static String createProduct(){
        String createTableProduct = "CREATE TABLE " + PRODUCT_TABLE + " ("
                + COLUMN_ID_PRODUCT + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_PRODUCT_PRICE + " INTEGER, "
                + COLUMN_PRODUCT_NAME + " TEXT, "
                + COLUMN_PRODUCT_STOCK + " INTEGER, "
                + COLUMN_PRODUCT_DESCRIPTION + " TEXT)";

        return createTableProduct;
    }

    public static boolean addOneProduct(Product product, SQLiteDatabase db) {
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_PRODUCT_PRICE, product.getPriceProduct());
        cv.put(COLUMN_PRODUCT_NAME, product.getNameProduct());
        cv.put(COLUMN_PRODUCT_STOCK, product.getStockProduct());
        cv.put(COLUMN_PRODUCT_DESCRIPTION, product.getDescription());

        long insert = db.insert(PRODUCT_TABLE, null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }

    public static List<Product> getAllProducts(SQLiteDatabase db) {
        List<Product> returnList = new ArrayList<>();

        String queryString = "SELECT * FROM " + PRODUCT_TABLE;

        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            do {
                int idProduct = cursor.getInt(0);
                String productPrice = cursor.getString(1);
                String productName = cursor.getString(2);
                String productStock = cursor.getString(3);
                String productDescription = cursor.getString(4);

                Product newProduct = new Product(idProduct, Integer.parseInt(productPrice), productName, Integer.parseInt(productStock), productDescription);
                returnList.add(newProduct);

            } while (cursor.moveToFirst());

        } else {

        }
        cursor.close();
        db.close();
        return returnList;
    }

}
