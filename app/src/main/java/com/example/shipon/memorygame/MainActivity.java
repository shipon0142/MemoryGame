package com.example.shipon.memorygame;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.media.Image;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {
    private int score = 0,ran;
    private Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,click;
    TextView scor,find;
    CountDownTimer ct;
    Button[] b = new Button[100];
    TextView T;
    int j,life=3;
    int[] in=new int[100];
    final ArrayList<Integer> numbers = new ArrayList<Integer>();
    ProgressBar mProgressBar;
    ImageView img1,img2,img3;
   private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        scor=findViewById(R.id.idScore);
        find=findViewById(R.id.idFind);
        b[1]=findViewById(R.id.id1);
        b[2]=findViewById(R.id.id2);
        b[3]=findViewById(R.id.id3);
        b[4]=findViewById(R.id.id4);
        b[5]=findViewById(R.id.id5);
        b[6]=findViewById(R.id.id6);
        b[7]=findViewById(R.id.id7);
        b[8]=findViewById(R.id.id8);
        b[9]=findViewById(R.id.id9);
        b[10]=findViewById(R.id.id10);
        b[11]=findViewById(R.id.id11);
        b[12]=findViewById(R.id.id12);
        b[13]=findViewById(R.id.id13);
        b[14]=findViewById(R.id.id14);
        b[15]=findViewById(R.id.id15);
        b[16]=findViewById(R.id.id16);
        b[17]=findViewById(R.id.id17);
        b[18]=findViewById(R.id.id18);
        b[19]=findViewById(R.id.id19);
        b[20]=findViewById(R.id.id20);
        T=findViewById(R.id.time);
        img1=findViewById(R.id.img1);
        img2=findViewById(R.id.img2);
        img3=findViewById(R.id.img3);

        numbers.clear();
        life=3;
        scor.setText("Score : 0");
        find.setVisibility(View.INVISIBLE);
      //  mProgressBar=(ProgressBar)findViewById(R.id.progressbar);
      size();
        score = 0;
        initial();
        Click();
    }
    @Override
    protected void onDestroy()
    {

        super.onDestroy();
        toast.cancel();
        MainActivity.this.finish();
    }

    @Override
    protected void onStop () {
        super.onStop();
        toast.cancel();
        MainActivity.this.finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        toast.cancel();
        MainActivity.this.finish();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        numbers.clear();
        numbers.clear();
        life=3;
        scor.setText("Score : 0");
        find.setVisibility(View.INVISIBLE);
        //  mProgressBar=(ProgressBar)findViewById(R.id.progressbar);
        size();
        score = 0;
        initial();
        Click();
    }

    public void size(){
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        for(int i=1;i<=20;i++){
            b[i].setHeight((width/5));
            b[i].setWidth((width/5));
        }
    }
    public void initial(){
        j=6;
        numbers.clear();
        T.setVisibility(View.INVISIBLE);
       // Arrays.fill(b,new String("0"));
        for(int i=1;i<=20;i++){
            b[i].setTextColor(Color.BLACK);
            b[i].setBackgroundResource(R.drawable.circle_button);
            b[i].setVisibility(View.INVISIBLE);
        }

    }

    public void Button_Click(View view) {

        T.setVisibility(View.INVISIBLE);
        Button bb = (Button)view;
        String buttonText = bb.getText().toString();
        if(Integer.valueOf(buttonText).equals(ran)){
         //   bb.setBackgroundColor(Color.GREEN);
            bb.setTextColor(Color.WHITE);
            bb.setBackgroundResource(R.drawable.green);
            score++;
            scor.setText("Score : "+score);

           // T.setVisibility(View.VISIBLE);

        }
        else {
            life--;
            if(life==2)img1.setVisibility(View.INVISIBLE);
            if(life==1)img2.setVisibility(View.INVISIBLE);
            if (life==0)img3.setVisibility(View.INVISIBLE);
           // bb.setBackgroundColor(Color.RED);
            bb.setTextColor(Color.WHITE);
            bb.setBackgroundResource(R.drawable.red_button);
            for(int i=1;i<=20;i++){
               if(Integer.valueOf(b[i].getText().toString()).equals(ran)){
                  // b[i].setBackgroundColor(Color.GREEN);
                   b[i].setTextColor(Color.WHITE);
                   b[i].setBackgroundResource(R.drawable.green);
               }
            }
          //  j=6;
           // T.setVisibility(View.VISIBLE);


        }
        new CountDownTimer(2000,1000){
            @Override
            public void onTick(long l) {
                for(int i=1;i<=20;i++){
                    b[i].setClickable(false);

                }
                // T.setText(""+(j-1));
                //  j--;

            }

            @Override
            public void onFinish() {
                if(life==0){
                         toast.cancel();
                    Intent ii=new Intent(getApplicationContext(),First.class);
                    startActivity(ii);
                    MainActivity.this.finish();

                }
                else {
                    T.setVisibility(View.VISIBLE);
                    //  ct.onFinish();
                    //  ct.start();
                    ct.cancel();
                    initial();
                    play();
                }
            }
        }.start();


       // initial();
        //play();
    }

    public void Click() {
      //  new CountDownTimer(10000,100){
         //   @Override
          //  public void onTick(long l) {
            play();
          //  }

          //  @Override
         //   public void onFinish() {
         //    finish();
         //   }
      //  };

    }
    public void finish(){
        for(int i=0;i<score+1;i++){

           // b1.setVisibility(View.GONE);
           // b2.setVisibility(View.GONE);
         //   b3.setVisibility(View.GONE);
         //   b4.setVisibility(View.GONE);
         //   b5.setVisibility(View.GONE);
        //    b6.setVisibility(View.GONE);
        }


    }

    public void play() {
        int min = 1;
        int max = 20;

        Random r = new Random();

        numbers.clear();
        while (numbers.size() <= score + 1) {
            int randomInteger = r.nextInt(max - min + 1) + min;
            if (!numbers.contains(randomInteger)) {
                {
                    //Toast.makeText(getApplicationContext(),String.valueOf(numbers.size()).toString(),Toast.LENGTH_SHORT).show();
                    numbers.add(randomInteger);

                }
            }
        }




        for(int i=0;i<score+1;i++){
          int num=  numbers.get(i);
          //  Toast.makeText(getApplicationContext(),String.valueOf(num).toString(),Toast.LENGTH_SHORT).show();
            b[num].setText(String.valueOf(i+1).toString());

            b[num].setVisibility(View.VISIBLE);

        }
      //  j=6;
      //  T.setVisibility(View.VISIBLE);

     new CountDownTimer(7000,1000){
               @Override
              public void onTick(long l) {
                 find.setVisibility(View.INVISIBLE);
                   for(int i=1;i<=20;i++){
                       b[i].setClickable(false);

                   }
                   T.setVisibility(View.INVISIBLE);
                  // T.setText(""+(j-1));
                //   j--;

                  // mProgressBar.setProgress((int)j*1000/(5000/100));

              }

              @Override
               public void onFinish() {
                 // T.setVisibility(View.INVISIBLE);
                 // j--;
                 // T.setText(""+j);
                //  mProgressBar.setProgress(100);
                  for(int i=1;i<=20;i++){
                      b[i].setClickable(true);
                  }

                  for(int i=0;i<score+1;i++){
                      int num=  numbers.get(i);
                      //Toast.makeText(getApplicationContext(),String.valueOf(num).toString(),Toast.LENGTH_SHORT).show();
                      b[num].setTextColor(getResources().getColor(R.color.textc));
                    //  b[num].setVisibility(View.INVISIBLE);
                  }
                  int m=1;
                  int n=score+1;
                  Random rr = new Random();
                  ran = rr.nextInt( n- m + 1) + m;
                  LayoutInflater inflater = getLayoutInflater();
                  View layout = inflater.inflate(R.layout.toast,
                          (ViewGroup) findViewById(R.id.toast_layout_root));
                  TextView text = (TextView) layout.findViewById(R.id.text);
                  text.setText(""+ran);
                  find.setVisibility(View.VISIBLE);
                  find.setText("Find : "+ran);
                  text.setBackgroundColor(Color.TRANSPARENT);

                  toast = new Toast(MainActivity.this);
                  toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                  toast.setDuration(Toast.LENGTH_SHORT);
                  toast.setView(layout);
                  toast.show();
                  T.setVisibility(View.VISIBLE);
                  ct.start();

                  //Toast.makeText(getApplicationContext(),"Find : "+ran,Toast.LENGTH_SHORT).show();
               }
              }.start();
        j=6;
        T.setVisibility(View.VISIBLE);

        ct= new CountDownTimer(7000,1000){
            @Override
            public void onTick(long l) {

                T.setText(""+(j-1));
                j--;


            }

            @Override
            public void onFinish() {

                       toast.cancel();
                    life--;
                    if(life==2)img1.setVisibility(View.INVISIBLE);
                    if(life==1)img2.setVisibility(View.INVISIBLE);
                    if (life==0)img3.setVisibility(View.INVISIBLE);
                    if(life==0){

                        new CountDownTimer(2000,1000){
                            @Override
                            public void onTick(long l) {

                                // T.setText(""+(j-1));
                                //  j--;

                            }

                            @Override
                            public void onFinish() {
                                toast.cancel();
                                Intent ii=new Intent(getApplicationContext(),First.class);
                                startActivity(ii);
                                MainActivity.this.finish();


                            }
                        }.start();

                    }
                    //   Toast.makeText(getApplicationContext(), "false", Toast.LENGTH_SHORT).show();

            else {

                        T.setVisibility(View.INVISIBLE);
                        j = 6;
                        initial();
                        play();
                    }

            }
        };

       // score++;

    }



}
