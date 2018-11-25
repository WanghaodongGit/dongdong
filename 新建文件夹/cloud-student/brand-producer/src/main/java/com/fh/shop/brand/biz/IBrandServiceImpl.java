package com.fh.shop.brand.biz;

import com.fh.common.ServerResponse;
import com.fh.shop.brand.mapper.IBrandMapper;
import com.fh.shop.brand.po.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("brandService")
@Transactional(rollbackFor = Exception.class)
public class IBrandServiceImpl implements IBrandService {
    @Autowired
    private IBrandMapper brandMapper;

    @Override
    @Transactional(readOnly = true)
    public ServerResponse findBrandList() {
        List<Brand> brandList = brandMapper.findBrandList();
        return ServerResponse.success(brandList);
    }

    @Override
    public ServerResponse addBrand(Brand brand) {
        brandMapper.addBrand(brand);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse deleteBrand(Integer id) {
        brandMapper.deleteBrand(id);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse updateBrand(Brand brand) {
        brandMapper.updateBrand(brand);
        return ServerResponse.success();
    }
}
