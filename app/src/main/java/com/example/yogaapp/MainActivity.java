package com.example.yogaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class MainActivity extends AppCompatActivity {

    Button button1,button2;

    FirebaseFirestore db;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Toolbar toolbar =findViewById(R.id.toolBar);
       setSupportActionBar(toolbar);

       mAuth=FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        button1=findViewById(R.id.startyoga1);
        button2=findViewById(R.id.startyoga2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SecondActivity2.class);
                startActivity(intent);
            }
        });


    }


    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user=mAuth.getCurrentUser();
        if (user==null)
            startActivity(new Intent(MainActivity.this,LogIn.class));
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

        if(id == R.id.logOut){

            mAuth.signOut();
            startActivity(new Intent(MainActivity.this,LogIn.class));
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
                                    Toast.makeText(MainActivity.this, "Conected successfuly to db"+document.getId() + " => " + document.getData(), Toast.LENGTH_LONG).show();
                                }
                            } else {
                                Toast.makeText(MainActivity.this,  "Error getting documents."+task.getException(), Toast.LENGTH_LONG).show();
                            }
                        }
                    });

            startActivity(new Intent(MainActivity.this,MyProfile.class));

            return true;
        }

        return true;
    }

    public void beforeage18(View view) {
        Intent intent=new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);
    }

    public void afterage18(View view) {
        Intent intent=new Intent(MainActivity.this,SecondActivity2.class);
        startActivity(intent);
    }

    public void food(View view) {
        Intent intent=new Intent(MainActivity.this,FoodActivity.class);
        startActivity(intent);
    }
}