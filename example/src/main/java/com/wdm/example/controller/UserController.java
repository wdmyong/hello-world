package com.wdm.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.wdm.example.controller.Response;
import com.wdm.example.model.User;
import com.wdm.example.service.UserService;

/*
 * @author wdmyong
 * 20170415
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Response get(@PathVariable("id") Integer id) {
        Response response = new Response();
        response.setData(userService.getById(id));
        return response;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Response insert(User user) {
        Response response = new Response();
        userService.insert(user);
        response.setData(user);
        return response;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Response update(@PathVariable("id") Integer id, User user) {
        Response response = new Response();
        user.setId(id);
        userService.update(user);
        response.setData(user);
        return response;
    }

    /*
     * 输出：
{
  "code": 0,
  "msg": null,
  "data": [
    // 默认数据库setDefaultTargetDataSource产生的结果，表test数据
    {
      "id": 1,
      "name": "duanyong",
      "account": "yongduan@wdm-inc.com",
      "passwd": "123456",
      "mobile": "13647231328",
      "createTime": "2017-04-15 00:00:00",
      "modifyTime": 1492185600000
    },
    // 注解master产生的结果，表test数据
    {
      "id": 1,
      "name": "duanyong",
      "account": "yongduan@wdm-inc.com",
      "passwd": "123456",
      "mobile": "13647231328",
      "createTime": "2017-04-15 00:00:00",
      "modifyTime": 1492185600000
    },
    // 注解first产生的结果，表test1数据
    {
      "id": 1,
      "name": "a",
      "account": "b",
      "passwd": "c",
      "mobile": "13512345678",
      "createTime": "2017-04-20 00:34:05",
      "modifyTime": 1492619645000
    },
    // 注解second产生的结果，表test2数据
    {
      "id": 1,
      "name": "e",
      "account": "f",
      "passwd": "g",
      "mobile": "13587654321",
      "createTime": "2017-04-20 00:34:28",
      "modifyTime": 1492619668000
    }
  ]
}
     */
    @RequestMapping(value = "/multi/{id}", method = RequestMethod.GET)
    public Response getMulti(@PathVariable("id") Integer id) {
        Response response = new Response();
        List<User> userList = new ArrayList<>();
        userList.add(userService.getById(id));
        userList.add(userService.getById0(id));
        userList.add(userService.getById1(id));
        userList.add(userService.getById2(id));
        response.setData(userList);
        return response;
    }
}
