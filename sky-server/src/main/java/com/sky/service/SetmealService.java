package com.sky.service;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.result.PageResult;
import com.sky.vo.SetmealVO;

import java.util.List;

/**
 * #author 龚圆康
 * #class 软件2144
 * #student_number 21040147
 */
public interface SetmealService {
    //新增套餐以及包含的菜品
    void insertSetmealWithDish(SetmealDTO setmealDTO);

    //套餐分页查询
    PageResult getPage(SetmealPageQueryDTO setmealPageQueryDTO);

    //套餐的批量删除
    void delete(List<Long> ids);

    void updateSetmealWithDish(SetmealDTO setmealDTO);

    SetmealVO getById(Long id);
}
