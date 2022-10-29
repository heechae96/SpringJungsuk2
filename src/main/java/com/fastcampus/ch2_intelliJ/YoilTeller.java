package com.fastcampus.ch2_intelliJ;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Calendar;

// 년월일 입력 -> 날짜 출력
@Controller
public class YoilTeller {   // http://localhost:8080/ch2/getYoil?year=2022&month=10&day=25
//    public static void main(String[] args) {
    @RequestMapping("/getYoil")
    public void main(HttpServletRequest req, HttpServletResponse rep) throws Exception{
        // 입력
//        String year = args[0];
//        String month = args[1];
//        String day = args[2];
        String Year = req.getParameter("year");
        String Month = req.getParameter("month");
        String Day = req.getParameter("day");

        int yyyy = Integer.parseInt(Year);
        int mm = Integer.parseInt(Month);
        int dd = Integer.parseInt(Day);

        // 작업
        Calendar cal = Calendar.getInstance();
        cal.set(yyyy, mm - 1, dd);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);  // 1:일요일, ...
        char yoil = " 일월화수목금토".charAt(dayOfWeek);

        // 출력
//        System.out.print(Year + "년 " + Month + "월 " + Day + "일은 ");
//        System.out.println(yoil + "요일");

        // 아래 두 줄 작성안하면 글자 깨짐
        rep.setContentType("text/html");
        rep.setCharacterEncoding("utf-8");

        PrintWriter out = rep.getWriter();  // rep(response)객체에서 브라우져로의 출력 스트림을 얻는다
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.print(Year + "년 " + Month + "월 " + Day + "일은 ");
        out.println(yoil + "요일");
        out.println("</body>");
        out.println("</html>");
    }
}
