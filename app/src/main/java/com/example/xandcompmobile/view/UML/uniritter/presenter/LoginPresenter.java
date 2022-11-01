package com.example.xandcompmobile.view.UML.uniritter.presenter;

import android.content.Intent;
import android.util.Log;

import com.example.xandcompmobile.view.UML.uniritter.model.User;
import com.example.xandcompmobile.view.UML.uniritter.repository.UserDataBase;
import com.example.xandcompmobile.view.UML.uniritter.view.CadastroActivity;
import com.example.xandcompmobile.view.UML.uniritter.view.PerfilUserActivity;


public class LoginPresenter implements PresenterContract.presenterLogin{
    private static final String tagLog = "LoginPresenter";

    private PresenterContract.view view;
    public LoginPresenter(PresenterContract.view view) { this.view = view; }



    @Override
    public void verificaUsuario(String login, String senha) {
        Log.d(tagLog, tagLog+"/verificaUser");

        String sLogin, sSenha;
        for (int i = 0; i< UserDataBase.getUsers().size(); i++){
            User user = UserDataBase.getUsers().get(i);
            sLogin = UserDataBase.getUsers().get(i).getLogin();
            sSenha = UserDataBase.getUsers().get(i).getSenha();

            if (sLogin.equals(login) && sSenha.equals(senha)){
                this.usuarioValido(user);
                break;
            }else{

                Log.d(tagLog, tagLog+"/USUARIO NÃO É VALIDO");
            }
        }
    }

    @Override
    public void usuarioValido(User user) {
        Log.d(tagLog, tagLog+"/USUARIO É VALIDO");;
        Intent intent = new Intent(view.getActivity(), PerfilUserActivity.class);
        intent.putExtra("USER_OBJECT", user);
        view.getActivity().startActivity(intent);
        view.message("USUARIO VÁLIDO");
    }

    @Override
    public void telaCadastro() {
        Intent intent = new Intent(view.getActivity(), CadastroActivity.class);
        view.getActivity().startActivity(intent);
    }
}

