package com.example.mobileapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobileapp.model.Product;

public class ShopRowBinding {
    public static ShopRowBinding inflate(LayoutInflater layoutInflater, ViewGroup parent, boolean b) {
        ShopRowBinding shop = new ShopRowBinding();
        return shop;
    }

    public void setShopInterface(ShopListAdapter.ShopInterface shopInterface) {
    }

    public void setProduct(Product product) {
    }

    public void executePendingBindings() {
    }

    public View getRoot() {

        return null;
    }
}
