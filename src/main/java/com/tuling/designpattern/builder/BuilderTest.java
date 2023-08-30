package com.tuling.designpattern.builder;

import org.springframework.web.servlet.mvc.method.RequestMappingInfo;

public class BuilderTest {
    public static void main(String[] args) {

        DefaultConcreteProductBuilder defaultConcreteProductBuilder =new DefaultConcreteProductBuilder();
        Director director =new Director(defaultConcreteProductBuilder);
        Product product = director.makeProduct("productName", "companyName", "a", "b");
        System.out.println(product);
    }

}

interface ProductBuilder {
    void builderProductName(String productName);

    void builderCompanyName(String companyName);

    void builderA(String a);

    void builderB(String b);
    Product build();
}

class DefaultConcreteProductBuilder implements ProductBuilder {

    private String productName;
    private String companyName;
    private String a;
    private String b;

    @Override
    public void builderProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public void builderCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public void builderA(String a) {
        this.a = a;
    }

    @Override
    public void builderB(String b) {
        this.b = b;
    }

    @Override
    public Product build() {
        return new Product(this.productName,this.companyName,this.a,this.b);
    }
}
class Director{
    public Director(ProductBuilder builder) {
        this.builder = builder;
    }

    private ProductBuilder builder;
    public Product makeProduct (String productName,String companyName,String a,String b){
        builder.builderProductName(productName);
        builder.builderCompanyName(companyName);
        builder.builderA(a);
        builder.builderB(b);
        Product build = builder.build();
        return build;
    }
}

class Product {
    public Product(String productName, String companyName, String a, String b) {
        this.productName = productName;
        this.companyName = companyName;
        this.a = a;
        this.b = b;
    }

    private String productName;
    private String companyName;
    private String a;
    private String b;

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                '}';
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }
}
