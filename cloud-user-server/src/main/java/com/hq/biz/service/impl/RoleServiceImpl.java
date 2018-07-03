package com.hq.biz.service.impl;

import com.hq.biz.model.Role;
import com.hq.biz.dao.RoleMapper;
import com.hq.biz.service.RoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author huang
 * @since 2018-07-03
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
