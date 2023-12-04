package com.sky.service.impl;

import com.sky.dto.SetmealDTO;
import com.sky.entity.Setmeal;
import com.sky.entity.SetmealDish;
import com.sky.mapper.SetmealDishMapper;
import com.sky.mapper.SetmealMapper;
import com.sky.service.SetmealService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * #author 龚圆康
 * #class 软件2144
 * #student_number 21040147
 */
@Service
public class SetmealServiceImpl implements SetmealService {
    @Autowired
    private SetmealMapper setmealMapper;
    @Autowired
    private SetmealDishMapper setmealDishMapper;

    @Override
    @Transactional
    public void insertSetmealWithDish(SetmealDTO setmealDTO) {
        //数据封装
        Setmeal setmeal = new Setmeal();
        BeanUtils.copyProperties(setmealDTO,setmeal);
        //向套餐表中插入套餐数据
        setmealMapper.insert(setmeal);
        Long id = setmeal.getId(); //获取套餐id
        //向套餐与菜品关系表中插入数据
        List<SetmealDish> setmealDishes = setmealDTO.getSetmealDishes(); //获取套餐中的菜品
        setmealDishes.forEach(setmealDish -> {
            setmealDish.setSetmealId(id); //设置套餐id
            setmealDishMapper.insert(setmealDish);
        });
    }
}
