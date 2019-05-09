package bo.Androides.MiCafe;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import bo.Androides.MiCafe.model.Producto;

public class AdaptadorBebidas extends BaseAdapter {

    private static LayoutInflater inflater = null;





    Context contexto;
    List<Producto> items = new ArrayList<>();

    public AdaptadorBebidas(Context contexto, List<Producto> productos) {
        this.contexto = contexto;
        this.items = productos;

        inflater = (LayoutInflater) contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();

            //Inflater nos permite usar un layout dentro de un componente
            LayoutInflater inflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_elemento_lista, null); //Cual layout y principal o no.

            viewHolder.nombre = (TextView) convertView.findViewById(R.id.NombreDeBebida);
            viewHolder.imagen = (ImageView) convertView.findViewById(R.id.imagen);
            viewHolder.precioBebidas =(TextView) convertView.findViewById(R.id.precioBebidas);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Producto producto = this.items.get(i);
        viewHolder.nombre.setText(producto.getNombre());
        viewHolder.imagen.setImageResource(producto.getImagen());
        viewHolder.precioBebidas.setText("Precio: "+ String.valueOf(producto.getPrecio()) + " Bs.");
        return convertView;
    }

    class ViewHolder {
        TextView nombre;
        ImageView imagen;
        TextView precioBebidas;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Producto getItem(int position) {
        return this.items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.items.get(position).getId();
    }


}
