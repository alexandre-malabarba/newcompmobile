package com.example.xandcompmobile.view.UML.uniritter.presenter;

import android.content.Intent;
import com.example.xandcompmobile.view.UML.uniritter.model.User;
import com.example.xandcompmobile.view.UML.uniritter.repository.UserDataBase;
import com.example.xandcompmobile.view.UML.uniritter.view.LoginActivity;
import java.util.List;

public class CadastroPresenter implements PresenterContract.presenterCadastro {
    private static final String tagLog = "CadastroPresenter";

    private PresenterContract.view view;
    public CadastroPresenter(PresenterContract.view view) { this.view = view; }


    @Override
    public void telaLogin() {
        Intent intent = new Intent(view.getActivity(), LoginActivity.class);
        view.getActivity().startActivity(intent);
    }


    @Override
    public void criarUsuario(String nome, String login, String senha) {
        List<User> users = UserDataBase.getUsers();
        users.add(new User(users.size()+1, nome, login, senha));
        this.telaLogin();
        view.message("USUARIO CRIADO");
    }
}
