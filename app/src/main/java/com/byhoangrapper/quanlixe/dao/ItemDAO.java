package com.byhoangrapper.quanlixe.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.byhoangrapper.quanlixe.model.Itemdsxe;
import com.byhoangrapper.quanlixe.sqlite.SqliteHelper;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static com.byhoangrapper.quanlixe.common.Constants.ITEM_GIA;
import static com.byhoangrapper.quanlixe.common.Constants.ITEM_ID;
import static com.byhoangrapper.quanlixe.common.Constants.ITEM_MAUSAC;
import static com.byhoangrapper.quanlixe.common.Constants.ITEM_MAXE;
import static com.byhoangrapper.quanlixe.common.Constants.ITEM_SOLUONGCON;
import static com.byhoangrapper.quanlixe.common.Constants.ITEM_TABLE;
import static com.byhoangrapper.quanlixe.common.Constants.ITEM_TENLOAIXE;

public class ItemDAO {

    private SQLiteDatabase sqLiteDatabase;

    private SqliteHelper sqliteHelper;

    public ItemDAO(SqliteHelper sqliteHelper) {
        this.sqliteHelper = sqliteHelper;
    }

    public List<Itemdsxe> getAllItems() {

        // xin quyen doc ghi vao DB
        sqLiteDatabase = sqliteHelper.getWritableDatabase();


        // Khoi tao 1 list item rong~ de luu du lieu
        List<Itemdsxe> items = new ArrayList<>();


        // khai bao cau lenh query toan bo bang item
        String GET_ALL_ITEMS = "SELECT * FROM " + ITEM_TABLE;

        // viet cau lenh query va tra ket qua vao doi tuong con tro? la Cursor
        Cursor cursor = sqLiteDatabase.rawQuery(GET_ALL_ITEMS, null);


        // Kiem tra gia tri con tro truoc khi doc du lieu de tranh crash app
        if (cursor != null & cursor.getCount() > 0) {
            // di chuyen con tro toi vi tri dau tien
            cursor.moveToFirst();

            // vong while chay toi khi nao het gia tri trong con tro Cursor
            while (!cursor.isAfterLast()){


                // lay gia tri cac column theo Column Index (or theo ten cot)
                int id = cursor.getInt(cursor.getColumnIndex(ITEM_ID));
                String maxe = cursor.getString(cursor.getColumnIndex(ITEM_MAXE));
                String tenloaixe = cursor.getString(cursor.getColumnIndex(ITEM_TENLOAIXE));
                String mausac = cursor.getString(cursor.getColumnIndex(ITEM_MAUSAC));
                String gia = cursor.getString(cursor.getColumnIndex(ITEM_GIA));
                String soluongcon = cursor.getString(cursor.getColumnIndex(ITEM_SOLUONGCON));


                // gan du lieu lay dc vao model Item
                Itemdsxe item = new Itemdsxe();
                item.id = id;
                item.maxe = maxe;
                item.tenloaixe = tenloaixe;
                item.mausac = mausac;
                item.gia=gia;
                item.soluongcon=soluongcon;

                // them item da dc gan du lieu vao List Item
                items.add(item);

                // di chuyen toi phan tu tiep theo
                cursor.moveToNext();
            }

            // close ket noi, giai phong bo nho
            cursor.close();
            sqLiteDatabase.close();

        }
        // tra ve ket qua la items (List)
        return items;
    }
    public List<Itemdsxe> getItemxe() throws ParseException {
        String sql = "SELECT * FROM item_table";
        return getPr(sql);
    }

    public List<Itemdsxe> getPr(String sql, String...selectionArgs)  {
        List<Itemdsxe> list = new ArrayList<>();
        Cursor cursor =sqLiteDatabase.rawQuery(sql,selectionArgs);
        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex(ITEM_ID));


            String maxe = cursor.getString(cursor.getColumnIndex(ITEM_MAXE));
            String tenloaixe = cursor.getString(cursor.getColumnIndex(ITEM_TENLOAIXE));
            String mausac = cursor.getString(cursor.getColumnIndex(ITEM_MAUSAC));
            String gia = cursor.getString(cursor.getColumnIndex(ITEM_MAUSAC));
            String soluongcon = cursor.getString(cursor.getColumnIndex(ITEM_SOLUONGCON));
            Itemdsxe item = new Itemdsxe();
            item.id = id;
            item.maxe = maxe;
            item.tenloaixe = tenloaixe;
            item.mausac = mausac;
            item.gia=gia;
            item.soluongcon=soluongcon;
            list.add(item);
        }
        return list;
    }
    public Itemdsxe getItemByID (Itemdsxe itemId){
        Itemdsxe item = null;

        sqLiteDatabase = sqliteHelper.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.query(ITEM_TABLE,
                new String[]{ITEM_ID,ITEM_MAXE,ITEM_TENLOAIXE,ITEM_MAUSAC,ITEM_GIA,ITEM_SOLUONGCON},ITEM_ID + "=?",
                new String[]{String.valueOf(itemId)},null,null,null,null);

        // Kiem tra gia tri con tro truoc khi doc du lieu de tranh crash app
        if (cursor != null & cursor.getCount() > 0) {
            // di chuyen con tro toi vi tri dau tien
            cursor.moveToFirst();

            // lay gia tri cac column theo Column Index (or theo ten cot)
            int id = cursor.getInt(cursor.getColumnIndex(ITEM_ID));
            String maxe = cursor.getString(cursor.getColumnIndex(ITEM_MAXE));
            String tenloaixe = cursor.getString(cursor.getColumnIndex(ITEM_TENLOAIXE));
            String mausac = cursor.getString(cursor.getColumnIndex(ITEM_MAUSAC));
            String gia= cursor.getString(cursor.getColumnIndex(ITEM_GIA));
            String soluongcon = cursor.getString(cursor.getColumnIndex(ITEM_SOLUONGCON));

            // gan du lieu lay dc vao model Item
            item = new Itemdsxe();
            item.id = id;
            item.maxe=maxe;
            item.tenloaixe = tenloaixe;
            item.mausac = gia;
            item.gia = mausac;
            item.soluongcon=soluongcon;

            // di chuyen toi phan tu tiep theo
            cursor.moveToNext();
        }

        // close ket noi, giai phong bo nho
        cursor.close();
        sqLiteDatabase.close();

        return item;
    }

    public long updateItem(Itemdsxe item){

        sqLiteDatabase = sqliteHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(ITEM_ID,item.id);
        contentValues.put(ITEM_MAXE,item.maxe);
        contentValues.put(ITEM_TENLOAIXE,item.tenloaixe);
        contentValues.put(ITEM_MAUSAC,item.mausac);
        contentValues.put(ITEM_GIA,item.gia);
        contentValues.put(ITEM_SOLUONGCON,item.soluongcon);

        long result = sqLiteDatabase.update(ITEM_TABLE,contentValues,ITEM_ID + "=?",
                new String[]{String.valueOf(item.id)});

        sqLiteDatabase.close();

        return result;
    }


    public void insertItem(Itemdsxe item){

        sqLiteDatabase = sqliteHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(ITEM_MAXE,item.maxe);
        contentValues.put(ITEM_TENLOAIXE,item.tenloaixe);
        contentValues.put(ITEM_MAUSAC,item.mausac);
        contentValues.put(ITEM_GIA,item.gia);
        contentValues.put(ITEM_SOLUONGCON,item.soluongcon);

       sqLiteDatabase.insert(ITEM_TABLE,null,contentValues);

        sqLiteDatabase.close();


    }

    public long deleteItem(int id){
        sqLiteDatabase = sqliteHelper.getWritableDatabase();

        long result = sqLiteDatabase.delete(ITEM_TABLE,ITEM_ID + "=?",
                new String[]{String.valueOf(id)});

        sqLiteDatabase.close();

        return result;

    }




}