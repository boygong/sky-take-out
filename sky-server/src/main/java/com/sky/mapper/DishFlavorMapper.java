package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * #author 龚圆康
 * #class 软件2144
 * #student_number 21040147
 */

@Mapper
public interface DishFlavorMapper {
    /*
    * 批量插入口味数据
    * */
    void insertBatch(List<DishFlavor> flavors);

    /*
    *根据菜品id删除口味数据
    * */
    @Delete("delete from dish_flavor where dish_id=#{dishId}")
    void deleteByDishId(Long dishId);
}
