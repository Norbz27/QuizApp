package com.example.quizapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {
    private int CurrentProgress = 0;
    private ProgressBar progressBar;

    ArrayList<Integer> numbers = new ArrayList<Integer>();
    String question[] = new String[40];
    String a[] = new String[40];
    String b[] = new String[40];
    String c[] = new String[40];
    String d[] = new String[40];
    String answer[] = new String[40];
    int ctr=0;
    int ctr1=0;
    int ctr2=0;
    int i=0;
    public static int score=0;
    public static int catid2;
    int max=10,min=0;
    int max1=21,min1=11;
    int max2=32,min2=22;
    Random rand;
    TextView tvQ;
    ImageView img;
    Button r1;
    Button r2;
    Button r3;
    Button r4;

    TextView tvS, num;
    private CountDownTimer countDownTimer;
    private ProgressBar progressBar1;
    private TextView timerTextView;
    Handler handler;
    private TextView category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        rand = new Random();
        catid2 = CategoryActivity.catID;
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        category = (TextView) findViewById(R.id.category);

        tvQ = (TextView) findViewById(R.id.Q);
        img = (ImageView) findViewById(R.id.image);
        r1 = (Button) findViewById(R.id.btnc1);
        r2 = (Button) findViewById(R.id.btnc2);
        r3 = (Button) findViewById(R.id.btnc3);
        r4 = (Button) findViewById(R.id.btnc4);
        num = (TextView) findViewById(R.id.num);
        progressBar1 = findViewById(R.id.timer_progress);
        progressBar1.setMax(3000);
        progressBar.setProgress(0);

        timerTextView = findViewById(R.id.timer_text);

        score = 0;
        if(catid2 == 1){
            category.setText("Philippines Landmarks");
            questions();
            generateQuestions();
        }else if(catid2 == 2){
            category.setText("France Landmarks");
            questions();
            generateQuestions();
        }else if(catid2 == 3){
            category.setText("Singapore Landmarks");
            questions();
            generateQuestions();
        }

        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTimer();
                if(r1.getText().equals(answer[i])){
                    r1.setBackgroundResource(R.drawable.curve_shape_green);
                    r1.setTextColor(Color.WHITE);

                    score +=1;
                } else {
                    r1.setBackgroundResource(R.drawable.curve_shape_red);
                    r1.setTextColor(Color.WHITE);
                    if(r2.getText().equals(answer[i])){
                        r2.setBackgroundResource(R.drawable.curve_shape_green);
                        r2.setTextColor(Color.WHITE);
                    } else if(r3.getText().equals(answer[i])){
                        r3.setBackgroundResource(R.drawable.curve_shape_green);
                        r3.setTextColor(Color.WHITE);
                    } else if(r4.getText().equals(answer[i])){
                        r4.setBackgroundResource(R.drawable.curve_shape_green);
                        r4.setTextColor(Color.WHITE);
                    }
                }
                r1.setEnabled(false);
                r2.setEnabled(false);
                r3.setEnabled(false);
                r4.setEnabled(false);

                handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        CurrentProgress = CurrentProgress + 10;
                        progressBar.setProgress(CurrentProgress);
                        progressBar.setMax(100);
                        r1.setEnabled(true);
                        r2.setEnabled(true);
                        r3.setEnabled(true);
                        r4.setEnabled(true);
                        r1.setBackgroundResource(R.drawable.curve_shape_white);
                        r1.setTextColor(Color.parseColor("#566BF3"));
                        r2.setBackgroundResource(R.drawable.curve_shape_white);
                        r2.setTextColor(Color.parseColor("#566BF3"));
                        r3.setBackgroundResource(R.drawable.curve_shape_white);
                        r3.setTextColor(Color.parseColor("#566BF3"));
                        r4.setBackgroundResource(R.drawable.curve_shape_white);
                        r4.setTextColor(Color.parseColor("#566BF3"));
                        generateQuestions();
                    }
                },2000);
            }
        });
        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTimer();
                if(r2.getText().equals(answer[i])){
                    r2.setBackgroundResource(R.drawable.curve_shape_green);
                    r2.setTextColor(Color.WHITE);

                    score +=1;
                } else {
                    r2.setBackgroundResource(R.drawable.curve_shape_red);
                    r2.setTextColor(Color.WHITE);
                    if(r1.getText().equals(answer[i])){
                        r1.setBackgroundResource(R.drawable.curve_shape_green);
                        r1.setTextColor(Color.WHITE);
                    } else if(r3.getText().equals(answer[i])){
                        r3.setBackgroundResource(R.drawable.curve_shape_green);
                        r3.setTextColor(Color.WHITE);
                    } else if(r4.getText().equals(answer[i])){
                        r4.setBackgroundResource(R.drawable.curve_shape_green);
                        r4.setTextColor(Color.WHITE);
                    }
                }
                r1.setEnabled(false);
                r2.setEnabled(false);
                r3.setEnabled(false);
                r4.setEnabled(false);

                handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        CurrentProgress = CurrentProgress + 10;
                        progressBar.setProgress(CurrentProgress);
                        progressBar.setMax(100);
                        r1.setEnabled(true);
                        r2.setEnabled(true);
                        r3.setEnabled(true);
                        r4.setEnabled(true);
                        r1.setBackgroundResource(R.drawable.curve_shape_white);
                        r1.setTextColor(Color.parseColor("#566BF3"));
                        r2.setBackgroundResource(R.drawable.curve_shape_white);
                        r2.setTextColor(Color.parseColor("#566BF3"));
                        r3.setBackgroundResource(R.drawable.curve_shape_white);
                        r3.setTextColor(Color.parseColor("#566BF3"));
                        r4.setBackgroundResource(R.drawable.curve_shape_white);
                        r4.setTextColor(Color.parseColor("#566BF3"));
                        generateQuestions();
                    }
                },2000);
            }
        });
        r3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTimer();
                if(r3.getText().equals(answer[i])){
                    r3.setBackgroundResource(R.drawable.curve_shape_green);
                    r3.setTextColor(Color.WHITE);

                    score +=1;
                } else {
                    r3.setBackgroundResource(R.drawable.curve_shape_red);
                    r3.setTextColor(Color.WHITE);
                    if(r2.getText().equals(answer[i])){
                        r2.setBackgroundResource(R.drawable.curve_shape_green);
                        r2.setTextColor(Color.WHITE);
                    } else if(r1.getText().equals(answer[i])){
                        r1.setBackgroundResource(R.drawable.curve_shape_green);
                        r1.setTextColor(Color.WHITE);
                    } else if(r4.getText().equals(answer[i])){
                        r4.setBackgroundResource(R.drawable.curve_shape_green);
                        r4.setTextColor(Color.WHITE);
                    }
                }
                r1.setEnabled(false);
                r2.setEnabled(false);
                r3.setEnabled(false);
                r4.setEnabled(false);

                handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        CurrentProgress = CurrentProgress + 10;
                        progressBar.setProgress(CurrentProgress);
                        progressBar.setMax(100);
                        r1.setEnabled(true);
                        r2.setEnabled(true);
                        r3.setEnabled(true);
                        r4.setEnabled(true);
                        r1.setBackgroundResource(R.drawable.curve_shape_white);
                        r1.setTextColor(Color.parseColor("#566BF3"));
                        r2.setBackgroundResource(R.drawable.curve_shape_white);
                        r2.setTextColor(Color.parseColor("#566BF3"));
                        r3.setBackgroundResource(R.drawable.curve_shape_white);
                        r3.setTextColor(Color.parseColor("#566BF3"));
                        r4.setBackgroundResource(R.drawable.curve_shape_white);
                        r4.setTextColor(Color.parseColor("#566BF3"));
                        generateQuestions();
                    }
                },2000);
            }
        });
        r4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTimer();
                if(r4.getText().equals(answer[i])){
                    r4.setBackgroundResource(R.drawable.curve_shape_green);
                    r4.setTextColor(Color.WHITE);

                    score +=1;
                } else {
                    r4.setBackgroundResource(R.drawable.curve_shape_red);
                    r4.setTextColor(Color.WHITE);
                    if(r2.getText().equals(answer[i])){
                        r2.setBackgroundResource(R.drawable.curve_shape_green);
                        r2.setTextColor(Color.WHITE);
                    } else if(r3.getText().equals(answer[i])){
                        r3.setBackgroundResource(R.drawable.curve_shape_green);
                        r3.setTextColor(Color.WHITE);
                    } else if(r1.getText().equals(answer[i])){
                        r1.setBackgroundResource(R.drawable.curve_shape_green);
                        r1.setTextColor(Color.WHITE);
                    }
                }
                r1.setEnabled(false);
                r2.setEnabled(false);
                r3.setEnabled(false);
                r4.setEnabled(false);

                handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        CurrentProgress = CurrentProgress + 10;
                        progressBar.setProgress(CurrentProgress);
                        progressBar.setMax(100);
                        r1.setEnabled(true);
                        r2.setEnabled(true);
                        r3.setEnabled(true);
                        r4.setEnabled(true);
                        r1.setBackgroundResource(R.drawable.curve_shape_white);
                        r1.setTextColor(Color.parseColor("#566BF3"));
                        r2.setBackgroundResource(R.drawable.curve_shape_white);
                        r2.setTextColor(Color.parseColor("#566BF3"));
                        r3.setBackgroundResource(R.drawable.curve_shape_white);
                        r3.setTextColor(Color.parseColor("#566BF3"));
                        r4.setBackgroundResource(R.drawable.curve_shape_white);
                        r4.setTextColor(Color.parseColor("#566BF3"));
                        generateQuestions();
                    }
                },2000);
            }
        });

    }
    private void startTimer() {
        countDownTimer = new CountDownTimer(3000, 10) {
            public void onTick(long millisUntilFinished) {
                progressBar1.setVisibility(View.VISIBLE);
                int progress = (int) (millisUntilFinished / 10);
                progressBar1.setProgress(progress);
                timerTextView.setText(Integer.toString((int) millisUntilFinished / 1000));
            }

            public void onFinish() {
                progressBar1.setVisibility(View.INVISIBLE);
                timerTextView.setText("");
                progressBar1.setProgress(0);
            }
        }.start();
    }
    public void generateQuestions() {
        if (catid2 == 1) {
            if (ctr < 10) {
                i = rand.nextInt(max - min + 1) + min;
                if (numbers.contains(i)) {
                    generateQuestions();
                } else {
                    //clear();
                    numbers.add(i);
                    tvQ.setText(question[i]);
                    r1.setText(a[i]);
                    r2.setText(b[i]);
                    r3.setText(c[i]);
                    r4.setText(d[i]);
                    img.setImageResource(factArray[i].getmImage());
                    ctr = ctr + 1;
                    num.setText(ctr + "/10");
                }
            } else {
                Intent i = new Intent(QuizActivity.this, ResultActivity.class);
                startActivity(i);
            }
        } else if (catid2 == 2) {
            if (ctr1 < 10) {
                i = rand.nextInt(max1 - min1 + 1) + min1;
                if (numbers.contains(i)) {
                    generateQuestions();
                } else {
                    numbers.add(i);
                    tvQ.setText(question[i]);
                    r1.setText(a[i]);
                    r2.setText(b[i]);
                    r3.setText(c[i]);
                    r4.setText(d[i]);
                    img.setImageResource(factArray[i].getmImage());
                    ctr1 = ctr1 + 1;
                    num.setText(ctr1 + "/10");
                }
            } else {
                Intent i = new Intent(QuizActivity.this, ResultActivity.class);
                startActivity(i);
            }
        } else if (catid2 == 3) {
            if (ctr2 < 10) {
                i = rand.nextInt(max2 - min2 + 1) + min2;
                if (numbers.contains(i)) {
                    generateQuestions();
                } else {
                    numbers.add(i);
                    tvQ.setText(question[i]);
                    r1.setText(a[i]);
                    r2.setText(b[i]);
                    r3.setText(c[i]);
                    r4.setText(d[i]);
                    img.setImageResource(factArray[i].getmImage());
                    ctr2 = ctr2 + 1;
                    num.setText(ctr2 + "/10");
                }
            } else {
                Intent i = new Intent(QuizActivity.this, ResultActivity.class);
                startActivity(i);
            }
        }
    }
    public void questions(){
        //PH Questions
        question[0] = "Which of the following landmarks in the Philippines is occasionally called the Eighth Wonders of the World?";
        a[0] = "Mayon Volcano";
        b[0] = "Chocolate Hills";
        c[0] = "Banaue Rice Terraces";
        d[0] = "Tubbataha Reef";
        answer[0] = "Banaue Rice Terraces";

        question[1] = "Which landmark in the Philippines is known for its vibrant marine life and is a popular destination for divers and swimmers?";
        a[1] = "Mayon Volcano";
        b[1] = "Chocolate Hills";
        c[1] = "Tubbataha Reef";
        d[1] = "Banaue Rice Terraces";
        answer[1] = "Tubbataha Reef";

        question[2] = "What is the name of the famous white sand beach in Boracay?";
        a[2] = "Sabang Beach";
        b[2] = "Nacpan Beach";
        c[2] = "White Beach";
        d[2] = "Alona Beach";
        answer[2] = "White Beach";

        question[3] = "What is the name of the iconic fortress built by the Spanish in Manila?";
        a[3] = "Fort San Pedro";
        b[3] = "Fort Santiago";
        c[3] = "Intramuros";
        d[3] = "Malacañang Palace";
        answer[3] = "Fort Santiago";

        question[4] = "What is the name of the Philippine's most active volcano?";
        a[4] = "Taal Volcano";
        b[4] = "Mayon Volcano";
        c[4] = "Mount Pinatubo";
        d[4] = "Mount Pulag";
        answer[4] = "Taal Volcano";

        question[5] = "Which landmark is known for its chocolate-colored hills?";
        a[5] = "Banaue Rice Terraces";
        b[5] = "Mount Apo";
        c[5] = "Chocolate Hills";
        d[5] = "Mount Banahaw";
        answer[5] = "Chocolate Hills";

        question[6] = "What is the name of the famous waterfall located in the province of Antipolo City?";
        a[6] = "Hinulugang Taktak Falls";
        b[6] = "Kawasan Falls";
        c[6] = "Mag-Aso Falls";
        d[6] = "Pagsanjan Falls";
        answer[6] = "Hinulugang Taktak Falls";

        question[7] = "What is the name of the historic church located in Paoay, Ilocos Norte?";
        a[7] = "San Agustin Church";
        b[7] = "Quiapo Church";
        c[7] = "Paoay Church";
        d[7] = "Baclayon Church";
        answer[7] = "Paoay Church";

        question[8] = "What is the name of the famous underground river in Palawan?";
        a[8] = "Hinatuan Enchanted River";
        b[8] = "Puerto Princesa Subterranean River";
        c[8] = "Agusan Marsh";
        d[8] = "Danao Adventure Park";
        answer[8] = "Puerto Princesa Subterranean River";

        question[9] = "What is the name of the old-famous park located in the heart of Cebu City?";
        a[9] = "Rizal Park";
        b[9] = "Burnham Park";
        c[9] = "Luneta Park";
        d[9] = "Fuente Osmeña Circle";
        answer[9] = "Fuente Osmeña Circle";

        question[10] = "What is the name of a famous waterfall in the Mindanao province's Bislig City stated for its three-tiered waterfalls, which rises 55 meters?";
        a[10] = "Kawasan Falls";
        b[10] = "Mag-Aso Falls";
        c[10] = "Aliwagwag Falls";
        d[10] = "Tinuy-an Falls";
        answer[10] = "Tinuy-an Falls";

        //France Questions

        question[11] = "Which famous Parisian landmark is a Gothic cathedral known for its stunning stained glass windows?";
        a[11] = "Eiffel Tower";
        b[11] = "Arc de Triomphe";
        c[11] = "Notre-Dame Cathedral";
        d[11] = "Louvre Museum";
        answer[11] = "Notre-Dame Cathedral";

        question[12] = "Which French landmark is a 17th-century palace that was the seat of power for the French monarchy for many years?";
        a[12] = "Palace of Versailles";
        b[12] = "Mont Saint-Michel";
        c[12] = "Sacré-Cœur Basilica";
        d[12] = "Château de Chambord";
        answer[12] = "Palace of Versailles";

        question[13] = "Which Parisian landmark is a famous monument that honors soldiers who fought for France during the Napoleonic Wars?";
        a[13] = "Eiffel Tower";
        b[13] = "Arc de Triomphe";
        c[13] = "Notre-Dame Cathedral";
        d[13] = "Louvre Museum";
        answer[13] = "Arc de Triomphe";

        question[14] = "Which landmark is a medieval castle perched on a rocky island off the coast of Normandy?";
        a[14] = "Palace of Versailles";
        b[14] = "Mont Saint-Michel";
        c[14] = "Sacré-Cœur Basilica";
        d[14] = "Château de Chambord";
        answer[14] = "Mont Saint-Michel";

        question[15] = "Which Parisian landmark is a museum that is home to many famous works of art, including the Mona Lisa?";
        a[15] = "Eiffel Tower";
        b[15] = "Arc de Triomphe";
        c[15] = "Notre-Dame Cathedral";
        d[15] = "Louvre Museum";
        answer[15] = "Louvre Museum";

        question[16] = "Which French landmark is a 19th-century basilica that sits atop a hill overlooking Paris?";
        a[16] = "Eiffel Tower";
        b[16] = "Arc de Triomphe";
        c[16] = "Notre-Dame Cathedral";
        d[16] = "Sacré-Cœur Basilica";
        answer[16] = "Sacré-Cœur Basilica";

        question[17] = "Which Parisian landmark is a famous tower that was built for the 1889 World's Fair?";
        a[17] = "Eiffel Tower";
        b[17] = "Arc de Triomphe";
        c[17] = "Notre-Dame Cathedral";
        d[17] = "Louvre Museum";
        answer[17] = "Eiffel Tower";

        question[18] = "Which French landmark is a 13th-century castle that is often associated with the legend of King Arthur?";
        a[18] = "Palace of Versailles";
        b[18] = "Mont Saint-Michel";
        c[18] = "Château de Chambord";
        d[18] = "Château de Pierrefonds";
        answer[18] = "Château de Pierrefonds";

        question[19] = "Which Parisian landmark is a famous art museum that is home to many Impressionist paintings?";
        a[19] = "Eiffel Tower";
        b[19] = "Arc de Triomphe";
        c[19] = "Notre-Dame Cathedral";
        d[19] = "Musée d'Orsay";
        answer[19] = "Musée d'Orsay";

        question[20] = "Which French landmark is a Roman Catholic cathedral that is considered a masterpiece of Gothic architecture?";
        a[20] = "Palace of Versailles";
        b[20] = "Mont Saint-Michel";
        c[20] = "Chartres Cathedral";
        d[20] = "Château de Chambord";
        answer[20] = "Chartres Cathedral";

        question[21] = "Which Parisian landmark is a famous avenue that is home to many high-end shops and boutiques?";
        a[21] = "Eiffel Tower";
        b[21] = "Arc de Triomphe";
        c[21] = "Champs-Élysées";
        d[21] = "Louvre Museum";
        answer[21] = "Champs-Élysées";

        //Singapore Questions

        question[22] = "Which iconic Singapore landmark is a massive ferris wheel that offers panoramic views of the city?";
        a[22] = "Marina Bay Sands";
        b[22] = "Gardens by the Bay";
        c[22] = "Merlion Park";
        d[22] = "Singapore Flyer";
        answer[22] = "Singapore Flyer";

        question[23] = "Which famous shopping district in Singapore is home to luxury stores, hotels, and restaurants?";
        a[23] = "Orchard Road";
        b[23] = "Chinatown";
        c[23] = "Little India";
        d[23] = "Clarke Quay";
        answer[23] = "Orchard Road";

        question[24] = "Which Singapore landmark is a nature park that features hiking trails, waterfalls, and wildlife?";
        a[24] = "Gardens by the Bay";
        b[24] = "Sentosa Island";
        c[24] = "MacRitchie Reservoir";
        d[24] = "Singapore Botanic Gardens";
        answer[24] = "MacRitchie Reservoir";

        question[25] = "Which historic district in Singapore features restored shophouses, cafes, and boutique shops?";
        a[25] = "Arab Street";
        b[25] = "Chinatown";
        c[25] = "Little India";
        d[25] = "Kampong Glam";
        answer[25] = "Kampong Glam";

        question[26] = "Which futuristic Singapore landmark is an integrated resort that features a hotel, casino, and rooftop infinity pool?";
        a[26] = "Marina Bay Sands";
        b[26] = "Gardens by the Bay";
        c[26] = "Merlion Park";
        d[26] = "Singapore Flyer";
        answer[26] = "Marina Bay Sands";

        question[27] = "Which famous theme park in Singapore features rides, attractions, and a water park?";
        a[27] = "Marina Bay Sands";
        b[27] = "Gardens by the Bay";
        c[27] = "Merlion Park";
        d[27] = "Singapore Flyer";
        answer[27] = "Merlion Park";

        question[28] = "Which Parisian landmark is a famous tower that was built for the 1889 World's Fair?";
        a[28] = "Universal Studios Singapore";
        b[28] = "Adventure Cove Waterpark";
        c[28] = "S.E.A. Aquarium";
        d[28] = "Wild Wild Wet";
        answer[28] = "Universal Studios Singapore";

        question[29] = "Which Singapore landmark is a cultural heritage site that features traditional Chinese architecture and artifacts?";
        a[29] = "Haw Par Villa";
        b[29] = "Buddha Tooth Relic Temple";
        c[29] = "Peranakan Museum";
        d[29] = "Chinatown Heritage Centre";
        answer[29] = "Chinatown Heritage Centre";

        question[30] = "Which Singapore landmark is a museum that showcases the history and culture of Singapore?";
        a[30] = "ArtScience Museum";
        b[30] = "National Museum of Singapore";
        c[30] = "Singapore Discovery Centre";
        d[30] = "Asian Civilisations Museum";
        answer[30] = "National Museum of Singapore";

        question[31] = "Which famous street in Singapore is known for its lively nightlife and riverside restaurants?";
        a[31] = "Clarke Quay";
        b[31] = "Boat Quay";
        c[31] = "Robertson Quay";
        d[31] = "Ann Siang Hill";
        answer[31] = "Clarke Quay";

        question[32] = "Which Singapore landmark is a futuristic park that features giant tree-like structures and conservatories?";
        a[32] = "Marina Bay Sands";
        b[32] = "Gardens by the Bay";
        c[32] = "Merlion Park";
        d[32] = "Singapore Flyer";
        answer[32] = "Gardens by the Bay";

    }
    //PH
    Facts f00 = new Facts(R.drawable.banaue);
    Facts f01 = new Facts(R.drawable.tubbataha);
    Facts f02 = new Facts(R.drawable.white);
    Facts f03 = new Facts(R.drawable.fort);
    Facts f04 = new Facts(R.drawable.taal);
    Facts f05 = new Facts(R.drawable.choco);
    Facts f06 = new Facts(R.drawable.hinulagang);
    Facts f07 = new Facts(R.drawable.paoay);
    Facts f08 = new Facts(R.drawable.puerto);
    Facts f09 = new Facts(R.drawable.circle);
    Facts f10 = new Facts(R.drawable.tinuyan);

    //FR
    Facts f11 = new Facts(R.drawable.notre);
    Facts f12 = new Facts(R.drawable.palace);
    Facts f13 = new Facts(R.drawable.arc);
    Facts f14 = new Facts(R.drawable.mont);
    Facts f15 = new Facts(R.drawable.louvre);
    Facts f16 = new Facts(R.drawable.sacre);
    Facts f17 = new Facts(R.drawable.eiffel);
    Facts f18 = new Facts(R.drawable.chat);
    Facts f19 = new Facts(R.drawable.musee);
    Facts f20 = new Facts(R.drawable.chartres);
    Facts f21 = new Facts(R.drawable.champ);

    //SG

    Facts f22 = new Facts(R.drawable.flyer);
    Facts f23 = new Facts(R.drawable.orchard);
    Facts f24 = new Facts(R.drawable.mac);
    Facts f25 = new Facts(R.drawable.kampong);
    Facts f26 = new Facts(R.drawable.marina);
    Facts f27 = new Facts(R.drawable.merlion);
    Facts f28 = new Facts(R.drawable.universal);
    Facts f29 = new Facts(R.drawable.china);
    Facts f30 = new Facts(R.drawable.nat);
    Facts f31 = new Facts(R.drawable.clarke);
    Facts f32 = new Facts(R.drawable.garden);

    Facts [] factArray = new Facts[]{
            f00,f01,f02,f03,f04,f05,f06,f07,f08,f09,f10,
            f11,f12,f13,f14,f15,f16,f17,f18,f19,f20,f21,
            f22,f23,f24,f25,f26,f27,f28,f29,f30,f31,f32
    };
}
