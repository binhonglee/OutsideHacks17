package com.example.outsidehacks17.outsidehacks;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ArrayAdapter;


public class ArtistsActivity extends AppCompatActivity {

    private UserFactory users;
    private int currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artists);


        users = this.getIntent().getParcelableExtra("UserFactory");
        currentUser = this.getIntent().getIntExtra("id", 0);



        AutoCompleteTextView textView1 = (AutoCompleteTextView) findViewById(R.id.artist1);
        AutoCompleteTextView textview2 = (AutoCompleteTextView) findViewById(R.id.artist2);
        AutoCompleteTextView textView3 = (AutoCompleteTextView) findViewById(R.id.artist3);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ARTISTNAMES);
        textView1.setAdapter(adapter);
        textview2.setAdapter(adapter);
        textView3.setAdapter(adapter);


    }



    private static final String[] ARTISTNAMES = new String[] {
            "Metallica", "The Who", "Gorillaz", "Lorde", "A Tribe Called Quest", "alt-J", "Queens Of The Stone Age", "Above & Beyond", "Fleet Foxes", "Empire Of The Sun", "The Avett Brothers",
            "Belle and Sebastian", "Solange", "Future Islands", "ScHoolboy Q", "Rebelution", "Young The Giant", "Little Dragon", "Vance Joy", "Kaytranada", "Bleachers", "Tove Lo", "Action Bronson",
            "Sleigh Bells", "Louis The Child", "Royal Blood", "Shovels & Rope", "Thundercat", "Dawes", "Warpaint", "Dr. Octagon", "Rag’n’Bone Man",
            "Bomba Estéreo", "Real Estate", "James Vincent McMorrow", "RAC", "Temples", "K.Flay", "Hamilton Leithauser", "Maggie Rogers", "Sofi Tukker", "Foxygen", "How To Dress Well", "SOHN", "Electric Guest",
            "Goldroom", "Hundred Waters", "Noname", "Khruangbin", "Kamaiyah", "S U R V I V E", "Kali Uchis", "San Fermin", "Joseph", "The Japanese House", "Mon Laferte", "Lee Fields & The Expressions", "The Lemon Twigs",
            "Grace Mitchell", "Porches", "Jacob Banks", "MUNA", "Mondo Cozmo", "John Moreland", "Frenship", "Sam Dew", "Oliver Tree", "Lawrence", "The She’s", "Berklee College of Music"

    };

    public void buttonContinue(View theView) {
        AutoCompleteTextView textView1 = (AutoCompleteTextView) findViewById(R.id.artist1);
        AutoCompleteTextView textview2 = (AutoCompleteTextView) findViewById(R.id.artist2);
        AutoCompleteTextView textView3 = (AutoCompleteTextView) findViewById(R.id.artist3);


        users.get(currentUser).setFavArtists1(textView1.getText().toString());
        users.get(currentUser).setFavArtists2(textview2.getText().toString());
        users.get(currentUser).setFavArtists3(textView3.getText().toString());



        Intent i = new Intent();
        i.setClass(this, ChooseEventsActivity.class);
        i.putExtra("UserFactory", users);
        i.putExtra("id", currentUser);
        startActivity(i);
    }

}
