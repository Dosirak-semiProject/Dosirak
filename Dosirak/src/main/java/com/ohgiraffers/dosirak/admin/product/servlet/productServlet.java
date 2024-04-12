package com.ohgiraffers.dosirak.admin.product.servlet;

import java.io.IOException;

import com.ohgiraffers.dosirak.admin.product.dao.ProductMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

@WebServlet("/search")
public class productServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // HTTP 요청에서 검색어 추출
        String keyword = request.getParameter("keyword");

        // MyBatis 설정 로드
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(
                this.getClass().getResourceAsStream("/path/to/your/mybatis-config.xml")
        );

        // MyBatis와 연결
        try (SqlSession session = sqlSessionFactory.openSession()) {
            // MyBatis 매퍼 인터페이스 가져오기
            ProductMapper productMapper = session.getMapper(ProductMapper.class);

            // MyBatis 매퍼 메서드 호출
            String result = productMapper.productselcetlist(keyword);

            // 결과를 HTTP 응답으로 보내기
            response.getWriter().println("Search result: " + result);
        }
    }
}

