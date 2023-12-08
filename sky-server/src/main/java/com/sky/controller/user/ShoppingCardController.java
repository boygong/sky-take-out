package com.sky.controller.user;

import com.sky.dto.ShoppingCartDTO;
import com.sky.entity.ShoppingCart;
import com.sky.result.Result;
import com.sky.service.ShoppingCartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * #author 龚圆康
 * #class 软件2144
 * #student_number 21040147
 */
@RestController
@RequestMapping("/user/shoppingCart")
@Slf4j
@Api(tags = "c端用户购物车相关接口")
public class ShoppingCardController {
    @Autowired
    private ShoppingCartService shoppingCartService;
    @PostMapping("/add")
    @ApiOperation("添加购物车")
    public Result add(@RequestBody ShoppingCartDTO shoppingCartDTO){
        log.info("添加购物车商品信息为:{}",shoppingCartDTO);
        shoppingCartService.addShoppingCard(shoppingCartDTO);
        return Result.success();
    }

    //查看购物车
    @GetMapping("/list")
    @ApiOperation("查看购物车")
    public Result<List<ShoppingCart>> list(){
        List<ShoppingCart> list = shoppingCartService.showShoppingCart();
        return Result.success(list);
    }

    //清空购物车
    @DeleteMapping("/clean")
    @ApiOperation("清空购物车")
    public Result clean(){
        shoppingCartService.cleanShoppingCart();
        return Result.success();
    }

    /*
    * 删除购物车中的一个商品
    * */
    @PostMapping("/sub")
    @ApiOperation("删除购物车中的一个商品")
    public Result sub(@RequestBody ShoppingCartDTO shoppingCartDTO ){
        shoppingCartService.subShoppingCart(shoppingCartDTO);
        return Result.success();
    }
}
