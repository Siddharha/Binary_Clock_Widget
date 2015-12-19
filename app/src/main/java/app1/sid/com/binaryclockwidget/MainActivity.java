package app1.sid.com.binaryclockwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.sql.Time;
import java.text.DateFormat;

import android.util.Log;
import android.widget.Chronometer;
import android.widget.RemoteViews;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;

public class MainActivity extends AppWidgetProvider {
    private int color_block,color_block2 ;
    private CharSequence txt;
    RemoteViews views;
    PendingIntent pending;
    int sec,min,hou ;




    public void onUpdate(Context context, AppWidgetManager appWidgetManager,int[] appWidgetIds) {


        for(int i=0; i<appWidgetIds.length; i++){
            int currentWidgetId = appWidgetIds[i];
            String url = "http://www.creativelizard.x10.mx";

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse(url));
            pending = PendingIntent.getActivity(context, 0, intent, 0);
            views = new RemoteViews(context.getPackageName(),R.layout.activity_main);

            setColor_block();
           // startTimer();
            timeGet();
            methodHH(String.valueOf(hou));
            methodMM(String.valueOf(min));
            // methodSS(String.valueOf(sec));
            Log.e("Tick", "tick");
            appWidgetManager.updateAppWidget(currentWidgetId, views);
            Toast.makeText(context, "widget added", Toast.LENGTH_SHORT).show();




        }





    }



    private void startTimer() {

        Timer timer;


        TimerTask minuteTask = new TimerTask() {

            @Override
            public void run() {

                timeGet();
                methodHH(String.valueOf(hou));
                methodMM(String.valueOf(min));
                // methodSS(String.valueOf(sec));
                Log.e("Tick", "tick");
            }
        };

        timer = new Timer();

        // schedule the task to run starting now and then every minute
        timer.scheduleAtFixedRate(minuteTask, 0l, 1000 );


    }

    private void methodMM(String s) {
        String h1,h2;

        if(s.length() == 2) {
            h1 =s.substring(0,1);
            h2 =s.substring(1);
        }
        else
        {
            h1 ="0";
            h2 =s.substring(0);
        }
        int h1_int,h2_int;

        h1_int = Integer.parseInt(h1);
        h2_int = Integer.parseInt(h2);
        Log.e("values1:",String.valueOf(h1_int));
        Log.e("values2:",String.valueOf(h2_int));
        switch(h1_int)
        {
            case 0:
                // img30.setBackgroundColor(color_block);
                // img20.setBackgroundColor(color_block);
                views.setInt(R.id.img02, "setBackgroundColor", color_block);
                views.setInt(R.id.img12, "setBackgroundColor", color_block);
                views.setInt(R.id.img22, "setBackgroundColor", color_block);
                views.setInt(R.id.img32, "setBackgroundColor", color_block);
                break;
            case 1:

                views.setInt(R.id.img02, "setBackgroundColor", color_block);
                views.setInt(R.id.img12, "setBackgroundColor", color_block);
                views.setInt(R.id.img22, "setBackgroundColor", color_block);
                views.setInt(R.id.img32, "setBackgroundColor", color_block2);
                break;
            case 2:
                views.setInt(R.id.img02, "setBackgroundColor", color_block);
                views.setInt(R.id.img12, "setBackgroundColor", color_block);
                views.setInt(R.id.img22, "setBackgroundColor", color_block2);
                views.setInt(R.id.img32, "setBackgroundColor", color_block);
                break;
            case 3:

                views.setInt(R.id.img02, "setBackgroundColor", color_block);
                views.setInt(R.id.img12, "setBackgroundColor", color_block);
                views.setInt(R.id.img22, "setBackgroundColor", color_block2);
                views.setInt(R.id.img32, "setBackgroundColor", color_block2);
                break;
            case 4:
                views.setInt(R.id.img02, "setBackgroundColor", color_block);
                views.setInt(R.id.img12, "setBackgroundColor", color_block2);
                views.setInt(R.id.img22, "setBackgroundColor", color_block);
                views.setInt(R.id.img32, "setBackgroundColor", color_block);
                break;
            case 5:
                views.setInt(R.id.img02, "setBackgroundColor", color_block);
                views.setInt(R.id.img12, "setBackgroundColor", color_block2);
                views.setInt(R.id.img22, "setBackgroundColor", color_block);
                views.setInt(R.id.img32, "setBackgroundColor", color_block2);
                break;
            case 6:
                views.setInt(R.id.img02, "setBackgroundColor", color_block);
                views.setInt(R.id.img12, "setBackgroundColor", color_block2);
                views.setInt(R.id.img22, "setBackgroundColor", color_block2);
                views.setInt(R.id.img32, "setBackgroundColor", color_block);
                break;
            case 7:
                views.setInt(R.id.img02, "setBackgroundColor", color_block);
                views.setInt(R.id.img12, "setBackgroundColor", color_block2);
                views.setInt(R.id.img22, "setBackgroundColor", color_block2);
                views.setInt(R.id.img32, "setBackgroundColor", color_block2);
                break;
            case 8:
                views.setInt(R.id.img02, "setBackgroundColor", color_block2);
                views.setInt(R.id.img12, "setBackgroundColor", color_block);
                views.setInt(R.id.img22, "setBackgroundColor", color_block);
                views.setInt(R.id.img32, "setBackgroundColor", color_block);
                break;
            case 9:
                views.setInt(R.id.img02, "setBackgroundColor", color_block2);
                views.setInt(R.id.img12, "setBackgroundColor", color_block);
                views.setInt(R.id.img22, "setBackgroundColor", color_block);
                views.setInt(R.id.img32, "setBackgroundColor", color_block2);
                break;



        }

        switch(h2_int)
        {
            case 0:
                views.setInt(R.id.img03, "setBackgroundColor", color_block);
                views.setInt(R.id.img13, "setBackgroundColor", color_block);
                views.setInt(R.id.img23, "setBackgroundColor", color_block);
                views.setInt(R.id.img33, "setBackgroundColor", color_block);
                break;
            case 1:
                /*img01.setBackgroundColor(color_block);
                img11.setBackgroundColor(color_block);
                img21.setBackgroundColor(color_block);
                img31.setBackgroundColor(color_block2);*/

                views.setInt(R.id.img03, "setBackgroundColor", color_block);
                views.setInt(R.id.img13, "setBackgroundColor", color_block);
                views.setInt(R.id.img23, "setBackgroundColor", color_block);
                views.setInt(R.id.img33, "setBackgroundColor", color_block2);
                break;
            case 2:
                /*img01.setBackgroundColor(color_block);
                img11.setBackgroundColor(color_block);
                img21.setBackgroundColor(color_block2);
                img31.setBackgroundColor(color_block);*/

                views.setInt(R.id.img03, "setBackgroundColor", color_block);
                views.setInt(R.id.img13, "setBackgroundColor", color_block);
                views.setInt(R.id.img23, "setBackgroundColor", color_block2);
                views.setInt(R.id.img33, "setBackgroundColor", color_block);
                break;
            case 3:
                /*img01.setBackgroundColor(color_block);
                img11.setBackgroundColor(color_block);
                img21.setBackgroundColor(color_block2);
                img31.setBackgroundColor(color_block2);*/

                views.setInt(R.id.img03, "setBackgroundColor", color_block);
                views.setInt(R.id.img13, "setBackgroundColor", color_block);
                views.setInt(R.id.img23, "setBackgroundColor", color_block2);
                views.setInt(R.id.img33, "setBackgroundColor", color_block2);
                break;
            case 4:
                /*img01.setBackgroundColor(color_block);
                img11.setBackgroundColor(color_block2);
                img21.setBackgroundColor(color_block);
                img31.setBackgroundColor(color_block);*/

                views.setInt(R.id.img03, "setBackgroundColor", color_block);
                views.setInt(R.id.img13, "setBackgroundColor", color_block2);
                views.setInt(R.id.img23, "setBackgroundColor", color_block);
                views.setInt(R.id.img33, "setBackgroundColor", color_block);
                break;
            case 5:
                /*img01.setBackgroundColor(color_block);
                img11.setBackgroundColor(color_block2);
                img21.setBackgroundColor(color_block);
                img31.setBackgroundColor(color_block2);*/

                views.setInt(R.id.img03, "setBackgroundColor", color_block);
                views.setInt(R.id.img13, "setBackgroundColor", color_block2);
                views.setInt(R.id.img23, "setBackgroundColor", color_block);
                views.setInt(R.id.img33, "setBackgroundColor", color_block2);
                break;
            case 6:
                /*img01.setBackgroundColor(color_block);
                img11.setBackgroundColor(color_block2);
                img21.setBackgroundColor(color_block2);
                img31.setBackgroundColor(color_block);*/

                views.setInt(R.id.img03, "setBackgroundColor", color_block);
                views.setInt(R.id.img13, "setBackgroundColor", color_block2);
                views.setInt(R.id.img23, "setBackgroundColor", color_block2);
                views.setInt(R.id.img33, "setBackgroundColor", color_block);
                break;
            case 7:
                /*img01.setBackgroundColor(color_block);
                img11.setBackgroundColor(color_block2);
                img21.setBackgroundColor(color_block2);
                img31.setBackgroundColor(color_block2);*/

                views.setInt(R.id.img03, "setBackgroundColor", color_block);
                views.setInt(R.id.img13, "setBackgroundColor", color_block2);
                views.setInt(R.id.img23, "setBackgroundColor", color_block2);
                views.setInt(R.id.img33, "setBackgroundColor", color_block2);
                break;
            case 8:
               /* img01.setBackgroundColor(color_block2);
                img11.setBackgroundColor(color_block);
                img21.setBackgroundColor(color_block);
                img31.setBackgroundColor(color_block);*/

                views.setInt(R.id.img03, "setBackgroundColor", color_block2);
                views.setInt(R.id.img13, "setBackgroundColor", color_block);
                views.setInt(R.id.img23, "setBackgroundColor", color_block);
                views.setInt(R.id.img33, "setBackgroundColor", color_block);
                break;
            case 9:
               /* img01.setBackgroundColor(color_block2);
                img11.setBackgroundColor(color_block);
                img21.setBackgroundColor(color_block);
                img31.setBackgroundColor(color_block2);*/

                views.setInt(R.id.img03, "setBackgroundColor", color_block2);
                views.setInt(R.id.img13, "setBackgroundColor", color_block);
                views.setInt(R.id.img23, "setBackgroundColor", color_block);
                views.setInt(R.id.img33, "setBackgroundColor", color_block2);
                break;


        }
    }


    private void methodHH(String s) {
        String h1,h2;

        if(s.length() == 2) {
            h1 =s.substring(0,1);
            h2 =s.substring(1);
        }
        else
        {
            h1 ="0";
            h2 =s.substring(0);
        }
        int h1_int,h2_int;

        h1_int = Integer.parseInt(h1);
        h2_int = Integer.parseInt(h2);
        Log.e("values1:",String.valueOf(h1_int));
        Log.e("values2:",String.valueOf(h2_int));
        switch(h1_int)
        {
            case 0:
               // img30.setBackgroundColor(color_block);
               // img20.setBackgroundColor(color_block);
                views.setInt(R.id.img30, "setBackgroundColor", color_block);
                views.setInt(R.id.img20, "setBackgroundColor", color_block);
                break;
            case 1:
                //img30.setBackgroundColor(color_block2);
                //img20.setBackgroundColor(color_block);
                views.setInt(R.id.img30, "setBackgroundColor", color_block2);
                views.setInt(R.id.img20, "setBackgroundColor", color_block);
                break;
            case 2:
               // img30.setBackgroundColor(color_block);
               // img20.setBackgroundColor(color_block2);
                views.setInt(R.id.img30, "setBackgroundColor", color_block);
                views.setInt(R.id.img20, "setBackgroundColor", color_block2);
                break;

        }

        switch(h2_int)
        {
            case 0:
               /* img01.setBackgroundColor(color_block);
                img11.setBackgroundColor(color_block);
                img21.setBackgroundColor(color_block);
                img31.setBackgroundColor(color_block);*/

                views.setInt(R.id.img01, "setBackgroundColor", color_block);
                views.setInt(R.id.img11, "setBackgroundColor", color_block);
                views.setInt(R.id.img21, "setBackgroundColor", color_block);
                views.setInt(R.id.img31, "setBackgroundColor", color_block);
                break;
            case 1:
                /*img01.setBackgroundColor(color_block);
                img11.setBackgroundColor(color_block);
                img21.setBackgroundColor(color_block);
                img31.setBackgroundColor(color_block2);*/

                views.setInt(R.id.img01, "setBackgroundColor", color_block);
                views.setInt(R.id.img11, "setBackgroundColor", color_block);
                views.setInt(R.id.img21, "setBackgroundColor", color_block);
                views.setInt(R.id.img31, "setBackgroundColor", color_block2);
                break;
            case 2:
                /*img01.setBackgroundColor(color_block);
                img11.setBackgroundColor(color_block);
                img21.setBackgroundColor(color_block2);
                img31.setBackgroundColor(color_block);*/

                views.setInt(R.id.img01, "setBackgroundColor", color_block);
                views.setInt(R.id.img11, "setBackgroundColor", color_block);
                views.setInt(R.id.img21, "setBackgroundColor", color_block2);
                views.setInt(R.id.img31, "setBackgroundColor", color_block);
                break;
            case 3:
                /*img01.setBackgroundColor(color_block);
                img11.setBackgroundColor(color_block);
                img21.setBackgroundColor(color_block2);
                img31.setBackgroundColor(color_block2);*/

                views.setInt(R.id.img01, "setBackgroundColor", color_block);
                views.setInt(R.id.img11, "setBackgroundColor", color_block);
                views.setInt(R.id.img21, "setBackgroundColor", color_block2);
                views.setInt(R.id.img31, "setBackgroundColor", color_block2);
                break;
            case 4:
                /*img01.setBackgroundColor(color_block);
                img11.setBackgroundColor(color_block2);
                img21.setBackgroundColor(color_block);
                img31.setBackgroundColor(color_block);*/

                views.setInt(R.id.img01, "setBackgroundColor", color_block);
                views.setInt(R.id.img11, "setBackgroundColor", color_block2);
                views.setInt(R.id.img21, "setBackgroundColor", color_block);
                views.setInt(R.id.img31, "setBackgroundColor", color_block);
                break;
            case 5:
                /*img01.setBackgroundColor(color_block);
                img11.setBackgroundColor(color_block2);
                img21.setBackgroundColor(color_block);
                img31.setBackgroundColor(color_block2);*/

                views.setInt(R.id.img01, "setBackgroundColor", color_block);
                views.setInt(R.id.img11, "setBackgroundColor", color_block2);
                views.setInt(R.id.img21, "setBackgroundColor", color_block);
                views.setInt(R.id.img31, "setBackgroundColor", color_block2);
                break;
            case 6:
                /*img01.setBackgroundColor(color_block);
                img11.setBackgroundColor(color_block2);
                img21.setBackgroundColor(color_block2);
                img31.setBackgroundColor(color_block);*/

                views.setInt(R.id.img01, "setBackgroundColor", color_block);
                views.setInt(R.id.img11, "setBackgroundColor", color_block2);
                views.setInt(R.id.img21, "setBackgroundColor", color_block2);
                views.setInt(R.id.img31, "setBackgroundColor", color_block);
                break;
            case 7:
                /*img01.setBackgroundColor(color_block);
                img11.setBackgroundColor(color_block2);
                img21.setBackgroundColor(color_block2);
                img31.setBackgroundColor(color_block2);*/

                views.setInt(R.id.img01, "setBackgroundColor", color_block);
                views.setInt(R.id.img11, "setBackgroundColor", color_block2);
                views.setInt(R.id.img21, "setBackgroundColor", color_block2);
                views.setInt(R.id.img31, "setBackgroundColor", color_block2);
                break;
            case 8:
               /* img01.setBackgroundColor(color_block2);
                img11.setBackgroundColor(color_block);
                img21.setBackgroundColor(color_block);
                img31.setBackgroundColor(color_block);*/

                views.setInt(R.id.img01, "setBackgroundColor", color_block2);
                views.setInt(R.id.img11, "setBackgroundColor", color_block);
                views.setInt(R.id.img21, "setBackgroundColor", color_block);
                views.setInt(R.id.img31, "setBackgroundColor", color_block);
                break;
            case 9:
               /* img01.setBackgroundColor(color_block2);
                img11.setBackgroundColor(color_block);
                img21.setBackgroundColor(color_block);
                img31.setBackgroundColor(color_block2);*/

                views.setInt(R.id.img01, "setBackgroundColor", color_block2);
                views.setInt(R.id.img11, "setBackgroundColor", color_block);
                views.setInt(R.id.img21, "setBackgroundColor", color_block);
                views.setInt(R.id.img31, "setBackgroundColor", color_block2);
                break;


        }
    }

    private void timeGet() {
        Calendar c = Calendar.getInstance();
        sec = c.get(Calendar.SECOND);
        min = c.get(Calendar.MINUTE);
        hou = c.get(Calendar.HOUR);
    }



    private void setColor_block() {
        color_block = Color.GRAY;
        color_block2 = Color.BLACK;
    }



}
