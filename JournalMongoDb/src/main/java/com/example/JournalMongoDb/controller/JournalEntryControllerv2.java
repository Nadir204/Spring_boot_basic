package com.example.JournalMongoDb.controller;

import com.example.JournalMongoDb.entity.JournalEntry;
import com.example.JournalMongoDb.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journal")
@CrossOrigin(origins = "*")
public class JournalEntryControllerv2 {
@Autowired
    private JournalEntryService JournalService;
@GetMapping()
    public List<JournalEntry> getAll1(){
    return JournalService.getAll();


}
@PostMapping()
    public Boolean CreateEntry(@RequestBody JournalEntry myEntry){

    JournalService.CreateEntry1(myEntry);
    return true;


}

//find by id
@GetMapping("/id/{myId}")
public JournalEntry getJournalEntrybyId(@PathVariable ObjectId myId){
return JournalService.FindId34(myId).orElse(null);




}

@DeleteMapping("/id/{myId}")
    public boolean deleteBBy(@PathVariable ObjectId myId){

    JournalService.deleteByid(myId);
    return true;



}
@PutMapping("id/{id}")

    public JournalEntry UpEntry(@PathVariable ObjectId id,@RequestBody JournalEntry myEntry){

    JournalEntry old = JournalService.FindId(id);

    if(old!=null){

        //chat gpt---------------------------------------------------------------------------------------------------------------------------
//        if (old != null) {
//            // Only update title if a new title is provided
//            if (myEntry.getTitle() != null && !myEntry.getTitle().isEmpty()) {
//                old.setTitle(myEntry.getTitle());
//            }
//
//            // Optionally update content if provided
//            if (myEntry.getContent() != null && !myEntry.getContent().isEmpty()) {
//                old.setContent(myEntry.getContent());
//            }
//
//            // Save the updated entry back to MongoDB
//            return JournalService.save(old);
//        }

        //-------------------------------------------------------------------------------------------------------

        //old.getTitle(condition ? value_if_true : value_if_false)
        old.setTitle(myEntry.getTitle()!=null && !myEntry.getTitle().equals("")?myEntry.getTitle() : old.getTitle());

//ternary operator (? :).
        //condition ? value_if_true : value_if_false
        //condition → a boolean expression.
        //
        //If condition is true → the expression evaluates to value_if_true.
        //
        //If condition is false → the expression evaluates to value_if_false.

        old.setContent(myEntry.getContent()!=null && !myEntry.getContent().equals("")?myEntry.getContent():old.getContent());




    }
    //parameter passed to function (old)
JournalService.CreateEntry1(old);
    //return for this fun only
    return old;




}

//own---------------------------

    @GetMapping("/search/content/{oneV}")
            public String Getone(@PathVariable ObjectId oneV){
    JournalEntry obj = JournalService.FindId(oneV);

    if(obj!=null){

      return obj.getContent();


    }
    else {
        return "opps not found";
    }


    }
    //get only title----

    @GetMapping("/search/title/{oneV}")
    public String Gettity(@PathVariable ObjectId oneV){
        JournalEntry obj = JournalService.FindId(oneV);

        if(obj!=null){

           return obj.getTitle();


        }
        else {
            return "opps not found!pussy";
        }


    }










}
