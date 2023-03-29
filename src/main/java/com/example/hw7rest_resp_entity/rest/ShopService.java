package com.example.hw7rest_resp_entity.rest;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ShopService {
    private HashMap<String, Shop> db = new HashMap<>();

    public Shop addShop(Shop shop) {
        return db.put(shop.getId(), shop);
    }

    public Shop getShopById(String id) {
        return db.get(id);
    }

    public List<Shop> getShops() {
        return new ArrayList<>(db.values());
    }

    public Shop updateShop(String shopId, Shop shop) {
        shop.setId(shopId);
        return db.put(shopId, shop);
    }

    public void delete(String shopId) {
        db.remove(shopId);
    }
}

