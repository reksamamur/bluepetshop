package com.example.bluepetshop.model;

public class DataItem {
    private String itemName;
    private String itemRace;
    private String itemCodeRace;
    private String itemAge;
    private String itemGender;
    private int itemImage;

    public DataItem(String itemName, String itemRace, String itemCodeRace, String itemAge, String itemGender, int itemImage) {
        this.itemName = itemName;
        this.itemRace = itemRace;
        this.itemCodeRace = itemCodeRace;
        this.itemAge = itemAge;
        this.itemGender = itemGender;
        this.itemImage = itemImage;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemRace() {
        return itemRace;
    }

    public void setItemRace(String itemRace) {
        this.itemRace = itemRace;
    }

    public String getItemCodeRace() {
        return itemCodeRace;
    }

    public void setItemCodeRace(String itemCodeRace) {
        this.itemCodeRace = itemCodeRace;
    }

    public String getItemAge() {
        return itemAge;
    }

    public void setItemAge(String itemAge) {
        this.itemAge = itemAge;
    }

    public String getItemGender() {
        return itemGender;
    }

    public void setItemGender(String itemGender) {
        this.itemGender = itemGender;
    }

    public int getItemImage() {
        return itemImage;
    }

    public void setItemImage(int itemImage) {
        this.itemImage = itemImage;
    }
}
