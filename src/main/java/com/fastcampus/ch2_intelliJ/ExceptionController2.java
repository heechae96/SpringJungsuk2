package com.fastcampus.ch2_intelliJ;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileNotFoundException;

@Controller
public class ExceptionController2 {

    // 예외처리를 하는 메소드(catcher)가 없지만
    //  -> GlobalCatcher의 @ControllerAdvice로 예외 처리

    @RequestMapping("/ex4")
    public String main4() throws Exception {
        throw new Exception("예외가 발생했습니다4");
    }

    @RequestMapping("/ex5")
    public String main5() throws Exception {
        throw new NullPointerException("예외가 발생했습니다5");
    }

    @RequestMapping("/ex6")
    public String main6() throws Exception {
        throw new FileNotFoundException("예외가 발생했습니다6");
    }
}
