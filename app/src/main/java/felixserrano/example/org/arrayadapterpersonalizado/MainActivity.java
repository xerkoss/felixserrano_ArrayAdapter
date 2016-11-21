package felixserrano.example.org.arrayadapterpersonalizado;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends ListActivity {

    private static final String[] items = {"En", "un", "lugar", "de", "la", "Mancha", "de", "cuyo", "nombre",
            "no", "quiero", "acordarme", "no", "ha", "mucho", "tiempo", "que", "vivía", "un", "hidalgo", "de", "los", "de"
            , "lanza", "en", "astillero", "adarga", "antigua", "rocín", "flaco", "y", "galgo", "corredor"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new AdaptadorConIcono());
    }

    public class AdaptadorConIcono extends ArrayAdapter<String> {

        public AdaptadorConIcono(){
            super(MainActivity.this,R.layout.fila, R.id.etiqueta,items);
        }

        public View getView(int position, View convertView, ViewGroup parent)
        {
            View fila = super.getView(position,convertView,parent);
            ImageView icon = (ImageView)fila.findViewById(R.id.icono);

            if(items[position].length()>4) {
                icon.setImageResource(android.R.drawable.btn_star_big_off);
            }
            else{
                icon.setImageResource(android.R.drawable.btn_star_big_on);
            }

            TextView tamanyo = (TextView)fila.findViewById(R.id.tamanyo);
            tamanyo.setText(String.format(getString(R.string.tamanyo_template),items[position].length()));
            return (fila);
        }
    }

}
