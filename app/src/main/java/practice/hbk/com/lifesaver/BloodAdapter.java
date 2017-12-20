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

public class BloodAdapter extends RecyclerView.Adapter<BloodAdapter.ViewHolder>{

    Context context;
    ArrayList<BloodGroup> bloodGroups;

    public BloodAdapter(Context context, ArrayList<BloodGroup> bloodGroups) {
        this.context = context;
        this.bloodGroups = bloodGroups;
    }

    @Override
    public BloodAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.blood_group_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BloodAdapter.ViewHolder holder, int position) {
        BloodGroup bloodGroup = bloodGroups.get(position);
        holder.bloodGroup.setText(bloodGroup.getBloodGroup());
    }

    @Override
    public int getItemCount() {
        return bloodGroups.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView bloodGroup;

        public ViewHolder(View view) {
            super(view);
            bloodGroup = (TextView) view.findViewById(R.id.group);
        }

    }

}
