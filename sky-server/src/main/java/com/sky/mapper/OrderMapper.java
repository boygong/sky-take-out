package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.GoodsSalesDTO;
import com.sky.dto.OrdersPageQueryDTO;
import com.sky.entity.Orders;
import com.sky.vo.OrderStatisticsVO;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * #author 龚圆康
 * #class 软件2144
 * #student_number 21040147
 */

@Mapper
public interface OrderMapper {

    //插入订单数据
    void insert(Orders orders);

    /**
     * 根据订单号查询订单
     * @param orderNumber
     */
    @Select("select * from orders where number = #{orderNumber}")
    Orders getByNumber(String orderNumber);

    /**
     * 修改订单信息
     * @param orders
     */
    void update(Orders orders);

    Page<Orders> pageQuery(OrdersPageQueryDTO ordersPageQueryDTO);

    //根据id查询订单
    @Select("select * from orders where id=#{id}")
    Orders getById(Long id);

    //获取待接单，待派送，派送中的订单数量直接封装到OrderStatisticsVO中
    @Select("SELECT " +
            "SUM(CASE WHEN o.status = 2 THEN 1 ELSE 0 END) as toBeConfirmed, " +
            "SUM(CASE WHEN o.status = 3 THEN 1 ELSE 0 END) as confirmed, " +
            "SUM(CASE WHEN o.status = 4 THEN 1 ELSE 0 END) AS deliveryInProgress " +
            "FROM orders o")
    OrderStatisticsVO getOrderStatistics();

    /**
     * 根据订单状态和下单时间查询订单
    * */
    @Select("select * from orders where status=#{status} and order_time<#{orderTime}")
    List<Orders> getByStatusAndOrderTimeLT(Integer status, LocalDateTime orderTime);

    /*
    * 根据动态条件统计营业额数据
    * */
    Double sumByMap(Map map);

    //根据动态条件统计
    Integer countByMap(Map map);

    //销量排名统计(前10)
    List<GoodsSalesDTO> getSalesTop10(LocalDateTime begin,LocalDateTime end);
}
