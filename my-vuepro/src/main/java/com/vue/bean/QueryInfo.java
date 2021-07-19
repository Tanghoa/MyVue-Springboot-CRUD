package com.vue.bean;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QueryInfo {

    private Integer pageNum;
    private Integer pageSize;
    private Integer navigatePages;



}
