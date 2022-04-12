package com.example.practiceseven;

import android.app.Activity;
import android.app.usage.UsageEvents;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;
import java.util.List;


public class MainActivity extends Activity {

    @Override

    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Привязываем компоненты к соответствующим объектам
        // назначая их идентификаторы
        // с помощью метода findViewById ()

        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);
        Button button4 = (Button)findViewById(R.id.button4);



        // реализация события onClick для неявного намерения

        button1.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v)

            {
               // выполнение действия по открытию веб-страницы
                Uri url = Uri.parse("https://sun1-88.userapi.com/impf/Y9GQVQtnE0hWityvT8SRhPro8AvoS1nFjFPV-A/bZzlZqXMLlc.jpg?size=736x885&quality=95&sign=6a2996ae6a52f0c67fcd2502ff3e106b&type=album");
                Intent intent = new Intent(Intent.ACTION_VIEW, url);
                startActivity(intent);

            }

        });

        button2.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v)

            {
                // выполнение действия по открытию веб-страницы
                Uri location = Uri.parse("geo:53.055748, 102.896304");
                Intent intent1 = new Intent(Intent.ACTION_VIEW, location);
                startActivity(intent1);
            }

        });

        button3.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v)

            {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"john@mail.ru"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email subject");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message text");
                emailIntent.putExtra(Intent.EXTRA_STREAM,Uri.parse("content://path/to/email/attachment"));
                startActivity(emailIntent);

            }

        });

        button4.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v)

            {
                Intent calendarIntent = new Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI);Calendar beginTime = Calendar.getInstance();
                beginTime.set(2022, 04, 19, 7, 30);
                Calendar endTime = Calendar.getInstance();
                endTime.set(2022, 04, 19, 8, 30);
                calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,beginTime.getTimeInMillis());
                calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,endTime.getTimeInMillis());
                calendarIntent.putExtra(CalendarContract.Events.TITLE, "Ninja class");
                calendarIntent.putExtra(CalendarContract.Events.EVENT_LOCATION,"Secret dojo");
                startActivity(calendarIntent);


            }

        });

    }

}