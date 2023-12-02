package com.sky.service;

import com.sky.dto.DishDTO;

/**
 * #author 龚圆康
 * #class 软件2144
 * #student_number 21040147
 */
public interface DishService {

    /*
    * 新增菜品和对应的口味数据
    * */
    public void saveWithFlavor(DishDTO dishDTO);
}
