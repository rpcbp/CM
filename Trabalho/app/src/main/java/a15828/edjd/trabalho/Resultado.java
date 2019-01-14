package a15828.edjd.trabalho;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    String golos1,golos2,golos3,golos4;
    String golos11,golos22,golos33,golos44;
    String golos111,golos222,golos333,golos444;

    int Pontos1=0,Pontos2=0,Pontos3=0,Pontos4=0;
    int gm1=0,gm2=0,gm3=0,gm4=0;

    TextView equipa1,pontos1,g1;
    TextView equipa2,pontos2,g2;
    TextView equipa3,pontos3,g3;
    TextView equipa4,pontos4,g4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Bundle bundle = getIntent().getExtras();

        setTitle("Resultados");

        golos1 = (String) bundle.get("golos1");
        golos11 = (String) bundle.get("golos11");
        golos111 = (String) bundle.get("golos111");
        golos2 = (String) bundle.get("golos2");
        golos22 = (String) bundle.get("golos22");
        golos222 = (String) bundle.get("golos222");
        golos3 = (String) bundle.get("golos3");
        golos33 = (String) bundle.get("golos33");
        golos333 = (String) bundle.get("golos333");
        golos4 = (String) bundle.get("golos4");
        golos44 = (String) bundle.get("golos44");
        golos444 = (String) bundle.get("golos444");

        equipa1=findViewById(R.id.equipa1);
        pontos1=findViewById(R.id.pontos1);
        g1=findViewById(R.id.gm1);
        equipa2=findViewById(R.id.equipa2);
        pontos2=findViewById(R.id.pontos2);
        g2=findViewById(R.id.gm2);
        equipa3=findViewById(R.id.equipa3);
        pontos3=findViewById(R.id.pontos3);
        g3=findViewById(R.id.gm3);
        equipa4=findViewById(R.id.equipa4);
        pontos4=findViewById(R.id.pontos4);
        g4=findViewById(R.id.gm4);

        equipa1.setText((String)bundle.get("nome1"));
        equipa2.setText((String)bundle.get("nome2"));
        equipa3.setText((String)bundle.get("nome3"));
        equipa4.setText((String)bundle.get("nome4"));

        int ngolos1= Integer.parseInt(golos1);
        int ngolos11= Integer.parseInt(golos11);
        int ngolos111= Integer.parseInt(golos111);
        int ngolos2=Integer.parseInt(golos2);
        int ngolos22=Integer.parseInt(golos22);
        int ngolos222=Integer.parseInt(golos222);
        int ngolos3=Integer.parseInt(golos3);
        int ngolos33=Integer.parseInt(golos33);
        int ngolos333=Integer.parseInt(golos333);
        int ngolos4=Integer.parseInt(golos4);
        int ngolos44=Integer.parseInt(golos44);
        int ngolos444=Integer.parseInt(golos444);

        gm1=ngolos1+ngolos11+ngolos111;
        gm2=ngolos2+ngolos22+ngolos222;
        gm3=ngolos3+ngolos33+ngolos333;
        gm4=ngolos4+ngolos44+ngolos444;



        int aux1=VerificaResultado(ngolos1,ngolos2);
        if (aux1 == 1)
        {
            Pontos1 += 3;
        }
        if (aux1==0)
        {
            Pontos1 +=1;
            Pontos2 +=1;
        }
        if(aux1==2)
        {
            Pontos2+=3;
        }
        int aux2=VerificaResultado(ngolos11,ngolos3);
        if (aux2 == 1)
        {
            Pontos1 += 3;
        }
        if (aux2==0)
        {
            Pontos1 +=1;
            Pontos3 +=1;
        }
        if(aux2==2)
        {
            Pontos3+=3;
        }
        int aux3=VerificaResultado(ngolos111,ngolos4);
        if (aux3 == 1)
        {
            Pontos1 += 3;
        }
        if (aux3==0)
        {
            Pontos1 +=1;
            Pontos4 +=1;
        }
        if(aux3==2)
        {
            Pontos4+=3;
        }
        int aux4=VerificaResultado(ngolos22,ngolos33);
        if (aux4 == 1)
        {
            Pontos2 += 3;
        }
        if (aux4==0)
        {
            Pontos2 +=1;
            Pontos3 +=1;
        }
        if(aux4==2)
        {
            Pontos3+=3;
        }
        int aux5=VerificaResultado(ngolos222,ngolos44);
        if (aux5 == 1)
        {
            Pontos2 += 3;
        }
        if (aux5==0)
        {
            Pontos2 +=1;
            Pontos4 +=1;
        }
        if(aux5==2)
        {
            Pontos4+=3;
        }
        int aux6=VerificaResultado(ngolos333,ngolos444);
        if (aux6 == 1)
        {
            Pontos3 += 3;
        }
        if (aux6==0)
        {
            Pontos3 +=1;
            Pontos4 +=1;
        }
        if(aux6==2)
        {
            Pontos4+=3;
        }
        pontos1.setText(Pontos1+"pontos");
        g1.setText(gm1+"golos marcados");
        pontos2.setText(Pontos2+"pontos");
        g2.setText(gm2+"golos marcados");
        pontos3.setText(Pontos3+"pontos");
        g3.setText(gm3+"golos marcados");
        pontos4.setText(Pontos4+"pontos");
        g4.setText(gm4+"golos marcados");

    }
    public int VerificaResultado(int n1,int n2)
    {
        if (n1 > n2) {
            return 1;
        }
        if (n1 == n2)
        {
            return 0;
        }
        if(n1 < n2)
        {
            return  2;
        }
        return 50;
    }
}
