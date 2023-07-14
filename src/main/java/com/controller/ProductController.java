package com.controller;

import com.entity.Cart;
import com.entity.Comment;
import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author qiqi
 * @Date 2023/6/16
 * @Version 1.0
 * @Since 1.0
 */
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CartService cartService;
    @Autowired
    private CollectionService collectionService;
    @Autowired
    private PictureService pictureService;
    @Autowired
    private ProductModelService productModelService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private MerchantService merchantService;

    /**
     * 商品详情
     * @param productId
     * @return
     */
    @RequestMapping("/detail")
    public Map<Object,Object> productDetail(@RequestParam("productId") Integer productId){
        //主展示图
        List<Map<String, Object>> mainPicture = pictureService.showMain(productId);
        //商品详情
        List<Map<String, Object>> detailInfo = productService.queryDetail(productId);
        //商品型号
        List<Map<String, Object>> model = productModelService.queryModel(productId);
        //所有非公告展示图
        List<String> notNoticePicture = pictureService.showNotNotice(productId);
        //商品所在商家信息
        List<Map<String, Object>> merchant = merchantService.queryMerchantByPdt(productId);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("merchant",merchant);
        map.put("mainPicture",mainPicture);
        map.put("detailInfo",detailInfo);
        map.put("notNoticePicture",notNoticePicture);
        map.put("model",model);
        return map;
    }

    /**
     * 查看评论
     * @param productId
     * @return
     */
    @RequestMapping("/comment")
    public List<Map<String, Object>> comment(@RequestParam("productId") Integer productId){
        return commentService.queryComment(productId);
    }

    /**
     * 添加评论
     * @param userId
     * @param productId
     * @param comment
     * @return
     */
    @RequestMapping("/add_comment")
    public List<Map<String, Object>> addComment(@RequestParam("userId") Integer userId,
                           @RequestParam("productId") Integer productId,
                           @RequestParam("comment") String comment){
        Comment comment1 = new Comment();
        comment1.setProductId(productId);
        comment1.setContent(comment);
        comment1.setTime(new Timestamp(System.currentTimeMillis()));
        comment1.setUserId(userId);
        return commentService.addComment(comment1);
    }

    /**
     * 添加到购物车
     * @param productId
     * @param userId
     * @param num
     * @return
     */
    @RequestMapping("/add_to_cart")
    public boolean addToCart(@RequestParam("productId") Integer productId,
                             @RequestParam("userId") Integer userId,
                             @RequestParam(value = "num",required = false,defaultValue = "1") Integer num,
                             @RequestParam(value = "model",required = false) String model){
        //先删除已存在的再插入
        cartService.deleteExist(userId, productId);
        Cart cart = new Cart(null,new java.util.Date(),num,userId,productId,model);
        return cartService.addCart(cart);
    }

    /**
     * 查询是否已在收藏夹
     * @param userId
     * @param productId
     * @return
     */
    @RequestMapping("/query_coll")
    public Integer queryColl(@RequestParam("userId") Integer userId, @RequestParam("productId") Integer productId){
        return collectionService.selectByUserIdAndProductId(userId,productId);
    }

    /**
     * 根据用户ID和商品ID删除收藏夹记录
     * @param userId
     * @param productId
     * @return
     */
    @RequestMapping("/delete_coll")
    public boolean deleteColl(@RequestParam("userId") Integer userId,@RequestParam("productId") Integer productId){
        return collectionService.deleteByUserIdAndProductId(userId,productId);
    }

}
