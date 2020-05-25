package com.spring.community2.controller;

import com.spring.community2.entity.DiscussPost;
import com.spring.community2.entity.User;
import com.spring.community2.service.DiscussPostService;
import com.spring.community2.util.CommunityUtil;
import com.spring.community2.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @ClassName DiscussPostController
 * @Author ruizhou
 * @Date 2020/5/23 22:25
 **/
@Controller
@RequestMapping("/discuss")
public class DiscussPostController {
    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private HostHolder hostHolder;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addDiscussPost(String title, String content) {
        User user = hostHolder.getUser();
        if (user == null) {
            return CommunityUtil.getJSONString(403, "您还没有登录");
        }
        DiscussPost discussPost = new DiscussPost();
        discussPost.setUserId(user.getId());
        discussPost.setTitle(title);
        discussPost.setContent(content);
        discussPost.setCreateTime(new Date());
        discussPostService.addDiscusPost(discussPost);

        // 报错的情况以后统一处理
        return CommunityUtil.getJSONString(0, "发布成功！");
    }
}
