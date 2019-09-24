package com.serifgungor.httpurlconnection_internalstorage;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.serifgungor.httpurlconnection_internalstorage.Helper.ImageLibrary;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ImageLibrary il;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        il = new ImageLibrary();
        iv = findViewById(R.id.imageView);

        new AsyncTask<Void,Void,Void>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                //resmi göster
                iv.setImageBitmap(il.loadImageFromStorage("/data/data/"+getPackageName()+"/app_imageDir","test.jpg"));
            }

            @Override
            protected Void doInBackground(Void... voids) {
                //eğer yoksa resmi indir
                if(il.isImageInStorage("/data/data/"+getPackageName()+"/app_imageDir","test.jpg")==false){

                    Bitmap bitmap = il.getBitmapFromURL("https://cdn-images-1.medium.com/max/2000/1*ldlq-6Z5tf2yE9R1EjoEdg.jpeg");
                    il.saveImageToInternalStorage(bitmap,"test.jpg",getApplicationContext());

                }


                return null;
            }
        }.execute();



    }
}
