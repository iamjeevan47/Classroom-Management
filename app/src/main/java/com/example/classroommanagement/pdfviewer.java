package com.example.classroommanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;
import android.content.Context;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class pdfviewer extends AppCompatActivity
{
    String url;
    PDFView pdfView;
    TextView textView;
    ProgressBar progressBar;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_pdfviewer);
        pdfView = findViewById(R.id.pdfview);
        textView = findViewById(R.id.appbartitle);
        progressBar = findViewById(R.id.progressbar);

        final String name = getIntent().getStringExtra("pdf");
        url = getIntent().getStringExtra("file");
        textView.setText(name);

//        progressBar.setVisibility(View.VISIBLE);
//        progressBar.setVisibility(View.GONE);
        new RetrivePDFStream(getApplicationContext()).execute(url);
    }

    @SuppressLint("StaticFieldLeak")
    class RetrivePDFStream extends AsyncTask<String, Void, InputStream> {

        Context context;
        String res;

        public RetrivePDFStream(Context context)
        {
            this.context = context;
        }

        @Override
        protected void onPostExecute(InputStream inputStream)
        {
            super.onPostExecute(inputStream);

            pdfView.fromStream(inputStream)
                    .enableAnnotationRendering(false)
                    .enableAntialiasing(true)
                    .enableDoubletap(true)
                    .swipeHorizontal(true)
                    .scrollHandle(null)
                    .enableSwipe(true)
                    .enableSwipe(true)
                    .password(null)
                    .defaultPage(0)
                    .spacing(0)
                    .load();

            System.out.println("Input Stream"+inputStream);
        }

        @Override
        protected InputStream doInBackground(String... strings)
        {
            InputStream inputStream = null;
            try
            {
                URL uri = new URL(strings[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) uri.openConnection();
                //if (urlConnection.getResponseCode() == 200) {
                inputStream = new BufferedInputStream(urlConnection.getInputStream());
                //}
            }
            catch (IOException e)
            {
                return null;
            }
            return inputStream;
        }
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
    }
}