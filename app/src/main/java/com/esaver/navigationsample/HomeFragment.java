package com.esaver.navigationsample;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.esaver.navigationsample.databinding.FragmentHomeBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private MySharedPrefUtil mySharedPrefUtil;
    private Context context;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false);

        // view binding
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        mySharedPrefUtil = new MySharedPrefUtil(context);
        checkIfLoggedIn();
        elementActions();
        return view;
    }

    private void checkIfLoggedIn() {
        if(!mySharedPrefUtil.isLoggedIn()) {
            moveScreen();
        }
    }

    private void elementActions() {
        binding.btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySharedPrefUtil.updateIsLoggedIn(false);
                moveScreen();
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        this.context = context;
        super.onAttach(context);
    }

    private void moveScreen() {
        NavHostFragment.findNavController(this).navigate(R.id.action_homeFragment_to_loginActivity);
    }
}
