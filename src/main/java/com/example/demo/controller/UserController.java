package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author hypert1tion
 * @Create 2022 02 25 18:37
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 新增用户
     * @param user
     * @return
     */
    @PostMapping
    public Result add(@RequestBody User user){
        userService.save(user);
        return Result.success();
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    @PutMapping
    public Result update(@RequestBody User user){
        userService.save(user);
        return Result.success();
    }

    /**
     * 删除
     * user/1
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        userService.del(id);
        return Result.success();
    }

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<User> findById(@PathVariable Long id){
        return Result.success(userService.findById(id));
    }

    /**
     * 分页模糊查询
     * @return
     */
    @GetMapping("/page")
    public Result<Page<User>> findPage(@RequestParam(defaultValue  = "1")Integer pageNum,
                                           @RequestParam(defaultValue = "10")Integer pageSize,
                                           @RequestParam(required = false) String name){
        return Result.success(userService.findPage(pageNum,pageSize,name));
    }


}