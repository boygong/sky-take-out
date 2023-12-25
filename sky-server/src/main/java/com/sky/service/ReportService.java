package com.sky.service;

import com.sky.vo.OrderReportVO;
import com.sky.vo.SalesTop10ReportVO;
import com.sky.vo.TurnoverReportVO;
import com.sky.vo.UserReportVO;

import java.time.LocalDate;

/**
 * #author 龚圆康
 * #class 软件2144
 * #student_number 21040147
 */
public interface ReportService {


    /*
    * 统计制定时间内的数据
    * */
    TurnoverReportVO getTurnOverStatistics(LocalDate begin,LocalDate end);

    UserReportVO getUserStatistics(LocalDate begin, LocalDate end);

    OrderReportVO getOrderStatistics(LocalDate begin, LocalDate end);

    //统计制定时间内的销量前10
    SalesTop10ReportVO getSalesTop10(LocalDate begin, LocalDate end);
}
