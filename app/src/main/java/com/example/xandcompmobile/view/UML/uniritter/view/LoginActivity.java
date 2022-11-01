package com.example.xandcompmobile.view.UML.uniritter.view;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.xandcompmobile.R;
import com.example.xandcompmobile.view.UML.uniritter.presenter.LoginPresenter;
import com.example.xandcompmobile.view.UML.uniritter.presenter.PresenterContract;
import com.example.xandcompmobile.view.UML.uniritter.repository.UserDataBase;

public class LoginActivity extends AppCompatActivity implements PresenterContract.view {
    private static final String tagLog = "LoginActivity";
    private PresenterContract.presenterLogin presenterLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.d(tagLog, tagLog+"/onCreate");

        this.presenterLogin = new LoginPresenter(this);

        ((Button)findViewById(R.id.btEntrar)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(tagLog, "/onClick botao login");
                presenterLogin.verificaUsuario(
                        ((EditText)findViewById(R.id.etLoginLogin)).getText().toString(),
                        ((EditText)findViewById(R.id.etSenhaLogin)).getText().toString()
                );
            }
        });

        ((Button)findViewById(R.id.btTelaCadastro)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(tagLog, "/onClick botao para tela cadastro");
                presenterLogin.telaCadastro();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tagLog, tagLog+"/onResume");
    }

    @Override
    public void message(String msg) { Toast.makeText(this, msg, Toast.LENGTH_LONG).show(); }

    @Override
    public Activity getActivity() {
        return this;
    }


    public void logUsers() {
        for (int i = 0; i< UserDataBase.getUsers().size(); i++){
            Log.d("users",
                    "ID: "+Integer.toString(UserDataBase.getUsers().get(i).getId())+
                            " | Nome: "+UserDataBase.getUsers().get(i).getNome().toString()+
                            " | Login: "+UserDataBase.getUsers().get(i).getLogin().toString()
            );
        }
    }
}