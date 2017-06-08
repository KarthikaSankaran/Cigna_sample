package com.evaluation.karthika.sampleboxes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnSubmit;
    EditText edtNumber;
    TextView textView;
    int minimun=1,maximum=10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSubmit=(Button)findViewById(R.id.submit_button);
        edtNumber=(EditText)findViewById(R.id.number_editText);
        textView=(TextView)findViewById(R.id.textView2);

        textView.setText("Enter any number from "+minimun+ " to "+ maximum);
        edtNumber.setFilters(new InputFilter[]{new InputFilterMinMax(minimun,maximum)});

    }
    public void onClick(View v) {
        Intent intent = new Intent(this, BoxActivity.class);
        String message = edtNumber.getText().toString();
        if(message.isEmpty()){
            Toast.makeText(this,"Please enter any number between "+minimun+" to "+maximum,Toast.LENGTH_SHORT).show();
        }else {
            intent.putExtra("BOX NUMBER", message);
            startActivity(intent);
        }

    }


    public class  InputFilterMinMax implements InputFilter{
        private  int min,max;
        public  InputFilterMinMax(int min,int max){
            this.max=max;
            this.min=min;
        }
        public  InputFilterMinMax(String min,String max){
            this.min=Integer.parseInt(min);
            this.max=Integer.parseInt(max);
        }

        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            try{
                int input=Integer.parseInt((dest.toString()+source.toString()));
                if(isInRange(min,max,input))
                    return null;

            }catch (NumberFormatException e){ }
            return "";
        }
            private boolean isInRange(int a,int b,int c){
            return b>a?c>=a&&c<=b:c>=b&&c<=a;
        }
    }
}
