package com.example.elnacabotparedes.ls30917_ls30741_ls31293.Classes;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.elnacabotparedes.ls30917_ls30741_ls31293.Activities.ProductActivity;
import com.example.elnacabotparedes.ls30917_ls30741_ls31293.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class CartAdapter extends ArrayAdapter<ProductModel> {

    private List<ProductModel> products;

    public CartAdapter(Context context, ArrayList<ProductModel> products) {
        super(context, R.layout.layout_cart);
        this.products = products;
    }

    public int getCount() {
        return this.products.size();
    }

    public ProductModel getItem(int index) {
        return this.products.get(index);
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if( row == null){
            Log.d("DEBUG", "Starting row inflation.");
            LayoutInflater inflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.layout_cart, parent, false);

            Log.d("DEBUG", "Row inflated correctly.");
        }

        ProductModel item = getItem(position);

        TextView name = (TextView)row.findViewById(R.id.product_name);
        name.setText(item.getName());

        TextView prize = (TextView)row.findViewById(R.id.prize);
        Integer productPrize = item.getPrize();
        prize.setText(productPrize.toString());

        TextView amount = (TextView)row.findViewById(R.id.amount);
        Integer productAmount = item.getAmount();
        amount.setText(productAmount.toString());

        Integer totalPrize = productPrize * productAmount;
        TextView accumulated = (TextView)row.findViewById(R.id.accumulated);
        accumulated.setText(totalPrize.toString());

        ImageView image = (ImageView)row.findViewById(R.id.imageproduct);
        Integer imFile = item.getImage();
        image.setImageResource(imFile);

        return row;
    }
}
