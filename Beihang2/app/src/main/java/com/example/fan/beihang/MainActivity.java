package com.example.fan.beihang;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TextWatcher,MainView{


    EditText appSou;


    ListView appSouList;

    RelativeLayout activitySou;



    private String asou;
    private List<Data>  dataList;
    private SearchPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appSouList = (ListView)findViewById(R.id.app_sou_list);
        appSou = (EditText)findViewById(R.id.app_sou);
        appSou.addTextChangedListener(this);
        presenter = new SearchPresenterImpl(this,this);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        //获取输入框的值
        asou = appSou.getText().toString().trim();

        presenter.searh(asou);
        //Toast.makeText(MainActivity.this,"张onTextChanged",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void afterTextChanged(Editable editable) {
        //presenter.searh("张");

    }

    public void searchList(JsonsRootBean jsonsRootBean){

        dataList = jsonsRootBean.getData();


        ArrayList<String> list=new ArrayList<String>();


        for (int i=0;i<dataList.size();i++){
            list.add(dataList.get(i).getName());
        }



        String[] strings = new String[list.size()];

        list.toArray(strings);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this, android.R.layout.simple_list_item_1, strings);

        appSouList.setAdapter(adapter);

    }



}
