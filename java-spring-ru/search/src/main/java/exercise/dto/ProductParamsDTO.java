package exercise.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductParamsDTO {
    private String titleCont;
    private Long categoryId;
    private Integer priceLt;
    private Integer priceGt;

    public String getTitleCont() {
        return titleCont;
    }

    public void setTitleCont(String titleCont) {
        this.titleCont = titleCont;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getPriceLt() {
        return priceLt;
    }

    public void setPriceLt(Integer priceLt) {
        this.priceLt = priceLt;
    }

    public Long getPriceGt() {
        return priceGt;
    }

    public void setPriceGt(Integer priceGt) {
        this.priceGt = priceGt;
    }

    public Double getRatingGt() {
        return ratingGt;
    }

    public void setRatingGt(Double ratingGt) {
        this.ratingGt = ratingGt;
    }

    private Double ratingGt;
}
