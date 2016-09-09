package id.sch.smktelkom_mlg.tugas01.xirpl5008.formulirpendaftaran;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    EditText etTahun;
    EditText etAlamat;
    Button bOk;
    TextView tvHasil;
    RadioButton rbL, rbP;
    CheckBox cbT, cbM, cbL;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editText);
        etTahun = (EditText) findViewById(R.id.editText2);
        etAlamat = (EditText) findViewById(R.id.editText3);
        bOk = (Button) findViewById(R.id.button);
        rbL = (RadioButton) findViewById(R.id.radioButton);
        rbP = (RadioButton) findViewById(R.id.radioButton2);
        cbT = (CheckBox) findViewById(R.id.checkBox);
        cbM = (CheckBox) findViewById(R.id.checkBox2);
        cbL = (CheckBox) findViewById(R.id.checkBox3);
        spinner = (Spinner) findViewById(R.id.spin);
        tvHasil = (TextView) findViewById(R.id.textView6);



        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nama = etNama.getText().toString();
                String tahun = etTahun.getText().toString();
                String alamat = etAlamat.getText().toString();
                String asal = spinner.getSelectedItem().toString();

                String hsl1 ="";
                if (rbL.isChecked()) {
                    hsl1 = rbL.getText().toString();
                } else if (rbP.isChecked()) {
                    hsl1 = rbL.getText().toString();
                }

                String hsl2 = "Penyakit Yang Pernah Diderita :\n";
                int startlen = hsl2.length();
                if (cbT.isChecked()) hsl2 += cbT.getText() + "\n";
                if (cbM.isChecked()) hsl2 += cbM.getText() + "\n";
                if (cbL.isChecked()) hsl2 += cbL.getText() + "\n";

                if (hsl2.length() == startlen) hsl2 += "Sehat";

                tvHasil.setText("Nama Depan :\n" + nama + "\n\nTahun Kelahiran : \n" + tahun + "\n\nAlamat : \n" + alamat + "\n\nJenis Kelamim : \n" + hsl1 + "\n\n Asal Kota : \n" + asal + "\n\n" + hsl2);
            }
        });
        etTahun.setText("");
        etNama.setText("");
        etAlamat.setText("");

    }

    private void doProcess()
    {
        if(isValid())
        {
            String nama =  etNama.getText().toString();
            int tahun = Integer.parseInt(etTahun.getText().toString());
            int usia = 2016 - tahun;

        }
    }

    private boolean isValid()
    {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String tahun = etTahun.getText().toString();
        String alamat = etAlamat.getText().toString();

        if(nama.isEmpty())
        {
            etNama.setError("Nama belum diisi");
            valid = false;
        }
        else if(nama.length()<3)
        {
            etNama.setError("Harus lebih dari 3 huruf");
            valid = false;
        }
        else
        {
            etNama.setError(null);
        }

        if(tahun.isEmpty())
        {
            etTahun.setError("Isi Tahun Lahir Anda");
            valid = false;
        }
        else if(tahun.length()!=4)
        {
            etTahun.setError("Format TTL salah");
            valid = false;
        }
        else
        {
            etTahun.setError(null);
        }
        if(alamat.isEmpty())
        {
            etAlamat.setError("Alamat belum diisi");
            valid = false;
        }
        else if(alamat.length()<3)
        {
            etAlamat.setError("Alamat Harus Lengkap");
            valid = false;
        }
        else
        {
            etAlamat.setError(null);
        }

        return valid;
    }
}
