package ifnoticias.com.br.ifnoticias;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.Texto1);

        new ParsePage().execute();
    }


    class ParsePage extends AsyncTask<String,Void,String>{

        Elements elements = new Elements();

        @Override
        protected String doInBackground(String... params) {
            Document doc;

            try{
                doc = Jsoup.connect("http://ifg.edu.br").get();
                elements = doc.getElementsByClass("contentpagetitle");

            }catch (IOException e){
                e.printStackTrace();
            }


            return "rodou";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            ArrayList<String> arrayList = new ArrayList<>();

            for(Element e : elements){
                arrayList.add(e.text().toString());
            }

           textView.setText(arrayList.get(0));

        }
    }

}
