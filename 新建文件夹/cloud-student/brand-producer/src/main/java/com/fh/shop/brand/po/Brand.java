package com.fh.shop.brand.po;

import java.io.Serializable;

public class Brand implements Serializable {
    private static final long serialVersionUID = 4085504375974534905L;

    private Integer id;

    private String brandName;

    private String logo;

    private String brandDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getBrandDesc() {
        return brandDesc;
    }

    public void setBrandDesc(String brandDesc) {
        this.brandDesc = brandDesc;
    }
}
