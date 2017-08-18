package com.mydroid.embaralhado.adapter;

/*
 * Created by Jeferson on 17/11/2016.
 */

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import com.mydroid.embaralhado.R;
import com.mydroid.embaralhado.model.Score;
import com.mydroid.embaralhado.persistence.DataBase;

public class ScoreAdapter extends BaseAdapter{

    private List<Score> scores;
    private Context context;
    private Integer contextID;

    public ScoreAdapter(Context context, Integer contextID) {
        this.context = context;
        this.contextID = contextID;
        DataBase dataBase = new DataBase(context);
        this.scores = dataBase.searchScoresDatabase(contextID);
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return this.scores.size();
    }

    @Override
    public Object getItem(int i) {
        return this.scores.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {// Inflar o layout da lista

        View layout;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layout = inflater.inflate(R.layout.score_item_list, null);
        }
        else{
            layout = view;
        }

        ImageView imageView = (ImageView) layout.findViewById(R.id.image_item);
        TextView textView = (TextView) layout.findViewById(R.id.text_item);

        Score score = this.scores.get(i);
        textView.setText(score.getUser()+" acertou "+score.getAnswerCount()+" de "+score.getAnswerTotal()+" = "+score.getScore()+"%");

        imageView.setImageBitmap(this.scores.get(i).getImage());

        return layout;
    }

    public Integer getContextID() {
        return contextID;
    }
}