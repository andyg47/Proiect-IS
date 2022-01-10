package com.example.yogaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class SecondActivity2 extends AppCompatActivity {

    FirebaseFirestore db;
    int[] newArray;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seccond);

        Toolbar toolbar=findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        mAuth=FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        newArray=new int[]{
                R.id.bow_pose,R.id.bridge_pose,R.id.chair_pose,R.id.child_pose,R.id.cobbler_pose,
                R.id.cow_pose,R.id.playji_pose,R.id.pauseji_pose,R.id.crunches_pose ,R.id.plank_pose,
                R.id.situp_pose,R.id.rotation_pose,R.id.twist_pose,R.id.windmill_pose,R.id.legup_pose
        };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return  true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id == R.id.id_privacy){

            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://trueyouweightloss.com/privacy-policy/"));
            startActivity(intent);

            return true;
        }

        if(id == R.id.id_term){
            Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://en.wikipedia.org/wiki/Weight_loss"));
            startActivity(intent);

            return true;
        }

        if(id == R.id.rate){

            try {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("market://details?id="+getPackageName())));
            }catch (Exception ex){
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id="+ getPackageName())));
            }

            return true;
        }

        if(id == R.id.more){

            Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/search?q=fitness&c=apps&gl=RO"));
            startActivity(intent);

            return true;
        }

        if(id == R.id.share){

            Intent myIntent = new Intent(Intent.ACTION_SEND);
            myIntent.setType("text/plain");
            String sharebody="This is the best for yoga\n By this app you streach your body \n this is the free download Now\n" + "https://play.google.com/store/apps/details?id=com.example.yogaapp&h1=en";

            String sharehub="Yoga App";
            myIntent.putExtra(Intent.EXTRA_SUBJECT,sharehub);
            myIntent.putExtra(Intent.EXTRA_TEXT,sharebody);
            startActivity(Intent.createChooser(myIntent,"share using"));


            return true;
        }
        if(id == R.id.myProfile){

            db.collection("users")
                    .get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    Toast.makeText(SecondActivity2.this, "Conected successfuly to db"+document.getId() + " => " + document.getData(), Toast.LENGTH_LONG).show();
                                }
                            } else {
                                Toast.makeText(SecondActivity2.this,  "Error getting documents."+task.getException(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });

            startActivity(new Intent(SecondActivity2.this,MyProfile.class));

            return true;
        }
        if(id == R.id.logOut){

            mAuth.signOut();
            startActivity(new Intent(SecondActivity2.this,LogIn.class));
            return true;
        }

        return true;
    }

    public void Imagebuttonclicked(View view) {
        for (int i=0;i<newArray.length;i++){
            if (view.getId() == newArray[i]){
                int value=i++;
                Log.i("FIRST",String.valueOf(value));
                Intent intent = new Intent(SecondActivity2.this,ThirdActivity2.class);
                intent.putExtra("value",String.valueOf(value));
                startActivity(intent);
            }
        }
    }
}