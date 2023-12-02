package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * #author 龚圆康
 * #class 软件2144
 * #student_number 21040147
 */
@Mapper
public interface SetmealDishMapper {

    //根据菜品id，查询套餐id
    List<Long> getSetmealIdsByDishIds(List<Long> dishIds);
}
