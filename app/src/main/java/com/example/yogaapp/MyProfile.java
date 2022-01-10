package com.example.yogaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class MyProfile extends AppCompatActivity {
    FirebaseFirestore db;
    TextView profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        profile=findViewById(R.id.age);

        db = FirebaseFirestore.getInstance();

        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Toast.makeText(MyProfile.this, "Conected successfuly to db"+document.getId() + " => " + document.getData(), Toast.LENGTH_LONG).show();
                                profile.setText(document.getData().toString());
                            }
                        } else {
                            Toast.makeText(MyProfile.this,  "Error getting documents."+task.getException(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

}