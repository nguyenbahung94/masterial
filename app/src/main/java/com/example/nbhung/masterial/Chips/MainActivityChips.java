package com.example.nbhung.masterial.Chips;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.doodle.android.chips.ChipsView;
import com.doodle.android.chips.model.Contact;
import com.example.nbhung.masterial.R;

/**
 * Created by nbhung on 8/15/2017.
 */

public class MainActivityChips extends AppCompatActivity {
    private RecyclerView mContacts;
    private ContactsAdapter mAdapter;
    private ChipsView mChipsView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_chips_activity);

        mContacts = (RecyclerView) findViewById(R.id.rv_contact);
        mChipsView = (ChipsView) findViewById(R.id.cv_contacts);
        mContacts.setLayoutManager(new LinearLayoutManager(MainActivityChips.this));
        mAdapter = new ContactsAdapter(mChipsView, this);
        mContacts.setAdapter(mAdapter);
        mChipsView.getEditText().setCursorVisible(true);
        mChipsView.setChipsValidator(new ChipsView.ChipValidator() {
            @Override
            public boolean isValid(Contact contact) {
                if (contact.getDisplayName().equals("asd@qwe.de")) {
                    return false;
                }
                return true;
            }
        });
        mChipsView.setChipsListener(new ChipsView.ChipsListener() {
            @Override
            public void onChipAdded(ChipsView.Chip chip) {
                for (ChipsView.Chip chipITem : mChipsView.getChips()) {
                    Log.d("ChipList", "chip:" + chipITem.toString());
                }
            }

            @Override
            public void onChipDeleted(ChipsView.Chip chip) {

            }

            @Override
            public void onTextChanged(CharSequence text) {
                mAdapter.filterItems(text);
            }

            @Override
            public boolean onInputNotRecognized(String text) {
                return false;
            }
        });
    }
}
