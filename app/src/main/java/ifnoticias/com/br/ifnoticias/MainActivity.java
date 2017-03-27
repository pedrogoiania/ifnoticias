package ifnoticias.com.br.ifnoticias;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    TextView textView2;
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.Texto1);
        textView2 = (TextView) findViewById(R.id.Texto2);
        textView3 = (TextView) findViewById(R.id.Texto3);

//        new ParsePage().execute();
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

            Log.d("POST EXECUTE: ", "onPostExecute: rodou");

            ArrayList<String> arrayList = new ArrayList<>();

            for(Element e : elements){
                arrayList.add(e.text().toString());
                Log.d("Element e ", e.text().toString());
            }

           textView.setText(arrayList.get(0).toString());
           textView2.setText(arrayList.get(1).toString());
           textView3.setText(arrayList.get(2).toString());

        }
    }

}
