package org.michaelliu.spring.beans.vo;

/**
 * Created by Michael on 7/1/16.
 */
public class ProductFieldUpdateParam {

    private Long id;

    private Integer priceChange;

    private Integer balanceChange;

    private Integer salesVolumeChange;

    private Integer commentCountChange;

    private Integer collectCountChange;

    private Integer popularityChange;

    public ProductFieldUpdateParam() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPriceChange() {
        return priceChange;
    }

    public void setPriceChange(Integer priceChange) {
        this.priceChange = priceChange;
    }

    public Integer getBalanceChange() {
        return balanceChange;
    }

    public void setBalanceChange(Integer balanceChange) {
        this.balanceChange = balanceChange;
    }

    public Integer getSalesVolumeChange() {
        return salesVolumeChange;
    }

    public void setSalesVolumeChange(Integer salesVolumeChange) {
        this.salesVolumeChange = salesVolumeChange;
    }

    public Integer getCommentCountChange() {
        return commentCountChange;
    }

    public void setCommentCountChange(Integer commentCountChange) {
        this.commentCountChange = commentCountChange;
    }

    public Integer getCollectCountChange() {
        return collectCountChange;
    }

    public void setCollectCountChange(Integer collectCountChange) {
        this.collectCountChange = collectCountChange;
    }

    public Integer getPopularityChange() {
        return popularityChange;
    }

    public void setPopularityChange(Integer popularityChange) {
        this.popularityChange = popularityChange;
    }

    public static class Builder {

        private Long id;

        private Integer priceChange;

        private Integer balanceChange;

        private Integer salesVolumeChange;

        private Integer commentCountChange;

        private Integer collectCountChange;

        private Integer popularityChange;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setPriceChange(Integer priceChange) {
            this.priceChange = priceChange;
            return this;
        }

        public Builder setBalanceChange(Integer balanceChange) {
            this.balanceChange = balanceChange;
            return this;
        }

        public Builder setSalesVolumeChange(Integer salesVolumeChange) {
            this.salesVolumeChange = salesVolumeChange;
            return this;
        }

        public Builder setCommentCountChange(Integer commentCountChange) {
            this.commentCountChange = commentCountChange;
            return this;
        }

        public Builder setCollectCountChange(Integer collectCountChange) {
            this.collectCountChange = collectCountChange;
            return this;
        }

        public Builder setPopularityChange(Integer popularityChange) {
            this.popularityChange = popularityChange;
            return this;
        }

        public ProductFieldUpdateParam build() {
            return new ProductFieldUpdateParam(this);
        }

    }

    private ProductFieldUpdateParam(Builder builder) {
        this.id = builder.id;
        this.priceChange = builder.priceChange;
        this.balanceChange = builder.balanceChange;
        this.salesVolumeChange = builder.salesVolumeChange;
        this.commentCountChange = builder.commentCountChange;
        this.collectCountChange = builder.collectCountChange;
        this.popularityChange = builder.popularityChange;
    }

}
