package practice.hbk.com.lifesaver;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by H.B.K on 19-Dec-17.
 */

public class DonateFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.add_donor, null, false);
        final EditText name = (EditText) view.findViewById(R.id.name);
        final EditText contact = (EditText) view.findViewById(R.id.contact);
        final Spinner bg= (Spinner) view.findViewById(R.id.groups);

        Button addDonor = (Button) view.findViewById(R.id.add);

        addDonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String blood = bg.getSelectedItem().toString();
                String strName = name.getText().toString();
                String strContact = contact.getText().toString();

                if(TextUtils.isEmpty(blood) || TextUtils.isEmpty(strName) || TextUtils.isEmpty(strContact)) {
                    Toast.makeText(getActivity(), "Please provide all details", Toast.LENGTH_SHORT).show();
                }else {

                    Donor donor = new Donor();
                    donor.setName(strName);
                    donor.setContact(strContact);
                    donor.setBlood(blood);

                    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                    DatabaseReference databaseReference = firebaseDatabase.getReference();

                    String key = databaseReference.child("donors").push().getKey();
                    databaseReference.child("donors").child(key).setValue(donor).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {



                        }
                    });

                    dismiss();
                }

            }
        });

        alertDialog.setView(view);
        alertDialog.setTitle("Input your details");

        return alertDialog.create();
    }
}
