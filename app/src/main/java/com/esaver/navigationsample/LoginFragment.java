package com.esaver.navigationsample;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.esaver.navigationsample.databinding.FragmentLoginBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;
    private MySharedPrefUtil mySharedPrefUtil;
    private Context context;
    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_login, container, false);
        // view binding
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        mySharedPrefUtil = new MySharedPrefUtil(context);
        elementActions();
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        this.context = context;
        super.onAttach(context);
    }

    private void elementActions() {
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySharedPrefUtil.updateIsLoggedIn(true);
                moveScreen();
            }
        });
    }

    private void moveScreen() {
        NavHostFragment.findNavController(this).navigate(R.id.action_loginFragment_to_homeActivity);
    }
}
