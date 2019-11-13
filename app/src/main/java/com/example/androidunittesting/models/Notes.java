package com.example.androidunittesting.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "notes")
public class Notes implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id ;

    @NonNull
    @ColumnInfo(name = "title")
    private String title ;

    @ColumnInfo(name = "content")
    private String content ;

    @ColumnInfo(name = "timestamp")
    private String timestamp ;

    public Notes(@NonNull String title, String content, String timestamp) {
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
    }

    @Ignore
    public Notes(int id, @NonNull String title, String content, String timestamp) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
    }

    @Ignore
    public Notes(){

    }

    @Ignore
    public Notes(Notes notes){
        this.id = id;
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
    }

    protected Notes(Parcel in) {
        id = in.readInt();
        title = in.readString();
        content = in.readString();
        timestamp = in.readString();
    }

    public static final Creator<Notes> CREATOR = new Creator<Notes>() {
        @Override
        public Notes createFromParcel(Parcel in) {
            return new Notes(in);
        }

        @Override
        public Notes[] newArray(int size) {
            return new Notes[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(content);
        dest.writeString(timestamp);
    }

    @Override
    public boolean equals(Object o) {
        if(o == null) return false;
        if(getClass() != o.getClass()) return false ;
        Notes notes = (Notes) o;
        return getId() == notes.id &&
                getTitle().equals(notes.title) && getContent().equals(notes.content);
    }

}
