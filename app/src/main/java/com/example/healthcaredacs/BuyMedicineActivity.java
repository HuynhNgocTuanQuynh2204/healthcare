package com.example.healthcaredacs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {
    private String[][] pakages =
            {
                    {"Uprise-03 1000IU Capsule","","","", "50"},
                    {"HealthVit Chromium Picolinate 200mcg Capsule","","","","305"},
                    {"Vitamin B Complex Capsules","","","","448"},
                    {"Inlife Vitamin E Wheat Germ Dil Capsule","","","","539"},
                    {"Dolo 650 Tablet","","","","30"},
                    {"Croxin 650 Advance Tablet","","","","50"},
                    {"Strepsils Medicated Lozenges for Sore Throat","","","","40"},
                    {"Tata 1mg CalciumVitamin D3","","","", "30"},
                    {"Feronia -XT Tablet", "", "", "", "130"},
            };
    private String[] pakage_details =
            {
                    "Building and keeping the bones & teeth strong\n" +
                            "Reducing Fatigue/stress and muscular pains\n"+
                            "Boosting immunity and increasing resistance against infection",
                    "Chromium is an essential trace mineral that plays an important role in helping insulin regulate blood glucase,",
                    "Providesrelief from vitamin B deficiencies\n"+
                            "Helpsformation of red blood cells\n"+
                            "Maintains healthy nervous system",
                    "Itpromotes health as well as skin benefit.\n"+
                            "It helps reduce skin blenish and pigmentation.\n"+
                            "It act as safeguard the skin from the harsh UVA and UVB sun rays.'",
                    "Dolo 650 Tablet helps relieve pain and fever by blocking the release of certain chemical messangers responsible for fever and pain",
                    "Helps relieve fever and bring down a high temperature\n"+
                            "Suitable for people withheart condition or high blood pressure",
                    "Relieves the symptoms of a bacterial throat infection and soothes the recovery process\n"+
                            "Provides a warm and comforting feeling during sore throat",
                    "Reduces the risk of calcium deficiency, Rickets, and Osteoporosis\n"+
                            "Promotes mobility and flexibility of joints",
                    "Helps to reduce the iron deficiency due to chronic blood loss or low intake of iron"
            };

    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack, btnGoToCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_buy_medicine);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lst = findViewById(R.id.listViewBM);
        btnBack = findViewById(R.id.buttonBMBack);
        btnGoToCard = findViewById(R.id.buttonBMGoToCart);

        btnGoToCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(BuyMedicineActivity.this,CardBuyMedicineActivity.class));
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this,HomeActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i<pakages.length;i++){
            item = new HashMap<String,String>();
            item.put("line1", pakages[i][0]);
            item.put("line2", pakages[i][1]);
            item.put("line3", pakages[i][2]);
            item.put("line4", pakages[i][3]);
            item.put("line5","Total Cost:"+pakages[i][4]+"/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[] {"line1","line2","line3","line4","line5"},
                new int[] {R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(BuyMedicineActivity.this,BuyMedicineDetailsActivity.class);
                it.putExtra("text1",pakages[i][0]);
                it.putExtra("text2",pakage_details[i]);
                it.putExtra("text3",pakages[i][4]);
                startActivity(it);
            }
        });
    }

}