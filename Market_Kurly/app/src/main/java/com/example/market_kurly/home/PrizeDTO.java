package com.example.market_kurly.home;

public class PrizeDTO {
    private String name;
    private int pic, sale, price;
    private boolean bool_sale;

    public PrizeDTO(int pic, String name, boolean bool_sale, int sale, int price) {
        this.name = name;
        this.pic = pic;
        this.sale = sale;
        this.price = price;
        this.bool_sale = bool_sale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isBool_sale() {
        return bool_sale;
    }

    public void setBool_sale(boolean bool_sale) {
        this.bool_sale = bool_sale;
    }
}
