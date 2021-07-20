package com.example.bank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class details extends AppCompatActivity {

    FirebaseDatabase fdb=FirebaseDatabase.getInstance();
    TextView n,a,in,j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent i=getIntent();
        String r=i.getStringExtra("nameoflist");
        DatabaseReference ref=fdb.getReference(r);
        n=findViewById(R.id.textView2);
        a=findViewById(R.id.textView3);
        in=findViewById(R.id.textView4);
        j=findViewById(R.id.textView5);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name= snapshot.child("name").getValue(String.class);
                String add=snapshot.child("add").getValue(String.class);
                String income=snapshot.child("income").getValue(String.class);
                String job=snapshot.child("job type").getValue(String.class);
                System.out.println(name+add);
                n.setText("NAME : "+name);
                a.setText("ADDRESS : "+add);
                in.setText("INCOME : "+income);
                j.setText("JOB TYPE : "+job);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}