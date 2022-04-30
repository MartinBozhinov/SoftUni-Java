package com.example.xmlprocexe.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsInRangeRootDto {


    @XmlElement(name = "product")
    private List<ProductsInRangeDto> products;

    public List<ProductsInRangeDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductsInRangeDto> products) {
        this.products = products;
    }
}
