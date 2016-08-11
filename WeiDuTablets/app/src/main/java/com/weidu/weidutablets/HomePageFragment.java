package com.weidu.weidutablets;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * A placeholder fragment containing a simple view.
 */
public class HomePageFragment extends Fragment {
    ImageView good0;
    ImageView good1;
    ImageView good2;
    ImageView good3;
    CheckBox checkBox0;
    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    Button getinfo;
    ArrayList<Character> array = new ArrayList<>();
    int count = 0;
    String toast = "You can only compare 2 tablets.";
    static final int request = 1;
    public HomePageFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_page, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        good0 = (ImageView)getActivity().findViewById(R.id.good0);
        good1 = (ImageView)getActivity().findViewById(R.id.good1);
        good2 = (ImageView)getActivity().findViewById(R.id.good2);
        good3 = (ImageView)getActivity().findViewById(R.id.good3);
        good0.setVisibility(View.INVISIBLE);
        good1.setVisibility(View.INVISIBLE);
        good2.setVisibility(View.INVISIBLE);
        good3.setVisibility(View.INVISIBLE);
        getinfo = (Button)getActivity().findViewById(R.id.button);
        getinfo.setEnabled(count!=0);
        checkBox0 = (CheckBox)getActivity().findViewById(R.id.checkBox0);
        checkBox1 = (CheckBox)getActivity().findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox)getActivity().findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox)getActivity().findViewById(R.id.checkBox3);
        checkBox0.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(checkBox0.isChecked()){
                    count++;
                    if(count>=3){
                        Toast.makeText(getActivity(),toast,Toast.LENGTH_SHORT).show();
                        checkBox0.setChecked(false);
                        count--;
                        return;
                    }
                    array.add('0');
                } else {
                    if(count>0) count--;
                    array.remove((Character) '0');
                }
                getinfo.setEnabled(count!=0);
            }
        });
        checkBox1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(checkBox1.isChecked()){
                    count++;
                    if(count>=3){
                        Toast.makeText(getActivity(),toast,Toast.LENGTH_SHORT).show();
                        checkBox1.setChecked(false);
                        count--;
                        return;
                    }
                    array.add('1');
                } else {
                    if(count>0) count--;
                    array.remove((Character)'1');
                }
                getinfo.setEnabled(count!=0);
            }
        });
        checkBox2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(checkBox2.isChecked()){
                    count++;
                    if(count>=3){
                        Toast.makeText(getActivity(),toast,Toast.LENGTH_SHORT).show();
                        checkBox2.setChecked(false);
                        count--;
                        return;
                    }
                    array.add('2');
                } else {
                    if(count>0) count--;
                    array.remove((Character)'2');
                }
                getinfo.setEnabled(count!=0);
            }
        });
        checkBox3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(checkBox3.isChecked()){
                    count++;
                    if(count>=3){
                        Toast.makeText(getActivity(),toast,Toast.LENGTH_SHORT).show();
                        checkBox3.setChecked(false);
                        count--;
                        return;
                    }
                    array.add('3');
                } else {
                    if(count>0) count--;
                    array.remove((Character)'3');
                }
                getinfo.setEnabled(count!=0);
            }
        });



        getinfo.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                lookmore(array);
            }
        });
    }




    public void lookmore(ArrayList array){
        Intent intent = new Intent(getActivity(),DetailPage.class);
            for(int i = 0; i< array.size();i++){
                if(i == 0) {
                    if ((Character) array.get(i) == '0') {
                        intent.putExtra(DetailPageFragment.imagel, R.drawable.google_nexus_9);
                        intent.putExtra(DetailPageFragment.namel, "Google Nexus 9");
                        intent.putExtra(DetailPageFragment.osl, "Android 5.0");
                        intent.putExtra(DetailPageFragment.dimensionl, "8.9 inch");
                        intent.putExtra(DetailPageFragment.weightl, "436 g");
                        intent.putExtra(DetailPageFragment.urll,"http://www.google.com/nexus/9/");
                    }
                    if ((Character) array.get(i) == '1') {
                        intent.putExtra(DetailPageFragment.imagel, R.drawable.apple_ipad_air);
                        intent.putExtra(DetailPageFragment.namel, "Apple iPad Air");
                        intent.putExtra(DetailPageFragment.osl, "iOS 9.0");
                        intent.putExtra(DetailPageFragment.dimensionl, "9.7 inch");
                        intent.putExtra(DetailPageFragment.weightl, "469 g");
                        intent.putExtra(DetailPageFragment.urll,"http://www.apple.com/ipad-air-2/");
                    }
                    if ((Character) array.get(i) == '2') {
                        intent.putExtra(DetailPageFragment.imagel, R.drawable.samsung_galaxy_tab_s);
                        intent.putExtra(DetailPageFragment.namel, "Samsung Galaxy Tab S");
                        intent.putExtra(DetailPageFragment.osl, "Android 4.4");
                        intent.putExtra(DetailPageFragment.dimensionl, "10.5 inch");
                        intent.putExtra(DetailPageFragment.weightl, "465 g");
                        intent.putExtra(DetailPageFragment.urll,"http://www.samsung.com/us/explore/tab-s2-features-and-specs/?cid=ppc-");
                    }
                    if ((Character) array.get(i) == '3') {
                        intent.putExtra(DetailPageFragment.imagel, R.drawable.nvidia_shield_tablet_k1);
                        intent.putExtra(DetailPageFragment.namel, "NVIDIA Shield Tablet K1");
                        intent.putExtra(DetailPageFragment.osl, "Android 4.4");
                        intent.putExtra(DetailPageFragment.dimensionl, "7.6 inch");
                        intent.putExtra(DetailPageFragment.weightl, "745 g");
                        intent.putExtra(DetailPageFragment.urll,"https://shield.nvidia.com/");
                    }
                }
                if( i == 1) {
                    if ((Character) array.get(i) == '0') {
                        intent.putExtra(DetailPageFragment.imager, R.drawable.google_nexus_9);
                        intent.putExtra(DetailPageFragment.namer, "Google Nexus 9");
                        intent.putExtra(DetailPageFragment.osr, "Android 5.0");
                        intent.putExtra(DetailPageFragment.dimensionr, "8.9 inch");
                        intent.putExtra(DetailPageFragment.weightr, "436 g");
                        intent.putExtra(DetailPageFragment.urlr,"http://www.google.com/nexus/9/");
                    }
                    if ((Character) array.get(i) == '1') {
                        intent.putExtra(DetailPageFragment.imager, R.drawable.apple_ipad_air);
                        intent.putExtra(DetailPageFragment.namer, "Apple iPad Air");
                        intent.putExtra(DetailPageFragment.osr, "iOS 9.0");
                        intent.putExtra(DetailPageFragment.dimensionr, "9.7 inch");
                        intent.putExtra(DetailPageFragment.weightr, "469 g");
                        intent.putExtra(DetailPageFragment.urlr,"http://www.apple.com/ipad-air-2/");
                    }
                    if ((Character) array.get(i) == '2') {
                        intent.putExtra(DetailPageFragment.imager, R.drawable.samsung_galaxy_tab_s);
                        intent.putExtra(DetailPageFragment.namer, "Samsung Galaxy Tab S");
                        intent.putExtra(DetailPageFragment.osr, "Android 4.4");
                        intent.putExtra(DetailPageFragment.dimensionr, "10.5 inch");
                        intent.putExtra(DetailPageFragment.weightr, "465 g");
                        intent.putExtra(DetailPageFragment.urlr,"http://www.samsung.com/us/explore/tab-s2-features-and-specs/?cid=ppc-");
                    }
                    if ((Character) array.get(i) == '3') {
                        intent.putExtra(DetailPageFragment.imager, R.drawable.nvidia_shield_tablet_k1);
                        intent.putExtra(DetailPageFragment.namer, "NVIDIA Shield Tablet K1");
                        intent.putExtra(DetailPageFragment.osr, "Android 4.4");
                        intent.putExtra(DetailPageFragment.dimensionr, "7.6 inch");
                        intent.putExtra(DetailPageFragment.weightr, "745 g");
                        intent.putExtra(DetailPageFragment.urlr,"https://shield.nvidia.com/");
                    }
                }
            }
        startActivityForResult(intent,request);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        checkBox0.setChecked(false);
        checkBox1.setChecked(false);
        checkBox2.setChecked(false);
        checkBox3.setChecked(false);
        count = 0;
        if(requestCode == request){
            if(resultCode == Activity.RESULT_OK){
                if(data.hasExtra(DetailPageFragment.likeleft)){
                    boolean likeleft = data.getBooleanExtra(DetailPageFragment.likeleft,false);
                    if(likeleft){
                        switch(array.get(0)){
                            case '0':
                                good0.setVisibility(View.VISIBLE);
                                break;
                            case '1':
                                good1.setVisibility(View.VISIBLE);
                                break;
                            case '2':
                                good2.setVisibility(View.VISIBLE);
                                break;
                            case '3':
                                good3.setVisibility(View.VISIBLE);
                                break;
                        }
                    }
                }
                if(data.hasExtra(DetailPageFragment.likeright)){
                    boolean likeright = data.getBooleanExtra(DetailPageFragment.likeright,false);
                    if(likeright){
                        switch(array.get(1)){
                            case '0':
                                good0.setVisibility(View.VISIBLE);
                                break;
                            case '1':
                                good1.setVisibility(View.VISIBLE);
                                break;
                            case '2':
                                good2.setVisibility(View.VISIBLE);
                                break;
                            case '3':
                                good3.setVisibility(View.VISIBLE);
                                break;
                        }
                    }
                }
            }
        }
    }
}
