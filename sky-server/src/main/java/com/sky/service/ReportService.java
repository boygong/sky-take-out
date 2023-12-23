package com.sky.service;

import com.sky.vo.TurnoverReportVO;

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
}
