package org.example;

import java.io.Serializable;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRMI2027AtualizadoSemVirus implements Serializable {
    private static final long serialVersionUID = 1L; // Recomendado para Serializable
    private String name;
    private String msg;




    void send(String msg){

    }
}
