package com.example.mobileapp.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mobileapp.dataBase.DataBase;
import com.example.mobileapp.dataBase.ProductDB;
import com.example.mobileapp.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShopRepo {

    private MutableLiveData<List<Product>> mutableProductList;

    public LiveData<List<Product>> getProducts() {
        if(mutableProductList == null) {
            mutableProductList = new MutableLiveData<>();
            loadProducts();
        }
        return mutableProductList;
    }

    private void loadProducts() {
        List<Product> productList = new ArrayList<>();
        //productList = DataBase.getProducts();
        productList.add(new Product(1, 27, "Mango Spray", 50, "sweet"));
        productList.add(new Product(2, 27, "Tutty Frutty Spray", 50, "fresh"));
        productList.add(new Product(3, 27, "Golden Sunset Spray", 50, "sweet"));
        productList.add(new Product(4, 15, "Apple&Cinnamon Candle", 100, "sweet"));
        productList.add(new Product(5, 15, "Vanilla Black Candle", 100, "sweet"));
        productList.add(new Product(6, 30, "Room perfume Bubble Gum", 25, "sweet"));
        productList.add(new Product(7, 30, "Room perfume Liliac", 25, "fresh"));

        mutableProductList.setValue(productList);
    }
}
