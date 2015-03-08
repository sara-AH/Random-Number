package com.example.sara.random_number;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends ActionBarActivity {

    private int Number;
    private int score=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // calling the method generate Random Number
        Generate();

        //action for the Button Guess
        Button generate =(Button)findViewById(R.id.button);


        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
            }

        });

        //to generate Random number again
        Button generate2 =(Button)findViewById(R.id.button2);
        generate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                again();
            }

        });
    }


    //method to Generate random number
    public void Generate(){

        Random randomNumber = new Random();
        Number = randomNumber.nextInt(1000);

        //Toast.makeText(getBaseContext(),""+Number ,Toast.LENGTH_LONG).show();

    }
    //method to check if the guessed number is correct
    public void check(){


        EditText userEnter = (EditText)findViewById(R.id.editText);
        int value = Integer.parseInt( userEnter.getText().toString() );//getting Integer value from text

        TextView win = (TextView)findViewById(R.id.textView6);//to print the winner msg in
        TextView scoreText =(TextView)findViewById(R.id.textView8);
        Button TryButton =(Button)findViewById(R.id.button2);

        //comparing the entered number with the random one
        if( value == Number){
            win.setText("Congratulations !! you guessed it ;) ");
            scoreText.setText(""+score++);
            TryButton.setVisibility(View.VISIBLE);

        }else if(value <= Number +5 && value >= Number -5 ){
            Toast.makeText(getBaseContext(),"Very close",Toast.LENGTH_LONG).show();
        }else if(value < Number - 5 ){
            Toast.makeText(getBaseContext(),"Greater",Toast.LENGTH_LONG).show();

        }else if(value > Number + 5 ){
            Toast.makeText(getBaseContext(),"Smaller",Toast.LENGTH_LONG).show();
        }
    }

    //to generate Random number again . and reload the page
    public void again(){
        TextView win2 = (TextView)findViewById(R.id.textView6);//to print the winner msg in
        Button TryButton2 =(Button)findViewById(R.id.button2);
        win2.setText("");
        TryButton2.setVisibility(View.INVISIBLE);
        Generate();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
