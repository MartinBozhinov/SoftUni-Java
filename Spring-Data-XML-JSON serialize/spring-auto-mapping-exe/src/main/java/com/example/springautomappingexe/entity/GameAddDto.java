package com.example.springautomappingexe.entity;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

public class GameAddDto {
    private String title;
    private BigDecimal price;
    private Double size;
    private String trailer;
    private String thubnailURL;
    private String description;
    private LocalDate releaseDate;

    public GameAddDto() {
    }


    public GameAddDto(String title, BigDecimal price,
                      Double size, String trailer, String thubnailURL,
                      String description, LocalDate releaseDate) {
        this.title = title;
        this.price = price;
        this.size = size;
        this.trailer = trailer;
        this.thubnailURL = thubnailURL;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    @Pattern(regexp = "[A-Za-z]{3,100}",
            message = "Wrong title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @DecimalMin(value = "0",message = "Enter valid price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Positive
    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }
    @Size(min = 11, max = 11, message = "Enter valid trailer")
    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }
    @Pattern(regexp = "(https?).+")
    public String getThubnailURL() {
        return thubnailURL;
    }

    public void setThubnailURL(String thubnailURL) {
        this.thubnailURL = thubnailURL;
    }
    @Size(min = 20,message = "Enter valid description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
