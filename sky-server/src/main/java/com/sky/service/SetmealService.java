package com.sky.service;

import com.sky.dto.SetmealDTO;

/**
 * #author 龚圆康
 * #class 软件2144
 * #student_number 21040147
 */
public interface SetmealService {
    //新增套餐以及包含的菜品
    void insertSetmealWithDish(SetmealDTO setmealDTO);
}
