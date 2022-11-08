package com.fastcampus.ch2_intelliJ;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.FileNotFoundException;

// 모든 컨트롤러에서 예외 처리!
//@ControllerAdvice   // 모든 패키지
@ControllerAdvice("com.fastcampus.ch2_intelliJ")   // 지정 패키지만!
public class GlobalCatcher {

    @ExceptionHandler(Exception.class)
    public String catcher(Exception ex, Model m) {
        System.out.println("외부(글로벌) 캐쳐가 처리");
        m.addAttribute("ex", ex);
        return "error";
    }

    @ExceptionHandler({NullPointerException.class, FileNotFoundException.class})
    public String catcher3(Exception ex, Model m) {
        System.out.println("외부(글로벌) 캐쳐가 처리");
        m.addAttribute("ex", ex);
        return "error";
    }
}
