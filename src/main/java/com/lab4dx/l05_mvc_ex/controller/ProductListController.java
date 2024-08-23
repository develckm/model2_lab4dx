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

@WebServlet("/productList.do")
public class ProductListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ProductService productService=new ProductServiceImp();
            List<ProductDto> products=productService.getAll();
            req.setAttribute("products", products);
            req.getRequestDispatcher("/WEB-INF/views/productList.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
