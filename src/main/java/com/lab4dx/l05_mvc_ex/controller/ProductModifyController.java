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

@WebServlet("/productModify.do")
public class ProductModifyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productIdStr = req.getParameter("id");
        try {
            int productId = Integer.parseInt(productIdStr);

            ProductService productService=new ProductServiceImp();
            ProductDto product=productService.get(productId);
            req.setAttribute("product", product);
            req.getRequestDispatcher("/WEB-INF/views/productModify.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productIdStr = req.getParameter("id");
        String productName = req.getParameter("name");
        String productPriceStr = req.getParameter("price");
        int modify=0;
        try {
            int productId = Integer.parseInt(productIdStr);
            int productPrice = Integer.parseInt(productPriceStr);
            ProductDto product=new ProductDto();
            product.setProductId(productId);
            product.setProductName(productName);
            product.setProductPrice(productPrice);

            ProductService productService=new ProductServiceImp();
            modify=productService.modify(product);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if(modify>0){
            resp.sendRedirect("./productDetail.do?id="+productIdStr);
        }else{
            resp.sendRedirect("./productModify.do?id="+productIdStr);
        }

    }
}
