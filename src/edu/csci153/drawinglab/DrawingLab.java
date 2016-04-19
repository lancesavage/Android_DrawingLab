package edu.csci153.drawinglab;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.PathShape;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ImageView;

public class DrawingLab extends Activity {
	
    /** Called when the activity is first created. */
    
	int choice;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final ImageView iv = (ImageView)findViewById(R.id.ivShapes);
        final RadioGroup rgShapes = (RadioGroup)findViewById(R.id.rgShapes);
        
        final RadioButton rbCircle = (RadioButton)findViewById(R.id.rbCircle);
        final RadioButton rbRectangle = (RadioButton)findViewById(R.id.rbRectangle);
        final RadioButton rbOctagon = (RadioButton)findViewById(R.id.rbOctagon);
        final RadioButton rbTriangle = (RadioButton)findViewById(R.id.rbTriangle);
        
        final Button pbDisplay = (Button)findViewById(R.id.pbDisplay);
        
      //  rbCircle.toggle();
        
        rgShapes.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
        	public void onCheckedChanged(RadioGroup group, int id){
        		
        		if(rbCircle.isChecked()){
        			choice=1;
        		}else if (rbRectangle.isChecked()){
        			choice=2;
        		}else if (rbOctagon.isChecked()){
        			choice=3;
        		}else if (rbTriangle.isChecked()){
        			choice=4;
        		}
        		
        	}
        });
        
        pbDisplay.setOnClickListener(new Button.OnClickListener(){
        	public void onClick(View v){
        		System.out.println(choice);
        		if(choice==1){
        		        
        			ShapeDrawable circle = new ShapeDrawable(new OvalShape());
        			circle.setIntrinsicHeight(50);
        			circle.setIntrinsicWidth(50);
        			circle.getPaint().setColor(Color.BLUE);
        			iv.setImageDrawable(circle);
        		
        		}else if(choice==2){
        			
        			 iv.setImageResource(R.drawable.rectangle);
        			
        		}else if (choice == 3){
        			
        			Path p = new Path();
        			
        			p.moveTo(25,0);
        			p.lineTo(50,0);
        			p.lineTo(75,25);
        			p.lineTo(75,50);
        			p.lineTo(50,75);
        			p.lineTo(25,75);
        			p.lineTo(0,50);
        			p.lineTo(0,25);
        			p.lineTo(25,0);
        			
        			ShapeDrawable d = new ShapeDrawable(new PathShape(p,200,200));
        			
        			d.setIntrinsicHeight(200);
        			d.setIntrinsicWidth(200);
        			d.getPaint().setColor(Color.MAGENTA);
        			
        			iv.setImageDrawable(d);
        		}else if (choice == 4){
        			
        			iv.setImageResource(R.drawable.triangle);
        			
        		}
        		
        	}
        });
        
        
    }
}