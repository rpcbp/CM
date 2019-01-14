package a15828.edjd.trabalho;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NovoTorneio extends AppCompatActivity {

    String Nome;
    TextView NomeTorneio;
    TextView NumeroEquipas;

    TextView NomeEquipa1;
    TextView NomeEquipa2;
    TextView NomeEquipa3;
    TextView NomeEquipa4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_torneio);
        Bundle bundle = getIntent().getExtras();
        Nome = (String) bundle.get("Nome_torneio");
        setTitle(Nome);

        NomeTorneio = findViewById(R.id.textViewNome);
        NumeroEquipas = findViewById(R.id.textViewNumero);
        NomeEquipa1 = findViewById(R.id.textViewNomeEquipa1);
        NomeEquipa2 = findViewById(R.id.textViewNomeEquipa2);
        NomeEquipa3 = findViewById(R.id.textViewNomeEquipa3);
        NomeEquipa4 = findViewById(R.id.textViewNomeEquipa4);


        NomeTorneio.setText((String) bundle.get("Nome_torneio"));
        NumeroEquipas.setText(""+ bundle.get("NumeroEquipas_torneio"));

        NomeEquipa1.setText((String)bundle.get("nome1_equipa"));
        NomeEquipa2.setText((String)bundle.get("nome2_equipa"));
        NomeEquipa3.setText((String)bundle.get("nome3_equipa"));
        NomeEquipa4.setText((String)bundle.get("nome4_equipa"));

    }

        public void Equipa (View view)
        {

            String nometorneio = NomeTorneio.getText().toString();
            String numeroequipas = NumeroEquipas.getText().toString();
            Intent intent = new Intent(NovoTorneio.this, AdicionarEquipas.class);
            intent.putExtra("Nome_torneio", nometorneio);
            intent.putExtra("NumeroEquipas_torneio", numeroequipas);
            startActivity(intent);
        }
        public void ResultadoEClassificacao(View view)
        {
            String nome1 = NomeEquipa1.getText().toString();
            String nome2=NomeEquipa2.getText().toString();
            String nome3=NomeEquipa3.getText().toString();
            String nome4=NomeEquipa4.getText().toString();
            Intent intent = new Intent(NovoTorneio.this,ClassEResult.class);
            intent.putExtra("nome1_equipa",nome1);
            intent.putExtra("nome2_equipa",nome2);
            intent.putExtra("nome3_equipa",nome3);
            intent.putExtra("nome4_equipa",nome4);
            startActivity(intent);
        }
}
