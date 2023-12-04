package com.sky.controller.admin;

import com.sky.dto.SetmealDTO;
import com.sky.result.Result;
import com.sky.service.SetmealService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * #author 龚圆康
 * #class 软件2144
 * #student_number 21040147
 */
@RestController
@RequestMapping("/admin/setmeal")
@Api(tags = "套餐相关接口")
@Slf4j
public class SetmealController {
    @Autowired
    private SetmealService setmealService;

    @PostMapping
    @ApiOperation("新增套餐以及包含的菜品")
    public Result save(@RequestBody SetmealDTO setmealDTO){
        log.info("新增套餐以及包含的菜品:{}",setmealDTO);
        setmealService.insertSetmealWithDish(setmealDTO);
        return Result.success();
    }
}
