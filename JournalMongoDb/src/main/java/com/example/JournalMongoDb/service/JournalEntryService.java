package com.example.JournalMongoDb.service;

import com.example.JournalMongoDb.Repository.JournalEntryRepository;
import com.example.JournalMongoDb.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {
@Autowired
    private JournalEntryRepository JournalRepo;
public List<JournalEntry> getAll(){

    return JournalRepo.findAll();


}

//post all
    public JournalEntry CreateEntry1(JournalEntry journalEntry){
    journalEntry.setDate(LocalDateTime.now());

    return JournalRepo.save(journalEntry);


    }
    //get by id

public JournalEntry FindId(ObjectId id){

    return JournalRepo.findById(id).orElse(null);
    //findById(id) returns an Optional<JournalEntry>, not JournalEntry directly.
    //or if we add .orElse  then it will give data or null and we can store it direct in obj ,optional same thing doing



//findByid akta value er sathe null return kore 2 tai store korte hoi tai
//findByid use korle hoi .orElse use korte hobe noito Optional<> as return type use korte hobe
}
//or
public Optional<JournalEntry> FindId34(ObjectId id){

    return JournalRepo.findById(id);
    //findById(id) returns an Optional<JournalEntry>, not JournalEntry directly.
    //we just removed .orElse


}

//delete by id
    public Boolean deleteByid(ObjectId id){

    JournalRepo.deleteById(id);
    return true;



    }






}
