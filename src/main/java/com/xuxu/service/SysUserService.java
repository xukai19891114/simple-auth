package com.xuxu.service;

import com.xuxu.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xuxu
 * @since 2018-12-12
 */
public interface SysUserService extends IService<SysUser> {
	
	SysUser findByName(String username);
}
