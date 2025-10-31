package com.example.OwnPracMongo.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
//mapping
public class Book {
    //Create a Book class with fields: customBookId, title, author, category, quantity.
    //This is the basic “borrow” feature. Later, you could expand it to include:
//
//Tracking which user borrowed which book
//
//Due date for return
//
//Returning books (increase quantity)



    @Id
    private ObjectId id;

    private Long customBookId;

    private String title;

    private String author;
    private Integer quantity;

    public Long getCustomBookId() {
        return customBookId;
    }

    public void setCustomBookId(Long customBookId) {
        this.customBookId = customBookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
//object customBookId


    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }




}
