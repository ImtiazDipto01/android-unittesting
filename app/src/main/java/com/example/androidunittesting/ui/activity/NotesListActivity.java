package com.example.androidunittesting.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.androidunittesting.R;
import com.example.androidunittesting.repository.NoteRepository;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class NotesListActivity extends DaggerAppCompatActivity {

    @Inject
    public NoteRepository noteRepository ;

    private static final String TAG = "NotesListActivity" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        Log.e(TAG, "NoteRepository : "+noteRepository);
    }
}
