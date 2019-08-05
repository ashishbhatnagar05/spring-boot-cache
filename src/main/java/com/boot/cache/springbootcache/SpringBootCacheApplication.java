package com.boot.cache.springbootcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/** A simple cache implmentation. this one will not evict the cache.Use ehcache or redis */
@SpringBootApplication
@EnableCaching
public class SpringBootCacheApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootCacheApplication.class, args);
  }
}
