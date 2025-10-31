package com.example.OwnPracMongo.repo;

import com.example.OwnPracMongo.entity.Book;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface LibreryRepo extends MongoRepository<Book, ObjectId> {



    // Search by custom ID
    //akane ami extra feature banacci findByCustomId jeita save(),findById() etc (from defult mongorepo) er moto
    //amake customId long typer parameter use korbe


    //eta na korle ami custom book id dia mane jeita ami input dei oita dia book search korte parbo na
    //cz repo theke defult jei crud er jonno feature takhe ogolo sudu primary key er jonno kaj kore

//nicher golo dekhlei clear hoye java
    Optional<Book> findByCustomBookId(Long customBookId);

//findBy → tells Spring “I want to find something by a field”.
//
//CustomBookId → Spring looks for a field in your entity with this exact name.must match with getter method
    //i have getter method called getCustomBookID so c here is capital
//
//Long customBookId → parameter to compare against that field.



    // Delete by customBookId
    void deleteByCustomBookId(Long customBookId);

}
