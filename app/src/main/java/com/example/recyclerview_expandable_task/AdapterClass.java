package com.example.recyclerview_expandable_task;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.icu.text.Normalizer2;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.UserHolder> {

    Context context;
    List<ModelClass> modelClassList=new ArrayList<>();
    double longitude=17.651268;
    double latitude=76.725182;

    public AdapterClass(Context context, List<ModelClass> modelClassList) {
        this.context = context;
        this.modelClassList = modelClassList;
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_recycler_layout,parent,false);

        return new UserHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {
        holder.tplace.setText(modelClassList.get(position).getPlace());
        holder.placeimage.setImageResource(modelClassList.get(position).getPlaceImage());
        holder.downarrow.setImageResource(modelClassList.get(position).getDownarrow());
        holder.callimage.setImageResource(modelClassList.get(position).getCallimage());
        holder.mapimg.setImageResource(modelClassList.get(position).getMapimage());
        holder.webimage.setImageResource(modelClassList.get(position).getWebsiteImage());



        boolean isExpand=modelClassList.get(position).isExpand();
        holder.expandableLayout.setVisibility(isExpand ? View.VISIBLE:View.GONE);

        holder.callimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    Intent intent=new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+modelClassList.get(holder.getAdapterPosition()).getPhoneNo()));
                   intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);

                    context.startActivity(intent);

                }catch (Exception e)
                {
                    e.printStackTrace();

                    Toast.makeText(context, ""+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

//        holder.webimage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                try{
//                    Intent intent=new Intent();
//                           intent.setAction(Intent.ACTION_VIEW);
//                          // intent.setData(Uri.parse("website:"+modelClassList.get(holder.getAdapterPosition()).getWebsite())) ;
//                    intent.setData(Uri.parse("http://www.google.com"));
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
//
//                    context.startActivity(intent);

//                    Intent intent=new Intent();
//                    intent.setAction(Intent.ACTION_VIEW);
//                    // intent.setData(Uri.parse("website:"+modelClassList.get(holder.getAdapterPosition()).getWebsite())) ;
//                    intent.setData(Uri.parse("website:"+modelClassList.get(holder.getAdapterPosition()).getWebsite()));
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                    context.startActivity(intent);

                    String url="";
                    Intent intent=new Intent();
//                    try {
//
//                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse(""+modelClassList.get(holder.getAdapterPosition()).getWebsite()));
//                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
//                        context.startActivity(intent);
//                    } catch ( final Exception e ) {
//                        url = "https://play.google.com/store/apps/details?id=com.myapp.packagename";
//                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
//                        context.startActivity(intent);
//                    }
//
//                }catch (Exception e)
//                {
//                    e.printStackTrace();
//
//                    Toast.makeText(context, ""+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return modelClassList.size();
    }

    public class UserHolder extends RecyclerView.ViewHolder {
        TextView tplace;

        ImageView placeimage,downarrow,callimage,mapimg,webimage;
        LinearLayout expandableLayout;
        public UserHolder(@NonNull View itemView) {
            super(itemView);
            tplace=itemView.findViewById(R.id.recyclertextplace1);
            downarrow=itemView.findViewById(R.id.downarrowid);
            callimage=itemView.findViewById(R.id.callid);
            mapimg=itemView.findViewById(R.id.mapid);
            webimage=itemView.findViewById(R.id.webid);
            placeimage=itemView.findViewById(R.id.placeimage);
            expandableLayout=itemView.findViewById(R.id.expandid);

            downarrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ModelClass modelClass=modelClassList.get(getAdapterPosition());
                    modelClass.setExpand(!modelClass.isExpand());
                    notifyItemChanged(getAdapterPosition());
                }
            });

            mapimg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String label=modelClassList.get(getAdapterPosition()).getPlace();
                    String uriBegin= "geo:" + modelClassList.get(getAdapterPosition()).getLatitude() + "," + modelClassList.get(getAdapterPosition()).getLongitude();
                    String query= modelClassList.get(getAdapterPosition()).getLatitude() + "," + modelClassList.get(getAdapterPosition()).getLongitude() + "(" + label + ")";
                    String encodedquery= Uri.encode(query);
                    String uriString= uriBegin + "?q=" + encodedquery + "&z=16";

                    Uri uri= Uri.parse(uriString);

                    Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    context.startActivity(intent);

//

                }
            });
            webimage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse(modelClassList.get(getAdapterPosition()).getWebsite()));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);

                    context.startActivity(intent);

                }
            });




        }
    }
}
