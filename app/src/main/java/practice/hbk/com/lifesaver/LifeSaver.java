package practice.hbk.com.lifesaver;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class LifeSaver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_saver);

        CardView donate = (CardView) findViewById(R.id.donate);
        CardView donor = (CardView) findViewById(R.id.donor);

        donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DonateFragment donateFragment = new DonateFragment();
                donateFragment.show(getFragmentManager(), DonateFragment.class.getSimpleName());

            }
        });

        donor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LifeSaver.this, FindDonor.class));
            }
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.blood_group);


        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        String[] bloodGroup = getResources().getStringArray(R.array.blood_groups);

        ArrayList<BloodGroup> bloodGroups = new ArrayList<>();

        for (String blood : bloodGroup) {
            BloodGroup b = new BloodGroup();
            b.setBloodGroup(blood);
            bloodGroups.add(b);
        }

        BloodAdapter bloodAdapter = new BloodAdapter(this, bloodGroups);
        recyclerView.setAdapter(bloodAdapter);

    }
}
