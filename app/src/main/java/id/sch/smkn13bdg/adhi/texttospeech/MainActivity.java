package id.sch.smkn13bdg.adhi.texttospeech;

import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Button btnbicara;
    EditText sumbertxt;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnbicara = (Button) findViewById(R.id.btnspeak);
        sumbertxt = (EditText) findViewById(R.id.textisi);


        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i != TextToSpeech.ERROR) {
                    Locale locIndo = new Locale("id", "IND");
                    textToSpeech.setLanguage(locIndo);
                    //menggunakan bahasa US (amerika)

                }
            }
        });

        btnbicara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = sumbertxt.getText().toString();

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null,null);



                } else {
                    textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
                }

            }
        });
    }
}
