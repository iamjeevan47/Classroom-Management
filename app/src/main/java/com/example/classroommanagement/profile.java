package com.example.classroommanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class profile extends AppCompatActivity {
    Button upload;
    private static int SELECT_PICTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        upload = findViewById(R.id.upload);

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);
            }
        });

    }//endofoncreate

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && null != data)
        {
            Uri selctedImage = data.getData();
            String[] filepath = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(selctedImage, filepath, null, null, null);
            cursor.moveToFirst();

            int columnindex = cursor.getColumnIndex(filepath[0]);
            String picturepath = cursor.getString(columnindex);
            cursor.close();
            ImageView imageView = findViewById(R.id.profileimage);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturepath));
        }
        else
        {
            Toast.makeText(this, "Picture can't be uploaded", Toast.LENGTH_SHORT).show();
        }
    }
}//endofclass
