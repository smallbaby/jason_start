package com.jason.jason_start.domain.chart;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
@ToString
@Data
public class ChartParam implements Serializable {
    private static final long serialVersionUID = -7721656481202109396L;
    private String id; // 图表ID
    private String name; //图表名称
    private Integer chart_type;
    private Integer data_type; // 數據類型，0 實時  1 離線
}
