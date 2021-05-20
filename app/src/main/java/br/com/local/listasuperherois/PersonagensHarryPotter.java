package br.com.local.listasuperherois;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class PersonagensHarryPotter extends AppCompatActivity {
    //Declarar a variável que irá receber a ListView do XML
    ListView listView;
    //Criar os arrays que serão inseridos na listView

    /*arays dos nomes dos personagens que serão utilizados no seu projeto, eles fazem a busca na
    * ordem sequencial*/
    String nomePersonagens[] = {"Harry", "Hermione", "Ron", "Dumbledore",
            "Neville", "Snape", "Draco", "Voldemort"};

    /*arays das imagens dos personagens que serão utilizados no seu projeto, eles fazem a busca na
    * ordem sequencial*/
    int imgPersonagens[] = {R.drawable.harry, R.drawable.hermione,
            R.drawable.ron, R.drawable.dumbledore, R.drawable.neville,
            R.drawable.snape, R.drawable.draco, R.drawable.voldemort};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personagens_harry_potter); // layout do SuperHerois.java onde você esta localizado

        //a variavel listview está recebendo a listView XML

        //listaHerois é a id que esta localizada dentro de super_herois.xml
        listView = findViewById(R.id.listapersonagens);

        //Criar o objeto/classe que irá inserir o modelo na listView

        CustomAdapter adapter = new CustomAdapter();

        //Carregar o baseAdapter na listView
        listView.setAdapter(adapter);

        //Criando evento de click na listView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(getApplicationContext(), VisualizaHerois.class);
                //Passando valores de uma janela para outra

                //nomeHerois" deve estar igual no VizualizaHerois nomeHerois é o nome do seu array
                intent.putExtra("nomeHerois", nomePersonagens[i]);

                //imagemHerois" deve estar igual no VizualizaHerois nomeHerois é o nome do seu array
                intent.putExtra("imagemHerois", imgPersonagens[i]);

                startActivity(intent);

            }
        });


    }

    //inner class - Classe dentro de outra Classe
    public class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return imgPersonagens.length; //aqui tem que deixar o nome igual do seu arrays de imagens
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        //Montar o modelo para ser inserido na lista de planetas - ListView
        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {

            //aqui são as variáveis que você ira usar abaixo em txtNomeHerois e imagemHerois
            TextView txtNomeHerois;
            ImageView imagemHerois;

            //instanciando o modelo com os componentes para inserir na Lista

            //aqui é o nome do layout que ira inflar na tela no caso o lista_superherois.xml
            View carregaView = getLayoutInflater().inflate(R.layout.lista_superherois, null);

            //txtNomeHerois e imagemHerois são as variáveis que você setou a cima

            //txtListaHerois e imgListaHerois ficam detro de lista_superherois.xml
            txtNomeHerois = carregaView.findViewById(R.id.txtListaPersonagens);
            imagemHerois = carregaView.findViewById(R.id.imgListaPersonagens);

            //Carregando os valores nos componentes

            //txtNomeHerois e imagemHerois são as variáveis que você setou a cima

            //nomeHerois e imgHerois é o nome dos seus arrays
            txtNomeHerois.setText(nomePersonagens[position]);
            imagemHerois.setImageResource(imgPersonagens[position]);

            return carregaView;
        }
    }
}