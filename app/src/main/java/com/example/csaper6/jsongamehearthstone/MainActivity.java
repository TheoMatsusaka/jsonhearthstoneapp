package com.example.csaper6.jsongamehearthstone;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    public static final String TAG = MainActivity.class.getSimpleName();
    private TextView textScore, textQuestion;
    private Button buttonNew, button1, button2, button3, button4;
    int scoreNum = 0;
    String name = "";
    String type = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wirewidgets();
        String jsonString = "";
        try {
            InputStream fileInput = getAssets().open("Hearthstone.JSON");
            BufferedReader reader = new BufferedReader(new InputStreamReader(fileInput));
            String added;
            while ((added = reader.readLine()) != null){
                jsonString += added;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        final JSONObject finalObject = jsonObject;
        buttonNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ButtonReset();

                boolean minion1 = false;
                boolean minion2 = false;
                boolean minion3 = false;
                boolean minion4 = false;
                boolean equal1 = false;
                boolean equal2 = false;
                boolean equal3 = false;
                String correct = "";
                String wrong1 = "";
                String wrong2 = "";
                String wrong3 = "";


                //region Button Values
                while(!minion1) {
                    Random rand = new Random();
                    int n = rand.nextInt(300);
                    name = finalObject.optJSONArray("cards").optJSONObject(n).optString("name");
                    int i = rand.nextInt(4);
                    createQuestion(i);
                     correct = finalObject.optJSONArray("cards").optJSONObject(n).optString(type+"");

                    if(finalObject.optJSONArray("cards").optJSONObject(n).optString("type").equals("MINION")){
                        minion1 = true;

                    }

                }
                while(!minion2||equal1) {
                    Random rand = new Random();
                    int n = rand.nextInt(300);

                    wrong1 = finalObject.optJSONArray("cards").optJSONObject(n).optString(type+"");
                    if(wrong1.equals(correct+""))
                    {
                        equal1 = true;
                    }

                    if(finalObject.optJSONArray("cards").optJSONObject(n).optString("type").equals("MINION")){
                        minion2 = true;

                    }

                }
                while(!minion3||equal2) {
                    Random rand = new Random();
                    int n = rand.nextInt(300);

                    wrong2 = finalObject.optJSONArray("cards").optJSONObject(n).optString(type+"");
                    if(wrong2.equals(correct) || wrong2.equals(wrong1))
                    {
                        equal2 = true;
                    }

                    if(finalObject.optJSONArray("cards").optJSONObject(n).optString("type").equals("MINION")){
                        minion3 = true;

                    }

                }
                while(!minion4||equal3) {
                    Random rand = new Random();
                    int n = rand.nextInt(300);

                    wrong3 = finalObject.optJSONArray("cards").optJSONObject(n).optString(type+"");
                    if(wrong3.equals(correct+"")|| wrong3.equals(wrong2)|| wrong3.equals(wrong1))
                    {
                        equal3 = true;
                    }

                    if(finalObject.optJSONArray("cards").optJSONObject(n).optString("type").equals("MINION")){
                        minion4 = true;

                    }

                }
                //endregion
                Random rand = new Random();
                //region OnClickListeners
                int n = rand.nextInt(4);
                if (n == 0) {


                    button1.setText(correct);

                    button1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            //Toast.makeText(MainActivity.this, "correct", Toast.LENGTH_SHORT).show();
                            scoreNum++;
                            textScore.setText(scoreNum+"");
                            button1.setBackgroundColor(Color.GREEN);
                            button1.setEnabled(false);
                        }
                    });

                    button2.setText(wrong1);
                    button2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            scoreNum--;
                            textScore.setText(scoreNum+"");
                            button2.setBackgroundColor(Color.RED);
                            button2.setEnabled(false);
                        }
                    });

                    button3.setText(wrong2);
                    button3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            scoreNum--;
                            textScore.setText(scoreNum+"");
                            button3.setBackgroundColor(Color.RED);
                            button3.setEnabled(false);
                        }
                    });


                    button4.setText(wrong3);
                    button4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            scoreNum--;
                            textScore.setText(scoreNum+"");
                            button4.setBackgroundColor(Color.RED);
                            button4.setEnabled(false);

                        }
                    });
                }
                else if(n==1)
                {

                    button2.setText(correct);

                    button2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            Toast.makeText(MainActivity.this, "correct", Toast.LENGTH_SHORT).show();
                            button2.setBackgroundColor(Color.GREEN);
                            button2.setEnabled(false);
                        }
                    });

                    button1.setText(wrong1);
                    button1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            scoreNum--;
                            textScore.setText(scoreNum+"");
                            button1.setBackgroundColor(Color.RED);
                            button1.setEnabled(false);
                        }
                    });

                    button3.setText(wrong2);
                    button3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            scoreNum--;
                            textScore.setText(scoreNum+"");
                            button3.setBackgroundColor(Color.RED);
                            button3.setEnabled(false);
                        }
                    });

                    button4.setText(wrong3);
                    button4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            scoreNum--;
                            textScore.setText(scoreNum+"");
                            button4.setBackgroundColor(Color.RED);
                            button4.setEnabled(false);
                        }
                    });
                }
                else if (n == 2) {


                    button1.setText(wrong2);

                    button1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            //Toast.makeText(MainActivity.this, "correct", Toast.LENGTH_SHORT).show();
                            scoreNum--;
                            textScore.setText(scoreNum+"");
                            button1.setBackgroundColor(Color.RED);
                            button1.setEnabled(false);
                        }
                    });

                    button2.setText(wrong1);
                    button2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            scoreNum--;
                            textScore.setText(scoreNum+"");
                            button2.setBackgroundColor(Color.RED);
                            button2.setEnabled(false);
                        }
                    });

                    button3.setText(correct);
                    button3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            scoreNum++;
                            textScore.setText(scoreNum+"");
                            button3.setBackgroundColor(Color.GREEN);
                            button3.setEnabled(false);
                        }
                    });


                    button4.setText(wrong3);
                    button4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            scoreNum--;
                            textScore.setText(scoreNum+"");
                            button4.setBackgroundColor(Color.RED);
                            button4.setEnabled(false);

                        }
                    });
                }
                else {


                    button1.setText(wrong2);

                    button1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            //Toast.makeText(MainActivity.this, "correct", Toast.LENGTH_SHORT).show();
                            scoreNum--;
                            textScore.setText(scoreNum+"");
                            button1.setBackgroundColor(Color.RED);
                            button1.setEnabled(false);
                        }
                    });

                    button2.setText(wrong1);
                    button2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            scoreNum--;
                            textScore.setText(scoreNum+"");
                            button2.setBackgroundColor(Color.RED);
                            button2.setEnabled(false);
                        }
                    });

                    button3.setText(wrong3);
                    button3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            scoreNum--;
                            textScore.setText(scoreNum+"");
                            button3.setBackgroundColor(Color.RED);
                            button3.setEnabled(false);
                        }
                    });


                    button4.setText(correct);
                    button4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            scoreNum++;
                            textScore.setText(scoreNum+"");
                            button4.setBackgroundColor(Color.GREEN);
                            button4.setEnabled(false);

                        }
                    });
                }
                //endregion



            }
        }
        );
        buttonNew.callOnClick();



    }

    private void ButtonReset() {
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        button4.setEnabled(true);

        button1.setBackgroundColor(Color.LTGRAY);
        button2.setBackgroundColor(Color.LTGRAY);
        button3.setBackgroundColor(Color.LTGRAY);
        button4.setBackgroundColor(Color.LTGRAY);

    }

    private void wirewidgets() {
        textQuestion = (TextView) findViewById(R.id.one);
        buttonNew = (Button) findViewById(R.id.button);
        button1 = (Button) findViewById(R.id.button2);
        button2 = (Button) findViewById(R.id.button3);
        button3 = (Button) findViewById(R.id.button4);
        button4 = (Button) findViewById(R.id.button5);
        textScore = (TextView) findViewById(R.id.text_score);
    }
    private void createQuestion(int i) {

        if (i == 0) {
            type = "attack";
            textQuestion.setText("What is the " + type + " of " + name + "?");
        } else if (i == 1) {
            type = "health";
            textQuestion.setText("What is the " + type + " of " + name + "?");
        } else if (i == 2) {
            type = "flavor";
            textQuestion.setText("What is the " + type + " of " + name + "?");
        } else if (i == 3) {
            type = "artist";
            textQuestion.setText("Who is the " + type + " of " + name + "?");
        }
    }


}
