package com.example.dogood.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dogood.R;
import com.example.dogood.activities.NewAskItemActivity;
import com.example.dogood.activities.NewGiveItemActivity;
import com.example.dogood.adapters.RecyclerViewAskAdapter;
import com.example.dogood.adapters.RecyclerViewGiveAdapter;
import com.example.dogood.objects.AskItem;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AskItemFragment extends Fragment {
    private static final String TAG = "Dogood";
    private static final int NEW_ASK_ITEM_RESULT_CODE = 1012;

    protected View view;
    private RecyclerView recyclerView;
    private ArrayList<AskItem> askItems;
    private FloatingActionButton addItem;

    public AskItemFragment() {
    }

    public AskItemFragment(ArrayList<AskItem> askItems) {
        this.askItems = askItems;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");

        if (view == null) {
            view = inflater.inflate(R.layout.fragment_ask_items, container, false);
        }
        initViews();
        populateItemsList();
        return view;
    }

    /**
     * A method to populate the items list
     */
    private void populateItemsList() {
        Log.d(TAG, "populateEventList: Populating list ");
        if (askItems == null) {
            Log.d(TAG, "populateItemsList: no askItems");
        } else {
            recyclerView = view.findViewById(R.id.askFragment_LST_mainRecycler);
            RecyclerViewAskAdapter recyclerViewAskAdapter = new RecyclerViewAskAdapter(getContext(), askItems);
            recyclerView.setAdapter(recyclerViewAskAdapter);

        }
    }

    /**
     * A method to initialize the views
     */
    private void initViews() {
        Log.d(TAG, "initViews: initializing views");
        addItem=view.findViewById(R.id.askFragment_BTN_addItemButton);
        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddItemActivity();
            }
        });
    }

    /**
     * A method to move to add item activity
     */
    private void openAddItemActivity() {
        Log.d(TAG, "openAddItemActivity: ");
        startActivityForResult(new Intent(getActivity(), NewAskItemActivity.class), NEW_ASK_ITEM_RESULT_CODE);
    }
}
