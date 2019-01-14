package a15828.edjd.trabalho;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    RealmResults<Torneios> torneiosList;
    ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();

        Realm realm = Realm.getDefaultInstance();

        torneiosList = realm.where(Torneios.class)
                .findAll();

        for (Torneios t : torneiosList) {
            Log.d("torneiosList_T", t.getNome());
        }

        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewTorneios);
        adapter = new ListAdapter();
        listView.setAdapter(adapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddTorneio.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            torneiosList.deleteFromRealm(torneiosList.size()-1);
            adapter.notifyDataSetChanged();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    class ListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return torneiosList.size();
        }

        @Override
        public Object getItem(int position) {
            return torneiosList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView==null)
                convertView = getLayoutInflater().inflate(R.layout.torneios_row,null);

            TextView textViewNome = convertView.findViewById(R.id.textViewNome);
            TextView textViewNumero = convertView.findViewById(R.id.textViewNumero);

            textViewNome.setText(torneiosList.get(position).getNome());
            textViewNumero.setText(""+torneiosList.get(position).getNequipas());

            convertView.setTag(new Integer(position));
            convertView.setClickable(true);
            convertView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    int position = (int) view.getTag();
                    Log.d("Torneios", "Position:" + position);

                    Intent intent = new Intent(MainActivity.this, NovoTorneio.class);
                    intent.putExtra("Nome_torneio", torneiosList.get(position).getNome());
                    intent.putExtra("NumeroEquipas_torneio", torneiosList.get(position).getNequipas());
                    startActivity(intent);
                }
            });

            return convertView;
        }

    }
}
