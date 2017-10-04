package br.com.ajkfreitas.securepasswordgenerator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private PasswordGenerator generator = new PasswordGenerator();
    private Button generate;
    private Button limpar;
    private EditText size;
    private TextView password;

    private CheckBox radioSimbolos;
    private CheckBox radioNumber;
    private CheckBox radioLowerCase;
    private CheckBox radioUperCase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        size = (EditText) findViewById(R.id.size);
        password = (TextView) findViewById(R.id.password);
        generate = (Button) findViewById(R.id.button_gerar);


        radioNumber =(CheckBox) findViewById(R.id.radioNumber);
        radioSimbolos =(CheckBox) findViewById(R.id.radioSpecialCharacter);
        radioLowerCase =(CheckBox) findViewById(R.id.radioLowerCase);
        radioUperCase =(CheckBox) findViewById(R.id.radioUperCase);

        password.setText("");

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean s =  radioSimbolos.isChecked();
                boolean n = radioNumber.isChecked();
                boolean l = radioLowerCase.isChecked();
                boolean u = radioUperCase.isChecked();
                if(validarChecBox(s,n,l,u)) {
                    PasswordGenerator generator = new PasswordGenerator(s, n, l, u);
                    generator.setSize(Integer.parseInt(size.getText().toString()));

                password.setText(generator.generate());
                }
            }
        });

    }
     public boolean validarChecBox(boolean simb, boolean number , boolean lowerC, boolean uperC){
        if(simb || number || lowerC || uperC){
         return true;
         }
         Toast.makeText(MainActivity.this, "Selecione pelomenos uma opção de filtro!",Toast.LENGTH_SHORT).show();
         return false;
     }
}
