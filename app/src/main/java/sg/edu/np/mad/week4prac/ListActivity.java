package sg.edu.np.mad.week4prac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    int count = 1;
    private static final String TAG = "ListActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        ArrayList<User> userlist = new ArrayList<>();
        if (userlist.size() == 0){
            for (int i = 0; i < 20; i++){
                User newUser = createUser();
                userlist.add(newUser);
            }
        }

        RecyclerView recyclerView = findViewById(R.id.recycler);
        adapter mAdapter = new adapter(ListActivity.this,userlist);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

    }
    private int random(){
        Random ran = new Random();
        int value = ran.nextInt(999999999);
        return value;
    }
    private User createUser(){
        int ran1 = random();
        int ran2 = random();
        String name = "Name" + ran1;
        boolean followed = false;
        int id = count;
        String description = "Description " + ran2;
        count++;
        User newUser = new User(name, description, id, false);
        return newUser;
    }
}
