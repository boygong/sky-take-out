package com.sky.mapper;

import com.sky.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * #author 龚圆康
 * #class 软件2144
 * #student_number 21040147
 */

@Mapper
public interface OrderDetailMapper {
//    @Select("select * from order_detail where order_id=#{orderId}")
//    List<OrderDetail> getByOrderId(Integer orderId);

    //批量插入订单明细文件
    void insertBatch(List<OrderDetail> orderDetailList);


    //根据订单id获取订单明细
    @Select("select * from order_detail where order_id=#{orderId}")
    List<OrderDetail> getByOrderId(Long orderId);
}
