package com.example.app_sql;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class mydialog extends Dialog  implements android.view.View.OnClickListener  {
	
	   private LeaveMyDialogListener listener;
	   public interface LeaveMyDialogListener{   
	        public void onClick(View view);   
	    }   
	   private TextView txt;
	   private Button   btu,bti,btd,btc;
       
	   public mydialog(Context context) {
		  super(context);
	   }
	   public mydialog(Context context,int theme,LeaveMyDialogListener listener) {
		  super(context,theme);
		  this.listener = listener;
	   }
	    protected void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.dia);
	      btu=(Button)this.findViewById(R.id.addbutton);
	      bti=(Button)this.findViewById(R.id.insbutton);
	      btd=(Button)this.findViewById(R.id.delbutton);
	      btc=(Button)this.findViewById(R.id.daobutton);
//	                 通过接口实现功能的定义
	      btu.setOnClickListener(this);
	      bti.setOnClickListener(this);
	      btd.setOnClickListener(this);
	      btc.setOnClickListener(this);
	   }
	@Override
	   public void onClick(View v) {
		listener.onClick(v);
		
	   }

}
