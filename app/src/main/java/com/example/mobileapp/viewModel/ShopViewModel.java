package com.example.mobileapp.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mobileapp.model.Product;
import com.example.mobileapp.repository.ShopRepo;

import java.util.List;

public class ShopViewModel extends ViewModel {

    ShopRepo shopRepo = new ShopRepo();

    public LiveData<List<Product>> getProducts() {
        return shopRepo.getProducts();
    }
}
