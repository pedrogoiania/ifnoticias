package ifnoticias.com.br.ifnoticias.Controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import ifnoticias.com.br.ifnoticias.R;

public class MainActivity extends Activity {

    Button principaisNoticiasButton;
    Button comunicadosButton;
    Button sobreButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        principaisNoticiasButton = (Button) findViewById(R.id.principaisNoticiasButton);
        comunicadosButton = (Button) findViewById(R.id.comunicadosButton);
        sobreButton = (Button) findViewById(R.id.sobreButton);

        principaisNoticiasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, principaisNoticias.class);
                startActivity(intent);
            }
        });

        comunicadosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Em desenvolvimento", Toast.LENGTH_LONG).show();
            }
        });

        sobreButton.setOnClickListener(new View.OnClickListener() {
            String mensagem = "Desenvolvido por: \n " +
                    "Alex Augusto \n" +
                    "Danielle Almeida \n" +
                    "Milton Divino \n" +
                    "Pedro Paulo \n" +
                    "Professor: Marcos Roriz \n" +
                    "IFG - Goiânia \n" +
                    "Sistemas de Informção - Tópicos Avaçados \n";
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, mensagem, Toast.LENGTH_LONG).show();
            }
        });
    }

}
