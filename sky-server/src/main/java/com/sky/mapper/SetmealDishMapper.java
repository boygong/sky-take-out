package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.SetmealDish;
import com.sky.vo.SetmealVO;
import org.apache.ibatis.annotations.Delete;
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

    void insert(SetmealDish setmealDish);

    //删除套餐菜品关系表中的数据
    @Delete("delete from setmeal_dish where setmeal_id=#{setmealId} ")
    void deleteBySetmealId(Long setmealId);


    @Select("select * from setmeal_dish where setmeal_id=#{setmealId}")
    List<SetmealDish> getBySetmealId(Long setmealId);
}
