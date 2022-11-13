package com.fastcampus.ch2_intelliJ;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RegisterController { // 신규 회원가입 화면
    @InitBinder
    public void toDate(WebDataBinder binder) {
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        //                                                                  빈 값을 허용 여부
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
//        binder.registerCustomEditor(String[].class, new StringArrayPropertyEditor("#"));
        //                                                      특정 필드 지정도 가능
        binder.registerCustomEditor(String[].class, "hobby", new StringArrayPropertyEditor("#"));

        // ConversionService 목록 확인
        ConversionService cs = binder.getConversionService();
        System.out.println("ConversionService = " + cs);
    }

    @RequestMapping(value = "/register/add", method = {RequestMethod.GET, RequestMethod.POST})
//    @RequestMapping("/register/add")
    // 단순하게 화면만 보여준다. 하는 역할이 없음. 뷰컨트롤러로 바꿈.
//    @GetMapping("/register/add")
    public String register() {
        return "registerForm";  // WEB-INF/views/registerForm.jsp
    }

    // 회원 정보 등록
//    @RequestMapping(value = "/register/save", method = RequestMethod.POST)
    @PostMapping("/register/save")  // 4.3부터
    public String save(User user, BindingResult result, Model model) throws Exception {   // User앞에 @ModelAttribute생략
        //                          바인딩할 객체 바로 뒤에 위치하도록!

        System.out.println("result = " + result);
        System.out.println("user = " + user);

        // 1. 유효성 검사
        if (!isValid(user)) {
            String msg = URLEncoder.encode("잘못된 id입니다.", "utf-8");

            model.addAttribute("msg", msg);
            return "forward:/register/add";
//            return "redirect:/register/add";
//            return "redirect:/register/add?msg="+msg;   // URL재작성(rewriting)
        }

        // 2. DB에 신규회원 정보를 저장
        return "registerInfo";
    }

    private boolean isValid(User user) {
//        return false;
        return true;
    }
}
