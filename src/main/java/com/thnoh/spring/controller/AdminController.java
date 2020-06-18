package com.thnoh.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * class : AdminController
 *
 * 관리자 페이지
 */

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping
    public String adminPage() {
        return "admin";
    }

}
