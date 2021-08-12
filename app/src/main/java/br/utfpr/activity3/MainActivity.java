package br.utfpr.activity3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public  void abreSiteUtfpr(View view){
        abreSite(getString(R.string.http) + getString(R.string.siteUtfpr));
    }
    private void abreSite(String url){

        //Exibição de dados de outra aplicação
        Intent intent = new Intent(Intent.ACTION_VIEW);

        //Parse para URI
        intent.setData(Uri.parse(url));

        //testa para saber se o SO pode atender a minha solicitação
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }else{
            Toast.makeText(this, R.string.nenhum_aplicativo_instalado, Toast.LENGTH_LONG).show();
        }
    }

}