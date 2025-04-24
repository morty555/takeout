package com.sky.controller.admin;

import com.sky.result.Result;
import com.sky.service.ReportService;
import com.sky.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Slf4j
@RequestMapping("/admin/report")
@Api(tags = "数据统计相关注解")
@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;
    @GetMapping("/turnoverStatistics")
    @ApiOperation("营业额统计")
    public Result<TurnoverReportVO> turnoverReportVOResult
            (
                    @DateTimeFormat(pattern = "yyyy-MM-dd")
                    LocalDate begin,
                    @DateTimeFormat(pattern = "yyyy-MM-dd")
                    LocalDate end
            )
    {

        log.info("营业额数据统计：{}，{}",begin,end);
        return Result.success(reportService.getTurnoverStatistics(begin,end));
    }

    @GetMapping("/userStatistics")
    @ApiOperation("用户统计")
    public Result<UserReportVO> userStatistics(
            @DateTimeFormat(pattern = "yyyy-MM-dd")
            LocalDate begin,
            @DateTimeFormat(pattern = "yyyy-MM-dd")
            LocalDate end
    )
    {
        log.info("用户数据统计：{}，{}",begin,end);
        return Result.success(reportService.getUserStatistics(begin,end));
    }

    @GetMapping("/ordersStatistics")
    @ApiOperation("订单统计")
    public Result<OrderReportVO> ordersStatistics(
            @DateTimeFormat(pattern = "yyyy-MM-dd")
            LocalDate begin,
            @DateTimeFormat(pattern = "yyyy-MM-dd")
            LocalDate end
    )
    {
        log.info("订单数据统计：{}，{}",begin,end);
        return Result.success(reportService.getOrdersStatistics(begin,end));
    }

    @GetMapping("/top10")
    @ApiOperation("top10")
    public Result<SalesTop10ReportVO> top10(
            @DateTimeFormat(pattern = "yyyy-MM-dd")
            LocalDate begin,
            @DateTimeFormat(pattern = "yyyy-MM-dd")
            LocalDate end
    )
    {
        log.info("top10：{}，{}",begin,end);
        return Result.success(reportService.getSalesTop10(begin,end));
    }
}
