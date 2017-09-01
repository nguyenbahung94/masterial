package com.example.nbhung.masterial.Chips;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.doodle.android.chips.ChipsView;
import com.doodle.android.chips.model.Contact;
import com.example.nbhung.masterial.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by nbhung on 8/15/2017.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.CheckableContactViewHolder> {
    private String[] data = new String[]{"bamoyk@yahoo.com",
            "info@delaroystudios.com",
            "qwerty@qwe.de",
            "verylongaddress@verylongserver.com",
            "YourEmail@address.com",
            "test@testeration.de",
            "short@short.com"};
    private ChipsView mChipsView;
    private List<String> filteredList = new ArrayList<>();
    private Context mContext;

    public ContactsAdapter(ChipsView mChipsView, Context mContext) {
        this.mChipsView = mChipsView;
        this.mContext = mContext;
        Collections.addAll(filteredList, data);
    }

    @Override
    public CheckableContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_check, parent, false);
        return new CheckableContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CheckableContactViewHolder holder, int position) {
        holder.name.setText(filteredList.get(position));
    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }

    public void filterItems(CharSequence text) {
        filteredList.clear();
        if (TextUtils.isEmpty(text)) {
            Collections.addAll(filteredList, data);
        } else {
            for (String s : data) {
                if (s.contains(text)) {
                    filteredList.add(s);
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return Math.abs(filteredList.get(position).hashCode());
    }

    class CheckableContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView name;
        private final CheckBox selection;


        public CheckableContactViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_contact_name);
            selection = (CheckBox) itemView.findViewById(R.id.cb_contact_selection);
            selection.setOnClickListener(this);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selection.performClick();
                }
            });
        }

        @Override
        public void onClick(View v) {
            String email = name.getText().toString();
            Uri imgUrl = Math.random() > .7d ? null : Uri.parse("https://robohash.org/" + Math.abs(email.hashCode()));
            Contact contact = new Contact(null, null, null, email, imgUrl);

            if (selection.isChecked()) {
                Log.e("email", email);
                Log.e("imgURl", String.valueOf(imgUrl));
                Log.e("contact", String.valueOf(contact));
                mChipsView.addChip(email, imgUrl, contact);
            } else {
                mChipsView.removeChipBy(contact);
            }
        }
    }
}
