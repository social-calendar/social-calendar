package com.socialCalendar.service;

import java.util.List;

import com.socialCalendar.pojo.User;

public interface UserService {
	/**
     * 修改用户
     * @param user
     * @return影响的记录数
     */
    public int updateUser(User user);
    
    /**
     * 添加用户
     * @param user
     * @return影响的记录数
     */
    public int addUser(User user);
    
    /**
     * 删除用户
     * @param id
     * @return
     */
    public int deleteUser(Integer id);
    
    /**
     * 根据用户user_id查询
     * @param 
     * @return 用户 
     */
    public User findByUserIdUser(Integer id);
    
    /**
     * 根据用户open_id查询
     * @param 
     * @return 用户 
     */
    public User findByOpenIdUser(String openID);
    
    /**
     * 根据用户user_nickName查询
     * @param 
     * @return 用户集 
     */
    public List<User> findByNickNameUser(String nickname); 
}
