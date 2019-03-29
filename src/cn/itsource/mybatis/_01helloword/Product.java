package cn.itsource.mybatis._01helloword;

import java.math.BigDecimal;

public class Product {
    private Long sid;
    private String productName;
    //对应的产品类型id
    private Long dirId;
    //销售价格
    private BigDecimal salePrice;
    //供应商
    private String supplier;
    //品牌
    private String brand;
    //折扣
    private BigDecimal cutoff;
    //成本价
    private BigDecimal costPrice;

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getDirId() {
        return dirId;
    }

    public void setDirId(Long dirId) {
        this.dirId = dirId;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getCutoff() {
        return cutoff;
    }

    public void setCutoff(BigDecimal cutoff) {
        this.cutoff = cutoff;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + sid +
                ", productName='" + productName + '\'' +
                ", dirId=" + dirId +
                ", salePrice=" + salePrice +
                ", supplier='" + supplier + '\'' +
                ", brand='" + brand + '\'' +
                ", cutoff=" + cutoff +
                ", costPrice=" + costPrice +
                '}';
    }
}
