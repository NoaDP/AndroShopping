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

import com.example.elnacabotparedes.ls30917_ls30741_ls31293.Activities.ProductActivity;
import com.example.elnacabotparedes.ls30917_ls30741_ls31293.R;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<ProductModel>{

    private List<ProductModel> products;
    private Context context;

    public CustomAdapter(Context context) {
        super(context, R.layout.layout_product);
        this.products = new ArrayList<ProductModel>();
        populate();
    }

    private void populate() {
        this.products.clear();
        this.products.add(new ProductModel("Xbox", 199,"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent id venenatis ipsum. Fusce molestie id metus ut ullamcorper. Praesent consequat tortor risus. Phasellus mollis lacus purus, nec lacinia tortor sodales in. Duis a lectus at eros ornare sollicitudin. Vivamus gravida erat nisi, in congue tortor semper nec. In a imperdiet metus. Pellentesque facilisis feugiat lacus, vitae mollis ligula placerat eget. Phasellus et sem accumsan, lacinia nisi at, tristique ante. Nullam aliquet purus quis quam interdum placerat. Curabitur sit amet ultrices orci. Etiam lectus sapien, semper quis venenatis eu, ultricies in velit. Nunc convallis sem nec diam elementum molestie. Duis vulputate sodales malesuada. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Nunc vulputate felis iaculis, lacinia urna ut, sollicitudin mauris."));
        this.products.add(new ProductModel("Sony", 299,"lorem ipsum blablablalbalbalblablablablablablablalb"));
        this.products.add(new ProductModel("Mac book pro", 1990,"lorem ipsum blablablalbalbalblablablablablablablalb"));
        this.products.add(new ProductModel("Acer P400", 399,"lorem ipsum blablablalbalbalblablablablablablablalb"));
        this.products.add(new ProductModel("Nexus 4", 200,"lorem ipsum blablablalbalbalblablablablablablablalb"));
        this.products.add(new ProductModel("iPad 4", 399,"lorem ipsum blablablalbalbalblablablablablablablalb"));
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
}
