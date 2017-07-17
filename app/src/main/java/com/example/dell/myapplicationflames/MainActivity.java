package com.example.dell.myapplicationflames;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

/////////////////////////////////////////////////////////////////////
    private int flameValue, sn, fn, arrayValue, looplength;
    private  String fname,secondName,nameChecker,checked;
    private EditText ET_fname,ET_secondName;


    //THIS IS OUR FLAMES ARRAY
    private   String[] flameList  ={
            "You Two are Friends of a Life Time, Naturally",
            "You Two are Lovers Naturally",
            "You Two are Admires Naturally",
            "You Two are Married Naturally",
            "You Two are Enemies Naturally",
            "You Two are Secrete Admires Naturally",
            "You two are a Soul Mates Naturally "};

    /////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    //////////////////////////////////////////////////////

//WHAT HAPPENS WHEN BUTTONS ARE CLICKED
    public void onClick(View v) {
        switch (v.getId()) {

            case  R.id.QuizflameButton:
                //change the page
                setContentView(R.layout.flames);

                //our text fields
                ET_fname = (EditText) findViewById(R.id.firstnametv);
                ET_secondName = (EditText) findViewById(R.id.secondnametv);

                //initialize
                flameValue =  1;
                arrayValue = 0 ;
                break;



            case R.id.flamesButton:

                //making sure that no field is left empty
                if (  ( !ET_fname.getText().toString().equals("")) && ( !ET_secondName.getText().toString().equals(""))) {

                    //getting the name values from the edit text boxes
                    fname = ET_fname.getText().toString().toLowerCase();
                    secondName = ET_secondName.getText().toString().toLowerCase();

                    //getting the names size/length
                    fn = fname.length();
                    sn = secondName.length();

                    //defining the loop length
                    if (fn > sn){
                        looplength = sn;
                    }
                    else {
                        looplength = fn;
                    }


                    //The While Loop and the algorithm
                      int w = 0;
                      while (w < looplength){
                          String d = String.valueOf(fname.charAt(w));
                          if (secondName.contains(d)) {
                             sn--;
                              fn--;

                              flameValue= sn +fn;
                          }
                          else {
                              flameValue= sn +fn;
                          }

                          w++;
                      }

                    //Logic to determine the array value which is OUR FLAME
                    if ( flameValue == 1 || flameValue == 7 || flameValue == 13 || flameValue == 19 || flameValue == 25 || flameValue == 31 ){
                        arrayValue = 0;
                    }
                    else if ( flameValue == 2 || flameValue == 8 || flameValue == 14 || flameValue == 20 || flameValue == 26 || flameValue == 32 ){
                        arrayValue = 1;
                    }
                    else if ( flameValue == 3 || flameValue == 9 || flameValue == 15 || flameValue == 21 || flameValue == 27 || flameValue == 33 ){
                        arrayValue = 2;
                    }
                    else if ( flameValue == 4 || flameValue == 10 || flameValue == 16 || flameValue == 22 || flameValue == 28 || flameValue == 34 ){
                        arrayValue = 3;
                    }
                    else if ( flameValue == 5 || flameValue == 11 || flameValue == 17 || flameValue == 23 || flameValue == 29 || flameValue == 35 ){
                        arrayValue = 4;
                    }
                    else if ( flameValue == 6 || flameValue == 12 || flameValue == 18 || flameValue == 24 || flameValue == 30 || flameValue == 36 ){
                        arrayValue = 5;
                    }
                    else{
                        arrayValue = 6;
                    }


                      //DISPLAYING THE ANS
                      String flameSays = flameList[arrayValue];
                      Toast.makeText(getApplicationContext(), "Wow!", Toast.LENGTH_SHORT).show();
                      final AlertDialog.Builder viewDetail = new AlertDialog.Builder(MainActivity.this);
                      viewDetail.setIcon(android.R.drawable.sym_action_chat);
                      //  viewDetail.setIcon(android.R.drawable.sym_action_chat);
                      viewDetail.setTitle("Your Flame Says");
                      viewDetail.setMessage("   ' " + flameSays + " '");
                      viewDetail.setNeutralButton("OK",
                              new DialogInterface.OnClickListener() {
                                  public void onClick(DialogInterface dialog,
                                                      int which) {
                                      dialog.dismiss();
                                     //////////its only a game////////////////

                                      final AlertDialog.Builder viewDetail2 = new AlertDialog.Builder(MainActivity.this);
                                      viewDetail2.setIcon(android.R.drawable.sym_action_chat);
                                      //  viewDetail.setIcon(android.R.drawable.sym_action_chat);
                                      viewDetail2.setTitle("LOL...Its Just A Game");
                                      viewDetail2.setMessage("..Its only you who has the POWER to Define what KIND of Relationship You Have With Other People. \n" +
                                              "...The Power of CHOICE is Yours...\n\n ...Ndine... Wishes You a Merry XMAS and Happy 2017");
                                      viewDetail2.setNeutralButton("Be Good..OK",
                                              new DialogInterface.OnClickListener() {
                                                  public void onClick(DialogInterface dialog,
                                                                      int which) {
                                                      dialog.dismiss();

                                  }
                              });
                              viewDetail2.show();
                                     // //////////////////////////////////////


                                  }
                              });
                      viewDetail.show();


                    //if fields are empty
                }
                else {

                    Toast.makeText(getApplicationContext(), "Please Fill in all Empty Fields", Toast.LENGTH_SHORT).show();
                }//end else

                break;
        }//endSwitch
    }
    //////////////////////////////////////////////////////////////////////////////////
}
