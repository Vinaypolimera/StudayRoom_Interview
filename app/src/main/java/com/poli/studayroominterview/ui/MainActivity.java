package com.poli.studayroominterview.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;
import com.poli.studayroominterview.R;
import com.poli.studayroominterview.beans.ItemObject;
import com.poli.studayroominterview.ui.adapter.ListAdapter;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private final String LOG_TAG = MainActivity.class.getSimpleName();
    ActivityModel mActivityModel;
    ListAdapter mListAdapter;
    TextInputEditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mActivityModel = ViewModelProviders.of(this).get(ActivityModel.class);

        mEditText = findViewById(R.id.edit_text);

        mListAdapter = new ListAdapter(this, new ItemObject[0]);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(mListAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mActivityModel.getItemObjectArrayLiveData().observe(this, new Observer<ItemObject[]>() {
            @Override
            public void onChanged(ItemObject[] itemObjects) {
                Log.i(LOG_TAG," onChanged ====> "+itemObjects.length);
                mListAdapter.updateList(itemObjects);
            }
        });

    }

    public void onFilterClicked(View view){
        Log.i(LOG_TAG," ** onFilterbtnClicked ** ");
        if(mEditText == null || mActivityModel == null)
            return;

        String tag = Objects.requireNonNull(mEditText.getText()).toString();
        mActivityModel.updateDataWithTag(tag);
    }
}