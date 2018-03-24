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
        this.products.add(new ProductModel("Xbox", 199,"Xbox 360 es la segunda videoconsola de sobremesa de la marca Xbox producida por Microsoft. Fue desarrollada en colaboración con IBM y ATI y lanzada en América del Sur, América del Norte, Japón, Europa y Australia entre 2005 y 2006. Su servicio Xbox Live (de pago) permite a los jugadores competir en línea y descargar contenidos como juegos arcade, demos, tráilers, programas de televisión y películas. La Xbox 360 es la sucesora directa de la Xbox, y compitió con la PlayStation 3 de Sony y Wii de Nintendo como parte de las videoconsolas de séptima generación."));
        this.products.add(new ProductModel("Sony", 299,"lorem ipsum blablablalbalbalblablablablablablablalb"));
        this.products.add(new ProductModel("Mac book pro", 1990,"Es más rápido y potente que antes, pero más fino y ligero que nunca. Tiene la pantalla con más color y brillo jamás vista en un portátil Mac. Y viene con la Touch Bar, una barra de vidrio Multi-Touch integrada en el teclado para que siempre tengas a mano las herramientas que necesitas. El MacBook Pro es el resultado de nuestras ideas más innovadoras. Y puede hacer realidad las tuyas."));
        this.products.add(new ProductModel("Acer P400", 399,"The Acer neoTouch P400 is a smartphone designed by Acer Inc. After using Android on phones such as the Acer beTouch E110 and Liquid A1, Acer has returned to Microsoft’s operating system. It shares the hardware and design with the Acer beTouch E400 but it runs Microsoft Windows Mobile 6.5.3 operating system that brings a more finger-friendly user interface.[2] The neoTouch P400 was first introduced at the Mobile World Congress 2010 in Barcelona."));
        this.products.add(new ProductModel("Nexus 4", 200,"El Nexus 4 es un teléfono inteligente de gama alta desarrollado por Google en la colaboración con LG. Es la cuarta generación de la gama Nexus. Se caracteriza por poseer una cámara de 8 MP, pantalla IPS LCD capacitiva y procesador de cuatro núcleos."));
        this.products.add(new ProductModel("iPad 4", 399,"El iPad de 4ª generación es una tableta diseñada, desarrollada y comercializada por Apple Inc, que se ha retomado sus ventas sustituyendo el famoso iPad 2. Fue anunciado el 23 de octubre de 2012 como la cuarta generación de la línea iPad, en reemplazo de la IPad de tercera generación y distribuida a partir del 2 de noviembre de 2012, junto al iPad mini."));
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
