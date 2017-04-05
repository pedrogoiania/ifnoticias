package ifnoticias.com.br.ifnoticias.View;

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
    Button eventosButton;
    Button agendaReitorButton;
    Button sobreButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        principaisNoticiasButton = (Button) findViewById(R.id.principaisNoticiasButton);
        comunicadosButton = (Button) findViewById(R.id.comunicadosButton);
        eventosButton = (Button) findViewById(R.id.eventosButton);
        sobreButton = (Button) findViewById(R.id.sobreButton);
        agendaReitorButton = (Button) findViewById(R.id.agendaReitorButton);

        principaisNoticiasButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, principaisNoticias.class);
                startActivity(intent);
            }
        });

        eventosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EventosNoticias.class);
                startActivity(intent);
            }
        });

        comunicadosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ComunicadosNoticias.class);
                startActivity(intent);
            }
        });

        agendaReitorButton.setOnClickListener(new View.OnClickListener() {
            String mensagem = "Em Desenvolvimento";
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, mensagem, Toast.LENGTH_LONG).show();
            }
        });

        sobreButton.setOnClickListener(new View.OnClickListener() {
            String mensagem = "Desenvolvido por: \n" +
                    "Alex Augusto, " +
                    "Danielle Almeida \n" +
                    "Milton Divino, " +
                    "Pedro Paulo \n" +
                    "Professor: Marcos Roriz \n" +
                    "IFG - Goiânia ~ " +
                    "Sistemas de Informção - Tópicos Avaçados \n";
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, mensagem, Toast.LENGTH_LONG).show();
            }
        });
    }

}
