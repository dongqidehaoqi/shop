package com;

import com.controller.ProductController;
import com.dao.*;
import com.entity.*;
import com.service.BrowsingHistoryService;
import com.service.OrderInfoService;
import com.service.ProductService;
import com.service.UserService;
import com.utils.ImgUtil;
import com.utils.MD5;
import org.json.JSONException;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;


/**
 * @Description
 * @Author qiqi
 * @Date 2023/5/5
 * @Version 1.0
 * @Since 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {
    @Autowired
    public CartMapper cartMapper;
    @Autowired
    public UserMapper userMapper;
    @Autowired
    public UserService userService;
    @Autowired
    public ProductService productService;
    @Autowired
    public OrderInfoService orderInfoService;
    @Autowired
    public BrowsingHistoryService browsingHistoryService;
    @Autowired
    public ProductTypeMapper productTypeMapper;
    @Autowired
    public CollectionMapper collectionMapper;
    @Autowired
    public MerchantMapper merchantMapper;
    @Autowired
    public ProductMapper productMapper;
    @Autowired
    public CommentMapper commentMapper;
    @Autowired
    public PictureMapper pictureMapper;
    @Autowired
    public ProductTypeRelationMapper productTypeRelationMapper;
    @Autowired
    public ProductModelMapper productModelMapper;
    @org.junit.Test
    public void  dosome() {
        //插入店铺
        //Merchant merchant = new Merchant();
        //merchant.setCreateTime(new Date());
        //merchant.setFansNum(1000);
        //byte a = 4;
        //merchant.setGoodsGrade(a);
        //merchant.setLogisticsGrade(a);
        //merchant.setOwnerName("张三");
        //merchant.setHeadProtrait("a.jpg");
        //merchant.setServiceGrade(a);
        //byte b = 1;
        //merchant.setStatus(b);
        //int i = 17;
        //for (;i <= 40;i++){
        //    merchant.setId(i);
        //    merchant.setShopName("店铺" + System.currentTimeMillis());
        //    merchantMapper.insert(merchant);
        //}
        //插入商品----------------------------
        //String[] info = {
        //        "佐菲奥特曼——ZOFFY——来源于“SOPHIA”（智慧女神，因为佐菲是男性所以加以区别)",
        //        "奥特曼——Ultraman——超人的意思。日文“ウルトラマン”也为超人的意思",
        //        "赛文奥特曼——SEVEN——数字7，由于奥特警备队原有6名队员，意为第七名成员。",
        //        "杰克奥特曼——JACK——本来没有名字，曾经叫过“新曼”。名字是后来在美国播放的时候加的，本来是用在泰罗身上的，但是当时日本的“HI JACK”不是什么好词",
        //        "艾斯奥特曼——ACE——英文：王牌",
        //        "泰罗奥特曼——TARO——日语“太郎”，意思是奥特之父与奥特之母的儿子",
        //        "雷欧奥特曼——LEO——英语：狮子。意喻其故乡是狮子座L77星",
        //        "阿斯特拉奥特曼——ASTRA——日语“飞虎”",
        //        "爱迪奥特曼——EIGHTY——播放时间是1980年，故以80的英文为名",
        //        "葛雷奥特曼——GREAT——英语：伟大的",
        //        "帕瓦德奥特曼——POWERED——英语：强有力的",
        //        "哉阿斯奥特曼——Z-earth——Z-星球，意思是他来自Z95星球",
        //        "迪迦奥特曼——TIGA——印度尼西亚语中代表神圣数字“3”",
        //        "戴拿奥特曼——DYNA——取自于Dynamic，意为“充满活力的”",
        //        "盖亚奥特曼——GAIA——源于希腊神话大地之母的名字",
        //        "阿古茹奥特曼——AGUL——日语“水”的罗马音变形而来，与大地相对应",
        //        "奈欧斯奥特曼——NEOS——意为新世纪",
        //        "纳伊斯奥特曼——NICE——英语：令人愉快的。这是一个专门为搞笑而设计的奥特曼，主角靠吃巧克力变身",
        //        "高斯奥特曼——COSMOS——英语：秩序，宇宙",
        //        "杰斯提斯奥特曼——JUSTICE——英语：正义，公正",
        //        "奈克斯特奥特曼——NEXT——英语：下一个",
        //        "奈克瑟斯奥特曼——NEXUS——英语：纽带",
        //        "诺亚奥特曼——NOA——源自圣经中的诺亚方舟",
        //        "麦克斯奥特曼——MAX——英文\"maximum\"的缩写，意为：最大的",
        //        "杰诺奥特曼——XENON——希腊语：陌生人",
        //        "梦比优斯奥特曼——Mebius——莫比乌斯环：∞，意为“无限”",
        //        "希卡利奥特曼——HIKARI——日语“光”",
        //        "雷杰多奥特曼——LEGEND——英语：传说", "赛罗奥特曼——ZERO——英语：数字\"0\"", "博伊奥特曼——BOY——英语：男孩",
        //        "白蝴蝶花 白蝴蝶花是鸢尾属的一种植物，蝴蝶花的一种。",
        //        "红蝴蝶花 白蝴蝶花是鸢尾属的一种植物，蝴蝶花的一种。",
        //        "橙蝴蝶花 白蝴蝶花是鸢尾属的一种植物，蝴蝶花的一种。",
        //        "黄蝴蝶花 白蝴蝶花是鸢尾属的一种植物，蝴蝶花的一种。",
        //        "绿蝴蝶花 白蝴蝶花是鸢尾属的一种植物，蝴蝶花的一种。",
        //        "青蝴蝶花 白蝴蝶花是鸢尾属的一种植物，蝴蝶花的一种。",
        //        "蓝蝴蝶花 白蝴蝶花是鸢尾属的一种植物，蝴蝶花的一种。",
        //        "紫蝴蝶花 白蝴蝶花是鸢尾属的一种植物，蝴蝶花的一种。",
        //        "黑蝴蝶花 白蝴蝶花是鸢尾属的一种植物，蝴蝶花的一种。",
        //        "甘露子是一种不是很常见的植物，但是开花的时候，小花还是很可爱的。甘露子属于根茎植物，具有药用的价值。",
        //        "狼毒，听起来是不是感觉凶凶的，其实它是一种能开小花的植物，比较漂亮。只不过它本身毒性是很大，养殖的还是要格外注意。",
        //        "活血丹是一种多年生的草本类植物，有着比较美好的花语。它的植株上面通常会开着比较漂亮的小花。",
        //        "小米草是一种草本植物，其实它比较不常见，但是具有较高的价值。一般养殖小米草，都是希望能够获得巨大的价值的。",
        //        "非洲凤仙是多年生草本植物，在欧美地区，它是比较流行的养殖盆栽花卉。",
        //        "秋牡丹可不是秋天的牡丹，也不是山茶的一种，它是毛莨科植物，开花很是精致。它原产自我国。",
        //        "蓝目菊是观赏价值比较高的一种，它属于草本花卉，开花的时候花盘是蓝紫色的。蓝目菊适合家庭养殖，以盆栽为佳",
        //        "铁兰又叫做紫凤梨，是我国比较常见的凤梨属植物，会开漂亮的花。家庭养殖铁兰，可是很不错的选择哦。"
        //};
        //String[] name= {
        //        "佐菲奥特曼",
        //        "奥特曼",
        //        "赛文奥特曼",
        //        "杰克奥特曼",
        //        "艾斯奥特曼",
        //        "泰罗奥特曼",
        //        "雷欧奥特曼",
        //        "阿斯特拉奥特曼",
        //        "爱迪奥特曼",
        //        "葛雷奥特曼",
        //        "帕瓦德奥特曼",
        //        "哉阿斯奥特曼",
        //        "迪迦奥特曼",
        //        "戴拿奥特曼",
        //        "盖亚奥特曼",
        //        "阿古茹奥特曼",
        //        "奈欧斯奥特曼",
        //        "纳伊斯奥特曼",
        //        "高斯奥特曼",
        //        "杰斯提斯奥特曼",
        //        "奈克斯特奥特曼",
        //        "奈克瑟斯奥特曼",
        //        "诺亚奥特曼",
        //        "麦克斯奥特曼",
        //        "杰诺奥特曼",
        //        "梦比优斯奥特曼",
        //        "希卡利奥特曼",
        //        "雷杰多奥特曼",
        //        "赛罗奥特曼",
        //        "博伊奥特曼",
        //        "白蝴蝶花",
        //        "红蝴蝶花",
        //        "橙蝴蝶花",
        //        "黄蝴蝶花",
        //        "绿蝴蝶花",
        //        "青蝴蝶花",
        //        "蓝蝴蝶花",
        //        "紫蝴蝶花",
        //        "黑蝴蝶花",
        //        "甘露子",
        //        "狼毒",
        //        "活血丹",
        //        "小米草",
        //        "非洲凤仙",
        //        "秋牡丹",
        //        "蓝目菊",
        //        "铁兰又"
        //};
        //Product product = new Product();
        //product.setAddress("北京");
        //byte a= 1;
        //product.setStatus(a);
        //product.setInventoryNum(100);
        //product.setWarnNum(20);
        //product.setModifyTime(new Timestamp(System.currentTimeMillis()));
        //for(int i = 18;i < 18 + name.length;i++){
        //    product.setId(i+40);
        //    product.setComeTime(new Timestamp(System.currentTimeMillis()));
        //    product.setName(name[i-18]);
        //    product.setDetailInfo(info[i-18]);
        //    product.setMarketPrice(new BigDecimal(100 + i));
        //    product.setPreferentialPrice(new BigDecimal(100 - i));
        //    product.setDiscount(2.0*i/(100+i) );
        //    product.setSaleNum(2000+i);
        //    product.setMerchantId(i%39 + 1);
        //    productMapper.insert(product);
        //}
    //    插入评论
    //    Comment comment = new Comment();
    //    byte a = 1;
    //    comment.setStatus(a);
    //    for (int i = 58;i<100;i++){
    //        comment.setId(i);
    //        comment.setContent("孩子很喜欢吃" + i*2);
    //        comment.setTime(new Timestamp(System.currentTimeMillis()));
    //        comment.setUserId( i % 20 + 4);
    //        comment.setProductId(i);
    //        commentMapper.insert(comment);
    //    }

    //    插入图片
    //    byte a = 0;
    //    Picture picture = new Picture();
    //    for(int i = 2;i<= 104; i++){
    //        picture.setCreateTime(new Date());
    //        picture.setId(i+100);
    //        picture.setName(i+84 + ".png");
    //        picture.setIsNotice(a);
    //        picture.setMerchantId(i % 40 + 1);
    //        picture.setProductId(i+56);
    //        picture.setTypeId(2);
    //        pictureMapper.insert(picture);
    //    }
    //    ProductType productType = new ProductType();
    //    String[] a = {"植物","奥特曼","动物","羊","花","草","红奥特曼","蓝奥特曼","白奥特曼","红花","绿花","蓝花","大草","小草"};
    //    //Object[] b = {null,null,null,null,null,null,2,2,2,2,2,2,null,null};
    //    for (int i = 22;i<22+a.length;i++){
    //        productType.setId(i);
    //        productType.setName(a[i-22]);
    //        productTypeMapper.insert(productType);
    //    }
    //    ProductTypeRelation ptr = new ProductTypeRelation();
    //    for (int i= 72;i<=32 + 104;i++){
    //        //if(i - 31==18){
    //        //    i++;
    //        //    continue;
    //        //}
    //        //if(i - 31 ==41){
    //        //    i=58;
    //        //    continue;
    //        //}
    //        ptr.setId(i);
    //        ptr.setProductId(i-14);
    //        ptr.setTypeId(i % 38 + 1);
    //        productTypeRelationMapper.insert(ptr);
    //    }
        ProductModel productModel = new ProductModel();
        for(int i =83;i < 200; i++){
            productModel.setId(i);
            productModel.setContent("型号"+i);
            productModel.setProductId(i-25);
            productModelMapper.insert(productModel);
        }


    }
}
