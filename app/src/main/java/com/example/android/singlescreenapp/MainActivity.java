package com.example.android.singlescreenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void openAddress_onClick(View view) {
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=NAMOT 504 Main Street San Diego, California 92123"));
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    public void makeCall_onClick(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "619-543-1234", null));
        startActivity(intent);
    }

    public void sendEmail_onClick(View view) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:guest_relations@namot.org"));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Queries");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Hi,\nmy name is ");
        if (emailIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(emailIntent);

        }
    }

    public void visitWebsite_onClick(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.www.namot.org")));
    }

}
