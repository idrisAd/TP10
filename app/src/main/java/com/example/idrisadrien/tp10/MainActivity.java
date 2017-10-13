package com.example.idrisadrien.tp10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {


    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button buttonPlus;
    Button buttonMoins;
    Button buttonDiv;
    Button buttonMul;
    Button buttonClear;
    Button buttonEnter;
    Button buttonPop;
    Button buttonSwap;

    TextView stack3;
    TextView stack2;
    TextView stack1;
    TextView stack0;

    EditText editText;


    private boolean clicOperateur = false;
    private double chiffre;
    private String operateur = "";
    private boolean update = false;

    Stack<Integer> stack = new Stack<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // On récupère les éléments de notre interface graphique
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonPlus = (Button) findViewById(R.id.buttonPlus);
        buttonMoins = (Button) findViewById(R.id.buttonMoins);
        buttonDiv = (Button) findViewById(R.id.buttonDiv);
        buttonMul = (Button) findViewById(R.id.buttonMul);
        buttonClear = (Button) findViewById(R.id.buttonClear);
        buttonEnter = (Button) findViewById(R.id.buttonEnter);
        buttonPop = (Button) findViewById(R.id.buttonPop);
        buttonSwap = (Button) findViewById(R.id.buttonSwap);

        editText = (EditText) findViewById(R.id.editText);

        stack3 = (TextView)findViewById(R.id.stack3);
        stack2 = (TextView)findViewById(R.id.stack2);
        stack1 = (TextView)findViewById(R.id.stack1);
        stack0=(TextView) findViewById(R.id.stack0);


        this.stack.push(0);
        this.stack.push(0);
        this.stack.push(0);
        this.stack.push(0);




        //Attribut des écouteurs aux boutons

        button0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               chiffreClick("7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("9");
            }
        });

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                plusClick();
            }
        });

        buttonMoins.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                moinsClick();
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mulClick();
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                divClick();
            }
        });

        buttonEnter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                enterClick();
            }
        });

        buttonPop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                popClick();
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clearClick();
            }
        });

        buttonSwap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                swapClick();
            }
        });


    }


    // Méthode exécutée lors d'un appui sur un bouton chiffre
    public void chiffreClick(String str){
        Log.d("CHIFFRE","test chiffre");
        if(update){
            update = false;
        }else{
            if(!editText.getText().equals("0"))
                str = editText.getText() + str;
        }
        editText.setText(str);
    }

    // Méthode exécutée lors d'un appui sur +
    public void plusClick() {
        Log.d("PLUS", "test plus");

        Integer a = Integer.valueOf(stack1.getText().toString()) ;
        Integer b = Integer.valueOf(stack0.getText().toString()) ;

        Integer c = a+b;
        stack.pop();
        stack.set(stack.size()-1,c);
        majStack();

        //stack0.setText(c.toString());


    }

    // Méthode exécutée lors d'un appui sur -
    public void moinsClick(){
        Log.d("MOINS","test moins");

        Integer a = Integer.valueOf(stack1.getText().toString()) ;
        Integer b = Integer.valueOf(stack0.getText().toString()) ;

        Integer c = a-b;
        stack.pop();
        stack.set(stack.size()-1,c);
        majStack();
    }


    // Méthode exécutée lors de l'appui sur *
    public void mulClick(){
        Log.d("MUL","test mul");

        Integer a = Integer.valueOf(stack1.getText().toString()) ;
        Integer b = Integer.valueOf(stack0.getText().toString()) ;

        Integer c = a*b;
        stack.pop();
        stack.set(stack.size()-1,c);
        majStack();
    }


    // Méthode exécutée lors de l'appui sur /
    public void divClick(){
        Log.d("DIV","test div");

        Integer a = Integer.valueOf(stack1.getText().toString()) ;
        Integer b = Integer.valueOf(stack0.getText().toString()) ;

        Integer c = a/b;
        stack.pop();
        stack.set(stack.size()-1,c);
        majStack();
    }


    // Méthode exécutée lors de l'appui sur enter
    public void enterClick() {
        Log.d("ENTER","test enter");

        int input;
        input = Integer.parseInt(editText.getText().toString());
        this.stack.push(input);
        majStack();
        editText.setText("");


        update = true;
        clicOperateur = false;
    }

    // Méthode exécutée pour la maj de la pile
    public void majStack(){

        int lenght = stack.size();

        stack0.setText(""+stack.get(lenght-1));
        stack1.setText(""+stack.get(lenght-2));
        stack2.setText(""+stack.get(lenght-3));
        stack3.setText(""+stack.get(lenght-4));


    }

    // Méthode exécutée lors de l'appui sur clear
    public void clearClick() {
        Log.d("CLEAR","test clear");

        editText.setText("");
    }

    // Méthode exécutée lors de l'appui sur swap
    public void swapClick() {
        Log.d("SWAP","test swap");
        String echange ="";
        echange = stack0.getText().toString(); //""+stack.get(1));
        stack0.setText(stack1.getText().toString());
        stack1.setText(echange);

        update = true;
        clicOperateur = false;
    }

    // Méthode exécutée lors de l'appui sur pop
    public void popClick() {
        Log.d("POP","test pop");
        stack.pop();
        majStack();
    }


    private void calcul(){

    }


}
