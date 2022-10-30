package com.fastcampus.ch2_intelliJ;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Calendar;

// 년월일 입력 -> 날짜 출력
@Controller
public class YoilTellerMVC {   // http://localhost:8080/ch2/getYoilMVC?year=2022&month=10&day=25
    //    public static void main(HttpServletRequest req, HttpServletResponse rep) throws Exception{
    @RequestMapping("/getYoilMVC")
    public String main(int year, int month, int day, Model model) throws Exception {
//    public void main(int year, int month, int day, Model model) throws Exception {
//    public ModelAndView main(int year, int month, int day) throws Exception {

//        ModelAndView mv = new ModelAndView();

        // 입력
//        int yyyy = Integer.parseInt(Year);
//        int mm = Integer.parseInt(Month);
//        int dd = Integer.parseInt(Day);

        // 1. 유효성 검사
        if (!isValid(year, month, day)) {
            return "yoilError";  //  /WEB-INF/views/yoilError.jsp
        }

        // 2. 요일 계산
        char yoil = getYoil(year, month, day);

        // 3. 계산한 결과를 model에 저장
        model.addAttribute("year", year);
        model.addAttribute("month", month);
        model.addAttribute("day", day);
        model.addAttribute("yoil", yoil);

//        mv.addObject("year", year);
//        mv.addObject("month", month);
//        mv.addObject("day", day);
//        mv.addObject("yoil", yoil);
//
//        // 4. 결과를 보여줄 view를 지정
//        mv.setViewName("yoil");
//        return mv;

        return "yoil";  //  /WEB-INF/views/yoil.jsp

    }

//        // 출력
////        System.out.print(Year + "년 " + Month + "월 " + Day + "일은 ");
////        System.out.println(yoil + "요일");
//
//        // 아래 두 줄 작성안하면 글자 깨짐
//        rep.setContentType("text/html");
//        rep.setCharacterEncoding("utf-8");
//
//        PrintWriter out = rep.getWriter();  // rep(response)객체에서 브라우져로의 출력 스트림을 얻는다
//        out.println("<html>");
//        out.println("<head>");
//        out.println("</head>");
//        out.println("<body>");
//        out.print(year + "년 " + month + "월 " + day + "일은 ");
//        out.println(yoil + "요일");
//        out.println("</body>");
//        out.println("</html>");

    private boolean isValid(int year, int month, int day) {
        return true;
    }

    private char getYoil(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);  // 1:일요일, ...
        return " 일월화수목금토".charAt(dayOfWeek);
    }

}
