package com.sky.controller.admin;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * #author 龚圆康
 * #class 软件2144
 * #student_number 21040147
 */
@RestController("adminShopController")
@RequestMapping("/admin/shop")
@Slf4j
@Api(tags = "店铺相关接口")
public class ShopController {

    public static final String KEY= "SHOP_STATUS";

    @Autowired
    private RedisTemplate redisTemplate;

    @PutMapping("/{status}")
    @ApiOperation("设置店铺的营业状态")
    public Result setStatus(@PathVariable Integer status){
        log.info("设置店铺的营业状态:{}",status == 1? "营业中":"打烊中");
        redisTemplate.opsForValue().set(KEY,status);
        return Result.success();
    }

    @GetMapping("/status")
    @ApiOperation("获取店铺的营业状态")
    public Result<Integer> getStatus(){
        Integer status = (Integer) redisTemplate.opsForValue().get(KEY);
        log.info("获取到店铺的营业状态为:{}",status == 1? "营业中":"打烊中");
        return Result.success(status);
    }
}
