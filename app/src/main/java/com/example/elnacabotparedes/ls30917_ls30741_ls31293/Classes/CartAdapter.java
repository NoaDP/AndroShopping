package com.example.elnacabotparedes.ls30917_ls30741_ls31293.Classes;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.elnacabotparedes.ls30917_ls30741_ls31293.R;

import java.util.ArrayList;
import java.util.List;


public class CartAdapter extends ArrayAdapter<ProductModel> {

    private List<ProductModel> products;

    // Esta clase sirve para ahorrar memoria y evitar que el listview pierda las referencias
    static class ViewHolder{
        TextView name, prize, amount, accumulated;
        ImageView image;
    }

    // Constructor
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
        ViewHolder holder;

        // Si la vista no ha sido creada
        if( row == null){
            holder = new ViewHolder();
            // Empieza la inflacion del elemento
            Log.d("DEBUG", "Starting row inflation.");
            LayoutInflater inflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.layout_cart, parent, false);

            // Guarda las referencias en el ViewHolder
            holder.name = (TextView)row.findViewById(R.id.product_name);
            holder.prize = (TextView)row.findViewById(R.id.prize);
            holder.amount = (TextView)row.findViewById(R.id.amount);
            holder.accumulated = (TextView)row.findViewById(R.id.accumulated);
            holder.image = (ImageView)row.findViewById(R.id.imageproduct);

            Log.d("DEBUG", "Row inflated correctly.");
            // Guarda el holder como tag, para no tener que crearlo otra vez
            row.setTag(holder);
        } else {
            // "Recicla" la vista ya creada
            holder = (ViewHolder)row.getTag();
        }
        // A partir de aquí se añaden los valores pertinentes a la vista
        ProductModel item = getItem(position);

        holder.name.setText(item.getName());

        Integer productPrize = item.getPrize();
        holder.prize.setText(productPrize.toString().concat(" €"));

        Integer productAmount = item.getAmount();
        holder.amount.setText(productAmount.toString());

        Integer totalPrize = productPrize * productAmount;
        holder.accumulated.setText(totalPrize.toString().concat(" €"));

        Integer imFile = item.getImage();
        holder.image.setImageResource(imFile);

        return row;
    }
}
