package br.unigran.controleabastecimento;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.unigran.R;
import br.unigran.bancodados.AbastecimentoDB;
import br.unigran.bancodados.DBHelper;

public class MainActivity extends AppCompatActivity {

    EditText kmAtual;
    EditText qntAbastecida;
    EditText dia;
    EditText valor;
    List<Abastecimento>dados;
    ListView listagem;
    DBHelper db;
    AbastecimentoDB abastecimentoDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DBHelper(this);
        kmAtual=findViewById(R.id.kmId);
        qntAbastecida=findViewById(R.id.qntAbastecidaId);
        dia=findViewById(R.id.diaId);
        valor=findViewById(R.id.valorId);
        dados = new ArrayList<>();
        listagem=findViewById(R.id.listaId);

        ArrayAdapter adapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,dados);
        listagem.setAdapter(adapter);
        abastecimentoDB=new AbastecimentoDB(db);
        abastecimentoDB.lista(dados);

    }
    public void acoes(){
        listagem.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                new AlertDialog.Builder(view.getContext()).setMessage("Deseja remover").setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int k) {
                        abastecimentoDB.remover(dados.get(i).getId());
                        abastecimentoDB.lista(dados);
                    }
                }).setNegativeButton("Cancelar",null).create().show();


                return false;
            }
        });
    }
    private void limpar(){
        kmAtual.setText("");
        qntAbastecida.setText("");
        dia.setText("");
        valor.setText("");

    }
    public void desistir(View view){
        limpar();
    }



    public void salvar(View view){
        Abastecimento abastecimento = new Abastecimento();
        abastecimento.setKmAtual(kmAtual.getText().toString());
        abastecimento.setQntAbastecida(qntAbastecida.getText().toString());
        abastecimento.setDia(dia.getText().toString());
        abastecimento.setValor(valor.getText().toString());

        abastecimentoDB.inserir(abastecimento);
        abastecimentoDB.lista(dados);

        ((ArrayAdapter) listagem.getAdapter()).notifyDataSetChanged();
        limpar();



    }
}