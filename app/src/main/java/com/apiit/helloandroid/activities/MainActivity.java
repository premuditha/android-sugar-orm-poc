package com.apiit.helloandroid.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.apiit.helloandroid.R;
import com.apiit.helloandroid.models.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText mEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User user = new User();

        user.setUserName("Jhon");
        user.setPassword("User@123");

        try {
            // Saving the user to System.
            user.save();

            // Getting the users from the database by the Name.
            List<User> savedUser = User.find(User.class, "user_name = ?", "Jhon");
        } catch (Exception ex) {

            // Something went wrong.
            System.out.println(ex.getMessage());
        }
    }

    public void onSubmit(View v) {
        mEdit = findViewById(R.id.editText);
        String name = mEdit.getText().toString();

        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("NAME", name);

        startActivity(intent);
    }
}
