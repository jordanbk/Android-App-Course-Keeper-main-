package com.example.course_keeper_capstone.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.course_keeper_capstone.DAO.UserDAO;
import com.example.course_keeper_capstone.Database.DatabaseBuilder;
import com.example.course_keeper_capstone.Database.Repository;
import com.example.course_keeper_capstone.Entity.User;
import com.example.course_keeper_capstone.R;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    EditText editUsername, editPassword;
    Button buttonLogin;
    TextView textViewSignUp;
    Repository repo;
    DatabaseBuilder database;
    String username;
    UserDAO db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Repository repo = new Repository(getApplication());
        editUsername = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        textViewSignUp = findViewById(R.id.textRegister);
        buttonLogin = findViewById(R.id.buttonLogin);


        textViewSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SignUpActivity.class));
            }
        });
//repo.isValidAccount(username, password
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editUsername.getText().toString().trim();
                String password = editPassword.getText().toString().trim();
                List<User> user = repo.getAllUsers();
                for(User u : repo.getAllUsers()) {
                    if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    intent.putExtra("username", username);
                    startActivity(intent);
                    finish();
                    }
                }
            }
        });

    }
}