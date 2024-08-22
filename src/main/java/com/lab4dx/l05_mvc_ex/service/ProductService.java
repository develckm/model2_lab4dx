package com.lab4dx.l05_mvc_ex.service;

import com.lab4dx.l05_mvc_ex.dto.ProductDto;

import java.util.List;

public interface ProductService {
    //어떤 서비스가 있는지 기획 (상품 등록,수정,삭제,리스트보기,상세보기)
    int regist(ProductDto productDto) throws Exception;
    int modify(ProductDto productDto)  throws Exception;
    int remove(int id)  throws Exception;
    ProductDto get(int id)  throws Exception;
    List<ProductDto> getAll()  throws Exception;
}
