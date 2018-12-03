package com.byhoangrapper.quanlixe.sqlite;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static com.byhoangrapper.quanlixe.common.Constants.CREATE_ITEM_TABLE;
import static com.byhoangrapper.quanlixe.common.Constants.ITEM_TABLE;
import static com.byhoangrapper.quanlixe.common.Constants.isDEBUG;
import static com.byhoangrapper.quanlixe.common.Constants.CREATE_ITEM_TABLE;
import static com.byhoangrapper.quanlixe.common.Constants.ITEM_TABLE;
import static com.byhoangrapper.quanlixe.common.Constants.isDEBUG;

public class SqliteHelper extends SQLiteOpenHelper {

    public SqliteHelper(Context context) {
        super(context, "db.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_ITEM_TABLE);
        if (isDEBUG) Log.e("ITEM_TABLE",CREATE_ITEM_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ITEM_TABLE);


    }

}
