package com.lab4dx.l05_mvc_ex.service;

import com.lab4dx.l05_mvc_ex.DBConnection;
import com.lab4dx.l05_mvc_ex.dao.ProdectDaoImp;
import com.lab4dx.l05_mvc_ex.dao.ProductDao;
import com.lab4dx.l05_mvc_ex.dto.ProductDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProductServiceImp implements ProductService {
    private Connection conn;
    private ProductDao productDao;
    public ProductServiceImp() throws Exception{
        conn= DBConnection.getConnection();
        //conn.setAutoCommit(true);
        productDao=new ProdectDaoImp(conn);
    }

    @Override
    public int regist(ProductDto productDto) throws Exception {
        int regist=0;
        try {
            //서비스가 여러 쿼리 실행으로 이루어진 트랜잭션이라면 오류 발생시 rollback()
            conn.commit();
            regist=productDao.save(productDto);
            conn.commit();
        } catch (Exception e) {
            try {conn.rollback();} catch (SQLException ex) {throw new RuntimeException(ex);}
            throw new RuntimeException(e);

        }
        return regist;
    }

    @Override
    public int modify(ProductDto productDto) throws Exception {
        return productDao.update(productDto);
    }

    @Override
    public int remove(int id) throws Exception {
        return productDao.delete(id);
    }

    @Override
    public ProductDto get(int id) throws Exception {
        return productDao.findById(id);
    }

    @Override
    public List<ProductDto> getAll() throws Exception {
        return productDao.findAll();
    }
}
