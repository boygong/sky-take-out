package com.sky.service;

import com.sky.dto.*;
import com.sky.entity.Orders;
import com.sky.result.PageResult;
import com.sky.vo.OrderPaymentVO;
import com.sky.vo.OrderStatisticsVO;
import com.sky.vo.OrderSubmitVO;
import com.sky.vo.OrderVO;
import io.swagger.models.auth.In;

/**
 * #author 龚圆康
 * #class 软件2144
 * #student_number 21040147
 */
public interface OrderService {
    OrderSubmitVO submitOrder(OrdersSubmitDTO ordersSubmitDTO);

    /**
     * 订单支付
     *
     * @param ordersPaymentDTO
     * @return
     */
    OrderPaymentVO payment(OrdersPaymentDTO ordersPaymentDTO) throws Exception;

    /**
     * 支付成功，修改订单状态
     *
     * @param outTradeNo
     */
    void paySuccess(String outTradeNo);

    //历史订单的分页查询
    PageResult pageQuery4User(int page, int pageSize, Integer status);

    OrderVO ordersWithDetail(Long id);

    //取消订单
    void update(Long id);

    //再来一次订单
    void again(Long id);

    //订单搜索
    PageResult search(OrdersPageQueryDTO ordersPageQueryDTO);

    //各个订单数量统计
    OrderStatisticsVO statistics();

    //接受订单
    void confirm(Long id);

    //拒绝订单
    void reject(OrdersRejectionDTO ordersRejectionDTO);

    //取消订单
    void cancel(OrdersCancelDTO ordersCancelDTO);

    /*
    * 派送订单
    * */
    void delivery(Long id);

    /**
     * 完成订单
     *
     * @param id
     */
    void complete(Long id);

    //客户催单
    void reminder(Long id);
}
