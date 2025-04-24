package com.sky.service;

import com.sky.vo.OrderReportVO;
import com.sky.vo.SalesTop10ReportVO;
import com.sky.vo.TurnoverReportVO;
import com.sky.vo.UserReportVO;

import java.time.LocalDate;

public interface ReportService {
   public TurnoverReportVO getTurnoverStatistics(LocalDate begin,LocalDate end);

   public UserReportVO getUserStatistics(LocalDate begin, LocalDate end);

   OrderReportVO getOrdersStatistics(LocalDate begin, LocalDate end);

   SalesTop10ReportVO getSalesTop10(LocalDate begin, LocalDate end);
}
