package com.fh.shop.brand.mapper;

import com.fh.shop.brand.po.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IBrandMapper {

    @Results({
          @Result(column = "id", property = "id"),
          @Result(column = "brandName", property = "brandName"),
          @Result(column = "logo", property = "logo"),
          @Result(column = "brandDesc", property = "brandDesc")
    })
    @Select("select id,brandName,logo,brandDesc from t_brand")
    public List<Brand> findBrandList();

    @Insert("insert into t_brand (brandName,logo,brandDesc) values (#{brandName},#{logo},#{brandDesc})")
    void addBrand(Brand brand);

    @Delete("delete from t_brand where id=#{value}")
    void deleteBrand(Integer id);

    @Update("update t_brand set brandname=#{brandName},logo=#{logo},brandDesc=#{brandDesc} where id=#{id}")
    void updateBrand(Brand brand);
}
