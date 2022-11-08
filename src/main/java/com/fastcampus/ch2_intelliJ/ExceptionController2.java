package com.fastcampus.ch2_intelliJ;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.FileNotFoundException;

//@ResponseStatus(HttpStatus.BAD_REQUEST) // 500 -> 400
class MyException extends RuntimeException{
    MyException(String msg){
        super(msg);
    }

    MyException(){
        this("");
    }
}

@Controller
public class ExceptionController2 {

    // 예외처리를 하는 메소드(catcher)가 없지만
    //  -> GlobalCatcher의 @ControllerAdvice로 예외 처리

    @RequestMapping("/ex4")
    public String main4() throws Exception {    // 사용자 예외를 처리하는 캐쳐가 없으므로 에러(디폴트 500)
        throw new MyException("예외가 발생했습니다4");
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
