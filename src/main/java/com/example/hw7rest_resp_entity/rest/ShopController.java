package com.example.hw7rest_resp_entity.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shops")
public class ShopController {

    private ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Shop> createShop(@RequestBody Shop shop) {
        HttpHeaders headers = new HttpHeaders();
        if (shop == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.shopService.addShop(shop);
        return new ResponseEntity<>(shop, headers, HttpStatus.CREATED);
    }

    @GetMapping("/{shopId}")
    public ResponseEntity<Shop> getShopById(@PathVariable("shopId") String shopId) {
        if (shopId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Shop shop = this.shopService.getShopById(shopId);
        if (shop == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(shop, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Shop>> getShops() {
        List<Shop> shopList = this.shopService.getShops();
        if (shopList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(shopList, HttpStatus.OK);
    }

    @PutMapping("/{shopId}")
    public ResponseEntity<Shop> updateShop(@PathVariable("shopId") String shopId, @RequestBody Shop shop) {
        HttpHeaders headers = new HttpHeaders();
        if (shop == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.shopService.updateShop(shopId, shop);
        return new ResponseEntity<>(shop, headers, HttpStatus.OK);
    }

    @DeleteMapping("/{shopId}")
    public ResponseEntity<Shop> deleteShop(@PathVariable("shopId") String shopId) {
        Shop shop = this.shopService.getShopById(shopId);
        if (shop == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.shopService.delete(shopId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
