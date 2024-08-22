package com.lab4dx.l05_mvc_ex.dao;

import com.lab4dx.l05_mvc_ex.DBConnection;
import com.lab4dx.l05_mvc_ex.dto.ProductDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdectDaoImp implements ProductDao{
    Connection conn;
    PreparedStatement psmt;
    ResultSet rs;
    public ProdectDaoImp(Connection conn) throws Exception {
        this.conn = conn;
    }

    public static void main(String[]args){
        //test 진행
        Connection conn = null;
        try{
            conn = DBConnection.getConnection();
            ProductDao productDao=new ProdectDaoImp(conn);

            //delete 테스트
            System.out.println(productDao.delete(3));

            //findAll 테스트
            System.out.println(productDao.findAll());

            //save 테스트
            ProductDto productDto=new ProductDto();
            productDto.setProductId(3);
            productDto.setProductName("단지우유");
            productDto.setProductPrice(2000);
            System.out.println(productDao.save(productDto));

            //findAll 테스트
            System.out.println(productDao.findAll());

            //findAll 테스트
            System.out.println(productDao.findById(3));

            //update 테스트
            productDto.setProductName("바나나 단지우유");
            productDto.setProductPrice(1500);
            System.out.println(productDao.update(productDto));
            System.out.println(productDao.findById(3));


            //delete 테스트
            System.out.println(productDao.delete(3));
            System.out.println(productDao.findAll());


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<ProductDto> findAll() throws Exception {
        List<ProductDto> products=null; //조회 실패시 null
        String sql = "select * from product";
        psmt=conn.prepareStatement(sql);
        rs=psmt.executeQuery();
        products=new ArrayList<ProductDto>(); //쿼리가 실행되면 객체생성
        while(rs.next()){
            ProductDto product=new ProductDto();
            product.setProductId(rs.getInt("product_id"));
            product.setProductName(rs.getString("product_name"));
            product.setProductPrice(rs.getInt("product_price"));
            products.add(product);
        }
        return products;
    }

    @Override
    public ProductDto findById(int id) throws Exception {
        ProductDto product=null;
        String sql = "select * from product where product_id=?";
        psmt=conn.prepareStatement(sql);
        psmt.setInt(1, id);
        rs=psmt.executeQuery();
        if(rs.next()){
            product=new ProductDto();
            product.setProductId(rs.getInt("product_id"));
            product.setProductName(rs.getString("product_name"));
            product.setProductPrice(rs.getInt("product_price"));
        }
        return product;
    }

    @Override
    public int save(ProductDto product) throws Exception {
        int save=0;
        String sql = "insert into product (product_id, product_name, product_price) values(?,?,?)";
        psmt=conn.prepareStatement(sql);
        psmt.setInt(1, product.getProductId());
        psmt.setString(2, product.getProductName());
        psmt.setInt(3, product.getProductPrice());
        save=psmt.executeUpdate();
        return save;
    }

    @Override
    public int update(ProductDto product) throws Exception {
        int update = 0;
        String sql = "update product set product_name=?,product_price=? where product_id=?";
        psmt=conn.prepareStatement(sql);
        psmt.setString(1, product.getProductName());
        psmt.setInt(2, product.getProductPrice());
        psmt.setInt(3, product.getProductId());
        update=psmt.executeUpdate();
        return update;
    }

    @Override
    public int delete(int id) throws Exception {
        int delete = 0;
        String sql = "delete from product where product_id=?";
        psmt=conn.prepareStatement(sql);
        psmt.setInt(1, id);
        delete=psmt.executeUpdate();
        return delete;
    }
}
