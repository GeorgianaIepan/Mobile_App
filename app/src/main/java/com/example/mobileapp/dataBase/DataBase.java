package com.example.mobileapp.dataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.mobileapp.model.Order;
import com.example.mobileapp.model.OrderProduct;
import com.example.mobileapp.model.Product;
import com.example.mobileapp.model.User;

import java.util.List;

public class DataBase extends SQLiteOpenHelper {

    //private static final DataBase dataBase = new DataBase(null);

    public DataBase(@Nullable Context context) {
        super(context, "ShopDB.db", null, 1);
    }

    // first time
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(UserDB.createUser());
        sqLiteDatabase.execSQL(ProductDB.createProduct());
        sqLiteDatabase.execSQL(OrderDB.createOrder());
        sqLiteDatabase.execSQL(OrderProductDB.createOrderProduct());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        return UserDB.addOneUser(user, db);
    }

    public boolean addOrder(Order order) {
        SQLiteDatabase db = this.getWritableDatabase();

        return OrderDB.addOneOrder(order, db);
    }

    public boolean addProduct(Product product) {
        SQLiteDatabase db = this.getWritableDatabase();

        return ProductDB.addOneProduct(product, db);
    }

    public boolean addOrderProduct(OrderProduct orderProduct) {
        SQLiteDatabase db = this.getWritableDatabase();

        return OrderProductDB.addOneOrderProduct(orderProduct, db);
    }

    public List<User> getUsers() {
        SQLiteDatabase db = getReadableDatabase();  // Readable = Select items from db, Writable = insert, update, delete

        return UserDB.getEveryoneUsers(db);
    }

    public List<Product> getProducts() {
        SQLiteDatabase db = getReadableDatabase();  // Readable = Select items from db, Writable = insert, update, delete

        return ProductDB.getAllProducts(db);
    }
}

