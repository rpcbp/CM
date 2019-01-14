package a15828.edjd.trabalho;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.realm.Realm;

public class AddTorneio extends AppCompatActivity {

    EditText editNome;
    EditText editNumeroEquipas;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_torneio);

        editNome = findViewById(R.id.editNome);
        editNumeroEquipas = findViewById(R.id.editNumero);


    }
    public void Guarda(View view)
    {
            int nequipas = Integer.parseInt(editNumeroEquipas.getText().toString());

            Torneios torneio = new Torneios();

            torneio.setNome(editNome.getText().toString());
            torneio.setNequipas(nequipas);


            Torneios.add(torneio, Realm.getDefaultInstance());

            Intent intent = new Intent(AddTorneio.this, MainActivity.class);
            startActivity(intent);
    }
}
