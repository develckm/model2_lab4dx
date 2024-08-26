package com.lab4dx.l05_mvc_ex.controller;

import com.lab4dx.l05_mvc_ex.dto.ProductDto;
import com.lab4dx.l05_mvc_ex.service.ProductService;
import com.lab4dx.l05_mvc_ex.service.ProductServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/productRegister.do")
public class ProductRegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/productRegister.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productIdStr = req.getParameter("id");
        String productName = req.getParameter("name");
        String productPriceStr = req.getParameter("price");
        int register=0;
        try {
            int productId = Integer.parseInt(productIdStr);
            int productPrice = Integer.parseInt(productPriceStr);
            ProductDto product=new ProductDto();
            product.setProductId(productId);
            product.setProductName(productName);
            product.setProductPrice(productPrice);

            ProductService productService=new ProductServiceImp();
            register=productService.regist(product);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if(register>0){
            resp.sendRedirect("./productList.do?");
        }else{
            resp.sendRedirect("./productRegister.do?");
        }

    }
}
