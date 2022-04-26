 package com.bansal.abhishek.javaquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView questionTV, questionNumberTV;
    private Button option1Btn, option2Btn, option3Btn, option4Btn;
    private ArrayList<QuizModal> quizModalArrayList;
    Random random;
    int currentScore = 0, questionAttempted = 1, currentPos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTV = findViewById(R.id.idTvQuestions);
        questionNumberTV = findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);

        quizModalArrayList = new ArrayList<>();
        random = new Random();
        getQuizQuestion(quizModalArrayList);
        currentPos = random.nextInt(quizModalArrayList.size());
        setDataToViews(currentPos);
        option1Btn.setOnClickListener(v -> {
            if (quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())) {
                currentScore++;
                option2Btn.setBackgroundColor(Color.GREEN);
            }
            questionAttempted++;
            currentPos = random.nextInt(quizModalArrayList.size());
            setDataToViews(currentPos);

        });

        option2Btn.setOnClickListener(v -> {
            if (quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())) {
                currentScore++;
                option2Btn.setBackgroundColor(Color.GREEN);
            }
            questionAttempted++;
            currentPos = random.nextInt(quizModalArrayList.size());
            setDataToViews(currentPos);

        });

        option3Btn.setOnClickListener(v -> {
            if (quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())) {
                currentScore++;
                option2Btn.setBackgroundColor(Color.GREEN);
            }
            questionAttempted++;
            currentPos = random.nextInt(quizModalArrayList.size());
            setDataToViews(currentPos);

        });

        option4Btn.setOnClickListener(v -> {
            if (quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())) {
                currentScore++;
                option2Btn.setBackgroundColor(Color.GREEN);
            }
            questionAttempted++;
            currentPos = random.nextInt(quizModalArrayList.size());
            setDataToViews(currentPos);

        });

    }

    private void showBottomSheet() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet, (LinearLayout) findViewById(R.id.idLLScore));
        TextView scoreTv = bottomSheetView.findViewById(R.id.idTVScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        String score = "Your score is " + currentScore + "/10";
        scoreTv.setText(score);
        restartQuizBtn.setOnClickListener(v -> {
            currentPos = random.nextInt(quizModalArrayList.size());
            setDataToViews(currentPos);
            questionAttempted = 1;
            currentScore = 0;
            bottomSheetDialog.dismiss();
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }


    public void setDataToViews(int currentPos) {
        String questionAttemp = "Question Attempted" + questionAttempted + "/10";
        questionNumberTV.setText(questionAttemp);

        if (questionAttempted == 11) {
            showBottomSheet();
        } else {
            questionTV.setText(quizModalArrayList.get(currentPos).getQuestion1());
            option1Btn.setText(quizModalArrayList.get(currentPos).getOption());
            option2Btn.setText(quizModalArrayList.get(currentPos).getOption2());
            option3Btn.setText(quizModalArrayList.get(currentPos).getOption3());
            option4Btn.setText(quizModalArrayList.get(currentPos).getOption4());

        }
    }


    private void getQuizQuestion(ArrayList<QuizModal> quizModalArrayList) {
        quizModalArrayList.add(new QuizModal("What is a correct syntax to output \"Hello World\" in Java?","System.out.println(\"Hello World\");","print(\"Hello World\");","printf(\"Hello World\");","console.WriteLine(\"Hello World\");","System.out.println(\"Hello World\");"));
        quizModalArrayList.add(new QuizModal("Java is short for javascript","true","false","may be","not may be","false"));
        quizModalArrayList.add(new QuizModal("How do you insert comment in java code","#This is comment","/*This is comment in java","//This is comment in java","<!--This is comment in java","//This is comment in java"));

        quizModalArrayList.add(new QuizModal("Which of the following is FALSE about arrays on Java","A java array is always an object","Length of array can be changed after creation of array","Arrays in Java are always allocated on heap","Both option 1 and 2","Length of array can be changed after creation of array"));
        quizModalArrayList.add(new QuizModal("class Main{   \n" +
                "  \t \t \t  public static void main(String args[]) {      \n" +
                "  \t \t \t       int t;      \n" +
                "  \t \t \t       System.out.println(t); \n" +
                "    }   \n" +
                "}","0","garbage value","compiler error","runtime error","compiler error"));


        quizModalArrayList.add(new QuizModal("Which of the following option leads to the portability and security of Java?","Bytecode is executed by JVM","The applet makes the Java code secure and portable","Use of exception handling","Dynamic binding between objects","Bytecode is executed by JVM"));
        quizModalArrayList.add(new QuizModal("Which of the following is not a Java features?","Dynamic","Architecture Neutral","Use of pointers","Object-oriented","Use of pointers"));
        quizModalArrayList.add(new QuizModal("The \\u0021 article referred to as a","Unicode escape sequence","Octal escape","Hexadecimal","Line feed","Unicode escape sequence"));
        quizModalArrayList.add(new QuizModal("_____ is used to find and fix bugs in the Java programs.","JRE","JDK","JVM","JDB","JDB"));
        quizModalArrayList.add(new QuizModal("Which of the following is a valid declaration of a char?","char ch = '\\utea';","char ca = 'tea';","char cr = \\u0223;","char cc = '\\itea';","char ch = '\\utea';"));
        quizModalArrayList.add(new QuizModal("What is the return type of the hashCode() method in the Object class?\n" +
                "\n","Object","int","long","void","int"));
        quizModalArrayList.add(new QuizModal("Which of the following is a valid long literal?","ABH8097","L990023","904423","0xnf029L","0xnf029L"));
        quizModalArrayList.add(new QuizModal("What does the expression float a = 35 / 0 return?","Run time exception","0","Not a Number","Infinity","Infinity"));
        quizModalArrayList.add(new QuizModal("Evaluate the following Java expression, if x=3, y=5, and z=10:\n" +
                "\n" +
                "++z + y - y + z + x++","25","20","24","23","24"));
        quizModalArrayList.add(new QuizModal("Which of the following tool is used to generate API documentation in HTML format from doc comments in source code?","javap tool","Javadoc tool","Javaw Command","javah command","Javadoc tool"));
        quizModalArrayList.add(new QuizModal("Which method of the Class.class is used to determine the name of a class represented by the class object as a String?","getClass()","toString()","intern()","getName()","getName()"));
        quizModalArrayList.add(new QuizModal("In which process, a local variable has the same name as one of the instance variables?","Variable Shadowing","Abstraction","Serialization","Multi-threading","Variable Shadowing"));
        quizModalArrayList.add(new QuizModal("Which of the following is true about the anonymous inner class?","It has only methods","It has no class name","It has a fixed class name","Objects can't be created","It has no class name"));
        quizModalArrayList.add(new QuizModal("Which option is false about the final keyword?","A final method can be inherited.","A final method cannot be overridden in its subclasses.","A final class cannot extend other classes.","A final class cannot be extended.","A final class cannot extend other classes."));
        quizModalArrayList.add(new QuizModal("In which memory a String is stored, when we create a string using new operator?","Stack","Random storage space","String memory","Heap memory","Heap memory"));
        quizModalArrayList.add(new QuizModal("Which of the following is a reserved keyword in Java?","system","main","object","strictfp","strictfp"));


    }
}