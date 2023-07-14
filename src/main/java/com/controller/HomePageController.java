package com.controller;

import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author qiqi
 * @Date 2023/6/9
 * @Version 1.0
 * @Since 1.0
 */
@RestController
@RequestMapping("/homepage")
public class HomePageController{
    @Autowired
    private ProductTypeRelationService productTypeRelationService;
    @Autowired
    private ProductTypeService productTypeService;
    @Autowired
    private ProductService productService;
    @Autowired
    private PictureService pictureService;
    @Autowired
    private UserService userService;
    @Autowired
    private CartService cartService;
    @Autowired
    private OrderInfoService orderInfoService;
    @Autowired
    private BrowsingHistoryService browsingHistoryService;
    /**
     * 搜索条模块，根据关键字查询
     * @param keyword
     * @return
     */
    @RequestMapping(value = "/search_by_keyword")
    public List<Map<String,Object>> searchByKeyword(@RequestParam("keyword") String keyword){
        List<Map<String, Object>> searchByKeyword = productTypeRelationService.searchByKeyword(keyword);
        return searchByKeyword;
    }

    /**
     * 首页分类模块，展示一级商品类型
     * @param limitNUm
     * @return
     */
    @RequestMapping(value = "/product_first_type",method = RequestMethod.POST)
    public List<Map<String,Object>> showFirstProductType(@RequestParam("limitNum") Integer limitNUm){
        List<Map<String,Object>> productTypes = productTypeService.queryFirstProductType(limitNUm);
        return productTypes;
    }

    /**
     * 查询公告图
     * @param limitNum
     * @return
     */
    @RequestMapping(value = "/notices")
    public List<Map<String,Object>> showNotice(
            @RequestParam(value = "limitNum",defaultValue = "4",required = false) Integer limitNum){
        List<Map<String, Object>> notices = pictureService.showNotice(limitNum);
        return notices;
    }

    /**
     * 首页展示用户简略信息
     * @param userId
     * @return
     */
    @RequestMapping(value = "/simple_userinfo")
    public Map<String,Object> userSimpleInfo(@RequestParam("userId") Integer userId){
        List<Map<String, Object>> headAndUsername = userService.showSimpleInfo(userId);
        Integer cartNum = cartService.cartNum(userId);
        Integer waitReceiveNum = orderInfoService.waitReceiveNum(userId);
        Integer waitSendNum = orderInfoService.waitSendNum(userId);
        Integer waitPayNum = orderInfoService.waitPayNum(userId);
        Integer waitCommentNum = orderInfoService.waitCommentNum(userId);
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("headAndUsername",headAndUsername);
        dataMap.put("cartNum",cartNum);
        dataMap.put("waitReceiveNum",waitReceiveNum);
        dataMap.put("waitSendNum",waitSendNum);
        dataMap.put("waitPayNum",waitPayNum);
        dataMap.put("waitCommentNum",waitCommentNum);
        return dataMap;
    }

    /**
     * 推荐商品模块，根据用户ID返回用户可能喜欢的商品
     * @param userId
     * @return
     */
    @RequestMapping(value = "/guess_your_love")
    public List<Map<String,Object>> guessYourLove(
            @RequestParam("userId") Integer userId,
            @RequestParam("startLine") Integer startLIne,
            @RequestParam("needNum") Integer needNum
            ){
        List<Map<String, Object>> guessYourLove = null;
        try {
            //历史记录数量
            Integer historyCount = browsingHistoryService.selectCount(userId);
            //如果没有历史记录就随意展示一部分商品
            if(historyCount == null || historyCount == 0){
                guessYourLove = productService.showHomePage(startLIne,needNum);
            }
            //有历史记录就走推荐
            else {
                guessYourLove = productService.guessYourLove(userId, startLIne, needNum);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        if (CollectionUtils.isEmpty(guessYourLove)){
            return  null;
        }
        return guessYourLove;

    }

}
