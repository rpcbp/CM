package a15828.edjd.trabalho;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AdicionarEquipas extends AppCompatActivity {

    String NomeTorneio;
    String NumeroEquipas;
    EditText Nome1;
    EditText Nome2;
    EditText Nome3;
    EditText Nome4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        setContentView(R.layout.activity_adicionar_equipas);

        setTitle("Equipas");

        Nome1 = findViewById(R.id.editNome1);
        Nome2 = findViewById(R.id.editNome2);
        Nome3 = findViewById(R.id.editNome3);
        Nome4 = findViewById(R.id.editNome4);
        NomeTorneio = (String) bundle.get("Nome_torneio");
        NumeroEquipas = (String)bundle.get("NumeroEquipas_torneio");
    }
    public void Guarda(View view)
    {
        String nome1 = Nome1.getText().toString();
        String nome2= Nome2.getText().toString();
        String nome3=Nome3.getText().toString();
        String nome4=Nome4.getText().toString();
        Intent intent = new Intent(AdicionarEquipas.this, NovoTorneio.class);
        intent.putExtra("nome1_equipa",nome1);
        intent.putExtra("nome2_equipa",nome2);
        intent.putExtra("nome3_equipa",nome3);
        intent.putExtra("nome4_equipa",nome4);
        intent.putExtra("Nome_torneio", NomeTorneio);
        intent.putExtra("NumeroEquipas_torneio", NumeroEquipas);

        startActivity(intent);
    }
}
