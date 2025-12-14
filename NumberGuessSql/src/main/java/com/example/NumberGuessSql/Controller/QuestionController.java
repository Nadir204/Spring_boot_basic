package com.example.NumberGuessSql.Controller;

import com.example.NumberGuessSql.Service.QuestionService;
import com.example.NumberGuessSql.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Questions")
public class QuestionController {
@Autowired
    private QuestionService QuessService;

@GetMapping
    public ResponseEntity<?> GetAll(){

    return QuessService.GEtall();


}
@PostMapping
    public ResponseEntity<?> CreateQuestion(@RequestBody Question NewQues){
try{

    QuessService.InserQuestion(NewQues);
    return new ResponseEntity<>(NewQues, HttpStatus.CREATED);
}
catch (Exception e){

    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

}




}
    @GetMapping("/FindById/{id}")
    public ResponseEntity<Question> Find(@PathVariable Long id){
Question old= QuessService.FindByCustomId(id).orElse(null);
if(old!=null){

    return new ResponseEntity<>(old,HttpStatus.OK);

}
else {

    return new ResponseEntity<>(HttpStatus.NOT_FOUND);

}
    }



    @GetMapping("/generate")
public ResponseEntity<?> generateNewQuestion(){
return QuessService.generateRandomQuestion1();


    }







}
