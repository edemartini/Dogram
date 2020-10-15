package com.edemartini.dogram;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Contacto extends AppCompatActivity {

    //Datos de la cuenta de correo electrónico que uso para enviar los mensajes del usuario
    String correo, contraseña;

    EditText nombre, email, mensaje;
    Button enviar;

    Session session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nombre = (EditText) findViewById(R.id.etNombreContacto);
        email = (EditText) findViewById(R.id.etEmailContacto);
        mensaje = (EditText) findViewById(R.id.etMensajeContacto);
        enviar = (Button) findViewById(R.id.btnEnviar);

        correo = "edemartini68@gmail.com";
        contraseña = "Juan3:16";



        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);

                Properties properties = new Properties();
                properties.put("mail.smtp.host", "smtp.googlemail.com");
                properties.put("mail.smtp.socketFactory.port", "465");
                properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.port", "465");

                try {
                    session = Session.getDefaultInstance(properties, new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(correo, contraseña);
                        }
                    });
                    if (session != null) {
                        String asunto, contenido;
                        asunto = "Mensaje de Dogram para: " + nombre.getText().toString();
                        contenido = mensaje.getText().toString();
                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(correo));
                        message.setSubject(asunto);
                        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getText().toString()));
                        message.setContent(contenido, "text/html; charset=utf-8");
                        Transport.send(message);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

    }
}