package com.example.classroommanagement;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NotesupFragment extends Fragment {

    EditText pdf;
    Button uploadpdf, viewpdf;
//    StorageReference storageReference;
//    DatabaseReference databaseReference;

    public NotesupFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        getActivity().setTitle("Notes");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notesup, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        pdf = view.findViewById(R.id.pdfname);
        uploadpdf = view.findViewById(R.id.uploadpdf);
        viewpdf = view.findViewById(R.id.viewpdf);
//        storageReference = FirebaseStorage.getInstance().getReference();
//        databaseReference = FirebaseDatabase.getInstance().getReference("Notes");

        uploadpdf.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
//                selectPDFfile();
            }
        });

        viewpdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(getContext(),viewnotes.class));
            }
        });
    }
//
//    private void selectPDFfile()
//    {
//        Intent intent = new Intent();
//        intent.setType("application/pdf");
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(Intent.createChooser(intent,"Select PDF File"),1);
//    }
//
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data)
//    {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null)
//        {
//            uploadPDFFile (data.getData());
//        }
//    }
//
//    private void uploadPDFFile(Uri data)
//    {
//        final ProgressDialog progressDialog = new ProgressDialog(this);
//        progressDialog.setTitle("Uploading...");
//        progressDialog.show();
//
//        StorageReference reference = storageReference.child("Notes/"+System.currentTimeMillis()+".pdf");
//        reference.putFile(data).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>()
//                {
//                    @Override
//                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot)
//                        {
//                            Task<Uri> uri  = taskSnapshot.getStorage().getDownloadUrl();
//                            while (!uri.isComplete());
//                            Uri url = uri.getResult();
//
//                            timetablegettersetter uploadPDf = new timetablegettersetter(pdf.getText().toString(),url.toString());
//                            databaseReference.child(databaseReference.push().getKey()).setValue(uploadPDf);
//                            Toast.makeText(getContext(), "PDF Uploaded", Toast.LENGTH_SHORT).show();
//                            progressDialog.dismiss();
//                        }
//                }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>()
//                        {
//                            @Override
//                            public void onProgress(UploadTask.TaskSnapshot taskSnapshot)
//                            {
//                                double progress = (100.0*taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
//                                progressDialog.setMessage("Uploaded: "+(int)progress+"%");
//                            }
//                        });
//    }

}//classend