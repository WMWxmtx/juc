package com.tuling.designpattern.builder;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;

import java.math.BigDecimal;

public class BuilderTest1 {
    public static void main(String[] args) {
        Computer build = new Computer.ComputerBuilder().cpu(new CPUI5()).disk(new DiskSSD()).build();
        IProductDiyBuilder  iProductDiyBuilder= new ProductDiyBuilder();
        iProductDiyBuilder.setProductA("A");
        iProductDiyBuilder.setProductB("B");
        iProductDiyBuilder.setProductC("C");
        iProductDiyBuilder.setProductD("D");
        System.out.println(iProductDiyBuilder.build());


    }
}

@Data

class Computer{
    private IParts cpu;
    private IParts disk;
    private Computer(ComputerBuilder computerBuilder){
        this.cpu =computerBuilder.cpu;
        this.disk =computerBuilder.disk;
    }

   static class ComputerBuilder{
       private IParts cpu;
       private IParts disk;
       ComputerBuilder cpu(IParts cpu){
            this.cpu =cpu;
            return this;
        }

       ComputerBuilder disk(IParts disk){
           this.disk =disk;
           return this;
       }
       Computer build(){
           return new Computer(this);
       }
    }
}

/*
 * 电脑配件
 */
interface IParts{
    int a =0;
    /*
     * 零件；CPU，硬盘，主板
     */
    String scene();

    /*
     * 品牌
     */
    String brand();
    /**
     * 型号
     */
    String model();

    /*
     * 价格
     */
    BigDecimal price();
}


class DiskSSD implements IParts{
    @Override
    public String scene() {
        return "disk";
    }

    @Override
    public String brand() {
        return "King";
    }

    @Override
    public String model() {
        return "SSD";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal(500);
    }
}
class CPUI5 implements IParts{
    @Override
    public String scene() {
        return "CPU";
    }

    @Override
    public String brand() {
        return "Intel";
    }

    @Override
    public String model() {
        return "I5";
    }

    @Override
    public BigDecimal price() {
        return new BigDecimal(600);
    }
}

class ProductDiy{
    @Override
    public String toString() {
        return "ProductDiy{" +
                "productA='" + productA + '\'' +
                ", productB='" + productB + '\'' +
                ", productC='" + productC + '\'' +
                ", productD='" + productD + '\'' +
                ", productE='" + productE + '\'' +
                '}';
    }

    String productA;

    public String getProductA() {
        return productA;
    }

    public ProductDiy setProductA(String productA) {
        this.productA = productA;
        return this;
    }

    public String getProductB() {
        return productB;
    }

    public ProductDiy setProductB(String productB) {
        this.productB = productB;
        return this;
    }

    public String getProductC() {
        return productC;
    }

    public ProductDiy setProductC(String productC) {
        this.productC = productC;
        return this;
    }

    public String getProductD() {
        return productD;
    }

    public ProductDiy setProductD(String productD) {
        this.productD = productD;
        return this;
    }

    public String getProductE() {
        return productE;
    }

    public ProductDiy setProductE(String productE) {
        this.productE = productE;
        return this;
    }

    String productB;
    String productC;
    String productD;
    String productE;


}

interface IProductDiyBuilder{
    IProductDiyBuilder  setProductA(String productA);
    IProductDiyBuilder  setProductB(String productB);
    IProductDiyBuilder  setProductC(String productC);
    IProductDiyBuilder  setProductD(String productD);
    IProductDiyBuilder  setProductE(String productE);
    ProductDiy build();

}
class ProductDiyBuilder implements IProductDiyBuilder{
    private ProductDiy productDiy;

    public ProductDiyBuilder() {
        this.productDiy  = new ProductDiy();;
    }

    @Override
    public IProductDiyBuilder setProductA(String productA) {
        productDiy.setProductA(productA);
        return this;
    }

    @Override
    public IProductDiyBuilder setProductB(String productB) {
        productDiy.setProductB(productB);
        return this;
    }

    @Override
    public IProductDiyBuilder setProductC(String productC) {
        productDiy.setProductC(productC);
        return this;
    }

    @Override
    public IProductDiyBuilder setProductD(String productD) {
        productDiy.setProductD(productD);
        return this;
    }

    @Override
    public IProductDiyBuilder setProductE(String productE) {
        productDiy.setProductE(productE);
        return this;
    }

    @Override
    public ProductDiy build() {
        return productDiy;
    }
}

