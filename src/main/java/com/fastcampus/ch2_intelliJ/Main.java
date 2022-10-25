package com.fastcampus.ch2_intelliJ;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {
//        Hello hello = new Hello();
//        hello.main();   // private이라서 외부 호출이 불가

        // Reflection API를 사용
        // -> 클래스 정보를 얻고 다룰 수 있는 강력한 기능 제공
        // Hello클래스의 Class객체(클래스의 정보를 담고 있는 객체)를 얻어온다
        Class helloClass = Class.forName("com.fastcampus.ch2_intelliJ.Hello");
        Hello hello = (Hello) helloClass.newInstance();
        Method main = helloClass.getDeclaredMethod("main");
        main.setAccessible(true);   // private인 main()을 호출 가능하도록 함

        main.invoke(hello); // hello.main()을 호출
    }
}
