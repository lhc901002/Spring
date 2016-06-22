package org.mliuframework.spring.orm.ibatis.bo;

public class VipCustomer extends Customer {

    private Integer starLevel;

    private Integer score;

    public Integer getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(Integer starLevel) {
        this.starLevel = starLevel;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

}
