package com.fastcampus.ch2_intelliJ;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Controller
public class TwoDice {
    @RequestMapping("/rollDice")
    public void dice(HttpServletResponse rep) throws Exception{
        // 실행할때마다 결과가 변하게 하기 위함. 동적 리소스
        int idx1 = (int)(Math.random()*6)+1;
        int idx2 = (int)(Math.random()*6)+1;

        rep.setContentType("text/html");
        rep.setCharacterEncoding("utf-8");

        PrintWriter out = rep.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<img src='resources/img/dice"+idx1+".jpg'>");
        out.println("<img src='resources/img/dice"+idx2+".jpg'>");
        out.println("</body>");
        out.println("</html>");
    }
}