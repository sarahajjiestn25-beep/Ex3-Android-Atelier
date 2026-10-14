# Atelier Android XML - Exercice 3 (Etudiant Manager)

This repository contains the source code and implementation for **Exercice 3** of the Android XML Practical Work (Atelier Android).

## Project Overview
The application allows users to input student details—including personal information, academic year, subject, and grade—and displays a formatted HTML-styled summary table via a popup message (`Toast`).

## Features & Classes
1. **Personne.java**: Base class encapsulating private attributes (`prenom`, `nom`, `eMail`), constructors, getters/setters, and the `toString()` method.
2. **Etudiant.java**: Subclass inheriting from `Personne`, adding academic fields (`annee`, `matiere`, `moyenne`).
3. **content_etudiant_main.xml**: XML layout featuring `EditText`, `RadioGroup` (1A/2A), `Spinner` (Info, Math, Réseaux), and an **Enregistrer** button using a `RelativeLayout`.
4. **MainActivity.java**: Handles GUI bindings, object instantiation, dynamic HTML table string generation, and rendering via `Html.fromHtml()`.

## Author
* **Sara Hajji** - *ILCS-S3*
