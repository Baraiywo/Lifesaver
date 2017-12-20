package practice.hbk.com.lifesaver;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by H.B.K on 19-Dec-17.
 */

public class DonorAdapter extends RecyclerView.Adapter<DonorAdapter.ViewHolder>{

    Context context;
    ArrayList<Donor> donors;

    public DonorAdapter(Context context, ArrayList<Donor> donors) {
        this.context = context;
        this.donors= donors;
    }

    @Override
    public DonorAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.donator_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DonorAdapter.ViewHolder holder, int position) {
        Donor donor = donors.get(position);
        holder.contact.setText(donor.getContact());
        holder.name.setText(donor.getName());
        holder.blood.setText(donor.getBlood());
    }

    @Override
    public int getItemCount() {
        return donors.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView name, blood, contact;

        public ViewHolder(View view) {
            super(view);
            blood = (TextView) view.findViewById(R.id.blood);
            name = (TextView) view.findViewById(R.id.name);
            contact = (TextView) view.findViewById(R.id.contact);
        }

    }

}
