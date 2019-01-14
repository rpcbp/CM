package a15828.edjd.trabalho;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ClassEResult extends AppCompatActivity {

    TextView nome1,nome2,nome3,nome4;
    TextView nome11,nome22,nome33,nome44;
    TextView nome111,nome222,nome333,nome444;

    EditText golos1,golos2,golos3,golos4;
    EditText golos11,golos22,golos33,golos44;
    EditText golos111,golos222,golos333,golos444;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        setContentView(R.layout.activity_class_eresult);

        setTitle("Jogos");
        nome1 = findViewById(R.id.editNome1);
        nome11=findViewById(R.id.editNome11);
        nome111=findViewById(R.id.editNome111);
        nome2 = findViewById(R.id.editNome2);
        nome22 = findViewById(R.id.editNome22);
        nome222 = findViewById(R.id.editNome222);
        nome3 = findViewById(R.id.editNome3);
        nome33 = findViewById(R.id.editNome33);
        nome333 = findViewById(R.id.editNome333);
        nome4 = findViewById(R.id.editNome4);
        nome44 = findViewById(R.id.editNome44);
        nome444 = findViewById(R.id.editNome444);


        golos1 = findViewById(R.id.equipa1golos);
        golos11 = findViewById(R.id.equipa11golos);
        golos111 = findViewById(R.id.equipa111golos);
        golos2 = findViewById(R.id.equipa2golos);
        golos22 = findViewById(R.id.equipa22golos);
        golos222 = findViewById(R.id.equipa222golos);
        golos3=findViewById(R.id.equipa3golos);
        golos33=findViewById(R.id.equipa33golos);
        golos333=findViewById(R.id.equipa333golos);
        golos4=findViewById(R.id.equipa4golos);
        golos44=findViewById(R.id.equipa44golos);
        golos444=findViewById(R.id.equipa444golos);


        nome1.setText((String) bundle.get("nome1_equipa"));
        nome11.setText((String) bundle.get("nome1_equipa"));
        nome111.setText((String) bundle.get("nome1_equipa"));
        nome2.setText((String) bundle.get("nome2_equipa"));
        nome22.setText((String) bundle.get("nome2_equipa"));
        nome222.setText((String) bundle.get("nome2_equipa"));
        nome3.setText((String)bundle.get("nome3_equipa"));
        nome33.setText((String)bundle.get("nome3_equipa"));
        nome333.setText((String)bundle.get("nome3_equipa"));
        nome4.setText((String)bundle.get("nome4_equipa"));
        nome44.setText((String)bundle.get("nome4_equipa"));
        nome444.setText((String)bundle.get("nome4_equipa"));
    }

        public void Resultado(View view)
        {
            String Nome1=nome1.getText().toString();
            String Nome2=nome2.getText().toString();
            String Nome3=nome3.getText().toString();
            String Nome4=nome4.getText().toString();
            String g1 = golos1.getText().toString();
            String g11 = golos11.getText().toString();
            String g111 = golos111.getText().toString();
            String g2= golos2.getText().toString();
            String g22= golos22.getText().toString();
            String g222= golos222.getText().toString();
            String g3= golos3.getText().toString();
            String g33= golos33.getText().toString();
            String g333= golos333.getText().toString();
            String g4= golos4.getText().toString();
            String g44= golos44.getText().toString();
            String g444= golos444.getText().toString();
            Intent intent = new Intent(ClassEResult.this, Resultado.class);
            intent.putExtra("golos1",g1);
            intent.putExtra("golos11",g11);
            intent.putExtra("golos111",g111);
            intent.putExtra("golos2",g2);
            intent.putExtra("golos22",g22);
            intent.putExtra("golos222",g222);
            intent.putExtra("golos3",g3);
            intent.putExtra("golos33",g33);
            intent.putExtra("golos333",g333);
            intent.putExtra("golos4",g4);
            intent.putExtra("golos44",g44);
            intent.putExtra("golos444",g444);
            intent.putExtra("nome1",Nome1);
            intent.putExtra("nome2",Nome2);
            intent.putExtra("nome3",Nome3);
            intent.putExtra("nome4",Nome4);

            startActivity(intent);
        }


    }

