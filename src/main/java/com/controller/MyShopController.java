package com.controller;

import com.entity.Address;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.*;
import com.utils.ImgUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.function.ServerResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author qiqi
 * @Date 2023/6/13
 * @Version 1.0
 * @Since 1.0
 */
@RestController
@RequestMapping("/myshop")
public class MyShopController {
    @Autowired
    private OrderInfoService orderInfoService;
    @Autowired
    private CartService cartService;
    @Autowired
    private CollectionService collectionService;
    @Autowired
    private BrowsingHistoryService browsingHistoryService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private UserService userService;
    /**
     * 根据状态返回订单信息
     * @param userId
     * @param orderStatus 订单状态,0-未支付，1-支付
     * @param logisticsStatus 物流状态，0-未发货，1-已发货，2-正在配送，3-到达目的地，尚未签收，4-已签收
     * @param pageNum 页码
     * @param keyword 关键词
     * @return
     */
    @RequestMapping("/order")
    public PageInfo getOrderByBatch(
            @RequestParam("userId") Integer userId,
            @RequestParam(value = "orderStatus",required = false) Integer orderStatus,
            @RequestParam(value = "logisticsStatus",required = false) Integer logisticsStatus,
            @RequestParam(value = "pageNum",required = false,defaultValue = "1") Integer pageNum,
            @RequestParam(value = "keyword",required = false) String keyword
            ){
        PageHelper.startPage(pageNum,4);
        List<Map<String, Object>> orderByBatch = orderInfoService.queryOrderByBatch(userId, orderStatus, logisticsStatus,keyword);
        if (CollectionUtils.isEmpty(orderByBatch)){
            return null;
        }
        PageInfo<Map<String, Object>> info = new PageInfo<>(orderByBatch);
        System.out.println(info);
        return info;
    }

    /**
     * 查询购买过的店铺
     * @param userId
     * @return
     */
    @RequestMapping("/bought_shop")
    public Object boughtShop(@RequestParam("userId") Integer userId){
        Map<String,List<String>> maps = orderInfoService.queryBoughtShop(userId);
        return maps;
    }

    /**
     * 查询收藏夹
     * @param userId
     * @param pdtKeyword
     * @return
     */
    @RequestMapping("/collection")
    public List<Map<String,Object>> collectionOfUser(@RequestParam("userId") Integer userId ,
                                               @RequestParam(value = "pdtKeyword" ,required = false) String pdtKeyword
    ){
        List<Map<String, Object>> maps = collectionService.collectionOfUser(userId,pdtKeyword);
        return maps;
    }

    /**
     * 添加到收藏夹
     * @param userId
     * @param productId
     * @return
     */
    @RequestMapping("/add_to_coll")
    public boolean addToColl(@RequestParam("userId") Integer userId,@RequestParam("productId") Integer productId){
        return  collectionService.addColl(userId,productId);
    }

    /**
     * 根据主键删除收藏夹记录
     * @param id
     * @return
     */
    @RequestMapping("/delete_coll")
    public boolean deleteColl(@RequestParam("id") Integer id){
        return collectionService.deleteById(id);
    }

    /**
     * 查询购物车
     * @param userId
     * @return
     */
    @RequestMapping("/cart")
    public Object cartOfUser(@RequestParam("userId") Integer userId){
        Map<String, List<Object>> cart = cartService.queryCart(userId);
        return cart;
    }

    /**
     * 修改购物车商品数量
     * @param userId
     * @param productId
     * @param num
     * @return
     */
    @RequestMapping("/productnum")
    public String modifyProductNum(@RequestParam("userId") Integer userId,
                                   @RequestParam("productId") Integer productId,
                                   @RequestParam("num") Integer num
                                   ){
        if (cartService.updateNum(userId,productId,num)){
            return "更新成功";
        }else {
            return "更新失败";
        }
    }

    /**
     * 根据主键删除购物车记录
     * @param id
     * @return
     */
    @RequestMapping("/delete_cart")
    public boolean deleteCartItem(@RequestParam("id") Integer id){
        return cartService.deleteById(id);
    }

    /**
     * 根据主键批量删除购物车记录
     * @param ids
     * @return
     */
    @RequestMapping("/delete_by_ids")
    public boolean deleteCartByIds(@RequestParam("ids") Integer[] ids){
        return cartService.deleteByIds(ids) ==  ids.length;
    }

    /**
     * 查询历史记录
     * @param userId
     * @return
     */
    @RequestMapping("/history")
    public List<Map<String, Object>> browsingHistory(@RequestParam("userId") Integer userId){
        return browsingHistoryService.queryHistroy(userId);
    }

    /**
     * 添加历史记录
     * @param userId
     * @param productId
     * @return
     */
    @RequestMapping("/add_history")
    public String addHistory(@RequestParam("userId") Integer userId,@RequestParam("productId") Integer productId){
        return browsingHistoryService.addHistory(userId,productId)? "添加成功" : "添加失败";
    }

    /**
     * 删除浏览记录
     * @param userId
     * @param productId
     * @return
     */
    @RequestMapping("/delete_history")
    public String  deleteHistory(@RequestParam("userId") Integer userId, @RequestParam("productId") Integer productId){
        return browsingHistoryService.deleteHistory(userId,productId)? "删除成功" : "删除失败";
    }

    /**
     * 根据用户ID查询地址信息
     * @param userId
     * @return
     */
    @RequestMapping("/address")
    public List<Address> userAddress(@RequestParam("userId") Integer userId){
        return addressService.queryByUserId(userId);
    }

    /**
     * 添加地址信息
     * @param address
     * @return
     */
    @RequestMapping("/add_address")
    public boolean addAddress(Address address){
        System.out.println("开始添加");
        return addressService.addAddress(address) == 1 ;
    }

    /**
     * 删除地址信息
     * @param id
     * @return
     */
    @RequestMapping("/delete_address")
    public boolean deleteAddress(@RequestParam("id") Integer id){
        System.out.println("开始删除");
        return addressService.deleteById(id) == 1 ;
    }

    /**
     * 修改地址信息
     * @param address
     * @return
     */
    @RequestMapping("/modify_address")
    public boolean modifyAddress( Address address){
        System.out.println("开始修改");
        return addressService.updateById(address) == 1;
    }

    /**
     * 简略用户信息
     * @param userId
     * @return
     */
    @RequestMapping("/simpleinfo")
    public List<Map<String,Object>> userSimpleInfo(@RequestParam("userId") Integer userId){
        return userService.simpleInfo(userId) ;
    }
    /**
     * 修改用户信息
     * @param userId
     * @param username
     * @param sex
     * @param headPortrait
     * @return
     */
    @RequestMapping("/modify_userinfo")
    public boolean modifyUserInfo(@RequestParam(value = "userId") Integer userId,
                                  @RequestParam(value = "username",required = false) String username,
                                  @RequestParam(value = "sex",required = false,defaultValue = "2") Byte sex,
                                  @RequestParam(value = "headPortrait",required = false) MultipartFile headPortrait,
                                  HttpServletRequest request){
        return  userService.updateInfo(userId, username, headPortrait, sex,request);
    }
}
