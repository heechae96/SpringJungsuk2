package com.fastcampus.ch2_intelliJ;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.StringJoiner;

public class MethodInfo {
    public static void main(String[] args) throws Exception {

        // 1. YoilTeller클래스의 객체를 생성
        Class clazz = Class.forName("com.fastcampus.ch2_intelliJ.YoilTellerMVC");
        Object obj = clazz.newInstance();

        // 2. 모든 메서드의 정보를 가져온다
        Method[] methodArr = clazz.getDeclaredMethods();

        // 반복문으로 메서드 출력
        for (Method m : methodArr) {
            String name = m.getName();  // 메서드 이름
            Parameter[] paramArr = m.getParameters();   // 매개변수 목록
//			Class[] paramTypeArr = m.getParameterTypes();
            Class returnType = m.getReturnType();   // 매서드 반환타입

            //                                      구분자             접두사     접미사
            StringJoiner paramList = new StringJoiner(", ", "(", ")");

            for (Parameter param : paramArr) {
                String paramName = param.getName();
                Class paramType = param.getType();

                paramList.add(paramType.getName() + " " + paramName);
            }

            System.out.printf("%s %s%s%n", returnType.getName(), name, paramList);
        }
    } // main
}