package br.com.ajkfreitas.securepasswordgenerator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private PasswordGenerator generator = new PasswordGenerator();
    private Button generate;
    private EditText size;
    private TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        size = (EditText) findViewById(R.id.size);
        password = (TextView) findViewById(R.id.password);
        generate = (Button) findViewById(R.id.button_gerar);

        password.setText("");

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                generator.setSize(Integer.parseInt(size.getText().toString()));

                password.setText(generator.generate());
            }
        });
    }
}
