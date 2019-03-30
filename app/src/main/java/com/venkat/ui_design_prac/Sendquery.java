package com.venkat.ui_design_prac;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;

public class Sendquery extends AppCompatActivity {
    private EditText mValueField;
    private Button mAddBtn;
    private Firebase mRootRef;
    private EditText mKeyValue;
    private Firebase mRef;
    private ArrayList<String> mUsernames=new ArrayList<>();
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_sendquery);

        mRootRef=new Firebase("https://unscript-a222c.firebaseio.com/Userq");
        mValueField=(EditText)findViewById(R.id.et);
        mAddBtn=(Button)findViewById(R.id.bt);
        mKeyValue=(EditText)findViewById(R.id.et2);

        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value=mValueField.getText().toString();
                String key=mKeyValue.getText().toString();
                Firebase childRef=mRootRef.child(key);
                childRef.setValue(value);
            }
        });

        mRef=new Firebase("https://unscript-a222c.firebaseio.com/Userq");
        mListView=(ListView)findViewById(R.id.lstv5);
        final ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mUsernames);
        mListView.setAdapter(arrayAdapter);

        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String value=dataSnapshot.getValue(String.class);
                mUsernames.add(value);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }

}
