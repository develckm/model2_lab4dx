package com.lab4dx.l05_mvc_ex.dao;

import com.lab4dx.l05_mvc_ex.dto.ProductDto;

import java.util.List;

public interface ProductDao {
    /*
    *     /*PRODUCT
    PRODUCT_ID NUMBER
    PRODUCT_NAME VARCHAR2(100)
    PRODUCT_PRICE NUMBER
    insert (save)
    update,
    delete,
    select(find)
    select where(by)
     */
     List<ProductDto> findAll() throws Exception;
     ProductDto findById(int id) throws Exception;
     int save(ProductDto product) throws Exception;
     int update(ProductDto product) throws Exception;
     int delete(int id) throws Exception;
}
