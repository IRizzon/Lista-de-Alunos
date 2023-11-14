package com.example.apptest.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.apptest.Controller.CursoController;
import com.example.apptest.Controller.PessoaController;
import com.example.apptest.Model.Curso;
import com.example.apptest.R;
import com.example.apptest.Model.Pessoa;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    PessoaController control;

    CursoController cursoControl;
    List<String> Cursos;

    Pessoa pessoa;

    EditText idNome;
    EditText idSobrenome;
    EditText idMatricula;
    EditText idCPF;

    Button idClear;
    Button idSave;
    Button idEnd;

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        control = new PessoaController(MainActivity.this);
        control.toString();

        cursoControl = new CursoController();
        Cursos = cursoControl.getListaCurso();

        pessoa = new Pessoa();

        control.Buscar(pessoa);

        idNome = findViewById(R.id.idNome);
        idSobrenome = findViewById(R.id.idSobrenome);
        idMatricula = findViewById(R.id.idMatricula);
        idCPF = findViewById(R.id.idCPF);

        idSave = findViewById(R.id.idSave);
        idClear = findViewById(R.id.idClear);
        idEnd = findViewById(R.id.idEnd);

        idNome.setText(pessoa.getNome());
        idSobrenome.setText(pessoa.getSobrenome());
        idMatricula.setText(pessoa.getMatricula());
        idCPF.setText(pessoa.getCPF());

        spinner = findViewById(R.id.idlistacurso);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, cursoControl.dataSpinner());
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter(adapter);

        idClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                idNome.setText("");
                idSobrenome.setText("");
                idMatricula.setText("");
                idCPF.setText("");
                control.Limpar(pessoa);

            }
        });

        idEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "Aplicativo Finalizado", Toast.LENGTH_LONG).show();
                finish();

            }
        });

        idSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pessoa.setNome(idNome.getText().toString());
                pessoa.setSobrenome(idSobrenome.getText().toString());
                pessoa.setMatricula(idMatricula.getText().toString());
                pessoa.setCPF(idCPF.getText().toString());

                Toast.makeText(MainActivity.this, "Dados Salvos", Toast.LENGTH_LONG).show();


                control.Salvar(pessoa);

                Log.i("Teste:", pessoa.toString());

            }
        });

    }
}