package com.example.libraryfirebase;

public class Book {
    private String title;
    private String summary;
    private int price;

    public Book(){
        //empty constructor needed for firebase
    }

    public Book(String title, String summary, int price) {
        this.title = title;
        this.summary = summary;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}//end Book class
