package com.fh.shop.brand.controller;

import com.fh.common.ServerResponse;
import com.fh.shop.brand.biz.IBrandService;
import com.fh.shop.brand.po.Brand;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class BrandController {
    @Resource(name="brandService")
    private IBrandService brandService;

    @GetMapping("/brand/list")
    public ServerResponse list() {
        return brandService.findBrandList();
    }

    @PostMapping("/brand/add")
    public ServerResponse addBrand(Brand brand) {
        return brandService.addBrand(brand);
    }

    @DeleteMapping("/brand/{id}")
    public ServerResponse deleteBrand(@PathVariable Integer id) {
        return brandService.deleteBrand(id);
    }

    @PutMapping("/brand/update")
    public ServerResponse updateBrand(@RequestBody Brand brand) {
        return brandService.updateBrand(brand);
    }
}
