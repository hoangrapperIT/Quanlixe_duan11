package com.byhoangrapper.quanlixe.activity;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.byhoangrapper.quanlixe.R;
import com.byhoangrapper.quanlixe.dao.ItemDAO;
import com.byhoangrapper.quanlixe.model.Itemdsxe;
import com.byhoangrapper.quanlixe.sqlite.SqliteHelper;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

public class AddActivity extends AppCompatActivity {
    private ItemDAO itemDAO;
    private Button btThem, btsua, btxoa;
    private EditText edMa, edTen, edMausac, edGia, edSoluong, edID;
    private ListView lvds;
    private SqliteHelper sqliteHelper;
    private Cursor cursor;

    private ArrayList<Itemdsxe> arrayList;



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        sqliteHelper = new SqliteHelper(this);

        arrayList=new ArrayList<>();
        itemDAO = new ItemDAO(sqliteHelper);

        btThem = findViewById(R.id.btSave);
        btsua = findViewById(R.id.btedit);
        btxoa = findViewById(R.id.btxoa);
        edMa = findViewById(R.id.edMa);
        edTen = findViewById(R.id.edName);
        edMausac = findViewById(R.id.edMausac);
        edGia = findViewById(R.id.edGiaban);
        edSoluong = findViewById(R.id.edSoluong);


        btThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Itemdsxe itemdsxe = new Itemdsxe();
                String MAXE = edMa.getText().toString();
                String TENLOAIXE = edTen.getText().toString();
                String MAUSAC = edMausac.getText().toString();
                String GIA = (edGia.getText().toString());
                String SOLUONGCON = (edSoluong.getText().toString());


                itemdsxe.maxe= MAXE;
                itemdsxe.tenloaixe= TENLOAIXE;
                itemdsxe.mausac= MAUSAC;
                itemdsxe.gia= GIA;
                itemdsxe.soluongcon= SOLUONGCON;
                itemDAO.insertItem(itemdsxe);
                itemDAO.getItemByID(itemdsxe);
                Toast.makeText(AddActivity.this,"Isert thành công!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplication(),DanhsachActivity.class);

                startActivity(intent);




            }

        });
        btsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Itemdsxe itemdsxe = new Itemdsxe();
                String MAXE = edMa.getText().toString();
                String TENLOAIXE = edTen.getText().toString();
                String MAUSAC = edMausac.getText().toString();
                String GIA = (edGia.getText().toString());
                String SOLUONGCON = (edSoluong.getText().toString());


                itemdsxe.maxe= MAXE;
                itemdsxe.tenloaixe= TENLOAIXE;
                itemdsxe.mausac= MAUSAC;
                itemdsxe.gia= GIA;
                itemdsxe.soluongcon= SOLUONGCON;
                itemDAO.updateItem(itemdsxe);
                itemDAO.getItemByID(itemdsxe);
                Intent intent = new Intent(getApplication(),DanhsachActivity.class);

                startActivity(intent);



            }
        });
        btxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_CANCELED, returnIntent);
                finish();
            }
        });

    }

}