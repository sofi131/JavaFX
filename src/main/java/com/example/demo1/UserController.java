package com.example.demo1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class UserController {
    @FXML
    protected Menu menuFile;
    @FXML
    protected MenuItem menuClose;
    @FXML
    protected TextField txtDatos;
    @FXML
    protected DatePicker dpFecha;
    @FXML
    protected TableView<Persona> table;
    @FXML
    protected TableColumn<Persona, String> name;
    @FXML
    protected TableColumn<Persona, String> surname;
    @FXML
    protected TableColumn<Persona, Integer> age;
    @FXML
    protected TextField txtName;
    @FXML
    protected TextField txtSurname;
    @FXML
    protected TextField txtAge;


    private ObservableList<Persona> personas;
//Constructor vacío y que cree una lista vacía
    public UserController() {
        personas=FXCollections.observableArrayList();
    }

    @FXML
    protected void close(){
        System.out.println("Cerrar ventana");
    }
    @FXML
    protected void btnPulsar(){
        System.out.println(dpFecha.getValue());
        System.out.println(txtDatos.getText());
    }

    @FXML
    protected void btnTraerDatos(){
        personas = FXCollections.observableArrayList(
                new Persona("Juan","Pérez",34),
                new Persona("María","Gónzalez",33),
                new Persona("Pedro","Martínez",35)
        );
        personas.addAll(new Persona("Juan","Rodríguez",56));
        table.setItems(personas);
    }

    //se ejecuta cuando se carga la vista -> esto ya llena la tabla ya desde el principio
    //copiamos de la tabla de arriba y nos cargamos cosas
    public void initialize(){

        //Asignar los datos a las columnas (flecha landa function)
        name.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        surname.setCellValueFactory(cellData -> cellData.getValue().surnameProperty());
        age.setCellValueFactory(cellData -> cellData.getValue().ageProperty().asObject());
    }

    public void btnCrearDatos(ActionEvent actionEvent){
        Persona persona=new Persona(txtName.getText(),txtSurname.getText(),Integer.parseInt(txtAge.getText()));
        personas.addAll(persona);
        txtName.clear();
        txtSurname.clear();
        txtAge.clear();
        table.setItems(personas);

    }
}