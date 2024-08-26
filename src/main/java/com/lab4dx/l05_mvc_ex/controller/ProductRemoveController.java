package com.lab4dx.l05_mvc_ex.controller;

import com.lab4dx.l05_mvc_ex.service.ProductService;
import com.lab4dx.l05_mvc_ex.service.ProductServiceImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.rmi.RemoteException;

@WebServlet("/productRemove.do")
public class ProductRemoveController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productIdStr = req.getParameter("id");
        int remove=0;
        try {
            int productId = Integer.parseInt(productIdStr);

            ProductService productService=new ProductServiceImp();
            remove=productService.remove(productId);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if(remove>0){
            resp.sendRedirect("./productList.do");
        }else{
            resp.sendRedirect("./productModify.do?id="+productIdStr);
        }
    }
}
