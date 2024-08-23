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
import java.util.List;

@WebServlet("/productDetail.do")
public class ProductDetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productIdStr = req.getParameter("id");
        try {
            int productId = Integer.parseInt(productIdStr);

            ProductService productService=new ProductServiceImp();
            ProductDto product=productService.get(productId);
            req.setAttribute("product", product);
            req.getRequestDispatcher("/WEB-INF/views/productDetail.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
