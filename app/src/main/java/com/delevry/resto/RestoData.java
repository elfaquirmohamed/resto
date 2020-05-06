package com.delevry.resto;

public class RestoData {
  int image;
 private String rTitle, rSubTitle,rRating ,rVille  ;

    public RestoData(int image, String rTitle, String rSubTitle, String rRating, String rVille) {
        this.image = image;
        this.rTitle = rTitle;
        this.rSubTitle = rSubTitle;
        this.rRating = rRating;
        this.rVille = rVille;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getrTitle() {
        return rTitle;
    }

    public void setrTitle(String rTitle) {
        this.rTitle = rTitle;
    }

    public String getrSubTitle() {
        return rSubTitle;
    }

    public void setrSubTitle(String rSubTitle) {
        this.rSubTitle = rSubTitle;
    }

    public String getrRating() {
        return rRating;
    }

    public void setrRating(String rRating) {
        this.rRating = rRating;
    }

    public String getrVille() {
        return rVille;
    }

    public void setrVille(String rVille) {
        this.rVille = rVille;
    }
}
