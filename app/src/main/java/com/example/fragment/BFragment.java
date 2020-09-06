package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.view.View;
import android.view.ViewGroup;

public class BFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BFragment newInstance(String param1, String param2) {
        BFragment fragment = new BFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private ArrayAdapter majorAdapter;
    private Spinner majorSpinner;

    private String college = "";
    private String major = "";



    @Override
    public void onActivityCreated(Bundle b){
        super.onActivityCreated(b);

        final RadioGroup collegeGroup = (RadioGroup) getView().findViewById(R.id.collegeGroup);
        majorSpinner = (Spinner) getView().findViewById(R.id.majorSpinner);

        collegeGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton collegeButton = (RadioButton) getView().findViewById(i);
                college = collegeButton.getText().toString();

                if (college.equals("인문대학")) {
                    majorAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.hcArea, android.R.layout.simple_spinner_dropdown_item);
                    majorSpinner.setAdapter(majorAdapter);
                }
                if (college.equals("자연과학대학")) {
                    majorAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.nscArea, android.R.layout.simple_spinner_dropdown_item);
                    majorSpinner.setAdapter(majorAdapter);
                }
                if (college.equals("공과대학")) {
                    majorAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.ecArea, android.R.layout.simple_spinner_dropdown_item);
                    majorSpinner.setAdapter(majorAdapter);
                }
                if (college.equals("교양")) {
                    majorAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.acArea, android.R.layout.simple_spinner_dropdown_item);
                    majorSpinner.setAdapter(majorAdapter);
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b, container, false);
    }
}