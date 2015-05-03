package com.example.app_sql;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class diaedi extends Dialog  implements android.view.View.OnClickListener {
	   private DialogListener listener;
	   public interface DialogListener{   
	        public void onClick(View view);   
	    }   
	   private TextView txt;
	   private Button   bt1,bt2;
	   private EditText diaev1;
	   private EditText diaev2;
	   private EditText diaev3;
	   private EditText diaev4;
	   private EditText diaev5;
	   public diaedi(Context context) {
		  super(context);
	   }
	   public diaedi(Context context,int theme,DialogListener listener) {
		  super(context,theme);
		  this.listener = listener;
	   }
	   public void onCreate(Bundle savedInstanceState) {
		      super.onCreate(savedInstanceState);
		      setContentView(R.layout.dia2);
		      
//		                 通过接口实现功能的定义
		      bt1=(Button)this.findViewById(R.id.edibu);
		      bt2=(Button)this.findViewById(R.id.qu);
		      bt1.setOnClickListener(this);
		      bt2.setOnClickListener(this);
		   }
		@Override
		   public void onClick(View v) {
			listener.onClick(v);
			
		   }

	}

