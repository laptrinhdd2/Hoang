package android2.team2.exe3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodAdapter extends BaseAdapter {

    Context contextF;
    int layoutF;
    ArrayList<Food> listF;

    public FoodAdapter(Context context, int layout, ArrayList<Food> listFood){
        contextF = context;
        layoutF = layout;
        listF = listFood;
    }
    @Override
    public int getCount() {
        return listF.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) contextF.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(layoutF, null);
        TextView txtName = (TextView) convertView.findViewById(R.id.txtNameFood);
        TextView txtPrice = (TextView) convertView.findViewById(R.id.txtPrice);
        ImageView imgView  = (ImageView) convertView.findViewById(R.id.itemFood);

        txtName.setText(listF.get(position).nameFood);
        txtPrice.setText(listF.get(position).priceFood +"");
        imgView.setImageResource(listF.get(position).imgFood);
        Animation animScale = AnimationUtils.loadAnimation(contextF, R.anim.anim_scale);
        convertView.startAnimation(animScale);
        return convertView;
    }
}
