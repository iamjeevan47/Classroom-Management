package com.example.classroommanagement.manager;

import android.content.Context;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class FirebaseManager {
    private static FirebaseManager sSelf = null;
    private final Context mContext;

    private FirebaseFirestore mFirestore;
    private FirebaseAuth mAuth;


    public static FirebaseManager getInstance(Context context) {
        if (sSelf == null) {
            sSelf = new FirebaseManager(context);
        }
        return sSelf;
    }

    public FirebaseManager(Context mContext) {
        this.mContext = mContext;

        initFirestore();
        initFirebaseAuth();
    }

    private void initFirebaseAuth() {
        mAuth = FirebaseAuth.getInstance();
    }

    public FirebaseAuth getmAuth() {
        return mAuth;
    }

    private void initFirestore() {
        mFirestore = FirebaseFirestore.getInstance();
    }

    public FirebaseFirestore getFirestore() {
        return mFirestore;
    }
}
