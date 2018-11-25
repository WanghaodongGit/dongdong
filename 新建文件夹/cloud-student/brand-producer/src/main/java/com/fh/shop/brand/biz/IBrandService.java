package com.fh.shop.brand.biz;


import com.fh.common.ServerResponse;
import com.fh.shop.brand.po.Brand;

public interface IBrandService {

    public ServerResponse findBrandList();

    ServerResponse addBrand(Brand brand);

    ServerResponse deleteBrand(Integer id);

    ServerResponse updateBrand(Brand brand);
}
