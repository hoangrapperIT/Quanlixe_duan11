package com.byhoangrapper.quanlixe.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.byhoangrapper.quanlixe.R;
import com.byhoangrapper.quanlixe.adapter.CustomAdapter;
import com.byhoangrapper.quanlixe.dao.ItemDAO;
import com.byhoangrapper.quanlixe.model.Itemdsxe;
import com.byhoangrapper.quanlixe.sqlite.SqliteHelper;

import java.util.ArrayList;
import java.util.List;

public class DanhsachActivity extends AppCompatActivity {
    private ListView lvds;
    private SqliteHelper sqliteHelper;
    private  CustomAdapter adapter;
    ArrayList<Itemdsxe> Itemdsxe;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsach);

        lvds=findViewById(R.id.lvds);


        sqliteHelper=new SqliteHelper(this);




        final ItemDAO itemDAO = new ItemDAO(sqliteHelper);
        final List<Itemdsxe> arrayList=itemDAO.getAllItems();

        final CustomAdapter adapter = new CustomAdapter(this,R.layout.listviewds, (ArrayList<com.byhoangrapper.quanlixe.model.Itemdsxe>) arrayList);
        lvds.setAdapter(adapter);
lvds.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(DanhsachActivity.this);
        alertDialogBuilder.setMessage("Bán có muốn xóa sản phẩm này!");
        alertDialogBuilder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                arrayList.remove(i);itemDAO.deleteItem(i);
                //cập nhật lại listview
                adapter.notifyDataSetChanged();
                com.byhoangrapper.quanlixe.model.Itemdsxe itemdsxe= new Itemdsxe();
                itemDAO.updateItem(itemdsxe);
                lvds.setAdapter(adapter);

            }
        });
        alertDialogBuilder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //không làm gì
            }
        });
        alertDialogBuilder.show();

    }


});

        }






    }
