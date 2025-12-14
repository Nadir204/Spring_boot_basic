package com.example.NumberGuessSql.Service;

import com.example.NumberGuessSql.Repo.QuestionRepo;
import com.example.NumberGuessSql.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class QuestionService {
    @Autowired
    private QuestionRepo QuessRepo;

    public ResponseEntity<List<?>> GEtall(){
        List<Question> all=QuessRepo.findAll();
        if(all!=null && !all.isEmpty()){

            return new ResponseEntity<>(all,HttpStatus.OK);


        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);



    }

    public Question InserQuestion(Question NewQues1){

    return QuessRepo.save(NewQues1);


    }


    public Optional<Question> FindByCustomId(Long id1){

        return QuessRepo.findByCustomId(id1);


    }

    public ResponseEntity<?> generateRandomQuestion1(){


            Random rand = new Random();
            Set<Integer> Numbers1=new HashSet<>();
            while (Numbers1.size()<4){
                //number er vitore 1-10 porjonto 4 ta number dokhe gelo
                Numbers1.add(rand.nextInt(10)+1);//1-10 er modde 4 ta


            }
               //number golo sajalam list kore options er modde
       //List <Integer> cz table a ei typer create kora variable
            List<Integer> options1= new ArrayList<>(Numbers1);
            //Options er vitor the randomly 4 ta number theke 1 ta correct ans a dokabo
            //vitorer 4 is bound
            int correct1= options1.get(rand.nextInt(4));


            //save----------------------------------------------------

            Question q= new Question();
            //1970 sal theke prottek mili secend
            q.setCustomId(System.currentTimeMillis());
            q.setQuu("Guess the number between 1-10!");
            q.setOptions(options1);
            q.setCorrectAns(correct1);
            QuessRepo.save(q);
            if(q!=null){

                return new ResponseEntity<>(q,HttpStatus.CREATED);

            }
            else{
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }


    }








}
