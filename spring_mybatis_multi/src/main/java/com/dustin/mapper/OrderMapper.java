package com.dustin.mapper;

import com.dustin.domain.Order;

import java.util.List;

/**
 *  @Classname OrderMapper
 *  @Descrption TODO
 *  @Date 2021/8/7上午 02:05
 *  @Created By Dustin_Peng
 */public interface OrderMapper {
     List<Order> findAll();
}
