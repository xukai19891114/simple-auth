package com.xuxu.controller;


import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xuxu
 * @since 2018-12-12
 */
@Controller
@RequestMapping("/sys/user")
public class SysUserController{
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestParam String username,@RequestParam String password,Model model,HttpServletRequest request){
		if(StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(password)){
			Subject subject = SecurityUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(username,password,true);
			try {
				subject.login(token);
				return "redirect:/hello.html";
			} catch (AuthenticationException e) {
				e.printStackTrace();
			}
		}else{
			
		}
		return "redirect:login.jsp";
	}
}
