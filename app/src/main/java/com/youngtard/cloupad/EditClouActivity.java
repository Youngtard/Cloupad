package com.youngtard.cloupad;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.youngtard.cloupad.fragment.ClousFragment;
import com.youngtard.cloupad.fragment.RemindersFragment;
import com.youngtard.cloupad.room.Clou;
import com.youngtard.cloupad.room.ClouDatabase;

public class EditClouActivity extends AppCompatActivity {
    private FloatingActionButton saveClou;
    private EditText clouTitleEntered;
    private EditText clouContentEntered;
    private String clouTitle;
    private String clouContent;

    private ClouDatabase clouDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_clou);

        getSupportActionBar().setTitle("Clou");

        saveClou = findViewById(R.id.fab_save_clou);
        clouTitleEntered = findViewById(R.id.et_title_entered);
        clouContentEntered = findViewById(R.id.et_content_entered);

        //Use getApplicationContext?
        clouDatabase = ClouDatabase.getInstance(this);

        saveClou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clouTitle = clouTitleEntered.getText().toString();
                clouContent = clouContentEntered.getText().toString();

                //Toast that clou saved after clicking save
                Clou clou = new Clou(clouTitle, clouContent);
                clouDatabase.clouDao().insertClou(clou);
                finish();
            }
        });
//        clouTitleEntered = findViewById(R.id.et_title_entered);
//        clouContentEntered = findViewById(R.id.et_content_entered);
//
//
//
//        saveClou.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ClousFragment clousFragment = new  ClousFragment();
//                String clouTitle = clouTitleEntered.getText().toString();
//                String clouContent = clouContentEntered.getText().toString();
//                Bundle bundle = new Bundle();
//                bundle.putString("Title", clouTitle);
//                bundle.putString("Content", clouContent);
////                Intent intent = new Intent(EditClouActivity.this, g);
////                intent.putExtra("Title", clouTitle);
////                intent.putExtra("Content", clouContent);
//                clousFragment.setArguments(bundle);
////                startActivity(intent);
//                FragmentTransaction transaction = getSupportFragmentManager()
//                        .beginTransaction();
//                transaction.replace(R.id.fl, clousFragment);
//                transaction.commit();
//            }
//        });
    }
}
