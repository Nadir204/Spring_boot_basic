package com.example.OwnPracMongo.controller;



import com.example.OwnPracMongo.entity.Book;
import com.example.OwnPracMongo.service.BooksService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BooksService BookService1;

    //Get all books
    //
    //Get a book by ID
    //
    //Add a new book
    //
    //Update an existing book
    //
    //Delete a book by ID
    //GET /books → return all books
    //
    //GET /books/{id} → return a single book by ID
    //
    //POST /books → add a new book
    //
    //PUT /books/{id} → update book details
    //
    //DELETE /books/{id} → delete a book
    @GetMapping()
    public List<Book> getall(){

        return BookService1.getAll();


    }

    @PostMapping()
    public Boolean Add(@RequestBody Book myBook){

        BookService1.Insert(myBook);
        return true;


    }

//get by book custom id
    @GetMapping("CustomId/{BookId}")
    public Book GetBycustomidOne(@PathVariable Long BookId){
        return BookService1.GetByCustomId(BookId).orElse(null);


    }

//Get a book by ID(objectid)---------------------------------------------------------------------------------------------------------------------
    //GET /books/{id} → return a single book by ID
@GetMapping("/{myId}")
    public Book getById(@PathVariable ObjectId myId){

        return BookService1.getId(myId);



}
    //Update an existing book(objectid)------------------------------------------------------------------------------------------------------------------------------------------------------
@PutMapping("update/{bookId}")
    public Book UpdateByObid(@PathVariable ObjectId bookId,@RequestBody Book myJsonBook){
Book old = BookService1.getId(bookId);
//customBookId: Long("2"),
//    title: 'Java Made Easy',
//    author: 'Nadir',
//    quantity: 5,
if(old!=null) {
    old.setCustomBookId(myJsonBook.getCustomBookId() != null && !myJsonBook.getCustomBookId().equals("") ? myJsonBook.getCustomBookId() : old.getCustomBookId());
    old.setTitle(myJsonBook.getTitle() != null && !myJsonBook.getTitle().equals("") ? myJsonBook.getTitle() : old.getTitle());
    old.setAuthor(myJsonBook.getAuthor() != null && !myJsonBook.getAuthor().equals("") ? myJsonBook.getAuthor() : old.getAuthor());
  old.setQuantity(myJsonBook.getQuantity()!=null?myJsonBook.getQuantity():old.getQuantity());
}
BookService1.Insert(old);
return BookService1.getId(bookId);





}


//put by calling customBookId---------------------------------------------------------------------------------------------------------------------------------------------------------
    @PutMapping("customUpdate/{id}")
    public Book CustomUpdateByOwnId(@PathVariable Long id,@RequestBody Book myJsonBook){
        Book old = BookService1.GetByCustomId(id).orElse(null);

        if(old!=null){


            old.setCustomBookId(myJsonBook.getCustomBookId()!=null && !myJsonBook.getCustomBookId().equals("")?myJsonBook.getCustomBookId():old.getCustomBookId());
            old.setTitle(myJsonBook.getTitle() != null && !myJsonBook.getTitle().equals("") ? myJsonBook.getTitle() : old.getTitle());
            old.setAuthor(myJsonBook.getAuthor() != null && !myJsonBook.getAuthor().equals("") ? myJsonBook.getAuthor() : old.getAuthor());
            old.setQuantity(myJsonBook.getQuantity()!=null?myJsonBook.getQuantity():old.getQuantity());




        }

        BookService1.Insert(old);
        return BookService1.GetByCustomId(id).orElse(null);
        //orElse cz we used optional<> in service field as return type


    }




    //Delete a book by ID(objectid)----------------------------------------------------------------------------------------------------------
    //DELETE /books/{id} → delete a book
@DeleteMapping("{bookId}")
    public Boolean deleteByid(@PathVariable ObjectId bookId){
        BookService1.DeleteByObjId(bookId);

        return true;
}

//delete by custom id-----------------------------------------
    @DeleteMapping("DeleteByCustom/{bookId}")
    public boolean deleteBycustomid(@PathVariable Long bookId){

        BookService1.DeleteByCustomId(bookId);
        return true;


    }


    //borrow book with quentity (2 ta boi dar nibo) (same book)(customid)----------------------------------------------------------------------------
    @PostMapping("/borrow/{customBookId}/{quantity}")
    //akana kono json body patacci na !!!!!!!!!!!!!!!!
    public String borrowBook1(@PathVariable Long customBookId,@PathVariable Integer quantity){

        boolean succes1=BookService1.borrowBook(customBookId,quantity);
        if(succes1){
            return "damn boi! Book borrowed successfully!";

        }
        else{
            return "Book not available or insufficient quantity.";

        }





    }








}
