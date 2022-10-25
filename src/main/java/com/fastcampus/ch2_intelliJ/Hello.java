package com.fastcampus.ch2_intelliJ;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 프로그램 등록
@Controller
public class Hello {
    int iv = 10;
    static int cv = 20;

    // 2. URL과 메서드 연결
    @RequestMapping("/hello")
    private void main() {
//        System.out.println("Hello - static");
        System.out.println("Hello - private");
        System.out.println(iv);
        System.out.println(cv);
    }

    public static void main2() {
//        System.out.println(iv);
        System.out.println(cv);
    }
}
