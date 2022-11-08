package com.fastcampus.ch2_intelliJ;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileNotFoundException;

@Controller
public class ExceptionController {

    // ExceptionController내부에서 발생하는 Exception예외를 받음
    //  -> 다른 컨트롤러에서 발생하는 예외는 처리 불가
    // try-catch의 catch블럭이라고 생각하자!
    @ExceptionHandler(Exception.class)
    public String catcher(Exception ex, Model m) {
        System.out.println("내부 캐쳐가 처리");
        m.addAttribute("ex", ex);
        return "error";
    }

//    @ExceptionHandler(NullPointerException.class)
//    public String catcher2(Exception ex, Model m) {
//        m.addAttribute("ex", ex);
//        return "error";
//    }

    @ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
    public String catcher3(Exception ex, Model m) {
        System.out.println("내부 캐쳐가 처리");
        m.addAttribute("ex", ex);
        return "error";
    }


    @RequestMapping("/ex")
    public String main() throws Exception {
        throw new Exception("예외가 발생했습니다");
    }

    @RequestMapping("/ex2")
    public String main2() throws Exception {
        throw new NullPointerException("예외가 발생했습니다2");
    }

    @RequestMapping("/ex3")
    public String main3() throws Exception {
        throw new FileNotFoundException("예외가 발생했습니다3");
    }
}
