package com.example.yccollage.ebook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;

import com.example.yccollage.R;
import com.github.barteksc.pdfviewer.PDFView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Stream;

import static android.net.wifi.WifiConfiguration.Status.strings;

public class PdfViewer extends AppCompatActivity {
    private String url;
    private PDFView pdfView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer);

        url=getIntent().getStringExtra("pdfurl");

        pdfView = findViewById(R.id.pdfview);


        new pdfdown().execute(url);
    }
    private class pdfdown extends AsyncTask<String,Void, InputStream>{

        private Object InputStream;
        @Override
        protected java.io.InputStream doInBackground(String... String) {
            InputStream inputStream = null;

            try {
                URL url =  new URL(strings[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                if(urlConnection.getResponseCode()==200){
                    inputStream =new BufferedInputStream(urlConnection.getInputStream());

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return inputStream;

        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            pdfView.fromStream((java.io.InputStream) InputStream).load();
        }
    }
}