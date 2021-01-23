package com.example.covid;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.covid.ui.main.SectionsPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);
        RecyclerView rv = (RecyclerView)findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        RVAdapter adapter=new RVAdapter(Data);
        rv.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    class InsertData{
        String state;
        int cases;
        InsertData(String state,int cases){
            this.state=state;
            this.cases=cases;
        }
    }
    private List<InsertData> Data;
    private void Init(){
        Data=new ArrayList<>();
        Data.add(new InsertData("Florida",4000));
        Data.add(new InsertData("Colorado",2000));

    }
    public class RVAdapter extends RecyclerView.Adapter<RVAdapter.DataViewHolder>{
        List <InsertData> Data;
        public class DataViewHolder extends RecyclerView.ViewHolder{
            CardView card_view;
            TextView Cases;
            DataViewHolder(View itemView){
                super(itemView);
                card_view=(CardView)itemView.findViewById(R.id.card_view);
                Cases=(TextView)itemView.findViewById(R.id.Cases);
            }
        }

        RVAdapter(List<InsertData> Data){
            this.Data=Data;
        }
        @Override
        public int getItemCount(){
            return Data.size();
        }

        @Override
        public DataViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_main,viewGroup,false);
            DataViewHolder dvh = new DataViewHolder(v);
            return dvh;
        }
        @Override
        public void onBindViewHolder(DataViewHolder dataViewHolder, int i){
            dataViewHolder.Cases.setText(Data.get(i).cases);
        }
        @Override
        public void onAttachedToRecyclerView(RecyclerView recyclerView){
            super.onAttachedToRecyclerView(recyclerView);
        }
    }
}