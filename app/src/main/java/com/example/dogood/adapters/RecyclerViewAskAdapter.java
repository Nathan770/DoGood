package com.example.dogood.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dogood.R;
import com.example.dogood.activities.ItemDetailsActivity;
import com.example.dogood.interfaces.ItemDetailsListener;
import com.example.dogood.objects.AskItem;
import com.example.dogood.objects.GiveItem;
import com.example.dogood.objects.User;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class RecyclerViewAskAdapter extends RecyclerView.Adapter<RecyclerViewAskAdapter.ViewHolder> {
    private static final String TAG = "Dogood";
    private static final String GIVE_ITEM = "giveItem";
    private static final String ASK_ITEM = "askItem";

    private Context context;
    private ArrayList<AskItem> items;
    private User myUser;

    public RecyclerViewAskAdapter(Context context, ArrayList<AskItem> items, User user) {
        Log.d(TAG, "RecyclerViewAskAdapter: Im in adapter with: " + items.toString());
        this.context = context;
        this.items = items;
        this.myUser = user;
    }


    @NonNull
    @Override
    public RecyclerViewAskAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.askitem_recyclerview_row, parent, false);
        return new RecyclerViewAskAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAskAdapter.ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: got item: " + items.get(position));
        AskItem temp = items.get(position);
        holder.itemName.setText(temp.getName());
        holder.itemCity.setText(temp.getCity());
        holder.postDate.setText(temp.getDate());
        getItemCategory(holder.itemPhoto, position);

        holder.rowCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openItemDetails(position);
            }
        });
    }

    /**
     * A method to init category image
     */
    private void getItemCategory(ShapeableImageView itemPhoto, int position) {
        Log.d(TAG, "getItemCategory: ");
        AskItem item = items.get(position);
        String category = item.getCategory();

        if (category.equals("Clothes")) {
            itemPhoto.setImageResource(R.drawable.ic_clothes);
            return;
        }
        if (category.equals("Office supplies")) {
            itemPhoto.setImageResource(R.drawable.ic_office_supplies);
            return;
        }
        if (category.equals("Medical equipment")) {
            itemPhoto.setImageResource(R.drawable.ic_medical_equipment);
            return;
        }
        if (category.equals("Gaming")) {
            itemPhoto.setImageResource(R.drawable.ic_gaming);
            return;
        }
        if (category.equals("Electronics")) {
            itemPhoto.setImageResource(R.drawable.ic_electronics);
            return;
        }
        if (category.equals("Appliances")) {
            itemPhoto.setImageResource(R.drawable.ic_appliances);
            return;
        }
        if (category.equals("Gift cards")) {
            itemPhoto.setImageResource(R.drawable.ic_gift_cards);
            return;
        }
        if (category.equals("Lighting")) {
            itemPhoto.setImageResource(R.drawable.ic_lighting);
            return;
        }
        if (category.equals("Food")) {
            itemPhoto.setImageResource(R.drawable.ic_food);
            return;
        }
        if (category.equals("Cosmetic")) {
            itemPhoto.setImageResource(R.drawable.ic_cosmetic);
            return;
        }
        if (category.equals("Games and Toys")) {
            itemPhoto.setImageResource(R.drawable.ic_games_and_toys);
            return;
        }
        if (category.equals("Cellular")) {
            itemPhoto.setImageResource(R.drawable.ic_cellular);
            return;
        }
        if (category.equals("Books")) {
            itemPhoto.setImageResource(R.drawable.ic_books);
            return;
        }
        if (category.equals("Baby Supplies")) {
            itemPhoto.setImageResource(R.drawable.ic_baby_supplies);
            return;
        }
        if (category.equals("Computers")) {
            itemPhoto.setImageResource(R.drawable.ic_computers);
            return;
        }
        if (category.equals("Other")) {
            itemPhoto.setImageResource(R.drawable.ic_other);
            return;
        }else {
            itemPhoto.setImageResource(R.drawable.ic_other);
            return;
        }
    }

    /**
     * A method to open the item details activity
     */
    private void openItemDetails(int position) {
        Log.d(TAG, "openItemDetails: ");
        ((ItemDetailsListener) context).getSelectedItem(null, items.get(position), false);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    /**
     * An inner class to specify each row contents
     */
    public class ViewHolder extends RecyclerView.ViewHolder { // To hold each row

        MaterialTextView itemName, itemCategory, itemCity, itemDescription, postDate;
        ShapeableImageView itemPhoto;
        MaterialCardView rowCard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            initViews();
        }

        /**
         * A method to initialize the views
         */
        private void initViews() {
            rowCard = itemView.findViewById(R.id.askRow_LAY_row);
            itemName = itemView.findViewById(R.id.askRow_LBL_itemName);
            itemCity = itemView.findViewById(R.id.askRow_LBL_itemCity);
            postDate = itemView.findViewById(R.id.askRow_LBL_postDate);
            itemPhoto = itemView.findViewById(R.id.askRow_IMG_itemCategoryPic);
        }


    }
}
