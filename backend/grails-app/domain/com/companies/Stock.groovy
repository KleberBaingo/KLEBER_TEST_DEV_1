package com.companies;
import java.math.BigDecimal;
import java.util.Date;
import java.time.LocalDateTime

public class Stock {
    private Company company;
    private BigDecimal price;
    private LocalDateTime priceDate;

    public Stock(Company company, BigDecimal price, LocalDateTime priceDate) {
        this.company = company;
        this.price = price;
        this.priceDate = priceDate;
    }

    public Company getCompany() {
        return company;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public LocalDateTime getPriceDate() {
        return priceDate;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setPriceDate(LocalDateTime priceDate) {
        this.priceDate = priceDate;
    }
}
