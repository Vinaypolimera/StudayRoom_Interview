package com.poli.studayroominterview.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import com.google.android.material.textfield.TextInputEditText;
import com.poli.studayroominterview.R;
import com.poli.studayroominterview.beans.ItemObject;
import com.poli.studayroominterview.ui.adapter.ListAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

        mListAdapter = new ListAdapter(this, new ArrayList<ItemObject>());
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(mListAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mActivityModel.getItemObjectArrayLiveData().observe(this, new Observer<List<ItemObject>>() {
            @Override
            public void onChanged(List<ItemObject> itemObjects) {
                Log.i(LOG_TAG," onChanged ====> "+itemObjects.size());
                mListAdapter.updateList(itemObjects);
            }
        });

        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence text, int i, int i1, int i2) {
                if(mActivityModel != null)
                    mActivityModel.updateDataWithTag(text.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

    }
}