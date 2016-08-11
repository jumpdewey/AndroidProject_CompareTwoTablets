package com.weidu.weidutablets;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailPageFragment extends Fragment {
    ImageView image0;
    ImageView image1;
    TextView name0;
    TextView name1;
    TextView os0;
    TextView os1;
    TextView dimension0;
    TextView dimension1;
    TextView weight0;
    TextView weight1;
    Button back;
    Button like0;
    Button like1;
    public static String imagel = "imagel";
    public static String imager = "imager";
    public static String namel = "namel";
    public static String namer = "namer";
    public static String osl = "osl";
    public static String osr = "osr";
    public static String dimensionl = "dimensionl";
    public static String dimensionr = "dimensionr";
    public static String weightl = "weightl";
    public static String weightr = "weightr";
    public static String likeleft = "likeleft";
    public static String likeright = "likeright";
    public static String urll = "urll";
    public static String urlr = "urlr";
    public boolean ll = false;
    public boolean lr = false;
    public DetailPageFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail_page, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        image0 = (ImageView)getActivity().findViewById(R.id.image0);
        image1 = (ImageView)getActivity().findViewById(R.id.image1);

        name0 = (TextView)getActivity().findViewById(R.id.name0);
        name1 = (TextView)getActivity().findViewById(R.id.name1);
        os0 = (TextView)getActivity().findViewById(R.id.os0);
        os1 = (TextView)getActivity().findViewById(R.id.os1);
        dimension0 = (TextView)getActivity().findViewById(R.id.dimension0);
        dimension1 = (TextView)getActivity().findViewById(R.id.dimension1);
        weight0 = (TextView)getActivity().findViewById(R.id.weight0);
        weight1 = (TextView)getActivity().findViewById(R.id.weight1);
        back = (Button)getActivity().findViewById(R.id.back);
        like0 = (Button)getActivity().findViewById(R.id.like0);
        like1 = (Button)getActivity().findViewById(R.id.like1);
        like0.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                ll = true;
            }
        });
        like1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                lr = true;
            }
        });
        Intent intent = getActivity().getIntent();
        final Bundle bundle = intent.getExtras();
        if(bundle!=null){
            String nl = bundle.getString(namel);
            String nr = bundle.getString(namer);
            String ol = bundle.getString(osl);
            String or = bundle.getString(osr);
            String dl = bundle.getString(dimensionl);
            String dr = bundle.getString(dimensionr);
            String wl = bundle.getString(weightl);
            String wr = bundle.getString(weightr);
            name0.setText(!TextUtils.isEmpty(nl)?nl:"Unknown");
            name1.setText(!TextUtils.isEmpty(nr)?nr:"");
            os0.setText(!TextUtils.isEmpty(ol)?ol:"Unknown");
            os1.setText(!TextUtils.isEmpty(or)?or:"");
            dimension0.setText(!TextUtils.isEmpty(dl)?dl:"Unknown");
            dimension1.setText(!TextUtils.isEmpty(dr)?dr:"");
            weight0.setText(!TextUtils.isEmpty(wl)?wl:"Unknown");
            weight1.setText(!TextUtils.isEmpty(wr)?wr:"");
            int il = (int)bundle.getInt(imagel, -1);
            if (il > -1){
                image0.setImageResource(il);
            }
            int ir = (int)bundle.getInt(imager,-1);
            if (ir > -1){
                image1.setImageResource(ir);
            }
            if(TextUtils.isEmpty(nr)){
                LinearLayout ll = (LinearLayout)getActivity().findViewById(R.id.detailll1);
                ll.setVisibility(View.INVISIBLE);
            }
        }
        image0.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String url = "";
                Intent myIntent = new Intent();
                myIntent.setAction(Intent.ACTION_VIEW);
                if(bundle!=null) url = bundle.getString(urll);
                myIntent.setData(Uri.parse(url));
                startActivity(myIntent);
            }
        });
        image1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String url = "";
                Intent myIntent = new Intent();
                myIntent.setAction(Intent.ACTION_VIEW);
                if(bundle!=null) url = bundle.getString(urlr);
                myIntent.setData(Uri.parse(url));
                startActivity(myIntent);
            }
        });
        back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent data = new Intent();
                data.putExtra(likeleft,ll);
                data.putExtra(likeright,lr);
                getActivity().setResult(Activity.RESULT_OK,data);
                getActivity().finish();
            }
        });
    }
}
