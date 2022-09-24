package br.unigran.bancodados;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import br.unigran.controleabastecimento.Abastecimento;

public class AbastecimentoDB {
    private DBHelper db;
    private SQLiteDatabase conexao;
    public AbastecimentoDB(DBHelper db){this.db=db;}

    public void inserir(Abastecimento abastecimento){
        conexao = db.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("kmAtual",abastecimento.getKmAtual());
        valores.put("qntAbastecida",abastecimento.getQntAbastecida());
        valores.put("dia",abastecimento.getDia());
        valores.put("valor",abastecimento.getValor());

        if (abastecimento.getId()>0)
            conexao.update("abastecimento",valores,"id=?", new String[]{abastecimento.getId().toString()});
        else
            conexao.insertOrThrow("abastecimento",null,valores);
        conexao.close();

    }
    public void atualizar(){}
    public void remover(int id){
        conexao=db.getWritableDatabase();
        conexao.delete("abastecimento","id=?",new String[]{id+""});
    }
    public void lista(List dados){
        dados.clear();
        conexao=db.getReadableDatabase();
        String names[]={"id","kmAtual","qntAbastecida","dia","valor"};
        Cursor query = conexao.query("abastecimento",names,null,null,null,null,"kmAtual");
        while(query.moveToNext()){
            Abastecimento abastecimento = new Abastecimento();
            abastecimento.setId(Integer.parseInt(query.getString(0)));
            abastecimento.setKmAtual(query.getString(1));
            abastecimento.setQntAbastecida(query.getString(2));
            abastecimento.setDia(query.getString(3));
            abastecimento.setValor(query.getString(4));
            dados.add(abastecimento);
        }
        conexao.close();
    }
}
