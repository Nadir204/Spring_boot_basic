package com.example.OwnPracMongo.service;



import com.example.OwnPracMongo.entity.Book;
import com.example.OwnPracMongo.repo.LibreryRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BooksService {
@Autowired
    private LibreryRepo BookRepo;

//get all-------------------------------------------
    public List<Book> getAll(){


        return BookRepo.findAll();

    }


    public void Insert(Book Bookobj){

        BookRepo.save(Bookobj);



    }

    //get by custom id
    public Optional<Book> GetByCustomId(Long myId){
        return BookRepo.findByCustomBookId(myId);


    }
    //get by object id
    public Book getId(ObjectId id){

        return BookRepo.findById(id).orElse(null);

    }
    //delete by id ------------------------------------------------------------------------------------
    public boolean DeleteByObjId(ObjectId id){

        BookRepo.deleteById(id);
        return true;

    }

    //delete by custom id----------------------------------------------------------------------------------
    public boolean DeleteByCustomId(Long id){
       BookRepo.deleteByCustomBookId(id);
       return true;


    }

//borror book -----------------------------------------------------------------------------------------------
public boolean borrowBook(Long Bookid,Integer quantity){

        Book old=BookRepo.findByCustomBookId(Bookid).orElse(null);

        if(old!=null&&old.getQuantity()>0){
            if(old.getQuantity()<quantity || quantity<=0){
                return false;

            }
            else {
//from cluade ai i changed old.getQuantity()>quantity to old.getQuantity()>=quantity
                if(old.getQuantity()>=quantity){
                old.setQuantity(old.getQuantity()-quantity);
                BookRepo.save(old);
                return true;}

                else{
                    return false;
                }

            }


        }
        else{
            return false;
        }



}


    


}
