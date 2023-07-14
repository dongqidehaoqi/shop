package com.utils;

import org.springframework.web.multipart.MultipartFile;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;


/**
 * @Description 图片处理工具
 * @Author qiqi
 * @Date 2023/3/1
 * @Version 1.0
 * @Since 1.0
 */
public class ImgUtil {
    /**
     *
     * @param files 前端传来的图片
     * @param savePath 图片保存的位置
     */
    public static void upload(MultipartFile[] files, String savePath,int width,int height){
        System.out.println(files);
        //BufferedOutputStream bufferedOutputStream = null;
        InputStream inputStream = null;
        if(files != null){
            try {
                for (MultipartFile file : files) {
                    //inputStream = new ByteArrayInputStream(file.getBytes());
                    //获取图片文件输入流
                    inputStream =file.getInputStream();
                    //读取图片
                    BufferedImage image = ImageIO.read(inputStream);
                    //图片缩放
                    Image imageScaledInstance = image.getScaledInstance(width, height, Image.SCALE_DEFAULT);
                    //bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(savePath));
                    //将 缩放的图片 绘制到 RenderedImage接口上，BufferedImage实现了此接口
                    BufferedImage bufImg = new BufferedImage(imageScaledInstance.getWidth(null), imageScaledInstance.getHeight(null),BufferedImage.TYPE_INT_RGB);
                    //创建画布
                    Graphics g = bufImg .createGraphics();
                    g.drawImage(imageScaledInstance, 0, 0, null);
                    //销毁画布
                    g.dispose();
                    //将缩放处理后的图片输出到本地磁盘
                    ImageIO.write(bufImg,"PNG",new File(savePath));
                    //一次读取1KB
                    //byte [] arr = new byte[1024];
                    //int length = 0;
                    //while ((length = inputStream.read(arr)) != -1) {
                    //    bufferedOutputStream.write(arr,0,length);
                    //}
                }


            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    //bufferedOutputStream.flush();
                    //bufferedOutputStream.close();
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
