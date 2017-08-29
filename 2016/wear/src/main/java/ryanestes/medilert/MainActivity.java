package ryanestes.medilert;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.wearable.view.WatchViewStub;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;

import java.util.List;

public class MainActivity extends Activity {

    private static final int SPEECH_RECOGNIZER_REQUEST_CODE = 3000;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.text);
                displaySpeechRecognizer();
            }
        });
    }

    private void displaySpeechRecognizer() {
        Intent intent = new Intent
                (RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                "What That\nMouth do?");
        startActivityForResult(intent,
                SPEECH_RECOGNIZER_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode, Intent data) {
        if (requestCode == SPEECH_RECOGNIZER_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                List<String> results =
                        data.getStringArrayListExtra
                                (RecognizerIntent.EXTRA_RESULTS);
                String spokenText = results.get(0);
                mTextView.setText(spokenText);

            }
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
