package com.myspringboot.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.myspringboot.entity.UserEntity;
import com.myspringboot.repository.user.UserEntityRepository;
import com.myspringboot.service.UserService;

@Service
@Transactional
@CacheConfig(cacheNames = "userservice")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserEntityRepository userRepository;

	@Override
	@Cacheable //key的属性值必须是SpEL表达式，如果常量的话必须加单引号如key = "'userlist'"
	public List<UserEntity> list() {
		List<UserEntity> users = userRepository.findAll();
		return users;
	}

	@Override
	public List<UserEntity> findUserByName(String name) {
//		List<UserEntity> users = userRepository.findUserByName(name);
		return null;
	}

	@Override
	public void deleteUserById(String id) {
//		userRepository.deleteUserById(id);
	}

	@Override
	public List<UserEntity> curPage(PageRequest pageRequest) {
		List<UserEntity> res = userRepository.findAll(pageRequest).getContent();
		return res;
	}
	
	
	
}
