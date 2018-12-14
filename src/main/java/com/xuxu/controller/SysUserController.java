package com.xuxu.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xuxu.common.DataResult;
import com.xuxu.common.ResultEnum;
import com.xuxu.entity.SysUser;
import com.xuxu.service.SysUserService;

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
	@Autowired
	private SysUserService userService;
	
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
	
	@RequestMapping(value="/page",method=RequestMethod.GET)
	@ResponseBody
	public DataResult getAllUser(@RequestParam("page") long current,@RequestParam("limit") long size){
		Page<SysUser> page = new Page<>(current,size);
		IPage<SysUser> userPage = userService.page(page);
		return new DataResult(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), userPage);
	}
	
	@RequestMapping(value="/users",method=RequestMethod.POST)
	@ResponseBody
	public void addBatch(){
		List<SysUser> userList = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			SysUser user = new SysUser();
			user.setUsername("xuxu-"+i);
			user.setNickname("许许-"+i);
			user.setRemark("备注");
			user.setTelephone("123456789");
			user.setAddress("地址"+i);
			userList.add(user);
		}
		userService.saveBatch(userList);
	}
}
