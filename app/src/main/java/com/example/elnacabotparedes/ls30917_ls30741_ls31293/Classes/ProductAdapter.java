package com.example.elnacabotparedes.ls30917_ls30741_ls31293.Classes;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.elnacabotparedes.ls30917_ls30741_ls31293.Activities.CartActivity;
import com.example.elnacabotparedes.ls30917_ls30741_ls31293.Activities.ProductActivity;
import com.example.elnacabotparedes.ls30917_ls30741_ls31293.R;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends ArrayAdapter<ProductModel>{

    private List<ProductModel> products;

    public ProductAdapter(Context context) {
        super(context, R.layout.layout_product);
        this.products = new ArrayList<ProductModel>();

        populate();
    }

    private void populate() {
        this.products.clear();
        this.products.add(new ProductModel("Xbox", 199, getContext().getString(R.string.xbox_description)));
        this.products.add(new ProductModel("Sony", 299,getContext().getString(R.string.sony_description)));
        this.products.add(new ProductModel("Mac book pro", 1990,getContext().getString(R.string.mac_description)));
        this.products.add(new ProductModel("Acer P400", 399,getContext().getString(R.string.acer_description)));
        this.products.add(new ProductModel("Nexus 4", 200,getContext().getString(R.string.nexus_description)));
        this.products.add(new ProductModel("iPad 4", 399,getContext().getString(R.string.iPad_description)));
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

        if (row == null) {
            Log.d("DEBUG", "Starting row inflation.");
            LayoutInflater inflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.layout_product, parent, false);

            row.findViewById(R.id.add_cart).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getItem(position).itemSelected();
                    String text = getItem(position).getName().concat(" ".concat(getContext().getString(R.string.product_added)));
                    Toast toast = Toast.makeText(getContext(), text, Toast.LENGTH_SHORT);
                    toast.show();
                }
            });

            row.findViewById(R.id.see_product).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), ProductActivity.class);
                    intent.putExtra("PRODUCT_NAME", getItem(position).getName());
                    intent.putExtra("PRODUCT_PRIZE", getItem(position).getPrize());
                    intent.putExtra("PRODUCT_DESC", getItem(position).getDescription());

                    getContext().startActivity(intent);
                }
            });
            Log.d("DEBUG", "Row inflated correctly.");
        }

        ProductModel item = getItem(position);
        row.setTag(item);

        TextView name = (TextView)row.findViewById(R.id.product_name);
        name.setText(item.getName());

        TextView prize = (TextView)row.findViewById(R.id.product_prize);
        prize.setText(item.getPrize().toString().concat(" €"));

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
