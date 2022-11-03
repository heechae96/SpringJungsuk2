package com.fastcampus.ch2_intelliJ;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
public class BoardController {
    @GetMapping("/list")
    public String list(HttpServletRequest req) {
        if (!loginCheck(req)) { // 로그인 안한 경우
            // 로그인을 안하고 게시판을 누른후 로그인을 해서 성공하면 홈으로 간다. 우리가 원하는것은 게시판으로 가게 하는 것.
            // 게시판으로 가기 위해서 to: /board/list를 넘겨줘야함
            return "redirect:/login/login?toURL="+req.getRequestURL(); // 로그인 화면으로
        }

        return "boardList"; // 로그인을 한 경우 게시판을 이동
    }

    private boolean loginCheck(HttpServletRequest req) {
        // 1. 세션을 얻어서
        HttpSession session = req.getSession();
        // 2. 세션에 id가 있는지 확인
//        if (session.getAttribute("id") != null) {
//            return true;
//        } else {
//            return false;
//        }
        // 위 코드를 한 줄로 작성
        return session.getAttribute("id") != null;
    }
}
