package com.android.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {
    TextView input, output;
    String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextViews();

    }

    public void initTextViews() {                       //initialise input and output
        input = (TextView) findViewById(R.id.input);
        output = (TextView) findViewById(R.id.output);
    }

    public void equalOnClick(View view) {               //calculate output
       Double res = null;
       ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
       try {
           res = (double)engine.eval(result);
       } catch (ScriptException e)
       {
           Toast.makeText(this,"Invalid input", Toast.LENGTH_SHORT).show();
       }

       if(res!= null){
           output.setText(String.valueOf(res.doubleValue()));
       }

    }

    private void setWorkings(String givenValues) {      //clear text from input
        result = result + givenValues;                  //and output
        input.setText(result);
    }

    public void clearOnClick(View view) {
        input.setText("");
        result = "";
        output.setText("");
        leftBracket = true;
    }

    boolean leftBracket = true;
    public void bracketOnClick(View view) {
        if(leftBracket){
            setWorkings("(");
            leftBracket = false;
        }
        else{
            setWorkings(")");
            leftBracket = true;
        }
    }

    public void modOnClick(View view) {
        setWorkings("%");
    }

    public void divOnClick(View view) {
        setWorkings("/");
    }

    public void sevenOnClick(View view) {
        setWorkings("7");
    }

    public void eightOnClick(View view) {
        setWorkings("8");
    }

    public void nineOnClick(View view) {
        setWorkings("9");
    }

    public void fourOnClick(View view) {
        setWorkings("4");
    }

    public void multiplyOnClick(View view) {
        setWorkings("*");
    }

    public void fiveOnClick(View view) {
        setWorkings("5");
    }

    public void sixOnClick(View view) {
        setWorkings("6");
    }

    public void SubtractOnClick(View view) {
        setWorkings("-");
    }

    public void oneOnClick(View view) {
        setWorkings("1");
    }

    public void twoOnClick(View view) {
        setWorkings("2");
    }

    public void threeOnClick(View view) { setWorkings("3"); }

    public void addOnClick(View view) {
        setWorkings("+");
    }

    public void doubleZeroOnClick(View view) {
        setWorkings("00");
    }

    public void zeroOnClick(View view) {
        setWorkings("0");
    }

    public void dotOnClick(View view) {
        setWorkings(".");
    }
}