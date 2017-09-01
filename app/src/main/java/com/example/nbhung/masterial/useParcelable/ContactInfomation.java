package com.example.nbhung.masterial.useParcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by nbhung on 8/21/2017.
 */

public class ContactInfomation implements Parcelable {
    public static final Creator<ContactInfomation> CREATOR = new Creator<ContactInfomation>() {
        @Override
        public ContactInfomation createFromParcel(Parcel source) {
            return new ContactInfomation(source);
        }

        @Override
        public ContactInfomation[] newArray(int size) {
            return new ContactInfomation[size];
        }
    };
    private String name;
    private String surName;
    private int idx;

    public ContactInfomation(String name, String surName, int idx) {
        this.name = name;
        this.surName = surName;
        this.idx = idx;
    }

    public ContactInfomation() {
    }

    protected ContactInfomation(Parcel in) {
        this.name = in.readString();
        this.surName = in.readString();
        this.idx = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.surName);
        dest.writeInt(this.idx);
    }

    @Override
    public String toString() {
        return "ContactInfomation{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", idx=" + idx +
                '}';
    }
}
