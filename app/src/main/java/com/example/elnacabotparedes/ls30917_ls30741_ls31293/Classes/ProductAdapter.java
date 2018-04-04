package com.example.elnacabotparedes.ls30917_ls30741_ls31293.Classes;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.elnacabotparedes.ls30917_ls30741_ls31293.Activities.ProductActivity;
import com.example.elnacabotparedes.ls30917_ls30741_ls31293.R;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends ArrayAdapter<ProductModel> {

    private List<ProductModel> products;
    private Context context;

    // Esta clase sirve para ahorrar memoria y evitar que el listview pierda las referencias
    static class ViewHolder{
        TextView name, prize;
        Button addCart, view;
    }

    // Constructor
    public ProductAdapter(Context context) {
        super(context, R.layout.layout_product);
        this.products = new ArrayList<ProductModel>();
        this.context = context;
        populate(context);
    }

    // Rellena la lista de productos
    private void populate(Context context) {
        this.products.clear();
        this.products.add(new ProductModel("Xbox", 199,context.getString(R.string.xbox_description), R.mipmap.xbox));
        this.products.add(new ProductModel("Sony", 299,context.getString(R.string.sony_description), R.mipmap.ps4));
        this.products.add(new ProductModel("Mac book pro", 1990,context.getString(R.string.mac_description), R.mipmap.mac));
        this.products.add(new ProductModel("Acer P400", 399,context.getString(R.string.acer_description), R.mipmap.acer));
        this.products.add(new ProductModel("Nexus 4", 200,context.getString(R.string.nexus_description), R.mipmap.nexus));
        this.products.add(new ProductModel("iPad 4", 399,context.getString(R.string.iPad_description), R.mipmap.ipad));
    }
    
    public int getCount() {
        return this.products.size();
    }

    public ProductModel getItem(int index) {
        return this.products.get(index);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder;

        // Si la vista no ha sido creada
        if (row == null) {
            holder = new ViewHolder();
            // Empieza la inflacion del elemento
            Log.d("DEBUG", "Starting row inflation.");
            LayoutInflater inflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.layout_product, parent, false);

            // Guarda las referencias en el ViewHolder
            holder.name = (TextView)row.findViewById(R.id.product_name);
            holder.prize = (TextView)row.findViewById(R.id.product_prize);
            holder.view = (Button)row.findViewById(R.id.see_product);
            holder.addCart = (Button)row.findViewById(R.id.add_cart);

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

        holder.prize.setText(item.getPrize().toString().concat(" €"));

        holder.addCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getItem(position).itemSelected();
                String text = getItem(position).getName().concat(" ".concat(getContext().getString(R.string.product_added)));
                Toast toast = Toast.makeText(getContext(), text, Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ProductActivity.class);
                intent.putExtra("PRODUCT_NAME", getItem(position).getName());
                intent.putExtra("PRODUCT_PRIZE", getItem(position).getPrize());
                intent.putExtra("PRODUCT_DESC", getItem(position).getDescription());
                intent.putExtra("PRODUCT_IMG", getItem(position).getImage());

                context.startActivity(intent);
            }
        });

        return row;
    }

    public List<ProductModel> getBoughtProducts() {
        List<ProductModel> list = new ArrayList<ProductModel>();
        for(ProductModel item : products){
            if (item.getAmount() > 0) {
                list.add(item);
            }
        }
        return list;
    }

    public void resetProducts(){
        for (ProductModel item : products) {
            item.setAmount(0);
        }
    }
}
