package com.example.NumberGuessSql.Service;

import com.example.NumberGuessSql.Repo.PlayerRepo;
import com.example.NumberGuessSql.Repo.QuestionRepo;
import com.example.NumberGuessSql.entity.PlayerEntry;
import com.example.NumberGuessSql.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class PlayerService {
@Autowired
private QuestionRepo QuessRepo;
    @Autowired
    private PlayerRepo PlayerRepo;



    public ResponseEntity<String> Submitans1(PlayerEntry newEntry1){

        Question question=QuessRepo.findByCustomId(newEntry1.getQuestionId()).orElse(null);
        if(question!=null){
            Integer correct1 =question.getCorrectAns();
            Integer selected1 =newEntry1.getSelectNumber();

            //for count how much attempt
            //player entity er QuestionId and Question entity er customId same
            //so customId > QuestionId > player er information golo obj e save
            PlayerEntry p=PlayerRepo.findByQuestionId(newEntry1.getQuestionId()).orElse(null);
            //First attempt should be 1 or it will be null
            Integer AttempTemp=1;
            if(p!=null){

                //AttemptTemp er vitor db theke ana AttemptNumber er value er sathe 1 addition
                AttempTemp=p.getAttemptNumber()+1;

            }
            //  If previous entry or obj exists for same question, update it; else, use newEntry1
            //ak kothay entryToSave hoi p diye na hoi newEntry1 dia update kortesi
            PlayerEntry entryToSave = (p != null) ? p : newEntry1;
            entryToSave.setSelectNumber(selected1);
            entryToSave.setAttemptNumber(AttempTemp);
            entryToSave.setPlayerName(newEntry1.getPlayerName());
            //dont use cz
            //If p != null → entryToSave is the existing DB object → questionId is already set.
            //If p == null → entryToSave is newEntry1 → questionId is already in newEntry1.
           // entryToSave.setQuestionId(p.getQuestionId()!=null?p.getQuestionId():newEntry1.getQuestionId());//use na korleo colbe(don't use cz null pointer exception) cz null na hole p er obj e use korbe entryTOsave


            //-------------------------------------------------------------------------


            if(correct1!=null && selected1!=null && correct1.intValue() == selected1.intValue()){
                System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");

                entryToSave.setResult("correct!!!! \n you tried "+ AttempTemp + "times");
               //PlayerRepo.save(newEntry1);

               // return new ResponseEntity<>(newEntry1.getResult(), HttpStatus.OK);

            }
            else{


                //for count how much attempt

                //First attempt should be 1 or it will be null
                //----------------------------------------------
                entryToSave.setResult("wrong!correct ans was " + question.getCorrectAns() +"Your current attempt to guess it is "+ AttempTemp);

              // PlayerRepo.save(newEntry1);
              //  return new ResponseEntity<>(newEntry1.getResult(),HttpStatus.OK);

            }
            //save update or insert
            PlayerRepo.save(entryToSave);

            return new ResponseEntity<>(entryToSave.getResult(), HttpStatus.OK);






        }
        else{

            String ResultErrorShow="question not found";

            return new ResponseEntity<>(ResultErrorShow,HttpStatus.BAD_REQUEST);
        }

    }





}
