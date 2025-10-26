package com.example.JournelApp.controller;

import com.example.JournelApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    //obj create
    private Map<Long, JournalEntry> JournalEntries=new HashMap<>();
    @GetMapping
    public List<JournalEntry> getall(){
        //covert array into list format
        return new ArrayList<>(JournalEntries.values());

    }
    @PostMapping
    public boolean createEntity(@RequestBody JournalEntry myentry){

      JournalEntries.put(myentry.getId(),myentry);

        return true;

    }
    //search by specific id
    @GetMapping("/id/{myId}")
    public JournalEntry getbyid(@PathVariable long myId){
      return JournalEntries.get(myId);

    }
    //search by id and show single result
    @GetMapping("/id1/{myId}")
    public String getid(@PathVariable long myId){
        JournalEntry entryObj = JournalEntries.get(myId);

        //JournalEntry entryObj ,,,,This part means you’re creating a new variable named entryObj
        //of type JournalEntry, to store whatever .get(myId) returns.
        //we can't use JournalEntries.getId() cz its a map which kepp whole structure by key and value


        //Why you don’t use new here?like :JournalEntry entryObj = new JournalEntries.get(myId); // ❌
        //ans:new can only be used with a constructor (like new JournalEntry()) and
        //JournalEntries.get(myId) is a method call, not a constructor.
        //Using new here doesn’t make sense — you don’t want a new object, you want the one already in the map.



       String content1= entryObj.getContent();
        String Tity= entryObj.getTitle();
        String total= content1 + Tity;
        return total;
        //cz program will get the hell out of this fun after it return something!!:)


    }

    //delete by id---------------------------------------------------------
    @DeleteMapping("id/{lol}")
    public JournalEntry delete(@PathVariable long lol){

        return JournalEntries.remove(lol);

    }

    //delete a variable value
    @DeleteMapping("id1/{lol}")
    public JournalEntry deletespecific(@PathVariable long lol){
JournalEntry variable= JournalEntries.get(lol);
if(variable != null){
    variable.setContent(null);


}
return variable;
//content null kore variable er modder obj show korbe


    }


    //update ---------------------------------------------------
    @PutMapping("id/{lol}")
    public JournalEntry updatebyId(@PathVariable long lol,@RequestBody JournalEntry myentry){

        return JournalEntries.put(lol,myentry);


    }




}
