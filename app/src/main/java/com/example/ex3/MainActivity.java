package com.example.ex3;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText editPrenom, editNom, editMail, editMoyenne;
    RadioGroup radioGroupAnnee;
    Spinner spinnerMatiere;
    Button btnEnregistrer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_etudiant_main);

        editPrenom = (EditText) findViewById(R.id.editPrenom);
        editNom = (EditText) findViewById(R.id.editNom);
        editMail = (EditText) findViewById(R.id.editMail);
        editMoyenne = (EditText) findViewById(R.id.editMoyenne);
        radioGroupAnnee = (RadioGroup) findViewById(R.id.radioGroupAnnee);
        spinnerMatiere = (Spinner) findViewById(R.id.spinnerMatiere);
        btnEnregistrer = (Button) findViewById(R.id.btnEnregistrer);

        // Remplir le Spinner avec les matières
        String[] matieres = {"Info", "Math", "Réseaux"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, matieres);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMatiere.setAdapter(adapter);

        btnEnregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String prenom = editPrenom.getText().toString();
                String nom = editNom.getText().toString();
                String mail = editMail.getText().toString();

                int selectedId = radioGroupAnnee.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(selectedId);
                int annee = (rb != null && rb.getText().toString().equals("2A")) ? 2 : 1;

                String matiere = spinnerMatiere.getSelectedItem().toString();

                double moyenne = 0.0;
                String moyStr = editMoyenne.getText().toString();
                if (!moyStr.isEmpty()) {
                    moyenne = Double.parseDouble(moyStr);
                }

                // Création de l'objet Etudiant
                Etudiant etudiant = new Etudiant(prenom, nom, mail, annee, matiere, moyenne);

                // Génération du contenu HTML sous forme de tableau (Format exact demandé par le TP)
                String htmlContent = "<b>C'est fait !</b><br>" +
                        "<table border='1'>" +
                        "<tr><th>Prenom</th><th>Nom</th><th>eMail</th><th>Annee</th><th>Matiere</th><th>Moyenne</th></tr>" +
                        "<tr><td>" + etudiant.getPrenom() + "</td><td>" + etudiant.getNom() + "</td><td>" + etudiant.getEMail() +
                        "</td><td>" + etudiant.getAnnee() + "</td><td>" + etudiant.getMatiere() + "</td><td>" + etudiant.getMoyenne() + "</td></tr>" +
                        "</table>";

                // Affichage du tableau HTML interprété dans le Toast grâce à Html.fromHtml
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    Toast.makeText(getApplicationContext(), Html.fromHtml(htmlContent, Html.FROM_HTML_MODE_LEGACY), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), Html.fromHtml(htmlContent), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}