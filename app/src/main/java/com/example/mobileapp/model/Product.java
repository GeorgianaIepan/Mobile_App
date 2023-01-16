package com.example.mobileapp.model;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;

public class Product {
    public static DiffUtil.ItemCallback<Product> itemCallback;
    private int idProduct;
    private int priceProduct;
    private String nameProduct;
    private int stockProduct;
    private String description;

    public Product(int idProduct, int priceProduct, String nameProduct, int stockProduct, String description) {
        this.idProduct = idProduct;
        this.priceProduct = priceProduct;
        this.nameProduct = nameProduct;
        this.stockProduct = stockProduct;
        this.description = description;
    }

    public Product() {

    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(int priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getStockProduct() {
        return stockProduct;
    }

    public void setStockProduct(int stockProduct) {
        this.stockProduct = stockProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", priceProduct=" + priceProduct +
                ", nameProduct='" + nameProduct + '\'' +
                ", stockProduct=" + stockProduct +
                ", description='" + description + '\'' +
                '}';
    }

   /* @Override

    public boolean equals(object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getclass()) return false;
        Product product = (Product) 0;
        return Double.compare(product.getIdProduct())
    }

    public static DiffUtil.ItemCallback<Product> itemCallback = new Diffutil.Itemcallback<Product>() {
        @Override
        public boolean areItemsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Product oldItem, @NonNull Product newItem) {
            return oldItem.equals(newItem);
        }


    };*/
}
