package morandoso.android.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        getSupportActionBar().hide();
    }

    public void abrirAliment(View view){
        startActivity(new Intent(getApplicationContext(), alimentacao.class));
    }

    public void abrirEmergencia(View view){
        startActivity(new Intent(getApplicationContext(), emergencia.class));
    }

    public void abrirLimpeza(View view){
        startActivity(new Intent(getApplicationContext(), limpeza.class));
    }

    public void abrirLocalize(View view){
        startActivity(new Intent(getApplicationContext(), localize.class));
    }

    public void abrirManutencao(View view){
        startActivity(new Intent(getApplicationContext(), manutencao.class));
    }

    public void abrirSaude(View view){
        startActivity(new Intent(getApplicationContext(), saude.class));
    }
}
