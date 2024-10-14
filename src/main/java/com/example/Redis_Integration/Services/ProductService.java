package com.example.Redis_Integration.Services;


import com.example.Redis_Integration.Entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    public RedisTemplate<Object, Object> redisTemplate;

    private static final String KEY = "myProductKey";


    public Product addProduct(Product product){
        this.redisTemplate.opsForHash().put(KEY, product.getId(), product);
        return product;
    }

    public Product getProduct(String key){
        return (Product) this.redisTemplate.opsForHash().get(KEY,key);
    }

    public Boolean deleteProduct(String key) {
        System.out.println(this.redisTemplate.opsForHash().delete(KEY, key));
        return true;
    }


}
