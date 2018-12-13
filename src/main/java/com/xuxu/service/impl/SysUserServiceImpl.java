package com.xuxu.service.impl;

import com.xuxu.entity.SysUser;
import com.xuxu.mapper.SysUserMapper;
import com.xuxu.service.SysUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xuxu
 * @since 2018-12-12
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
	@Autowired
	private SysUserMapper userMapper;
	
	@Override
	public SysUser findByName(String username) {
		QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
		return userMapper.selectOne(queryWrapper);
	}

}
